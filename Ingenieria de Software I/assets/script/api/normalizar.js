const obtenerDireccionNormalizada = async (direccion) =>{
    const URL = `https://servicios.usig.buenosaires.gob.ar/normalizar/?direccion=${direccion}&geocodificar=TRUE`

    const result = await fetch(URL)
    const direcciones = result.json()

    return direcciones
}

export default obtenerDireccionNormalizada