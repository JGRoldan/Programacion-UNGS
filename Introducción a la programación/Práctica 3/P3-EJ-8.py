#-------------------------
#--------------Ejercicio 8
#-------------------------

#----A

n=int(input('Ingrese un numero: '))

for i in range(n):
    if(pow(2,i)<n):
        print(pow(2,i))


#----B

n=int(input('Ingrese un numero: '))

if(n>0):
    for i in range(n):
        print(pow(2,i))
else:
    print('n>0')

#----C

n=int(input('Ingrese un numero: '))

if(n>0):
    for i in range(1,n+1):
        print(pow(i,i))
else:
    print('n>0')
