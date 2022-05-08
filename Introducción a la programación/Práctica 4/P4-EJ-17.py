# -------------------
# ----------------- 11
# -------------------

#---- A

def tieneRepetidas(cadena):
    letra=input('Ingrese el caracter que quiere buscar: ')
    cont=0
    for i in cadena:
        if i==letra:
            cont+=1
        if cont>=2:
            return True
    return False

cadena=input('Ingrese una cadena: ')
print(tieneRepetidas(cadena))

#---- B

def aparece(cadena,letra):
    
    cont=0
    for i in cadena:
        if i==letra:
            return True
    return False

cadena=input('Ingrese una cadena: ')
letra=input('Ingrese el caracter que quiere buscar: ')
print(aparece(cadena,letra))

#---- C

def dameRepetida(cadena):
    separarCadena=[]
    for i in cadena:
        separarCadena.append(i)
    archivo=[]
    repetidos=[]
    for i in separarCadena:
        if i not in archivo:
            archivo.append(i)
        elif i!=' ':
            repetidos.append(i)

    print(repetidos[0])
cadena='hola ke tal'
dameRepetida(cadena)

#---- D

def quitarRepeticiones(cadena,letra):
  cont=0
  new=''
  for i in cadena:
    if i==letra and cont==0:
      cont+=1
      new+=i
    elif i==letra and cont!=0:
      new+=''
    else:
      new+=i
  return new

cadena='mate cocido'
letra='c'
print(quitarRepeticiones(cadena,letra))
