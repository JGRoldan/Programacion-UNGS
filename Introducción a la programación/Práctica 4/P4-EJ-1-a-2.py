# -------------------
# ----------------- 1
# -------------------

# ----A

def raiz(x):
    if x<0:
        return 'El numero debe ser mayor a 0'
    else:
        return x**(1/2)
print(raiz(float(input('Ingrese un numero mayor a 0: '))))

# ----B

def raiz(x):
    if x<0:
        return x*-1
    else:
        return x
print(raiz(float(input('Ingrese un numero: '))))

# ----C

def raiz(x):
    if x<0:
        return (x-3)*-1
    else:
        return (x-3)
print(raiz(float(input('Ingrese un numero: '))))

# ----D

def raiz(x):
    if x-5<0:
        return 'Ingrese un valor mayor o igual a 5'
    else:
        return (x-5)**(1/2)
print(raiz(float(input('Ingrese un numero: '))))


# -------------------
# ----------------- 2
# -------------------

def cuak():                             
    chan()                                
    print('pienso que ',end='')             #4
    chan()

def chan():
    print('yo', end='')                 #2   5   8       
    plin()

def plin():
    print('.')                          #3   6   9       

print('No, yo ',end='')                 #1
cuak()
print('Yo ',end='')                                 #7
chan()

# No, yo yo. pienso que yo. Yo yo.

