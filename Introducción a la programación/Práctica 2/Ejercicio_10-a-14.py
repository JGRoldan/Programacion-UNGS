#------------------------------
#-------------------Ejercicio 10
#------------------------------

impuesto = 78
tarifaFija = 480
excedenteKW = 25.5
consumo = int(input('¿Cuantos KW excedentes has consumido?'))

if(consumo==0):
    print('Debido a que no consumiste KW excedentes, abonaras: \n','$', impuesto+tarifaFija)
else:
    print('Debido al consumo excedente de KW, abonaras: \n','$',(consumo*excedenteKW)+impuesto+tarifaFija)


#------------------------------
#-------------------Ejercicio 11
#------------------------------

a=float(input('Ingrese un numero: '))
b=float(input('Ingrese otro numero: '))
c=float(input('Ingrese un ultimo numero: '))

if (b<a>c):
    print('El mayor es: ',a)
elif (a<b>c):
    print('El mayor es: ',b)
elif (a<c>b):
    print('El mayor es: ',c)
else:
    print('Algunos de los numeros son iguales')


#------------------------------
#-------------------Ejercicio 12
#------------------------------


a=int(input('Ingrese una nota: '))
b=int(input('Ingrese otra nota: '))
c=int(input('Ingrese un ultimo nota: '))
prom = (a+b+c)/3

if(prom<=0):
    print('Alguno de los valores no es valido')
elif(prom<=3):
    print('Repobrado')
elif(prom<7):
    print('Debe rendir examen final')
else:
    print('Promociona')

#------------------------------
#-------------------Ejercicio 13
#------------------------------

a=int(input('Ingrese un numero: '))
b=int(input('Ingrese otro numero: '))

if(a>b):
    print('El primer valor ingresado fue ',a,' y es mayor que el segundo ',b)
else:
    print('El segundo valor ingresado fue ',b,' y es mayor que el primero ',a)


#------------------------------
#-------------------Ejercicio 14
#------------------------------


a=int(input('Ingrese un numero: '))
b=int(input('Ingrese otro numero: '))
print('Los valores ingresados fueron en el siguiente orden: ',a,b)

if(a<b):
    a,b=b,a
    print('Ordenado de mayor a menor quedaria: ',a,b)
else:
    print('Ordenado de mayor a menor quedaria: ',a,b)
