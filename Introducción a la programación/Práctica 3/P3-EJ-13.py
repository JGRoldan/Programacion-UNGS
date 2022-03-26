#-------------------------
#-------------Ejercicio 13
#-------------------------

#----A

validar=True

while(validar==True):
    n=int(input('Ingrese un numero positivo: '))
    acum=0
    if(n>0):
        validar=False
        for i in range(1,n+1):
            acum+=2*i
        print(acum)
    else:
        print('Ingrese un n>0')

#----B

validar=True

while(validar==True):
    n=int(input('Ingrese un numero positivo: '))
    acum=0
    if(n>0):
        validar=False
        for i in range(1,n+1):
            acum+= i**2
        print(acum)
    else:
        print('Ingrese un n>0')

#----C

validar=True

while(validar==True):
    n=int(input('Ingrese un numero positivo: '))
    acum=0
    if(n>0):
        validar=False
        for i in range(1,n+1):
            acum+= ((i**3)-(i**2))
        print(acum)
    else:
        print('Ingrese un n>0')

#----D

validar=True

while(validar==True):
    n=int(input('Ingrese un numero positivo: '))
    acum=0
    if(n>0):
        validar=False
        for i in range(1,n+1):
            acum+= (1/(i**2))
        print(acum)
    else:
        print('Ingrese un n>0')

##Cuando se incrementa el valor de N, el valor del ACUM se acerca a 2,
##pero nunca es 2

