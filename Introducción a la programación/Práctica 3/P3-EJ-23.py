#-------------------------
#-------------Ejercicio 23
#-------------------------

#----A
n=int(input('Ingresa un numero positivo: '))

if(n>0):
        print('*'*n)
else:
    print('n>0')


#----B

n=int(input('Ingresa un numero positivo: '))

if(n>0):
    for i in range(1,n+1):
        print('*'*i)
else:
    print('n>0')

#----C

n=int(input('Ingresa un numero positivo: '))

if(n>0):
    for i in range(1,n+1):
        print(((2*i)-1)*'*')
else:
    print('n>0')