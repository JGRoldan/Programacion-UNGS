from funcionesSeparador import *
from principal import *
from configuracion import *
import random
from final import*
from pygame.locals import *


validar=False
def lectura(archivo, salida):
#Recorrer el archivo lemario que viene de "principal.py"
#y despues almacenar cada uno de estos valores en salida.
#strip() saca los espacios del principio y final de una cadena.
    for palabra in archivo:
        salida.append(palabra.strip())


def nuevaPalabra(lista): #AGREGADO 
    return random.choice(lista) #de la lista que recibe, elige un elemento al azar

def palabraTOsilaba(palabra): #AGREGADO
    return separador(palabra)

def palabraTOsilabaEspacio(palabra): 
    return separadorEspacios(palabra)


def esCorrecta(palabraEnSilabasEnPantalla, palabra): #AGREGADO
    if palabraEnSilabasEnPantalla==palabra:
        global validar
        validar=True
        return True
    validar=False
    return False


def puntaje(palabra):
    puntos=0
    if validar:
        puntos+=5
    else:
        puntos-=5
    return puntos


###########################
#   CONTROLA CADA NIVEL   #
###########################

lema=open("lemario.txt","r")
nivel1=open("nivel1","w")
nivel2=open("nivel2","w") #"w", lee el archivo 
for palabra in lema:
    if len(palabra)<=6:
        nivel1.write(palabra)
    if len(palabra)>6:
        nivel2.write(palabra)
lema.close()
nivel1.close()
nivel2.close()

###########################
#          RANKING        #
###########################

#Abre el archivo de texto "records" para adherir elementos a el "a"
records=open("records.txt","a")
#Abre el archivo de texto "records" para leerlo "r" y para modificarlo "+"
leerRecords=open("records.txt","r")


#Llama a ranking que devuelve que devuelve una lista y controla el largo
# para que agregue los elementos solo si esta es menor a 4 (un total de 5)
def puntajes(nombre, puntaje):
    global records
    if (len(ranking(leerRecords))) <= 4:
        records.write(nombre+"->"+str(puntaje)+"\n")
    else:
        record=open("records.txt","r")
        rank=ranking(record)
        puntos=obtieneNumeros(rank)
        cont=0
        for p in puntos:
            if int(p)<puntaje and cont<1:
                records.write(nombre+"->"+str(puntaje)+"\n")
                cont+=1
    record.close()


