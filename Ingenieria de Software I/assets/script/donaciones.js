import notificationHandler from './alerts/SwalAlerts.js'

const btnCuentaPago = document.querySelector('.btn-cuenta-pago')
const btnPagoNet = document.querySelector('.btn-pago-net')
const modalCuentaPago = document.getElementById('modal-cuenta-pago')
const modalPagoNet = document.getElementById('modal-pago-net')
const btnDonacionPagoNet = document.querySelector('.btn-donacion-pago-net')
const btnDonacionCuentaPago = document.querySelector('.btn-donacion-cuenta-pago')
let numeroSucursal

btnCuentaPago.addEventListener('click', () => {
    modalCuentaPago.style.display = 'block'
})

btnPagoNet.addEventListener('click', () => {
    const sucursal = document.getElementById('random-sucursal')
    numeroSucursal = Math.floor(Math. random()*100) + 1 
    sucursal.innerHTML = numeroSucursal 
    modalPagoNet.style.display = 'block'

})

document.querySelectorAll('.close').forEach(closeBtn => {
    closeBtn.addEventListener('click', () => {
        modalCuentaPago.style.display = 'none'
        modalPagoNet.style.display = 'none'
    })
})

if (btnDonacionPagoNet) {
    btnDonacionPagoNet.addEventListener('click', () => {
        handleDonation('pago-net-monto', 'Pago Net', numeroSucursal)
    })
}

if (btnDonacionCuentaPago) {
    btnDonacionCuentaPago.addEventListener('click', () => {
        handleDonation('cuenta-pago-monto', 'Cuenta Pago');
    })
}

const handleDonation = (inputId, method, numeroSucursal = null) => {
    const inputElement = document.getElementById(inputId)
    const monto = inputElement.value
    
    if (monto && Number(monto) >= 100) {
        const donacion = {
            monto: parseFloat(monto).toLocaleString("es-AR", {style: "currency", currency: "ARS"}),
            fecha: new Date().toLocaleString(),
            metodo: method,
            numeroSucursal: numeroSucursal
        }

        let reporteDonacion = JSON.parse(localStorage.getItem('reporteDonacion')) || []
        reporteDonacion.push(donacion)
        localStorage.setItem('reporteDonacion', JSON.stringify(reporteDonacion))

        notificationHandler(
            "Donación realizada",
            "Gracias por su donación",
            "success"
        )

        inputElement.value = ''
    } else {
        notificationHandler(
            "Donación rechazada",
            "Ingresa un monto superior a $100. ",
            "error"
        )
    }
}
