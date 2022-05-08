# -------------------
# ----------------- 13
# -------------------

#   PRUEBA CON DOS NUMEROS

#   30  | 2             12 | 2
#   15  | 3             6  | 2
#   5   | 5             3  | 3
#   1                   1

# 30=2*3*5              12 = 2**2 * 3

# Al imprimir en pantalla los divisores primos del 12
# en pantalla muestra 2 y 3. Porque el 2 esta elevado al cuadrado
# por ende el 12 NO es libre de cuadrados.

#Entonces basta con preguntar si el producto de los divisores primos es < al numero dado => NO es libre de cuadrados


def esPrimo(num):
    for i in range(2,num):
        if num%i==0:
            return False
    return True

def divPrimo(num):
    productoDivPrimos=1
    for i in range(2,num):
        if esPrimo(i) and num%i==0:
            productoDivPrimos*=i
    return productoDivPrimos

num=30
if divPrimo(num)<num:
    print('No es Libre de Cuadrado')
else:
    print('Libre de cuadrado')