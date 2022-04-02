#-------------------------
#-------------Ejercicio 18
#-------------------------
n=int(input('Ingrese un numero: '))
m=int(input('Ingrese otro numero: '))

if(n<m):
    for i in range(n,m+1):
        for j in range(n,m+1):
            print(i,j)
else:
    print('El segundo numero debe ser menor al primero')
#-------------------------
#-------------Ejercicio 19
#-------------------------
n=int(input('Ingrese un numero: '))
m=int(input('Ingrese otro numero: '))

if(n<m):
    for i in range(n,m+1):
        for j in range(n,m+1):
            if i==j or i<j:
                print(i,j)
else:
    print('El segundo numero debe ser menor al primero')