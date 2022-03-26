#-------------------------
#-------------Ejercicio 14
#-------------------------

#----A


n=int(input('Ingrese un numero positivo: '))

if(n>0):
    res=0
    for i in range(1,n+1):
        if(i%2==0):
            res-=1/i
        else:
            res+=1/i
    print(res)
else:
    print('n>0')

#----B

##Si n=700 el error es de 0.1%
from math import log
ln=log(2)
print((-(res-log)/log)*100) ##porcentaje de error

#----C
##Si n=7000 el error es de 0.01%

#----D

#????