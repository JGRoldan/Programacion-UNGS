#-------------------------
#-------------Ejercicio 15
#-------------------------

#----A


n=int(input('Ingrese un numero positivo: '))
k = 1
s = 0
acum=0
for i in range(n):
    acum+=1
    if i % 2 == 0:
        s += 1/k
    else:
        s-=1/k
    k+= 2
    if(acum==8):
        print(f'Acotando {s}')
print(f'Sin acotar los terminos {s}')

#----B
##Cuando N=300, el error es de 0.1
from math import pi
print((((1/4*pi)-s)/(1/4*pi))*100)

#----C
##Cuando N=3000, el error es de 0.1

#----D

#????
