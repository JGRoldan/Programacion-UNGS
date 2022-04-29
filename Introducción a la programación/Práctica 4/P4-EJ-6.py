# -------------------
# ----------------- 6
# -------------------

# ----A

def exclamar(cadena):
    acum='¡'
    for i in cadena:
        acum+=i
    acum+='!'
    return acum

print(exclamar(input('Ingresa una cadena:')))

# ----B

def gritar(cadena):
    acum='¡¡¡'
    for i in cadena:
        acum+=i
    acum+='!!!'
    return acum

print(gritar(input('Ingresa una cadena:')))

# ----C

def exclamar(cadena):
  acum='¡'
  for i in cadena:
      acum+=i
  acum+='!'
  return acum

def gritar(cadena):
  acum2='¡¡'
  exclamar(cadena)
  nuevacadena=exclamar(cadena) #¡hola!
  for i in nuevacadena:
    acum2+=i
  acum2+='!!' 
  return acum2 #¡¡¡hola!!!

print(gritar('hola'))