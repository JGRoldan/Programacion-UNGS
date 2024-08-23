import mostrarMapa from '../api/mapa.js'

const getLatitudLongitud = (mailToFilter) =>{
    const storedData = JSON.parse(localStorage.getItem('dataCard'))
    const nombreEmprendimiento = document.querySelector('.mapa-emprendimiento')
    const detalleEmprendimiento = document.querySelector('.mapa-detalle')
    const {latitud, longitud, emprendimiento, detalle} = storedData.filter(card => card.mail === mailToFilter)[0]
    
    nombreEmprendimiento.innerHTML = emprendimiento
    detalleEmprendimiento.innerHTML = detalle
    mostrarMapa(latitud, longitud)
}

const getCardData = (buttons) =>{
    buttons.forEach( btn => {
        btn.addEventListener('click', e =>{
            getLatitudLongitud(e.target.getAttribute("data-email"))
        })
    })
}

export default getCardData

