# -------------------
# ----------------- 11
# -------------------

def maximoEntre(lista,x,y):
    maxElem=lista[0]
    for i in lista:
        if i>maxElem and x<i<y:
            maxElem=i

    index=0
    for i in range(len(lista)):
        if maxElem==lista[i]:
            index=i
    return index

lista=[1,5,6,8,10,50]
x=int(input('Ingrese dos numeros entre 1 y ' + str(len(lista))))
y=int(input('Ingrese dos numeros entre 1 y ' + str(len(lista))))

print(maximoEntre(lista,x,y))

# -------------------
# ----------------- 12
# -------------------

def intercambiar(lista,x,y):
    lista[x]=lista[y]
    return lista

lista=[1,5,6,8,10,50]
x=int(input('Ingrese dos numeros entre 1 y ' + str(len(lista))+ '-->'))
y=int(input('Ingrese dos numeros entre 1 y ' + str(len(lista))+ '-->'))
print(maximoEntre(lista,x,y))

# -------------------
# ----------------- 13
# -------------------

def frecuencia(lista,x):
    cont=0
    for i in lista:
        if i==x:
            cont+=1
    return cont

print(frecuencia([1,2,3,4,5,2,7,2,2],2))

# -------------------
# ----------------- 14
# -------------------

def interseccion(lista1,lista2):
    lista3=[]
    for i in lista1:
        for j in lista2:
            if i==j:
                lista3.append(j)
    return lista3

lista1=set([1,2,2,2,3,4,5,5])
lista2=set([1,2,3,3,5,5])

print(interseccion(lista1,lista2))

# -------------------
# ----------------- 15
# -------------------

def union(lista1,lista2):
    lista3=list(set(lista1+lista2))
    return lista3

lista1=list(set([1,2,2,2,3,4,5,5]))
lista2=list(set([1,2,3,3,5,5,6,7,8,9]))

print(union(lista1,lista2))


# -------------------
# ----------------- 16
# -------------------

def diferencia(lista1,lista2):
    lista3=[]
    for i in lista1:
        if i not in lista2:
            lista3.append(i)
    return lista3

lista1=list(set([1,2,3,4,5]))
lista2=list(set([1,2,6,7,8]))

print(diferencia(lista1,lista2))

