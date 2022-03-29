#-------------------------
#-------------Ejercicio 28
#-------------------------

p = input('Ingresa una palabra: ')
l = input('Ingresa una letra: ')


print(p.replace(l,'*'))


#-------------------------
#-------------Ejercicio 29
#-------------------------

import random

apellido = 'rivera'
arr=[]
n=random.randint(0,9)

for i in apellido:
    if i!='a' and i!='e' and i!='i' and i!='o' and i!='u':
        arr.append(i)

unir=''.join(arr)[0:4]

while len(unir)<4:
    unir+='*'

print('Su usuario privosorio es:',unir+str(n))


#-------------------------
#-------------Ejercicio 30
#-------------------------

nombre=input('Ingrese su nombre: ')
apellido=input('Ingrese su apellido: ')
dni=int(input('Ingrese su DNI: '))

num=str(dni)[0:3]+'_'
ap=apellido[0:3]
nom=nombre[0] + nombre[len(nombre)-1]

legajo=num+ap+nom
print(nombre,apellido,dni,'\nLegajo: ',legajo)


