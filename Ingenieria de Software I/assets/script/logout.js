import notificationHandler from "./alerts/SwalAlerts.js"

const logoutBtn = document.getElementById('logoutLink')

logoutBtn.addEventListener('click', ()=>{
    /*Despues de iniciar sesión tengo que borrar userLogin del localstorage
    A modo de prueba solo cambio el isLogged
    */
    const userLogin = JSON.parse(localStorage.getItem('userLogin')) || []
    userLogin.isLogged = false
    localStorage.setItem('userLogin', JSON.stringify(userLogin))

    localStorage.setItem('adminLogin', false)
    notificationHandler(
        "Cerrando sesión",
        "Hasta la próxima",
        "warning",
        () => {
            window.location.href = '../../index.html'
        }
    )
})
