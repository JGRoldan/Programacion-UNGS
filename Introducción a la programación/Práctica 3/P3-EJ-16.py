#-------------------------
#-------------Ejercicio 16
#-------------------------

#----A

n=int(input('Ingrese un numero positivo: '))
e=1
acum=0
for i in range(1,n+1):
    e*=i
    acum+=1/e
print(acum+1) ##acum + 1/0! = acum + 1

#----B
#----C
##A partir de n=3-4 el error es chico
from math import e
print(((e-(acum+1))/e)*100)

#----D
#????