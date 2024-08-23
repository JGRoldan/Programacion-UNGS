const notificationHandler = (title, text, icon, callback = null) => {
    Swal.fire({
        title: title,
        text: text,
        icon: icon,
        showConfirmButton: false,
        timer: 3000,
        didClose: () => {
            if (callback) {
                callback()
            }
        }
    })
}

export default notificationHandler