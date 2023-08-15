# DER

1. Una empresa vende productos a varies clientes. Se necesitan conocer los datos personales de les clientes—i.e. nombre, apellido, DNI, dirección, y fecha de nacimiento. Cada producto tiene un nombre y un código, así como un precio unitario. Une cliente puede comprar varios productos a la empresa, y un mismo producto puede ser comprado por varies clientes. Los productos son suministrados por diferentes proveedores. Se debe tener en cuenta que un producto sólo puede ser suministrado por une proveedore, y que une proveedore puede suministrar diferentes productos. De cada proveedore se desea conocer su CUIT, nombre, y dirección.

2. Una tienda de música desea modelar a les compositores de sinfonías, a las sinfonías, y a la relación entre ambes. De les compositores se conoce su nombre y su fecha de nacimiento, mientras que de cada sinfonía se conoce el nombre de su compositore, el género, la tonalidad, y los distintos instrumentos que se utilizan para su ejecución.

3. La panadería y confitería "El Churro de Chocolate" está organizando el delivery a sus clientes, para ello han dividido la ciudad en zonas. Cada zona tiene un nombre que la identifica. Cada cliente pertenece a una zona. Les repartidores tienen asignades clientes, cada cliente puede ser atendide por más de une repartidore, ó por ningune. A cada zona se le asigna une repartidore como jefe de esa zona. Une repartidore puede ser jefe de varias zonas ó de ninguna. De les repartidores se conoce el nombre y legajo. De les clientes se conoce el nombre, teléfono, dirección, y la fecha de la primera compra.

4. Modificar el DER anterior para que se pueda registrar cada vez que se realiza una entrega a domicilio, le repartidore que la realizó, la fecha y hora de la entrega y el monto pagado por le cliente.

5. La cadena de restaurantes "La Angioplastía" ha relevado información acerca de les clientes y de sus preferencias. De cada persona, identificada por su documento de identidad, se conoce su nombre, el restaurante que más frecuenta, y las comidas que más le gustan. De cada restaurante, identificado por su nombre, se conocen las comidas que preparan. De cada comida se conoce el nombre que la identifica, el tiempo de preparación, y los ingredientes que lleva y en qué cantidades. De los ingredientes se conoce, nombre, proveedore, precio, y unidad en la que está expresado el precio.

6. Modificar el DER anterior considerando los siguientes cambios:

   - Una persona frecuenta varios restaurantes.

   - A una persona no le gusta una comida por si sola, sino que le gusta como la sirven en determinados restaurantes.

7. La cooperativa de payases "Berumoddo" coordina las actuaciones de sus payases integrantes. Les payases tienen sus propias actuaciones—pueden tener más de una. De les payases se conoce su nombre y edad. Cada actuación pertenece a une únique payase y se pone en escena en un circo. De acuerdo al convenio que firmó, la cooperativa con la "Asociación de Circos Peronistas", las actuaciones son exclusivas para cada circo, pero en cada circo puede haber más de una actuación, aún correspondiente a distintes payases. Cada actuación tiene un nombre y un precio de entrada. Cada circo tiene un nombre, y una fecha de fundación.

8. El Registro Civil de las Personas, desea llevar un registro de todas las personas. De cada persona se conoce su primer y segundo nombre, su apellido, su fecha de nacimiento, y su número de DNI. También se desea llevar registro acerca de quienes se han casado, y con quién. Adicionalmente, se desea llevar un registro de quienes son les xadres biológiques de cada persona, y eventualmente, de quienes son les xadres adoptives.

9. La veterinaria "Pet Shop of Horrors" necesita llevar un control informatizado de su gestión. De cada animal—ó paciente—se desea guardar el código, el nombre, el tipo de animal, la raza, y el año de nacimiento. De cada dueñe de cada animal se desea guardar nombre, apellido, dirección, y teléfono.

También, se desea llevar un control de cada una de las veces que se atiende a une animal, registrando la fecha, el diagnostico, el tratamiento, le veterinarie que le atendió, y el costo de la consulta. La veterinaria tiene varies veterinaries, de les cuales se desea registrar, su número de matrícula, fecha de ingreso, nombre y apellido.

Une veterinarie puede atender a varies animales, pero una consulta es atendida por une únique veterinarie.

Adicionalmente, de les perres se desea guardar la fecha de su última vacuna contra la rabia, y de les gates se desea registrar el color de su pelaje.

Un problema adicional que tienen en esta veterinaria, es que suele suceder que les animales que están siendo atendides, ante una distracción de les veterinaries, se pelean entre elles, y les veterinaries por temor a lastimarse elles mismes no les separan. Le propietarie de la veterinaria ha puesto un premio para cada veterinarie que separa a les animales que se pelean. Por lo tanto, se desean registrar les animales que participaron en la pelea, y le veterinarie que les separo.

10. El Ministerio de Salud desea mantener un sistema de información relativo a los hospitales. A continuación, se detalla lo que se desea modelar:

hospital con los datos: código que lo identifica, nombre, dirección, teléfono, y cantidad de camas.

sala con los datos: código, nombre, y cantidad de camas.

médique con los datos: DNI, nombre, y especialidad.

laboratorio con los datos: código que lo identifica, nombre, dirección, teléfono.

paciente con los datos: DNI, número de historia clínica, número de cama, nombre, dirección, fecha de nacimiento, y sexo.

diagnóstico con los datos: código que lo identifica, tipo, y complicaciones.

Además, sabemos que:

Cada hospital tiene varias salas. Cada una de ellas pertenece a un solo hospital. En distintos hospitales pueden haber salas con el mismo código, pero esto no puede ocurrir dentro de un mismo hospital.

Cada médique trabaja en un único hospital.

Cada hospital trabaja con muchos laboratorios, y un laboratorio presta servicios a más de un hospital. Nos interesa conocer la descripción de cada servicio prestado por el laboratorio a un hospital, y la fecha en que se realizó.

Une paciente puede estar internade en una única sala.

Cada paciente puede ser atendide por más de une médique, y a su vez cada médique atenderá a varies pacientes. Nos interesa conocer las fechas de las atenciones.

Cada paciente puede tener varios diagnósticos. Nos interesa saber la fecha en que se realizó cada uno. 

