# -------------------
# ----------------- 11
# -------------------

#---- A

def ast(cadena,letra):
    cantidadLetra=0

    for i in cadena:
        if i==letra:
            cantidadLetra+=1
    print('La letra',letra,'aparecio',cantidadLetra)

ast('Sobrevivir','i')



#---- C

def ast(cadena,letra):
    cantidadLetra=0

    for i in cadena:
        if i==letra:
            cantidadLetra+=1
    c='* '+str(cantidadLetra)+' *'     
    for i in range(3):
        if i==0 or i==2:
            print('*'*len(c))
        else:
            print(c)

ast('Sobrevivir','i')