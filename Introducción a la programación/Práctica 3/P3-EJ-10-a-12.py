#-------------------------
#-------------Ejercicio 10
#-------------------------
n=int(input('Ingrese un numero positivo: '))

if(n>0):
    for i in range(1,n+1):
        print(1*i)
else:
    print('Ingrese un n>0')


#-------------------------
#-------------Ejercicio 11
#-------------------------

m=int(input('Ingrese un numero positivo: '))
aux=0

if(m>0):
    for i in range(1,m+1):
        aux+=i
        if(aux<m):
            n=i+1
    print(n)
else:
    print('m>0')


#-------------------------
#-------------Ejercicio 12
#-------------------------

#----A

validar=True

while(validar==True):
    n=int(input('Ingrese un numero positivo: '))

    if(n>0):
        validar=False
        for i in range(1,n+1):
            print(2*i)
    else:
        print('Ingrese un n>0')

#----B

validar=True

while(validar==True):
    n=int(input('Ingrese un numero positivo: '))

    if(n>0):
        validar=False
        for i in range(1,n+1):
            print((2*i)-1)
    else:
        print('Ingrese un n>0')

#----C

validar=True

while(validar==True):
    n=int(input('Ingrese un numero positivo: '))

    if(n>0):
        validar=False
        for i in range(1,n+1):
            print(i**2)
    else:
        print('Ingrese un n>0')

#----D

validar=True

while(validar==True):
    n=int(input('Ingrese un numero positivo: '))

    if(n>0):
        validar=False
        for i in range(1,n+1):
            print((i**3)-(i**2))
    else:
        print('Ingrese un n>0')

#----E

validar=True

while(validar==True):
    n=int(input('Ingrese un numero positivo: '))

    if(n>0):
        validar=False
        for i in range(1,n+1):
            print(1/(i**2))
    else:
        print('Ingrese un n>0')