#-------------------------
#-------------Ejercicio 17
#-------------------------

#----A

n=int(input('Ingrese un numero positivo: '))
m=int(input('Ingrese otro numero positivo: '))

for i in range(0,n+1):
    for j in range(m,0,-1):
        print(end='')
    print(n+i,m-i)

#----B

n=int(input('Ingrese un numero positivo: '))
m=int(input('Ingrese otro numero positivo: '))

for i in range(0,n+1):
    for j in range(m,0,-1):
        print(end='')
    if(n+i<m-i):
        print(n+i,m-i)