import pendingNotifications from './notificaciones/pendingMember.js'
import notificationHandler from './alerts/SwalAlerts.js'
import obtenerDireccionNormalizada from './api/normalizar.js'
import mostrarMapa from '../script/api/mapa.js'

let x,y;

const handlerData = () =>{
    const email = document.getElementById('email').value
    const password = document.getElementById('password').value
    const nombreEmprendimiento = document.getElementById('nombre-emprendimiento').value
    const direccion = document.getElementById('direccion').value
    const direccionVisible = document.getElementById('direccion-checkbox').checked
    const rubro = document.getElementById('rubro-opt').value
    const inicioTrabajo = document.getElementById('inicio-trabajo').value
    const finTrabajo = document.getElementById('fin-trabajo').value
    const logoEmprendimiento = document.getElementById('logo-emprendimiento').files[0] 
    const nombreMiembro = document.getElementById('nombre-miembro').value
    const detalleEmprendimiento = document.getElementById('detalle-emprendimiento').value
    const instagram = document.getElementById('instagram').value
    const facebook = document.getElementById('facebook').value
    const youtube = document.getElementById('youtube').value
    const tiktok = document.getElementById('tiktok').value
    const telefono  = document.getElementById('telefono-miembro').value
    //Si no se ingresa logo es undefined
    
    const userData = {
        mail: email,
        password: password,
        emprendimiento: nombreEmprendimiento,
        direccion: direccion,
        direccionVisible: direccionVisible,
        rubro: rubro,
        horaInicio: inicioTrabajo,
        horaFin: finTrabajo,
        logoEmprendimiento:logoEmprendimiento,
        isAcepted: false,
        donation:false,
        deshabilitado: false,
        latitud: x || 0, 
        longitud: y || 0,
        nombre: nombreMiembro,
        detalle: detalleEmprendimiento,
        telefono: telefono,
        redes:{
            instagram: instagram || null,
            youtube: youtube || null,
            facebook: facebook || null,
            tiktok: tiktok || null
        }
    }

    let users = JSON.parse(localStorage.getItem('users')) || []
    users.push(userData)
    localStorage.setItem('users', JSON.stringify(users))
    
    pendingNotifications(userData)
    notificationHandler(
        "Usuario registrado",
        "Cuando seas aceptado se te notificará vía mail",
        "success",
        () => {
            window.location.href = '../../index.html'
        }
    )
}

const normalizarDireccionyMapa = () =>{
    const modalRegister = document.getElementById('modal-register')
    const btnClose = document.querySelector('.close')
    const ulDirecciones = document.querySelector('.lista-direcciones')

    document.getElementById('direccion').addEventListener('change', async function() {
        const direccion = this.value
        const res = await obtenerDireccionNormalizada(direccion)
        
        if(res.direccionesNormalizadas.length === 0){
            modalRegister.style.display = 'block'
            const error = res.errorMessage

            ulDirecciones.innerHTML = error
            

            btnClose.addEventListener('click', () => {
                modalRegister.style.display = 'none'
            })
            return
        }
        if(res.direccionesNormalizadas.length > 1){
            modalRegister.style.display = 'block'

            ulDirecciones.innerHTML = ''
            
            res.direccionesNormalizadas.forEach(direccion => {
                const li = document.createElement('li')
                li.innerHTML = `<b>Dirección:</b> ${direccion.direccion}`
                ulDirecciones.appendChild(li)
            })


            btnClose.addEventListener('click', () => {
                modalRegister.style.display = 'none'
            })
            return
        }

        if(res.direccionesNormalizadas.length === 1){
            mostrarMapa(res.direccionesNormalizadas[0].coordenadas.y, res.direccionesNormalizadas[0].coordenadas.x)
            
            x = res.direccionesNormalizadas[0].coordenadas.y
            y = res.direccionesNormalizadas[0].coordenadas.x

            btnClose.addEventListener('click', () => {
                modalRegister.style.display = 'none'
            })

            return
        }

    })
}

document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('login-form')

    normalizarDireccionyMapa()

    form.addEventListener('submit', e => {
        e.preventDefault()
        handlerData()
        form.reset()
    })
})

