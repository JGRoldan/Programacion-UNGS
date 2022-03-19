#------------------------------
#-------------------Ejercicio 15
#------------------------------

a=int(input('Ingrese un numero: '))
b=int(input('Ingrese un numero: '))
c=int(input('Ingrese un numero: '))
print('Variables antes del condicional: ','A->',a,'B->',b,'C->',c)
print('Variables despues del condicional: ')
if(a>b>c): # if(a>b and a>c and b>c)
    a , b , c = c , b , a
    print('Variable: A',a,'\nVariable: B',b,'\nVariable: C',c)
elif(b>a>c): # elif(b>a and b>c and a>c)
    a , b , c = c , a , b
    print('Variable: A',a,'\nVariable: B',b,'\nVariable: C',c)
elif(b>c>a): #elif(b>a and b>c and c>a)
    a , b , c = a , c , b
    print('Variable: A',a,'\nVariable: B',b,'\nVariable: C',c)
elif(c>a>b): #elif(c>a and c>b and a>b)
    a , b , c = b , a , c
    print('Variable: A',a,'\nVariable: B',b,'\nVariable: C',c)
elif(c>b>a): #elif(c>a and c>b and b>a)
    a , b , c = a , b , c
    print('Variable: A',a,'\nVariable: B',b,'\nVariable: C',c)


#------------------------------
#-------------------Ejercicio 16
#------------------------------

year=int(input('Ingrese un año para saber si es bisiesto--> '))

if(year%4==0 and (year%100!=0 or year%400==0)):
    print('El año',year,'es bisiesto')
else:
    print('El año ingresado NO bisiesto')
