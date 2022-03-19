#------------------------------
#-------------------Ejercicio 17
#------------------------------

#Ax + B = 0 la ec. TIENE solucion y son TODOS los R
#Ax + B != 0 la ec. NO tiene solucion

print('Ecuacion de primer grado: Ax + B = 0')
a=float(input('Ingrese el coeficiente A: '))
b=float(input('Ingrese el coeficiente B: '))
print('La ecuacion es: ',a,'x','+',b,'= 0 \n')

if (a==0):
    print('La ecuacion no tiene solucion.')
else:
   x=(-b)/a
   print('El valor de la incognita es',x)
   print('La ecuacion tiene solucion en todos los reales')

#------------------------------
#-------------------Ejercicio 18
#------------------------------

from math import sqrt #Importo sqrt(raiz cuadrada) de la libreria MATH
#Sin la linea 1, la raiz cuadrada es x ** 0.5, donde x es un numero
#Ver ecuacion de 2do grado

a=int(input('Ingrese el coeficiente A: '))
b=int(input('Ingrese el coeficiente B: '))
c=int(input('Ingrese el coeficiente C: '))
print('La ecuacion es: ',a,'x^2','+',b,'x +',c,'\n')

coefRaiz = pow(b,2) - (4*a*c)
x1= (-b + sqrt(coefRaiz))/(2*a)
x2= (-b - sqrt(coefRaiz))/(2*a)

if(coefRaiz<0):
    print('∄ solucion en los reales')
elif(coefRaiz==0):
    print('La unica raiz posible es', x1)
else:
    print('La primer raiz es: ',x1,'\nLa segunda raiz es: ',x2)