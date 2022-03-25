#-------------------------
#--------------Ejercicio 4
#-------------------------

#---A

i=5
while(i<=11):
    print(i)
    i+=2

########## FOR

for i in range(i,12,2):
    print(i)

#---B

m=int(input('Ingrese un numero: '))
n=int(input('Ingrese un numero: '))

if(m<n):
    while(m<=n):
        print(m)
        m+=3
else:
    print('n1>n2')

########## FOR

if(m<n):
    for i in range(m,n+1,3):
        print(i)
else:
    print('n1>n2')

#---C

m=int(input('Ingrese un numero: '))
n=int(input('Ingrese un numero: '))
p=int(input('Ingrese un numero: '))

if(m<n):
    while(m<=n):
        print(m)
        m+=p
else:
    print('n1>n2')

########## FOR

if(m<n):
    for i in range(m,n+1,p):
        print(i)
else:
    print('n1>n2')


#-------------------------
#--------------Ejercicio 5
#-------------------------

i=8
while(i>=3):
    print(i)
    i-=1

########## FOR

for i in range(i,2,-1):
    print(i)

#-------------------------
#--------------Ejercicio 6
#-------------------------

i=15
while(i>=5):
    print(i)
    i-=3

########## FOR

for i in range(i,4,-3):
    print(i)
