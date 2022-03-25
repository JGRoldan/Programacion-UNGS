#------------------------------
#-------------------Ejercicio 15
#------------------------------

a=int(input('Ingrese un numero: '))
b=int(input('Ingrese un numero: '))
c=int(input('Ingrese un numero: '))

if(a > b):
    aux = b
    b = a
    a = aux

if(b > c):
    aux = b 
    b= c
    c = aux

if(a > b):
    aux = b
    b = a
    a = aux

print("el valor de a es:",a)
print("el valor de b es:",b)
print("el valor de c es:",c)


#------------------------------
#-------------------Ejercicio 16
#------------------------------

year=int(input('Ingrese un año para saber si es bisiesto--> '))

if(year%4==0 and (year%100!=0 or year%400==0)):
    print('El año',year,'es bisiesto')
else:
    print('El año ingresado NO bisiesto')
