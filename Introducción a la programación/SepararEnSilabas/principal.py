import pygame
from pygame.locals import *
from configuracion import *
from extras import *
from funcionesSeparador import *
from final import*
from funcionesVACIAS import *
from reglas import *

nivelFacil=False
nivelDificl=False
nivelNormal=False
nombre=""

###########################
#       FUNCION MAIN      #
###########################

def main():
        #Variables

        global screen
        gameClock = pygame.time.Clock()
        totaltime = 0
        segundos = TIEMPO_MAX
        fps = FPS_inicial
        puntos = 0
        palabra = ""
        listaPalabrasDiccionario=[]
        contadorRespuestasCorrectas=0
        validarRespuesta=''
        palabraEnPantallaAnterior=""
        palabraEnPantallaEnSilabas=''
        pygame.time.delay(100) #Espera 100ms para que no se superpongan los sonidos

        #Fondo personalizado
        fondo=pygame.image.load("imagenes/menu.jpg")
        screen.blit(fondo,(0,0))

        #Sonidos personalizados
        pygame.mixer.init()
        wrongAnswer=pygame.mixer.Sound("Sound/mal.mp3")
        goodAnswer=pygame.mixer.Sound("Sound/bien.wav")
        pocoTiempo=pygame.mixer.Sound("Sound/tiempo.wav")
        cincoCorrectas=pygame.mixer.Sound("Sound/levelup.flac")
        #Musica de fondo
        musicaDeFondo=pygame.mixer.Sound("Sound/musicpiano.mp3")
        musicaDeFondo.play()
        musicaDeFondo.set_volume(0.1)
        pocoTiempo.set_volume(0.1)

        #Titulo en ventana de main
        pygame.display.set_caption("El juego de separar en silabas...")
        #Seleccion de nivel
        if nivelFacil:
            archivo=open("nivel1","r")
        if nivelDificl:
            archivo=open("nivel2","r")
        if nivelNormal:
            archivo=open("lemario.txt","r")

        #Lectura del lemario
        lectura(archivo, listaPalabrasDiccionario)

        #Elige una palabra al azar
        palabraEnPantalla=nuevaPalabra(listaPalabrasDiccionario)

        while segundos > fps/1000:
            #Sonido cuando falten menos de 15 segundos
            if segundos <15:
                musicaDeFondo.stop()
                pocoTiempo.play()
            
            #Pantalla de game over
            if segundos<1:
                pocoTiempo.stop()
                puntajes(nombre,puntos)
                pantallaFinal(nombre,puntos)         

        # 1 frame cada 1/fps segundos
            gameClock.tick(fps)
            totaltime += gameClock.get_time()

            #Buscar la tecla apretada del modulo de eventos de pygame
            for e in pygame.event.get():

                #QUIT es apretar la X en la ventana
                if e.type == QUIT:
                    pygame.quit()
                    sys.exit() 
                if e.type==pygame.KEYDOWN:
                    if e.key==pygame.K_ESCAPE:
                        sys.exit()
                #Ver si fue apretada alguna tecla
                if e.type == KEYDOWN:
                    letra = dameLetraApretada(e.key)
                    palabra += letra #Palabra que escribe el usuario
                    if e.key == K_BACKSPACE:
                        palabra = palabra[0:len(palabra)-1]
                    if e.key == K_RETURN:
                        #pasa la palabra a silabas con espacios o con guion medio
                        palabraEnPantallaEnSilabas=palabraTOsilaba(palabraEnPantalla) #separa con -
                        palabraEnPantallaConEspacios=palabraTOsilabaEspacio(palabraEnPantalla) #separa con ' '
                        palabraEnPantallaAnterior=palabra

                        #Verifica que el usuario haya separado bien en silabas
                        #Si separo bien y lleva 5 rta correctas suma 15 sino suma 5. 
                        #Si NO separo bien resta 5
                        if esCorrecta(palabraEnPantallaEnSilabas,palabra) or esCorrecta(palabraEnPantallaConEspacios,palabra):
                            contadorRespuestasCorrectas+=1
                            if contadorRespuestasCorrectas==5:                         
                                puntos+=15
                                cincoCorrectas.play()
                                validarRespuesta=True
                                contadorRespuestasCorrectas=0

                            else:
                                goodAnswer.play()
                                validarRespuesta=True 
                                puntos +=puntaje(palabra)
                        else:
                            contadorRespuestasCorrectas=0
                            wrongAnswer.play()
                            validarRespuesta=False
                            puntos+=puntaje(palabra)

                        #Elige una al azar como proxima palabra
                        palabraEnPantalla=nuevaPalabra(listaPalabrasDiccionario)
                        palabra = ""

            segundos = TIEMPO_MAX - totaltime/1000

            #Limpiar pantalla anterior
            screen.blit(fondo,(0,0))

            #Dibujar de nuevo todo
            #AGREGADO los últimos 3 parámetros
            dibujar(screen, palabra, palabraEnPantalla, puntos,segundos,palabraEnPantallaAnterior,validarRespuesta,palabraEnPantallaEnSilabas)
            
            pygame.display.flip()

        archivo.close()


###########################
#       FUNCION MENU      #
###########################

