import pygame
from funcionesVACIAS import *
from configuracion import *


def dameLetraApretada(key):
    if key == K_a:
        return("a")
    elif key == K_b:
        return("b")
    elif key == K_c:
        return("c")
    elif key == K_d:
        return("d")
    elif key == K_e:
        return("e")
    elif key == K_f:
        return("f")
    elif key == K_g:
        return("g")
    elif key == K_h:
        return("h")
    elif key == K_i:
        return("i")
    elif key == K_j:
        return("j")
    elif key == K_k:
        return("k")
    elif key == K_l:
        return("l")
    elif key == K_m:
        return("m")
    elif key == K_n:
        return("n")
    elif key==241: #Letra ñ
        return("ñ")
    elif key == K_o:
        return("o")
    elif key == K_p:
        return("p")
    elif key == K_q:
        return("q")
    elif key == K_r:
        return("r")
    elif key == K_s:
        return("s")
    elif key == K_t:
        return("t")
    elif key == K_u:
        return("u")
    elif key == K_v:
        return("v")
    elif key == K_w:
        return("w")
    elif key == K_x:
        return("x")
    elif key == K_y:
        return("y")
    elif key == K_z:
        return("z")
    elif key == 45: #Guion medio cerca del ENTER
        return("-")
    elif key == K_KP_MINUS:
        return("-")
    elif key == K_SPACE:
       return(" ")
    else:
        return("")
        

###########################
#  FUNCION DIBUJARNOMBRE  #
###########################
#"dibuja" el nombre en pantalla

def dibujarNombre(nombre):
    fuenteNombre= pygame.font.Font( 'fuente/game_over.ttf', 60)
    fuenteIngrese= pygame.font.Font('fuente/game_over.ttf', 130)
    cuadrado=Rect(420,300,200,50)
    pygame.draw.rect(screen,(255,255,255),cuadrado)
    #Controla la ubicación en el centro de la pantalla de "Ingrese su nombre" 
    ingresarNombre=fuenteIngrese.render("Ingrese su nombre", 1, (255,255,255))
    screen.blit(ingresarNombre,(420+(cuadrado.width-ingresarNombre.get_width())/2,150+(cuadrado.height-ingresarNombre.get_height())/2))
    #Controla la ubicación de la palabra en el centro del rectángulo
    nombreIng=fuenteNombre.render(nombre,1,COLOR_FONDO)
    screen.blit(nombreIng,(420+(cuadrado.width-nombreIng.get_width())/2,295+(cuadrado.height-nombreIng.get_height())/2))

###########################
#     FUNCION DIBUJAR     #
###########################
#Función que "dibuja" el juego en si   
def dibujar(screen, palabraUsuario, palabraActual, puntos, segundos, palabraEnPantallaAnterior,validarRespuesta,palabraEnPantallaEnSilabas):

    defaultFont= pygame.font.Font( pygame.font.get_default_font(), TAMANNO_LETRA)
    defaultFontGrande= pygame.font.Font( pygame.font.get_default_font(), TAMANNO_LETRA_GRANDE)
    defaultFontChica= pygame.font.Font( pygame.font.get_default_font(), TAMANNO_LETRA_CHICA)
    #Linea Horizontal
    pygame.draw.line(screen, (255,200,255), (0, ALTO-70) , (ANCHO, ALTO-70), 25)
    
    #Muestra lo que escribe el jugador
    screen.blit(defaultFont.render(palabraUsuario, 1, COLOR_FONDO), (420, 570))
    #Muestra el puntaje
    screen.blit(defaultFont.render("Puntos: " + str(puntos), 1, COLOR_FONDO), (860, 10))


    #Muestra tu respuesta fue: #AGREGADO
    screen.blit(defaultFontChica.render("Tu respuesta fue: ", 1, COLOR_FONDO), (10, 520))

    #Muestra palabra correcta: #AGREGADO
    screen.blit(defaultFontChica.render("Respuesta correcta: ", 1, COLOR_FONDO), (420, 520))
    
    #Muestra si la palabra que ingreso el usuario esta bien o no (VERDE= OK / ROJO = WRONG) #AGREGADO
    if validarRespuesta:
        rtaUser=defaultFont.render(palabraEnPantallaAnterior, 1, COLOR_TEXTO_OK)
        
    else:
        rtaUser=defaultFont.render(palabraEnPantallaAnterior, 1, COLOR_TEXTO_BAD)
        rtaRight=screen.blit(defaultFont.render(palabraEnPantallaEnSilabas,1,COLOR_TEXTO_OK),(570, 520))

    #Muestra los segundos y puede cambiar de color con el tiempo
    if(segundos<15):
        ren = defaultFont.render("Tiempo: " + str(int(segundos)), 1, COLOR_TIEMPO_FINAL)
    else:
        ren = defaultFont.render("Tiempo: " + str(int(segundos)), 1, COLOR_FONDO)
    screen.blit(rtaUser,(150, 520))
    screen.blit(ren, (10, 10))

    #Muestra la palabra
    screen.blit(defaultFontGrande.render(palabraActual, 1, COLOR_FONDO), (ANCHO//2-len(palabraActual)*TAMANNO_LETRA_GRANDE//4,ALTO-350))





