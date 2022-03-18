#------------------------------
#-------------------Ejercicio 2
#------------------------------

edad = 69
distancia = 100

print('Los ciudadanos exentos de votar son: \n - Mas de 70 años o, \n - Tengan entre 18 y 70 años pero se encuentren a mas de 500 km del centro de votacion')

if(edad>70 or (18<edad<70 and distancia>500)):
    print('No es necesario que vaya al centro de votacion')
else:
    print('Usted debe ir a votar')

#or (18<edad<70 and distancia>500)