pygame.font.init()
pygame.display.set_caption("Menu principal")
fuente=pygame.font.Font('fuente/tiza.ttf', 30)
screen=pygame.display.set_mode((1000,600))
clickea=pygame.mixer.Sound("Sound/selectOption.mp3")
clickea.set_volume(0.1)
wrongAnswer=pygame.mixer.Sound("Sound/mal.mp3")
#Agregar img de boton y modificar su escala
postit=pygame.image.load('imagenes/post.png').convert_alpha()
postit = pygame.transform.scale(postit, (250, 250))

def dibujarmenu(texto,fuente,color,surface,x,y):
    texto=fuente.render(texto, 1, color)
    #obtiene el rectangulo
    textorect=texto.get_rect()
    #obtiene de la parte superior izquierda el angulo en x e y
    textorect.topleft = (x,y)
    #dibuja el texto en el rectangulo
    surface.blit(texto,textorect)


def menu():
    while True:
        #Variables
        global screen
        click=False
        pygame.display.set_caption("Menu principal")
        pygame.init()
        fondo=pygame.image.load("imagenes/menu.jpg")
        screen.blit(fondo,(0,0))
        pygame.mixer.init()
        #dibuja el menú a partir de la funcion dibujarmenu
        dibujarmenu("Menú principal",fuente, (255,255,255), screen,300,20)
        #calcula la posición del mouse
        mouseEnX, mouseEnY = pygame.mouse.get_pos()

        #Configuracion boton 1
        #rectangulo
        opcion1=Rect(100,200,200,50)
        #color
        pygame.draw.rect(screen,(255,0,0),opcion1)
        screen.blit(postit, postit.get_rect(center = opcion1.center))
        #texto sobre el recuadro
        texto1=fuente.render("Facil", 1, (0,0,0)) 
        #controla la ubicación de la palabra en el centro del rectángulo
        screen.blit(texto1,(100+(opcion1.width-texto1.get_width())/2,200+(opcion1.height-texto1.get_height())/2))

        #Configuracion boton 2
        opcion2=Rect(400,200,200,50)
        #color
        pygame.draw.rect(screen,(255,0,0),opcion2)
        screen.blit(postit, postit.get_rect(center = opcion2.center))
        #texto sobre el recuadro
        texto2=fuente.render("Dificil", 1, (0,0,0)) 
        #controla la ubicación de la palabra en el centro del rectángulo
        screen.blit(texto2,(400+(opcion2.width-texto2.get_width())/2,200+(opcion2.height-texto2.get_height())/2))

        #Configuracion boton 3
        opcion3=Rect(700,200,200,50)
        #color
        pygame.draw.rect(screen,(255,0,0),opcion3)
        screen.blit(postit, postit.get_rect(center = opcion3.center))
        #texto sobre el recuadro
        texto3=fuente.render("Normal", 1, (0,0,0)) 
        #controla la ubicación de la palabra en el centro del rectángulo
        screen.blit(texto3,(700+(opcion3.width-texto3.get_width())/2,200+(opcion3.height-texto3.get_height())/2))

        #Configuracion boton 4
        opcion4=Rect(400,450,200,50)
        #color
        pygame.draw.rect(screen,(255,0,0),opcion4)
        screen.blit(postit, postit.get_rect(center = opcion4.center))
        #texto sobre el recuadro
        texto4=fuente.render("Reglas", 1, (0,0,0)) 
        #controla la ubicación de la palabra en el centro del rectángulo
        screen.blit(texto4,(400+(opcion4.width-texto4.get_width())/2,450+(opcion4.height-texto4.get_height())/2))

        for evento in pygame.event.get():
            if evento.type == QUIT:
                pygame.quit()
                sys.exit() 

            if evento.type == KEYDOWN:
                if evento.key==K_ESCAPE:
                    pygame.quit()
                    sys.exit() 

            if evento.type == MOUSEBUTTONDOWN:
                if evento.button == 1:
                    click=True

        #Detectar la colision del mouse con los botones
        if opcion1.collidepoint((mouseEnX,mouseEnY)):
            if click:
                global nivelFacil
                clickea.play()
                nivelFacil=True
                main()

        if opcion2.collidepoint((mouseEnX,mouseEnY)):
            if click:
                global nivelDificl
                clickea.play()
                nivelDificl=True
                main()  
             
        if opcion3.collidepoint((mouseEnX,mouseEnY)):
            if click:
                global nivelNormal
                clickea.play()
                nivelNormal=True
                main()             

        if opcion4.collidepoint((mouseEnX,mouseEnY)):
            if click:
                reglas()

        pygame.display.flip()


def name():
    while True:
        #Variables
        global nombre
        global screen

        pygame.init()
        fondo=pygame.image.load("imagenes/menu.jpg")
        screen.blit(fondo,(0,0))
        #Muestra el nombre en pantalla
        dibujarNombre(nombre)
        
        #Detecta nombre del usuario
        for evento in pygame.event.get():
            if evento.type == KEYDOWN:
                l = dameLetraApretada(evento.key)
                nombre += l 
                if evento.key == K_BACKSPACE:
                        nombre = nombre[0:len(nombre)-1]
                if evento.key == K_RETURN:
                    if len(nombre)==0:
                        wrongAnswer.play()
                    else:
                        clickea.play()
                        menu()
                    
            if evento.type == QUIT:
                pygame.quit()
                sys.exit() 

        pygame.display.update()

if __name__ == "__main__":
    name() #se ejecuta primero




