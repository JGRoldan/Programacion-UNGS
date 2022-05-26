# -------------------
# ----------------- 20
# -------------------

#----A

def menor(s,x):
    cont=0

    for i in s:
        if i<x:
            cont+=1

    return cont

s=[1,2,3,4,5,6,7,9]
x=4.8

print(menor(s,x))


#----B

##??


# -------------------
# ----------------- 21
# -------------------

def cambiar(s,x):

    for i in range(len(s)):
        if s[i]<x:
          s[i]=0
    
    return s

s=[1,2,3,1,4,5,6,7,9]
x=4.1

print(cambiar(s,x))


# -------------------
# ----------------- 22
# -------------------

def cantidad(palabra,letra):
  cont=0
  for i in palabra:
    if i==letra:
      cont+=1
  return cont

def palabra(palabra):
  archivo=[]
  for i in palabra:
    if i not in archivo:
      archivo.append(i)
      print(i,':',cantidad(palabra,i))

palabra('conocido')

# -------------------
# ----------------- 23
# -------------------

def cantidad(palabra,letra):
  cont=0
  for i in palabra:
    if i==letra:
      cont+=1
  return cont

def palabra(palabra):
  archivo=[]
  for i in palabra:
    if i not in archivo:
      archivo.append(i)
      print(i,':',cantidad(palabra,i)*'*')

palabra('conocido')
