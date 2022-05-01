# -------------------
# ----------------- 9
# -------------------

# ----A

def esMayor(x,y):
  if x<y:
    return y
  else:
    return x

print(esMayor(100,200))

# ----B

def esMayor(x,y,z):
  if x>y and x>z:
    return x
  elif y>x and y>z:
    return y
  elif z>x and z>y:
    return z
  else:
    return x

x=int(input('Ingrese un numero: '))
y=int(input('Ingrese un numero: '))
z=int(input('Ingrese un numero: '))
print(esMayor(x,y,z))

# -------------------
# ----------------- 10
# -------------------

def potencia(a,b):
  return a**b

a=int(input('Ingrese un numero: '))
b=int(input('Ingrese su potencia: '))
print(potencia(a,b))