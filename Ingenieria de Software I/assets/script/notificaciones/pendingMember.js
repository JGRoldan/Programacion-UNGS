const pendingNotifications = (data) =>{
    const mail = {
        "Para": "admin@admin.com",
        "Asunto": "Aspirante a miembro nuevo",
        "Cuerpo": "Ingresa a el portal y verificá la pestaña de pendientes",
        "datos": [data]
    }

    console.log("Enviando mail al moderador...")
    console.log(mail)
}

export default pendingNotifications

