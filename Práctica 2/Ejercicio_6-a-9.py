#------------------------------
#-------------------Ejercicio 6
#----------------------------A

a=float(input('Ingrese un numero: '))
b=float(input('Ingrese otro numero: '))

if(a>b):
    print('El mayor entre los dos es: ', a)

#----------------------------B
a=float(input('Ingrese un numero: '))
b=float(input('Ingrese otro numero: '))

if(a>b):
    print('El menor entre los dos es: ', b)


#------------------------------
#-------------------Ejercicio 7
#------------------------------

a=float(input('Ingrese un numero: '))
b=float(input('Ingrese otro numero: '))
prom=(a+b)/2 > 7

if(prom):
    print('Aprobado')
else:
    print('Desaprobado')

#------------------------------
#-------------------Ejercicio 8
#------------------------------

a=int(input('Ingrese un numero mayor a cero: '))

if(a<0):
    print('El numero debe ser mayor a cero')
elif(0<a<=9):
    print('Usted ingreso un numero de una cifra')
else:
    print('El numero ingresado es de mas de una cifra')


#------------------------------
#-------------------Ejercicio 9
#------------------------------

dni1=30612453
dni2=23763290
dni3=21448503
dni4=34582048
dni5=15364857
dnix=12121212

if(dnix==dni1 or dnix==dni2 or dnix==dni3 or dnix==dni4 or dnix==dni5):
    print('El DNI', dnix , 'ya esta registrado en nuestra base de datos')
else:
    print('DNI', dnix , 'ingresado en nuestra base de datos')


