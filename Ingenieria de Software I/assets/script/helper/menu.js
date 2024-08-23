const handlerDOM = (name) =>{
    const usernameElement = document.getElementById("username")
    usernameElement.innerHTML = name
    usernameElement.style.display = "inline"

    const logoutLink = document.getElementById("logoutLink")
    logoutLink.style.display = "inline"

    const pendingLink = document.getElementById("pendingLink")
    pendingLink.style.display = "inline"

    const loginLink = document.getElementById("loginLink")
    loginLink.style.display = "none"

    const registerLink = document.getElementById("registerLink")
    registerLink.style.display = "none"
}

export default handlerDOM
