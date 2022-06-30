import sys
import pygame
from principal import *

def reglas():
    pygame.init()
    pygame.display.set_caption("Reglas")
    size=(1000,600)
    screen=pygame.display.set_mode(size)
    fondo=pygame.image.load("imagenes/reglas.jpg")
    screen.blit(fondo,(0,0))

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                sys.exit()
            if event.type==pygame.KEYDOWN:
                if event.key==pygame.K_ESCAPE:
                    return
        
        pygame.display.flip()