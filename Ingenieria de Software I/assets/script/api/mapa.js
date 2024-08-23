let map;
const mostrarMapa = (x, y) =>{
    
    const mapa = document.querySelector('.contenedor-mapa')
    mapa.style.display='block'
    
    document.querySelectorAll('.close-mapa').forEach(closeBtn => {
        closeBtn.addEventListener('click', () => {
            mapa.style.display = 'none'
        })
    })

    if (map) {
        map.remove()
    }
    
    map = L.map('map', {
        center: [x, y],
        zoom: 14
    })
    
    const marker = L.marker([x, y]).addTo(map)
    
    L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
    }).addTo(map)
}

export default mostrarMapa

