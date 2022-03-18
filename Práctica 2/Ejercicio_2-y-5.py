#------------------------------
#-------------------Ejercicio 2
#------------------------------

edad = int(input('Ingrese su edad ---->'))
distancia = int(input('Ingrese la distancia al centro de votacion ---->'))

print('Los ciudadanos exentos de votar son: \n - Mas de 70 años o, \n - Tengan entre 18 y 70 años pero se encuentren a mas de 500 km del centro de votacion')

if(edad>70 or (18<edad<70 and distancia>500)):
    print('No es necesario que vaya al centro de votacion')
else:
    print('Usted debe ir a votar')

#------------------------------
#-------------------Ejercicio 5
#------------------------------

nota = int(input('Ingrese una nota entre 0 y 10: '))

if(nota<4):
    print('Debe recuperar')

