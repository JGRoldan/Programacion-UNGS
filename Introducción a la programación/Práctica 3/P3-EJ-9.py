#-------------------------
#--------------Ejercicio 9
#-------------------------

#----A

n=int(input('Ingrese un numero positivo: '))

if(n>0):
    for i in range(1,n+1):
        if(n%i==0):
            print(n,'Es divisible por',i)
else:
    print('n>0')

#----B

n=int(input('Ingrese un numero positivo: '))

if(n>0):
    for i in range(1,n+1):
        if(n%i==0 and i%2==0):
            print('Los divisores pares de',n,'->',i)
else:
    print('n>0')

#----C

n=int(input('Ingrese un numero positivo: '))
a=0
if(n>0):
    for i in range(1,n+1):
        if(n%i==0):
            a+=1
    print(n,'Tiene',a,'divisores')
else:
    print('n>0')

#----D

n=int(input('Ingrese un numero positivo: '))
a=0
if(n>0):
    for i in range(1,n+1):
        if(n%i==0):
            a+=i
    print(a)
else:
    print('n>0')
