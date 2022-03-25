#-------------------------
#--------------Ejercicio 1
#-------------------------

#---A

i=1
while(i<=5):
    print(i)
    i+=1
########## FOR
for i in range(1,6):
    print(i)

#---B

n=int(input('Ingrese un numero:'))
i=1
while(i<=n):
    print(i)
    i+=1

########## FOR

for i in range(1,n+1):
    print(i)

#-------------------------
#--------------Ejercicio 2
#-------------------------

#---A

i=4
while(i<=7):
    print(i)
    i+=1

########## FOR

for i in range(i,8):
    print(i)

#---B

m=int(input('Ingrese un numero:'))
n=int(input('Ingrese otro numero:'))

if(m>=0 and n>=0):
    if(m>n):
        while(m>=n):
            print(m)
            m-=1
    else:
        while(n>=m):
            print(m)
            m+=1
else:
    print('(m,n) >= 0')

########## FOR

if(m>=0 and n>=0):
    if(m>n):
        for i in range(m,n-1,-1):
            print(i)
    else:
        for i in range(m,n+1):
            print(i)
else:
    print('(m,n) >= 0')


#-------------------------
#--------------Ejercicio 3
#-------------------------

#---A

i=10
j=i+5

while(i<j):
    i+=1
    print(i)

########## FOR

for i in range(i+1,j+1):
    print(i)

#---B

i=int(input('Ingrese un numero: '))
j=i+5

while(i<j):
    i+=1
    print(i)

########## FOR

for i in range(i+1,j+1):
    print(i)

#---C

i=int(input('Ingrese un numero: '))
j=int(input('Ingrese un numero: '))

if(i<j):
    while(i<j):
        i+=1
        print(i)
else:
    print('n1>n2')

########## FOR

if(i<j):
    for i in range(i+1,j+1):
        print(i)
else:
    print('n1>n2')

