import handlerDOM from './helper/menu.js';
import rubrosENUM from './helper/rubros.js';
import dataCard from './helper/card-data.js';
import getCardData from './helper/getCardData.js';
import getCardOnClick from './pendientes.js';

const filteredCards = (storedData) =>{
    const formMain = document.getElementById('form-main')

    formMain.addEventListener('submit', (e) => {
        e.preventDefault()
        const destacado = document.getElementById('destacado').value
        const rubro = document.getElementById('rubros').value
        
        let filteredData = []


        if (destacado === "DESTACADO") {
            filteredData = storedData.filter(({ donation }) => {
                return donation === true
            })
        } else if (destacado === "TODOS") {
            filteredData = storedData
        }
        else if (destacado === "NODESTACADO") {
            filteredData = storedData.filter(({ donation }) => {
                return donation === false
            })
        }
        
        if (rubro && rubro !== "TODOS") {
            const rubroValue = rubrosENUM[rubro]
            filteredData = filteredData.filter(({ rubro }) => rubro === rubroValue)
        }
    
        dynamicUpdateCard(filteredData)
    })
}

const dynamicUpdateCard = (filteredData) =>{
    const cardContainer = document.querySelector('.card-container')
    
    if(filteredData.length === 0) {
        cardContainer.innerHTML = 'No hay emprendimientos en el portal.'
        return
    }

    cardContainer.innerHTML = ''

    filteredData.sort((a, b) => (b.donation === true) - (a.donation === true))
    
    filteredData.map( ({emprendimiento, nombre, telefono, mail, direccion, redes, donation, horaInicio, horaFin}) => {
        let redesHTML = redesValidation(redes)
        const cardHTML = generateCardHTML(redesHTML, donation, {emprendimiento, nombre, telefono, mail, direccion, horaInicio, horaFin})

        cardContainer.innerHTML += cardHTML
    })

    getCardData(document.querySelectorAll("#onVerClick"))
    if(localStorage.getItem('adminLogin') == "true"){
        getCardOnClick(document.querySelectorAll("#onDeshabilitarClick"))
    }
}

const redesValidation = (redes) =>{
    if (redes) {
        return `
            <p style="color:#626567">Redes Sociales</p>
            <ul style="color:#626567; display:flex;">
                ${redes.instagram ? `<li> <svg  xmlns="http://www.w3.org/2000/svg"  width="24"  height="24"  viewBox="0 0 24 24"  fill="none"  stroke="currentColor"  stroke-width="2"  stroke-linecap="round"  stroke-linejoin="round"  class="icon icon-tabler icons-tabler-outline icon-tabler-brand-instagram"><path stroke="none" d="M0 0h24v24H0z" fill="none"/><path d="M4 4m0 4a4 4 0 0 1 4 -4h8a4 4 0 0 1 4 4v8a4 4 0 0 1 -4 4h-8a4 4 0 0 1 -4 -4z" /><path d="M12 12m-3 0a3 3 0 1 0 6 0a3 3 0 1 0 -6 0" /><path d="M16.5 7.5l0 .01" /></svg> </li>` : ''}
                ${redes.facebook ? `<li> <svg  xmlns="http://www.w3.org/2000/svg"  width="24"  height="24"  viewBox="0 0 24 24"  fill="none"  stroke="currentColor"  stroke-width="2"  stroke-linecap="round"  stroke-linejoin="round"  class="icon icon-tabler icons-tabler-outline icon-tabler-brand-meta"><path stroke="none" d="M0 0h24v24H0z" fill="none"/><path d="M12 10.174c1.766 -2.784 3.315 -4.174 4.648 -4.174c2 0 3.263 2.213 4 5.217c.704 2.869 .5 6.783 -2 6.783c-1.114 0 -2.648 -1.565 -4.148 -3.652a27.627 27.627 0 0 1 -2.5 -4.174z" /><path d="M12 10.174c-1.766 -2.784 -3.315 -4.174 -4.648 -4.174c-2 0 -3.263 2.213 -4 5.217c-.704 2.869 -.5 6.783 2 6.783c1.114 0 2.648 -1.565 4.148 -3.652c1 -1.391 1.833 -2.783 2.5 -4.174z" /></svg> </li>` : ''}
                ${redes.youtube ? `<li> <svg  xmlns="http://www.w3.org/2000/svg"  width="24"  height="24"  viewBox="0 0 24 24"  fill="none"  stroke="currentColor"  stroke-width="2"  stroke-linecap="round"  stroke-linejoin="round"  class="icon icon-tabler icons-tabler-outline icon-tabler-brand-youtube"><path stroke="none" d="M0 0h24v24H0z" fill="none"/><path d="M2 8a4 4 0 0 1 4 -4h12a4 4 0 0 1 4 4v8a4 4 0 0 1 -4 4h-12a4 4 0 0 1 -4 -4v-8z" /><path d="M10 9l5 3l-5 3z" /></svg> </li>` : ''}
                ${redes.tiktok ? `<li> <svg  xmlns="http://www.w3.org/2000/svg"  width="24"  height="24"  viewBox="0 0 24 24"  fill="none"  stroke="currentColor"  stroke-width="2"  stroke-linecap="round"  stroke-linejoin="round"  class="icon icon-tabler icons-tabler-outline icon-tabler-brand-tiktok"><path stroke="none" d="M0 0h24v24H0z" fill="none"/><path d="M21 7.917v4.034a9.948 9.948 0 0 1 -5 -1.951v4.5a6.5 6.5 0 1 1 -8 -6.326v4.326a2.5 2.5 0 1 0 4 2v-11.5h4.083a6.005 6.005 0 0 0 4.917 4.917z" /></svg> </li>` : ''}
            </ul>
        `
    }
}

