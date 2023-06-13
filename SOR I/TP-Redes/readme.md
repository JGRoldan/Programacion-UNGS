## Consigna
Tu equipo ha sido convocado para hacer el trabajo. La casa central se encuentra en Buenos Aires, y
posee sucursales en Córdoba y La Rioja.
La sede ubicada en el microcentro porteño, tiene un edificio de 4 pisos, con un total de 500
computadoras. Estas están distribuidas lógicamente en diferentes departamentos a saber:  
● Departamento de Desarrollo Tecnológico: tiene 260 computadoras o nodos.  
● Diseño Gráfico: 70 computadoras o hosts.  
● Gerencia: 90 nodos.  
● Contabilidad 80 hosts.  
● Se le ha pedido a tu equipo que segmente utilizando un switch central, se han comprado
dos routers Cisco para comunicar la red lan con el exterior.  
● Casa matriz posee 1 Web server que aloja el sitio oficial de skynet.com.ar.  

Sucursal Córdoba:  
● 150 nodos, Administración 90 y Ventas 60. Cuenta 1 switch y un router Cisco.  
Sucursal La Rioja:  
● 297 hosts. Administración 48, Ventas 100, Marketing 149.   

Se pide:  
● Diseñar la red de John Connor, eligiendo la red privada 172.16.0.0 utilizando subredes ajustando
a la necesidades que más se adecue a las necesidades de la compañía.  
● Subnetear por departamento para segmentar, y de esa forma evitar la propagación innecesaria
de tráfico.  
● Todos los routers de todas las sucursales se conectan entre sí, mediante direcciones públicas de
la clase que más se ajuste a la cantidad de nodos.   
● Habilitar en toda la red protocolo de enrutamiento RIP versión 2, para todos los nodos lleguen a
cualquier nodo de la red.   
● Una vez diseñada la red completa y probada, se pide analizar el tráfico entrante y saliente del
servidor web de la compañía. (Opcional)   
● Crear un servidor DNS en casa matriz para que resuelva el dominio http://www.skynet.com.ar
desde todas las computadoras que posee en Argentina.  
