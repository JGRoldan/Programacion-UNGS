# -------------------
# ----------------- 3
# -------------------

# ----A

def repetir(cadena):
    for i in range(3):
        print(cadena)

# ----B

#se guarda en un .py y para usarlo en otro archivo =>

# ----C
#from <nombre del archivo.py> import *
repetir(input('ingresa una cadena: '))

# -------------------
# ----------------- 4
# -------------------

# ----A

def prom(x,y):
    return (x+y)/2

# ----B

n1=float(input('n1: '))
n2=float(input('n2: '))
print(prom(n1,n2))

# ----C
def prom2(x,y,z):
    return (x+y+z)/3

n3=float(input('n3: '))
n4=float(input('n4: '))
n5=float(input('n5: '))
print(prom2(n3,n4,n5))


# -------------------
# ----------------- 5
# -------------------
def asboluto(x):
    if x<0:
        return x*-1
    else:
        return x
print(asboluto(float(input('Ingresa un numero real: '))))
