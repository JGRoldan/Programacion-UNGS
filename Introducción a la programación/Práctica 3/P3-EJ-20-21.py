#-------------------------
#-------------Ejercicio 20
#-------------------------


from random import randint

random = randint(0,99)
print(random)
multiplicador = 70
intento = 0

while (intento < 5):
    n=int(input('Ingrese un numero entre 0 y 99: '))
    m=int(input('Ingrese el monto a apostar: '))
    if(n==random):
        print('Ganaste','$', m*multiplicador)
        break
    print('Perdiste, volve a intentarlo \n')
    intento+=1
if(intento==5):
    print('Perdiste toda la plata.')


#-------------------------
#-------------Ejercicio 21
#-------------------------

import random

r=['piedra','papel','tijera']
scoreJugador=0
scorePc=0
i=1

while i<=5:
    pc=random.choice(r)
    jugador=input('¿Piedra, papel o tijera?').lower()

    if (pc == jugador):
        print('-------Empate-------')
    if (jugador == 'piedra'):
        if (pc == 'papel'):
            print('-------Perdiste-------')
            scorePc+=1
        if (pc == 'tijera'):
            print('-------Ganaste-------')
            scoreJugador+=1
    if (jugador == 'papel'):
        if (pc == 'piedra'):
            print('-------Ganaste-------')
            scoreJugador+=1
        if (pc == 'tijera'):
            print('-------Perdiste-------')
            scorePc+=1
    if (jugador == 'tijera'):
        if (pc == 'piedra'):
            print('-------Perdiste-------')
            scorePc+=1
        if (pc == 'papel'):
            print('-------Ganaste-------')
            scoreJugador+=1
    i+=1
print('*****************')
if(scorePc == scoreJugador):
    print('EMPATARON')
elif(scorePc > scoreJugador):
    print('PERDISTE')
else:
    print('GANASTE')
print('*****************')