# DEPENDENCIAS FUNCIONALES
1. Dadas las siguientes relaciones, indicar cuáles son las dependencias funcionales no triviales que se deberían cumplir.
   alumne(nro_legajo, nombre, apellido, dni, carrera, materia, nota_final).

   empleade(legajo, nombre, apellido, dpto, legajo_jefe_dpto, f_ingreso, salario).

2. Dada la relación
   artículo(cod, descr, costo, precio, stock, prov)
   y conjunto de dependencias funcionales

   F = {cod → descr stock, cod prov → costo, costo → precio, descr → cod},

   indicar cuales de las siguientes dependencias funcionales se pueden deducir de F usando los axiomas de Armstrong. En caso de que no se puedan deducir, demostrar mediante una instancia de la 
   relación artículo que sirva de contraejemplo.

      a) cod prov → descr precio
  
      b) cod → precio
  
      c) descr → stock
  
      d) precio → costo
  
      e) descr prov → cod descr costo precio stock prov
