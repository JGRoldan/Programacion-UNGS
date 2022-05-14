# -------------------
# ----------------- 1
# -------------------


from operator import length_hint


animales=['elefante','jirafa','mono']
nuevoAnimal=input('Ingrese un nuevo animal: ')
animales.append(nuevoAnimal)
print(animales[len(animales)-1])


# -------------------
# ----------------- 2
# -------------------

def mostarEnUnaLinea(enteros):
    for i in enteros:
        print(i,end=' ')

enteros=[1,2,3,4,5,6,7,8,9,10]
mostarEnUnaLinea(enteros)


# -------------------
# ----------------- 3
# -------------------

def divisores(num):
    listaDiv=[]
    for i in range(1,num+1):
        if num%i==0:
            listaDiv.append(i)
    return listaDiv

num=int(input('Ingrese un numero: '))
print(divisores(num))

# -------------------
# ----------------- 4
# -------------------

def laMasCorta(lista1,lista2):
    if len(lista1)>len(lista2):
        return lista1
    return lista2

lista1=[1,2,3,4,5,6]
lista2=[1,2,3]
print(laMasCorta(lista1,lista2))


# -------------------
# ----------------- 5
# -------------------

def sonFactores(n,lista):
    cont=0
    for i in range(len(lista)):
        if n%lista[i]==0:
            cont+=1
    if cont==len(lista):
        return True
    return False

print(sonFactores(11,[1,2,3,4,5,6,7,8,9,10,11]))


# -------------------
# ----------------- 6
# -------------------

def repetidos(lista):
    if len(lista)==len(set(lista)):
        return False
    return True

print(repetidos([1,2,3,4]))

#----------ó-----------

def repetidos(lista):
    rep=[]
    sinrep=[]
    for i in lista:
        if i not in sinrep:
            sinrep.append(i)
        else:
            rep.append(i)
    if len(rep)>0:
        return True
    return False

# -------------------
# ----------------- 7
# -------------------

def dondeAparece(blanco,lista):
    for i in range(len(lista)):
        if lista[i]==blanco:
            return i
    return -1

print(dondeAparece(4,[0,1,4,3,8]))


# -------------------
# ----------------- 8
# -------------------

def promedio(lista):
    tot=0
    for i in lista:
        tot+=i
    return tot/len(lista)

print(promedio([1.2,2.3,3.4,4.5,5.6,6.7]))


# -------------------
# ----------------- 9
# -------------------

def maximo(lista):
    maxElem=lista[0]
    for i in lista:
        if i>maxElem:
            maxElem=i
    return maxElem

print(maximo([1,2,10,50,5]))


# -------------------
# ----------------- 10
# -------------------

def maximo(lista):
    maxElem=lista[0]
    for i in lista:
        if i>maxElem:
            maxElem=i
            
    index=0
    for i in range(len(lista)):
        if maxElem==lista[i]:
            index=i
    return index

print(maximo([1,60,10,50,5]))