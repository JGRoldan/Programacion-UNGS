# -------------------
# ----------------- 12
# -------------------

def esPrimo(n):
    for i in range(2,n//2+1):
        if n%i==0:
            return False
    return True

def divisoresPrimos(n):
    cont=0
    for i in range(2,n+1):
        if n%i==0 and esPrimo(i):
            #Explicacion abajo
            if n%i**2==0:
                cont+=1
            else:
                cont-=1
    if cont>=1:
        print(n,'Si es poderoso')
    else:
        print(n, 'No es poderoso')

divisoresPrimos(12)
divisoresPrimos(36)

#En el caso de 12, i= 2 y 3
#12 % 4=0 =>cont=1
#12 % 9!=0 =>cont=0
#Entonces como cont<1 el numero NO es poderoso

#En el caso de 36, i= 2 y 3
#36 % 4=0 =>cont=1
#36 % 9==0 =>cont=2
#Entonces como cont>=1 el numero SI es poderoso

#-------------OTRA FORMA-------------
def primo(n):
    bandera=True
    for i in range(2,n//2+1):
        if(n%i==0):
            bandera=False
    return bandera

a=int(input("Ingrese un numero"))
poderoso=True
for i in range (1,a+1):
    if(a%i==0 and primo(i)):
        if(a%(i*i)!=0):
            poderoso=False

if (poderoso==True):
    print(a,"Si es poderoso")
else:
    print(a,"NO es poderoso")