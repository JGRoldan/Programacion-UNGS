import sys
import pygame
from principal import *
from pygame.locals import *
from funcionesVACIAS import*

pygame.init()

#Configuración de fuentes
defaultFont= pygame.font.Font( 'fuente/game_over.ttf', 150)
defaultFontGrande= pygame.font.Font( 'fuente/game_over.ttf', 100)
defaultFontChica= pygame.font.Font( 'fuente/game_over.ttf', 80)

#Configuraciones de pantalla
size=(1000,600)
screen=pygame.display.set_mode(size)

#Recuadro que se utiliza para centrar todo en el medio de la pantalla
recuadro=Rect(10,25,1000,600)
pygame.draw.rect(screen,(200,200,200),recuadro)
#Apertura del archivo records en lectura
records=open("records.txt","r")

###########################
#   RANKING EN PANTALLA   #
###########################
#Obtiene una lista con los ranking nombres y puntajes
def ranking(archivo):
    puntajes=[]
    for puntaje in archivo:
        puntajes.append(puntaje[:-1])
    archivo.close()
    return puntajes


#Función que retorna una lista con los nombres en el record (solo nombres)
def obtenerNombres(lista):
    nombres=[]
    for nombre in lista:
        indice=nombre.find('-')
        nombres.append(nombre[:indice])
    return nombres

#Función que retorna una lista con los puntajes en el record (solo números)
def obtieneNumeros(lista):
    numeros=[]
    for puntaje in lista:
        indice=puntaje.find('>')+1
        numeros.append(puntaje[indice:])
    return numeros

#Agrega en la pantalla los elementos de las listas, nombre y puntaje del mayor record           
def dibujarRanking():
    rank=ranking(records) #lista de records nombre + puntaje
    ubicacion=100 #para controlar ubicación de elementos en y
    puntos=obtieneNumeros(rank) #lista de puntos, solo números
    nombres=obtenerNombres(rank) #lista de nombres, solo números
    mejor=-1 #controla el mejor número en puntos, es decir, el mejor puntaje
    i=0 #controla el indice del mejor puntaje para usarlo también en el nombre y mostrarlos juntos
    for elemento in range(len(puntos)):
        if int(puntos[elemento])>mejor:
            mejor=int(puntos[elemento])
            i=elemento
    nomb=defaultFontChica.render(nombres[i],1,(0,0,0))#nombre en el indice i
    screen.blit(nomb,(0+(recuadro.width-nomb.get_width())/2,ubicacion+(recuadro.height-nomb.get_height())/2))
    punto=defaultFontChica.render(puntos[i],1,(0,0,0))#puntaje en el indice i
    screen.blit(punto,(0+(recuadro.width-punto.get_width())/2,(ubicacion+50)+(recuadro.height-punto.get_height())/2))           
    pygame.display.flip()


###########################
#        GAME OVER        #
###########################

def pantallaFinal(nombre,puntos):
    pygame.init()
    pygame.display.set_caption("Juego Finalizado")
    size=(1000,600)
    screen=pygame.display.set_mode(size)
    screen.fill((255,255,255)) #pantalla en blanco
    texto=defaultFont.render("Tu puntaje fue de: ", 1, (0,0,0))
    textoNombre=defaultFontGrande.render(nombre, 1, (0,0,0))
    textoPuntos=defaultFontGrande.render(str(puntos), 1, (0,0,0))
    textoSalir=defaultFontChica.render("Presione ESC para salir ", 1, (0,0,0))
    textoMejorJugador=defaultFontChica.render("El mejor jugador fue: ", 1, (0,0,0))
    recuadro=Rect(0,0,1000,600)
    pygame.draw.rect(screen,(200,200,200),recuadro)#dibuja el recuadro en color blanco se hace de esta forma para acceder al ancho y al alto y asi poder centrar las palabras
    screen.blit(texto,((recuadro.width-texto.get_width())/2,-150+(recuadro.height-texto.get_height())/2))
    screen.blit(textoNombre,((recuadro.width-textoNombre.get_width())/2,-100+(recuadro.height-textoNombre.get_height())/2))
    screen.blit(textoPuntos,((recuadro.width-textoPuntos.get_width())/2,-30+(recuadro.height-textoPuntos.get_height())/2))
    screen.blit(textoSalir,((recuadro.width-textoSalir.get_width())/2,260+(recuadro.height-textoSalir.get_height())/2))
    screen.blit(textoMejorJugador,((recuadro.width-textoMejorJugador.get_width())/2,60+(recuadro.height-textoMejorJugador.get_height())/2))

    dibujarRanking()
    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                sys.exit()
            if event.type==pygame.KEYDOWN:
                if event.key==pygame.K_ESCAPE:
                    sys.exit()
        
        pygame.display.flip()


    