const generateCardHTML = (redesHTML, donation, {emprendimiento, nombre, telefono, mail, direccion, horaInicio, horaFin}) => {

    const isAdminLoggedIn = localStorage.getItem('adminLogin') === "true"
    const deshabilitarButtonHTML = isAdminLoggedIn 
        ? `<button class="btn-generic deshabilitar-btn" id="onDeshabilitarClick" data-email=${mail}>Deshabilitar</button>` 
        : ''

    return donation 
        ?
            `
            <div class="card card-donation-true">
                <h3>${emprendimiento}</h3>
                <p style="color:#626567 "> <b>Nombre:</b> ${nombre}</p>
                <p style="color:#626567 "> <b>Whatsapp:</b> ${telefono}</p>
                <p style="color:#626567 "> <b>Mail:</b> ${mail}</p>
                <p style="color:#626567 "> <b>Dirección:</b> ${direccion}</p>
                <p style="color:#626567 "> <b>Horario laboral:</b> ${horaInicio} - ${horaFin}</p>
                ${redesHTML}
                <div>
                    <button class="btn-generic btn-cuenta-pago" id="onVerClick" data-email=${mail}>Ver</button>
                    ${deshabilitarButtonHTML}
                </div>
            </div>`

        : 
            `
            <div class="card card-donation-false">
                <h3>${emprendimiento}</h3>
                <p style="color:#626567 "> <b>Nombre:</b> ${nombre}</p>
                <p style="color:#626567 "> <b>Whatsapp:</b> ${telefono}</p>
                <p style="color:#626567 "> <b>Mail:</b> ${mail}</p>
                <p style="color:#626567 "> <b>Dirección:</b> ${direccion}</p>
                <p style="color:#626567 "> <b>Horario laboral:</b> ${horaInicio} - ${horaFin}</p>
                ${redesHTML}
                <div>
                    <button class="btn-generic btn-cuenta-pago" id="onVerClick" data-email=${mail}>Ver</button>
                    ${deshabilitarButtonHTML}
                </div>
            </div>
            `

}

const dynamicUpdateRubros = () =>{

    const selectRubros = document.getElementById("rubros")

    for (const rubro in rubrosENUM) {
        if (rubrosENUM.hasOwnProperty(rubro)) {
            const opcion = document.createElement("option")
            opcion.value = rubro
            opcion.textContent = rubrosENUM[rubro]
            selectRubros.appendChild(opcion)
        }
    }

}

document.addEventListener('DOMContentLoaded', ()=>{
    const dataCardJSON = JSON.stringify(dataCard)
    const storedData = JSON.parse(localStorage.getItem('dataCard') || dataCardJSON)
    const userLogin = JSON.parse(localStorage.getItem('userLogin')) || []

    /* Si se borran todos los emprendimientos descomentar la linea de abajo y recargar pagina.
    Despues comentarla nuevamente*/
    localStorage.setItem('dataCard', JSON.stringify(dataCard))

    if(localStorage.getItem('adminLogin') == "true"){
        handlerDOM('ADMIN')
    }

    if(localStorage.getItem('adminLogin') == "false" && userLogin.isLogged == true){
        handlerDOM(userLogin.email.split('@')[0])
    }

    dynamicUpdateCard(storedData)
    filteredCards(storedData)
    dynamicUpdateRubros()
})

export default dynamicUpdateCard