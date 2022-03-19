#Ejercicio 18
s = int(input('ingrese un tiempo en segundos ---->'))

d=s//86400 #seg en 1 dia
d1=s%86400
h= d1//3600 #seg en 1 h
h1 = s%3600
m=h1//60 #seg en 1 min
s1=h1%60


print('{} dia {} horas {} minutos {} segundos'.format(d,h,m,s1))
#print(f'{d} dia {h} horas {m} minutos {s1} segundos')

#-------------------------------------------------------------------------------
#Ejercicio 19
x = int(input('Ingrese un numero --->'))
y = int(input('Ingrese un numero --->'))

print('El valor del primer numero es \n --->', x)
print('El valor del segundo numero es \n --->', y)

x , y = x, y

print('El nuevo valor del primer numero es \n--->', x)
print('El nuevo valor del segundo numero es \n--->', y)


#-------------------------------------------------------------------------------
#Ejercicio 20
x = int(input('Ingrese un numero --->'))
y = int(input('Ingrese un numero --->'))
z = int(input('Ingrese un numero --->'))

x , y , z = y , z , x

print('El valor de x es:',x)
print('El valor de y es:',y)
print('El valor de z es:',z)





