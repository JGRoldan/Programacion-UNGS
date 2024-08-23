import adminCredentials from './helper/admin.js'
import handlerDOM from './helper/menu.js'
import notificationHandler from './alerts/SwalAlerts.js'

const login = () =>{
    localStorage.setItem('adminCredentials', JSON.stringify(adminCredentials))
    localStorage.setItem('adminLogin', false)

    document.getElementById('login-form').addEventListener('submit', (e)=>{
        e.preventDefault()
        submitHandler()
    })
}

const submitHandler = () => {
    const adminCredentials = JSON.parse(localStorage.getItem('adminCredentials'))
    const email = document.getElementById('email').value
    const password = document.getElementById('psw').value

    console.log(adminCredentials)

    if (email === adminCredentials.USER && password === adminCredentials.PASSWORD) {
        localStorage.setItem('adminLogin', true)
        successFullLoginHandler('ADMIN')
        return
    }

    const acceptedUsers = JSON.parse(localStorage.getItem('usersAccepted')) || []

    const user = acceptedUsers.find(user => user.email === email && user.password === password)

    if (user) {
        successFullLoginHandler('USER')
        updateUserLogin(email, password, true)
        return
    }

    invalidCredentialHandler()
}

const successFullLoginHandler = (name) => {
    handlerDOM(name)

    notificationHandler(
        "Credenciales Válidas",
        "Redirigiendo a la página principal",
        "success",
        () => {
            window.location.href = '../../index.html'
        }
    )
    resetFields()
}

const invalidCredentialHandler = () => {
    notificationHandler(
        "Credenciales Inválidas",
        "Vuelve a intentar",
        "error"
    )
    resetFields()
}

const updateUserLogin = (email, password, isLogged) => {
    const userLogin = [{
        email,
        password,
        isLogged,
        "dateFirstLogin":(new Date()).toDateString()
    }]
    localStorage.setItem('userLogin', JSON.stringify(userLogin))
}

const resetFields = () =>{
    document.getElementById('email').value = ''
    document.getElementById('psw').value = ''
}

document.addEventListener('DOMContentLoaded', login)
