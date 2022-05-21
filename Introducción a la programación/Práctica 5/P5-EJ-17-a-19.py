# -------------------
# ----------------- 17
# -------------------

def mcd(x,y):
    listaX=[]
    listaY=[]
    for i in range(1,x+1):
        if x%i==0:
            listaX.append(i)
    for i in range(1,y+1):
        if y%i==0:
            listaY.append(i)

    maxElem=0
    for max in listaX:
        if max>maxElem and max in listaY:
            maxElem=max
    return maxElem

print(mcd(24,36))


# -------------------
# ----------------- 18
# -------------------


def primos(x):
    listaPrimos=[]
   
    for i in range(1,x+1):
      cont=0
      for j in range(1,i+1):
          if i%j==0:
              cont+=1
      if cont==2:
        listaPrimos.append(i)
    
    return listaPrimos

print(primos(7))


# -------------------
# ----------------- 19
# -------------------


def factorizar(x):
    primos=[]

    for i in range(2,x//2+1):
        while x%i==0:
            primos.append(i)
            x=x/i
    return primos

print(factorizar(24))