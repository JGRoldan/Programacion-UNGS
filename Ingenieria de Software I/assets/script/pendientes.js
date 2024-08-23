import notificationHandler from './alerts/SwalAlerts.js'
import dynamicUpdateCard from '../script/index.js'

const dynamicUpdateDisabled = () => {
    const disabledContainer = document.querySelector('.disabled-card-container')
    let pendingDisabledUser = JSON.parse(localStorage.getItem('disabledUser')) || []

    if (disabledContainer !== null) {
        if (pendingDisabledUser.length === 0) {
            disabledContainer.innerHTML = 'No hay emprendimientos por habilitar'
            return
        }
        disabledContainer.innerHTML = ''
    }

    pendingDisabledUser.forEach(({mail, emprendimiento, direccion, nombre, telefono, detalle}) => {
        const pendingCard = generateHTML(mail, emprendimiento, direccion, nombre, telefono, detalle)
        disabledContainer.innerHTML += pendingCard
    })

    const aceptarButtons = document.querySelectorAll('.aceptar-btn')
    const rechazarButtons = document.querySelectorAll('.rechazar-btn')
    enableDisabledMiembro(aceptarButtons, pendingDisabledUser)
    rejectDisabledMiembro(rechazarButtons, pendingDisabledUser)
}

const enableDisabledMiembro = (aceptarButtons, pendingDisabledUser) => {
    let dataCard = JSON.parse(localStorage.getItem('dataCard')) || []

    aceptarButtons.forEach(button => {
        button.addEventListener('click', () => {
            const userEmail = button.parentElement.parentElement.dataset.user
            button.parentElement.parentElement.remove()

            const userIndex = pendingDisabledUser.findIndex(user => user.mail === userEmail)

            if (userIndex !== -1) {
                const user = pendingDisabledUser.splice(userIndex, 1)[0]
                dataCard.push(user)

                localStorage.setItem('disabledUser', JSON.stringify(pendingDisabledUser))
                localStorage.setItem('dataCard', JSON.stringify(dataCard))

                notificationHandler("Miembro habilitado", "Se habilitara nuevamente al miembro", "success")

                dynamicUpdateDisabled()
                dynamicUpdateCard()
            }
        })
    })
}

const rejectDisabledMiembro = (rechazarButtons, pendingDisabledUser) => {
    rechazarButtons.forEach(button => {
        button.addEventListener('click', () => {
            const userEmail = button.parentElement.parentElement.dataset.user
            button.parentElement.parentElement.remove()

            const userIndex = pendingDisabledUser.findIndex(user => user.mail === userEmail)

            if (userIndex !== -1) {
                pendingDisabledUser.splice(userIndex, 1)
                localStorage.setItem('disabledUser', JSON.stringify(pendingDisabledUser))
            }

            notificationHandler("Miembro borrado", "Se borro el emprendimiento", "success")
            dynamicUpdateDisabled()
        })
    })
}

const dynamicUpdatePendiente = () => {
    const pendienteContainer = document.querySelector('.pendiente-card-container')
    let pendingUsers = JSON.parse(localStorage.getItem('users')) || []

    if (pendienteContainer !== null) {
        if (pendingUsers.length === 0) {
            pendienteContainer.innerHTML = 'No hay emprendimientos por aceptar'
            return
        }
        pendienteContainer.innerHTML = ''
    }

    pendingUsers.forEach(({mail, emprendimiento, direccion, nombre, telefono, detalle}) => {
        const pendingCard = generateHTML(mail, emprendimiento, direccion, nombre, telefono, detalle)
        pendienteContainer.innerHTML += pendingCard
    })

    const aceptarButtons = document.querySelectorAll('.aceptar-btn')
    const rechazarButtons = document.querySelectorAll('.rechazar-btn')
    acceptPendingMiembro(aceptarButtons, pendingUsers)
    rejectPendingMiembro(rechazarButtons, pendingUsers)
}

const generateHTML = (mail, emprendimiento, direccion, nombre, telefono, detalle) => {
    return `
        <div class="pendiente-card" data-user="${mail}">
            <div class="pendiente-data">
                <h4>${emprendimiento}</h4>
                <p>${nombre}</p>
                <p>${direccion}</p>
                <p>${telefono}</p>
                <p>${mail}</p>
                <p>${detalle}</p>
                <button class="btn-pendientes aceptar-btn">ACEPTAR</button>
                <button class="btn-pendientes rechazar-btn">RECHAZAR</button>
            </div>
        </div>
    `
}

const acceptPendingMiembro = (aceptarButtons, pendingUsers) => {
    aceptarButtons.forEach(button => {
        button.addEventListener('click', () => {
            const userEmail = button.parentElement.parentElement.dataset.user
            let acceptedUsers = JSON.parse(localStorage.getItem('usersAccepted')) || []
            let dataCard = JSON.parse(localStorage.getItem('dataCard')) || []

            button.parentElement.parentElement.remove()

            const userIndex = pendingUsers.findIndex(user => user.mail === userEmail)
            if (userIndex !== -1) {
                const user = pendingUsers.splice(userIndex, 1)[0]
                user.isAcepted = true
                acceptedUsers.push(user)
                dataCard.push(user)

                localStorage.setItem('usersAccepted', JSON.stringify(acceptedUsers))
                localStorage.setItem('dataCard', JSON.stringify(dataCard))
                localStorage.setItem('users', JSON.stringify(pendingUsers))

                notificationHandler("Nuevo miembro aceptado", "Se enviará un mail al miembro", "success")

                dynamicUpdatePendiente()
                dynamicUpdateCard()
            }
        })
    })
}

const rejectPendingMiembro = (rechazarButtons, pendingUsers) => {
    rechazarButtons.forEach(button => {
        button.addEventListener('click', () => {
            const userEmail = button.parentElement.parentElement.dataset.user

            button.parentElement.parentElement.remove()

            const updatedUsers = pendingUsers.filter(user => user.mail !== userEmail)
            localStorage.setItem('users', JSON.stringify(updatedUsers))

            notificationHandler("Aspirante a miembro borrado", "Se enviará un mail al aspirante", "success")

            dynamicUpdatePendiente()
        })
    })
}

const getCard = (mailToFilter) =>{
    let dataCard = JSON.parse(localStorage.getItem('dataCard'))
    let data = dataCard.filter(card => card.mail === mailToFilter)[0]
    let disabledUser = JSON.parse(localStorage.getItem('disabledUser')) || []
    
    dataCard = dataCard.filter(card => card.mail !== mailToFilter)
    localStorage.setItem('dataCard', JSON.stringify(dataCard))

    disabledUser.push(data)
    localStorage.setItem('disabledUser', JSON.stringify(disabledUser))

    dynamicUpdateCard(dataCard)
}

const getCardOnClick = (buttons) =>{
    buttons.forEach( btn => {
        btn.addEventListener('click', e =>{
            getCard(e.target.getAttribute("data-email"))
            
        })
    })
}

document.addEventListener('DOMContentLoaded', () => {
    dynamicUpdatePendiente()
    dynamicUpdateDisabled()
})

export default getCardOnClick