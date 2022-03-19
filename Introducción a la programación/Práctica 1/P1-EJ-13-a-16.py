#ejercicio 13

capInv = float(input('Capital a invertir: '))
mesInv = int(input('Cantidad de meses a invertir: '))

incBanco= (capInv*6)/100
profit = (incBanco*mesInv) + capInv
print('Tu ganancia podria ser de: ',profit)


#ejercicio 14

cantLlamadas = int(input('Cantidad de llamas realizadas: '))
T= float(input('Cantidad de tiempo en llamadas: '))

precioFinal = (cantLlamadas *12) + (T*1.5)

print('El precio será de: ',precioFinal)

#ejercicio 15

monto1 = float(input('Ganancia en la primer venta: '))
monto2 = float(input('Ganancia en la segunda venta: '))
monto3 = float(input('Ganancia en la tercera venta: '))
sB=42000
extra = 10

montoTotal = ((monto1+monto2+monto3)*extra)/100
sueldoFinal = montoTotal + sB

print('Este mes recibiras: $',sueldoFinal)


#ejercicio 16

s = int(input('Ingrese una cantidad de segundos: '))
m=s/60
h=m/60
d=h/24

print(f'Ingresaste {s}s, serian {m}min, {h}hs y {d} dias')