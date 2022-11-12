.data
/* Definicion de datos */
bienvenida: .asciz " -------------------------------\n|     	┌─┐┬─┐┌─┐┌─┐  ╦         |\n|   	│ │├┬┘│ ┬├─┤  ║        	|\n|    	└─┘┴└─└─┘┴ ┴  ╩        	|\n|    ┌┬┐┌─┐┌┬┐┌─┐┌┬┐┌─┐┌─┐┌┬┐	|\n|    │││├┤ ││││ │ │ ├┤ └─┐ │ 	|\n|    ┴ ┴└─┘┴ ┴└─┘ ┴ └─┘└─┘ ┴ 	|\n|				|\n|     Para empezar presiona	|\n -------------------------------\n|       ┌─┐┌┐┌┌┬┐┌─┐┬─┐		|\n|       ├┤ │││ │ ├┤ ├┬┘		|\n|       └─┘┘└┘ ┴ └─┘┴└─		|\n -------------------------------\n"

bienvenidaLength = . - bienvenida

volverAJugar: .asciz "  _______ _______ _______ _______ _______ _______ \n|\     /|\     /|\     /|\     /|\     /|\     /|\n| +---+ | +---+ | +---+ | +---+ | +---+ | +---+ |\n| |   | | |   | | |   | | |   | | |   | | |   | |\n| |V  | | |O  | | |L  | | |V  | | |E  | | |R  | |\n| +---+ | +---+ | +---+ | +---+ | +---+ | +---+ |\n|/_____\|/_____\|/_____\|/_____\|/_____\|/_____\|\n                                                 \n                                                 \n _______                                         \n|\     /|                                        \n| +---+ |                                        \n| |   | |              (y or n)                  \n| |A  | |                                        \n| +---+ |                                        \n|/_____\|                                        \n                                                 \n                                                 \n _______ _______ _______ _______ _______         \n|\     /|\     /|\     /|\     /|\     /|        \n| +---+ | +---+ | +---+ | +---+ | +---+ |        \n| |   | | |   | | |   | | |   | | |   | |        \n| |J  | | |U  | | |G  | | |A  | | |R  | |        \n| +---+ | +---+ | +---+ | +---+ | +---+ |        \n|/_____\|/_____\|/_____\|/_____\|/_____\|        \n"

volverAJugarLength = .-volverAJugar

footer: .asciz "Ingrese primera posición (fila,columna):( , )  \nIngrese segunda posición (fila,columna):( , )  \nNº de intentos:0 \nNº de aciertos:0 \nNº de errores:0 \nVida restante:15 \n"
footerLength = .-footer

matrizInicial: .asciz "  0  1  2  3  4  5  6  7  8  9\n0 ?  ?  ?  ?  ?  ?  ?  ?  ?  ?\n1 ?  ?  ?  ?  ?  ?  ?  ?  ?  ?\n2 ?  ?  ?  ?  ?  ?  ?  ?  ?  ?\n3 ?  ?  ?  ?  ?  ?  ?  ?  ?  ?\n4 ?  ?  ?  ?  ?  ?  ?  ?  ?  ?\n5 ?  ?  ?  ?  ?  ?  ?  ?  ?  ?\n6 ?  ?  ?  ?  ?  ?  ?  ?  ?  ?\n7 ?  ?  ?  ?  ?  ?  ?  ?  ?  ?\n8 ?  ?  ?  ?  ?  ?  ?  ?  ?  ?\n9 ?  ?  ?  ?  ?  ?  ?  ?  ?  ?\n" 
matrizInicialLength =.-matrizInicial

perdiste: .asciz " ██████╗  █████╗ ███╗   ███╗███████╗\n██╔════╝ ██╔══██╗████╗ ████║██╔════╝\n██║  ███╗███████║██╔████╔██║█████╗  \n██║   ██║██╔══██║██║╚██╔╝██║██╔══╝  \n╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗\n ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝\n                                    \n ██████╗ ██╗   ██╗███████╗██████╗   \n██╔═══██╗██║   ██║██╔════╝██╔══██╗  \n██║   ██║██║   ██║█████╗  ██████╔╝  \n██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗  \n╚██████╔╝ ╚████╔╝ ███████╗██║  ██║  \n ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝  \n"                                    

perdisteLong= .-perdiste

ganaste: .asciz "██╗   ██╗ ██████╗ ██╗   ██╗\n╚██╗ ██╔╝██╔═══██╗██║   ██║\n ╚████╔╝ ██║   ██║██║   ██║\n  ╚██╔╝  ██║   ██║██║   ██║\n   ██║   ╚██████╔╝╚██████╔╝\n   ╚═╝    ╚═════╝  ╚═════╝\n                        \n██╗    ██╗██╗███╗   ██╗\n██║    ██║██║████╗  ██║\n██║ █╗ ██║██║██╔██╗ ██║\n██║███╗██║██║██║╚██╗██║\n╚███╔███╔╝██║██║ ╚████║\n ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝\n"

ganasteLong= .-ganaste

letraIngresada: .asciz " "

cls: .asciz "\x1b[H\x1b[2J" //borrar la pantalla usando ansi escape codes
lengthcls = . - cls

msgFila: .asciz "Ingrese el numero de FILA: "
filaLength = .-msgFila

msgColumna: .asciz "Ingrese el numero de COLUMNA: "
columnaLength = .-msgColumna

fila: .asciz "  "	//dato que ingresa el user en ascii
valorFila: .word 0	 //dato que ingresa el user en deicmal
columna:.asciz "  "
valorColumna: .word 0

primerCaracter: .asciz " "	//dato del primer caracter en la coordenada (fila,columna)
segundoCaracter: .asciz " "	//dato del segundo caracter en la coordenada (fila,columna)

signo: .asciz "?"
primerCordenada: .word 0	//valor decimal de la posicion exacta del la primer coordenada (fila,columna)
segundaCordenada: .word 0	//valor decimal de la posicion exacta del la segunda coordenada (fila,columna)
desde9: .asciz "9"
sumdesde9: .asciz "0"

.text

//----------------------------------------------------------
//Extrae de memoria los parametros necesarios para mostrar pantalla de juego
//----------------------------------------------------------
pantallaJuego:
                .fnstart
                push {r1,r2,lr}

                ldr r1, =matrizInicial
                ldr r2, =matrizInicialLength
                bl imprimirEnPantalla

                pop {r1,r2,lr}
                bx lr
                .fnend

//----------------------------------------------------------
//Extrae de memoria los parametros necesarios para mostrar el footer
//----------------------------------------------------------
mostrarFooter:
                .fnstart
                push {r1,r2,lr}

                ldr r1, =footer
                ldr r2, =footerLength
                bl imprimirSinClear

                pop {r1,r2,lr}
                bx lr
                .fnend


//----------------------------------------------------------
//limpia y dibuja en pantalla
//Input: r1= puntero al string , r2=longitud de lo que queremos imprimir
//Output: graba en memoria lo seleccionado utilizando la etiqueta palabra
//----------------------------------------------------------
imprimirEnPantalla:
      .fnstart
      push {r0,r1,r2,lr}
      bl clearScreen

      mov r7, #4
      mov r0, #1
      swi 0

      pop {r0,r1,r2,lr}

      bx lr
      .fnend

//----------------------------------------------------------
// Limpia la pantalla
//----------------------------------------------------------
clearScreen:
      .fnstart
                push {r0,r1,r2}

                mov r0, #1
                ldr r1, =cls
                ldr r2, =lengthcls

                mov r7, #4
                 swi #0

                pop {r0,r1,r2}
                 bx lr
        .fnend


//----------------------------------------------------------
//Extrae de memoria los parametros necesarios para mostrar pantalla inicial
//----------------------------------------------------------
pantallaIncial:
                .fnstart
                push {r1,r2,lr}

                ldr r1, =bienvenida
                ldr r2, =bienvenidaLength
                bl imprimirEnPantalla

                pop {r1,r2,lr}
                bx lr
                .fnend

//----------------------------------------------------------
//Extrae de memoria los parametros necesarios para mostrar pantalla volver a jugar
//----------------------------------------------------------
pantallaVolverAJugar:
                .fnstart
                push {r1,r2,lr}

                ldr r1, =volverAJugar
                ldr r2, =volverAJugarLength
                bl imprimirEnPantalla

                pop {r1,r2,lr}
                bx lr
                .fnend

//----------------------------------------------------------
//Lee la letra ingresada
//----------------------------------------------------------
leerLetraIngresada:
        .fnstart
        push {r1,lr}

        ldr r1,=letraIngresada
        bl leerteclado

        pop {r1,lr}
        bx lr
        .fnend


//-----------------------------------------------------------------
//extrae los caracteres que el usuario ingresa por teclado
//input r1= puntero a memoria donde guardar l
//Output: graba en memoria la cadena utilizando la etiqueta letraIngresada
//----------------------------------------------------------

leerteclado:
        .fnstart
                push {r0,r1,r2}

                mov r7, #3
                mov r0, #0
                mov r2,#4 
                swi 0

                pop {r0,r1,r2}
                bx lr
        .fnend


//----------------------------------------------------------
//dibuja en pantalla SIN CLEAR
//Input: r1= puntero al string , r2=longitud de lo que queremos imprimir
//Output: graba en memoria lo seleccionado utilizando la etiqueta palabra
//----------------------------------------------------------

imprimirSinClear:

      .fnstart
                push {r0,r1,r2,lr}

                mov r7, #4
                mov r0, #1
                swi 0

                pop {r0,r1,r2,lr}
                bx lr
      .fnend

//---------------------------------
//Iniciador del juego
//---------------------------------
primerCoordenada:
        .fnstart
                push {lr}

                bl ingreseFila
                bl leerFila
                bl asciiADecFila
                bl ingreseColumna
                bl leerColumna
                bl asciiADecColumna
                bl validarPrimerCoordenada
                bl reemplazarPrimerCoordenada
                pop {lr}
                bx lr
        .fnend


segundaCoordenada:
        .fnstart
                push {lr}

                bl ingreseFila
                bl leerFila
                bl asciiADecFila
                bl ingreseColumna
                bl leerColumna
                bl asciiADecColumna
                bl validarSegundaCoordenada
                bl reemplazarSegundaCoordenada
                pop {lr}
                bx lr
        .fnend
//------------------------------------------------------------------
//Extrae de memoria los parametros necesarios para imprimir en pantalla el mensaje de ingrese fila.
//----------------------------------------------------------
ingreseFila:
                .fnstart
                push {r1,r2,lr}

                ldr r1, =msgFila
                ldr r2, =filaLength
                bl imprimirSinClear

                pop {r1,r2,lr}
                bx lr
                .fnend


//------------------------------------------------------------------
//Extrae de memoria los parametros necesarios para leer los caracteres que el usuario ingresa por teclado
//----------------------------------------------------------

leerFila:
        .fnstart
                push {r1,lr}

                ldr r1,=fila
                bl leerteclado

                pop {r1,lr}
                bx lr
        .fnend
//------------------------------------------------------------------
// convierte ascci a decimal
//Extrae de memoria los parametros necesarios para la conversion.
//----------------------------------------------------------

asciiADecFila:
        .fnstart
                push {r1,r8,lr}

                ldr r1,=fila
                ldr r8, =valorFila
                bl convertAsciiADec

                pop {r1,r8,lr}
                bx lr
        .fnend

//------------------------------------------------------------------
//Extrae de memoria los parametros necesarios para imprimir en pantalla el mensaje de ingrese columna.
//----------------------------------------------------------

ingreseColumna:
        .fnstart
                push {r1,r2,lr}

                ldr r1, =msgColumna
                ldr r2, =columnaLength
                bl imprimirSinClear

                pop {r1,r2,lr}
                bx lr
        .fnend


//------------------------------------------------------------------
//Extrae de memoria los parametros necesarios para leer los caracteres que el usuario ingresa por teclado
//----------------------------------------------------------

leerColumna:
        .fnstart
                push {r1,lr}

                ldr r1,=columna
                bl leerteclado

                pop {r1,lr}
                bx lr
        .fnend


//------------------------------------------------------------------
// convierte ascci a decimal
//Extrae de memoria los parametros necesarios para la conversion.
//----------------------------------------------------------

asciiADecColumna:
        .fnstart
        push {r1,r8,lr}

        ldr r1,=columna
        ldr r8, =valorColumna
        bl convertAsciiADec

        pop {r1,r8,lr}
        bx lr
        .fnend

//------------------------------------------------------------------
// Convierte ascii a decimal
//input: r1= puntero a memoria ascii a convertir, r8= puntero a memoria donde guardar el valor decimal
//Output: graba en memoria el valor
//----------------------------------------------------------

convertAsciiADec:
        .fnstart
                push {r1,r2,r5,r8,r10,lr}

                mov r10,#10
                mov r2, #0

        otro:
                ldrb r5, [r1],#1
                cmp r5, #'\n'
                beq finconvert

                cmp r5, #00
                beq finconvert

                mul r2, r10             //desplaza la cifra
                sub r5, #0x30           // produce equivalencia de ascci en decimal
                add r2, r5
                b otro

        finconvert:
                str r2,[r8]

                pop {r1,r2,r5,r8,r10, lr}
                bx lr
        .fnend


//----------------------------------------------------------
//--------------------PRIMER COORDENADA---------------------
//----------------------------------------------------------
validarPrimerCoordenada:
         .fnstart
         push {r0,r1,r2,r3,r4,r5,r7,lr}
		 ldr r3, =valorFila
                 ldr r3, [r3]
		 ldr r4, =valorColumna
                 ldr r4, [r4]
                 
//----------------
//----FILA 0-----
//----------------		
fila0:		
		cmp r3, #0
		bne fila1
		cmp r4, #0
		bne fila0columna3
		mov r2,#'/'
		mov r1,#33
 		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit
fila0columna3:
		cmp r4, #3
		bne fila0columna9
		mov r2,#'!'
		mov r1,#42
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit
fila0columna9:
		cmp r4, #9
		bne exit
		mov r2,#'&'
		mov r1,#60
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit

//----------------
//----FILA 1-----
//----------------

fila1:
		cmp r3,#1
		bne fila2
		cmp r4,#1
		bne fila1Columna6

		mov r2,#'#'
		mov r1,#67
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit

fila1Columna6:
		cmp r4,#6
		bne exit
		mov r2,#'*'
 		mov r1,#82
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit
//----------------
//----FILA 2-----
//----------------	
fila2:		
		cmp r3,#2
		bne fila3
		cmp r4,#3
		bne exit
		mov r2,#'&'
		mov r1, #104
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit
//----------------
//----FILA 3-----
//----------------

fila3:		
		cmp r3, #3
		bne fila4
		cmp r4,	#0
		bne fila3Columna5
		mov r2,#'<'
 		mov r1, #126
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit

fila3Columna5:
		cmp r4,#5
		bne fila3Columna6
		mov r2,#'('
 		mov r1, #141
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit
			
fila3Columna6:
		cmp r4,	#6
		bne fila3Columna8
		mov r2,#')'
 		mov r1, #144
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit	

fila3Columna8:
		cmp r4,	#8
		bne exit	
		mov r2,#'$'
 		mov r1, #150
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit	

//----------------
//----FILA 4-----
//----------------

fila4:
		cmp r3, #4
		bne fila5
		cmp r4, #2
		bne exit
		mov r2,#'%'
 		mov r1, #163
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit	

//----------------
//----FILA 5-----
//----------------

fila5:
		cmp r3, #5
		bne fila6
		cmp r4, #0
		bne fila5Columna4
		mov r2,#'$'
 		mov r1, #188
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit	

fila5Columna4:
		cmp r4,#4
		bne fila5Columna5
		mov r2,#'('
 		mov r1, #200
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit	

fila5Columna5:
		cmp r4,#5
		bne exit
		mov r2,#')'
 		mov r1, #203
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit	


//----------------
//----FILA 6-----
//----------------

fila6:		cmp r3,#6
		bne fila7
		cmp r4, #6
		bne exit
		mov r2,#'<'
 		mov r1, #237
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit	


//----------------
//----FILA 7-----
//----------------

fila7:	
		cmp r3,#7
		bne fila8
		cmp r4,#1
		bne fila7Columna2
		mov r2,#'-'
 		mov r1, #253
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit	

fila7Columna2:
		cmp r4,#2
		bne fila7Columna9
		mov r2,#'-'
 		mov r1, #256
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit

fila7Columna9:
		cmp r4,#9
		bne exit
		mov r2,#'!'
 		mov r1, #277
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit


//----------------
//----FILA 8-----
//----------------

fila8:
		cmp r3,#8
		bne fila9
		cmp r4,#7
		bne exit
		mov r2,#'%'
 		mov r1, #302
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit	


//----------------
//----FILA 9-----
//----------------

fila9:		
		cmp r3,#9
		bne exit
		cmp r4, #3
		bne fila9Columna5
		mov r2,#'#'
 		mov r1, #321
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit

fila9Columna5:
		cmp r4,#5
		bne fila9Columna9
		mov r2,#'/'
 		mov r1, #327
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit

fila9Columna9:
		cmp r4,#9
		bne exit
		mov r2,#'*'
 		mov r1, #339
		bl finPrimerCoordenada
		ldr r7, =primerCordenada
		str r1, [r7]
		b exit
         
exit:			 
                 pop {r0,r1,r2,r3,r4,r5,r7,lr}
                 bx lr
                 .fnend

//------------------------------------
//Subrutina para guardar el caracter 
//en memoria y mostrarElcaracter en pantalla
//------------------------------------
finPrimerCoordenada:
	.fnstart
	push {r0,r1,r2,lr}
		ldr r0, =matrizInicial
		ldr r5, =primerCaracter //Este es para guardar el caracter para despues compararlo

		strb r2, [r0,r1]
		strb r2, [r5]
		bl pantallaJuego
	pop {r0,r1,r2,lr}
	bx lr
	.fnend


//----------------------------------------------------------
//--------------------SEGUNDA COORDENADA---------------------
//----------------------------------------------------------
//Extrae de memoria el valorFila y valorColumna para comparar
//si los datos ingresados por el user corresponden a posiciones
//validas

validarSegundaCoordenada:
         .fnstart
         push {r0,r1,r2,r3,r4,r6,r8,lr}
                 
		 ldr r3, =valorFila
                 ldr r3, [r3]
		 ldr r4, =valorColumna
                 ldr r4, [r4]
                 
//----------------
//----FILA 0-----
//----------------		
sfila0:		
		cmp r3, #0
		bne sfila1
		cmp r4, #0
		bne sfila0columna3
		mov r2,#'/'
		mov r1, #33
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2
sfila0columna3:
		cmp r4, #3
		bne sfila0columna9
		mov r2,#'!'
		mov r1, #42
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2
sfila0columna9:
		cmp r4, #9
		bne exit2
		mov r2,#'&'
		mov r1, #60
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2


//----------------
//----FILA 1-----
//----------------

sfila1:
		cmp r3,#1
		bne sfila2
		cmp r4,#1
		bne sfila1Columna6

		mov r2,#'#'
		mov r1, #67
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2

sfila1Columna6:
		cmp r4,#6
		bne exit2
		mov r2,#'*'
		mov r1, #82
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2
//----------------
//----FILA 2-----
//----------------	
sfila2:		
		cmp r3,#2
		bne sfila3
		cmp r4,#3
		bne exit2
		mov r2,#'&'
		mov r1, #104
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2
//----------------
//----FILA 3-----
//----------------

sfila3:		
		cmp r3, #3
		bne sfila4
		cmp r4,	#0
		bne sfila3Columna5
		mov r2,#'<'
		mov r1, #126
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2

sfila3Columna5:
		cmp r4,#5
		bne sfila3Columna6
		mov r2,#'('
		mov r1, #141
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2
			
sfila3Columna6:
		cmp r4,	#6
		bne sfila3Columna8
		mov r2,#')'
		mov r1, #144
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2

sfila3Columna8:
		cmp r4,	#8
		bne exit2	
		mov r2,#'$'
		mov r1, #150
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2	

//----------------
//----FILA 4-----
//----------------

sfila4:
		cmp r3, #4
		bne sfila5
		cmp r4, #2
		bne exit2
		mov r2,#'%'
		mov r1, #163
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2	

//----------------
//----FILA 5-----
//----------------

sfila5:
		cmp r3, #5
		bne sfila6
		cmp r4, #0
		bne sfila5Columna4
		mov r2,#'$'
		mov r1, #188
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2

sfila5Columna4:
		cmp r4,#4
		bne sfila5Columna5
		mov r2,#'('
		mov r1, #200
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2	

sfila5Columna5:
		cmp r4,#5
		bne exit2
		mov r2,#')'
		mov r1, #203
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2


//----------------
//----FILA 6-----
//----------------

sfila6:		cmp r3,#6
		bne sfila7
		cmp r4, #6
		bne exit2
		mov r2,#'<'
		mov r1, #237
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2	


//----------------
//----FILA 7-----
//----------------

sfila7:	
		cmp r3,#7
		bne sfila8
		cmp r4,#1
		bne sfila7Columna2
		mov r2,#'-'
		mov r1, #253
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2	

sfila7Columna2:
		cmp r4,#2
		bne sfila7Columna9
		mov r2,#'-'
		mov r1, #256
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2

sfila7Columna9:
		cmp r4,#9
		bne exit2
		mov r2,#'!'
		mov r1, #277
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2


//----------------
//----FILA 8-----
//----------------

sfila8:
		cmp r3,#8
		bne sfila9
		cmp r4,#7
		bne exit2
		mov r2,#'%'
		mov r1, #302
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2	


//----------------
//----FILA 9-----
//----------------

sfila9:		
		cmp r3,#9
		bne exit2
		cmp r4, #3
		bne sfila9Columna5
		mov r2,#'#'
		mov r1, #321
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2

sfila9Columna5:
		cmp r4,#5
		bne sfila9Columna9
		mov r2,#'/'
		mov r1, #327
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2

sfila9Columna9:
		cmp r4,#9
		bne exit2
		mov r2,#'*'
		mov r1, #339
		bl finSegundaCoordenada
		ldr r8, =segundaCordenada
		str r1, [r8]
		b exit2
         
exit2:		
                 pop {r0,r1,r2,r3,r4,r6,r8,lr}
                 bx lr
                 .fnend

//------------------------------------
//Subrutina para guardar el caracter 
//en memoria y mostrarElcaracter en pantalla
//------------------------------------
finSegundaCoordenada:
	.fnstart
	push {r0,r1,r2,lr}
		ldr r0, =matrizInicial
		ldr r6, =segundoCaracter //Este es para guardar el caracter para despues compararlo
                
		strb r2, [r0,r1]
		strb r2, [r6]
		bl pantallaJuego
	pop {r0,r1,r2,lr}
	bx lr
	.fnend

//----------------------------------------------------------
//Subrutina que cambia el caracter 42 y 44 para escribir 
//el numero de fila/columna que ingreso el usuario
//----------------------------------------------------------
reemplazarPrimerCoordenada:

        .fnstart
        push {r4,r5,r6,r7,lr}

        ldr r4, =footer
        ldr r5,=fila
        ldr r5,[r5]
        ldr r6,=columna
        ldr r6,[r6]

        ldrb r7,[r4,#42] //En la pos 41 esta el caracter a reemplazar
        strb r5,[r4,#42]
        ldrb r7,[r4,#44] //En la pos 44 esta el caracter a reemplazar
        strb r6,[r4,#44]
        bl pantallaJuego
        bl mostrarFooter
        pop {r4,r5,r6,r7,lr}
        bx lr
        .fnend

//----------------------------------------------------------
//Subrutina que cambia el caracter 91 y 93 para escribir 
//el numero de fila/columna que ingreso el usuario
//----------------------------------------------------------

reemplazarSegundaCoordenada:

        .fnstart
        push {r4,r5,r6,r7,lr}

        ldr r4, =footer
        ldr r5,=fila
        ldr r5,[r5]
        ldr r6,=columna
        ldr r6,[r6]

        ldrb r7,[r4,#91] //En la pos 91 esta el caracter a reemplazar
        strb r5,[r4,#91]
        ldrb r7,[r4,#93] //En la pos 93 esta el caracter a reemplazar
        strb r6,[r4,#93]
        bl pantallaJuego
        bl mostrarFooter
        pop {r4,r5,r6,r7,lr}
        bx lr
        .fnend

//----------------------------------------------------------
//Subrutina que compara si los caracteres son iguales o no
//---------------------------------------------------------
compararCaracteres:
        .fnstart
        push {r0,r1,r2,lr}
                ldr r0, =primerCaracter
                ldrb r0,[r0]
                ldr r1,=segundoCaracter
                ldrb r1,[r1]
comparaBlancos:
                cmp r0, #0x20
                beq comparaBlancos2
                b verAcierto
comparaBlancos2:
                cmp r1, #0x20
                beq restar
verAcierto:
                cmp r0,r1
                beq aciertos
restar:
                bl sumarErrores
                bl restarVidas
                bl volverAlSigno
                bl pantallaJuego
                bl mostrarFooter
                b salirComparacion


aciertos:
                bl sumarAciertos
                bl pantallaJuego
                bl mostrarFooter

salirComparacion:
        pop {r0,r1,r2,lr}
        bx lr
        .fnend

//----------------------------------------------------------
//Subrutinas para actualizar los datos del footer (vidas, intentos, etc)
//---------------------------------------------------------
sumarAciertos:
        .fnstart
	push {r0,r1,lr}
                 ldr r0, =footer
                 ldrb r1, [r0,#133]
                 cmp r1,#0x39  //Lo comparo con el 9
                 beq sumardesde92
                 ldrb r5, [r0,#134] //Me paro en el segundo digito
                 cmp r5,#0x30
                 bcs sumardesde92 //Si el segundo digito es mayor o igual a 0
                 add r1, #0x1
                 strb r1,[r0,#133]
	pop {r0,r1,lr}
	bx lr

sumardesde92:
	         mov r3,#0x31
                 ldr r2,=sumdesde9
                 ldrb r4,[r2]
                 strb r3,[r0,#133] //Reemplazo por un uno al primer digito.
                 ldrb r1, [r0,#134] //Me paro en el segundo digito
                 strb r4,[r0,#134] //Como es un espacio y yo empiezo a sumar desde 0, reemplazo el 1$
                 ldrb r1, [r0,#134]
                 strb r1,[r0,#134] //Ahora cargo en r1 de nuevo la posicion, y debe ser un 0 el valo$
                 add r4, #0x1
                 strb r4,[r2]

	pop {r0,r1,lr}
	bx lr
        .fnend

sumarErrores:
        .fnstart
        push {r0,r1,lr}
                 ldr r0, =footer
                 ldrb r1, [r0,#151]
                 add r1, #0x1
                 strb r1,[r0,#151]
        pop {r0,r1,lr}
        bx lr
        .fnend

restarVidas:
        .fnstart
        push {r0,r1,lr}
                 ldr r0, =footer 
                 ldrb r1, [r0,#169] //Me paro en el 5 de numero de vidas
		 cmp r1,#0x30  //Lo comparo con el 0
		 beq restardesde9
		 cmp r1,#0x20
		 beq restardesde9
		 sub r1, #0x1
                 strb r1,[r0,#169]
	pop {r0,r1,lr}
        bx lr
restardesde9:
		 mov r3,#0x20
		 ldr r2,=desde9
		 ldrb r4,[r2]
		 strb r3,[r0,#169] //Reemplazo por un espacio al segundo digito.
		 ldrb r1, [r0,#168] //Me paro en el numero de vidas
		 strb r4,[r0,#168] //Como es un 1 y yo empiezo a restar desde 9, reemplazo el 1 por un 9
		 ldrb r1, [r0,#168] 
		 strb r1,[r0,#168] //Ahora cargo en r1 de nuevo la posicion, y debe ser un 9 el valor.
		 sub r4, #0x1
		 strb r4,[r2]
        pop {r0,r1,lr}
        bx lr
        .fnend

sumarIntentos:
        .fnstart
        push {r0,r1,lr}
                 ldr r0, =footer
                 ldrb r1, [r0,#114]
		 cmp r1,#0x39  //Lo comparo con el 9
		 beq sumardesde9
	         ldrb r5, [r0,#115] //Me paro en el segundo digito
		 cmp r5,#0x30  
		 bcs sumardesde9 //Si el segundo digito es mayor o igual a 0		 
                 add r1, #0x1
                 strb r1,[r0,#114]
	pop {r0,r1,lr}
        bx lr
sumardesde9:
		 mov r3,#0x31
		 ldr r2,=sumdesde9
		 ldrb r4,[r2]
		 strb r3,[r0,#114] //Reemplazo por un uno al primer digito.
		 ldrb r1, [r0,#115] //Me paro en el segundo digito
		 strb r4,[r0,#115] //Como es un espacio y yo empiezo a sumar desde 0, reemplazo el 1 por un 0
		 ldrb r1, [r0,#115] 
		 strb r1,[r0,#115] //Ahora cargo en r1 de nuevo la posicion, y debe ser un 0 el valor.
		 add r4, #0x1
		 strb r4,[r2]  
        pop {r0,r1,lr}
        bx lr
        .fnend

//----------------------------------------------------------
//Extrae de memoria los parametros necesarios para mostrar pantalla de game over
//----------------------------------------------------------
gameOver:
	.fnstart
        push {r1,r2,lr}
        	ldr r1, =perdiste
		ldr r2, =perdisteLong
        	bl imprimirEnPantalla
        pop {r1,r2,lr}
        bx lr
        .fnend

//----------------------------------------------------------
//Extrae de memoria los parametros necesarios para mostrar pantalla de win
//----------------------------------------------------------

ganador:
	.fnstart
        push {r1,r2,lr}
        	ldr r1, =ganaste
		ldr r2, =ganasteLong
        	bl imprimirEnPantalla
        pop {r1,r2,lr}
        bx lr
        .fnend

//----------------------------------------------------------
//Devuelve la matriz como estaba previo al intento en caso de no acertar
//----------------------------------------------------------
volverAlSigno:
	.fnstart
	push {r0,r1,r2,r4,lr}
		ldr r0, =matrizInicial

		ldr r4, =signo //Extrae de memoria el '?'
		ldrb r4, [r4]

		ldr r1, =primerCordenada //Extrae de memoria el valor en decimal de la primerCoordenada
		ldr r1,[r1]
		ldr r2, =segundaCordenada //Extrae de memoria el valor en decimal de la segundaCoordenada
		ldr r2,[r2]
		strb r4, [r0,r1] //Doy vuelta las posiciones donde no sean iguales y vuelvo a tener el '?'
		strb r4, [r0,r2]
		bl pantallaJuego //Actualizo pantalla
	pop {r0,r1,r2,r4,lr}
	bx lr
	.fnend

//----------------------------------------------------------
//Extrae de memoria los parametros necesarios para formatear los valores
//----------------------------------------------------------
reiniciar:
	.fnstart
	push {r0,r1,r2,r4,r5,r6,r7,lr}
		ldr r0, =footer
		mov r2,#0x30
		mov r3,#0x31
		mov r4,#0x35
		ldrb r1,[r0,#151] //errores
		strb r2,[r0,#151]
		ldrb r1, [r0,#168] //vidas
		strb r3, [r0,#168]
		ldrb r1, [r0,#169] //vidas
		strb r4, [r0,#169]
		ldrb r1,[r0,#133]
		strb r2,[r0,#133]
		ldrb r1,[r0,#114]
		strb r2,[r0,#114]

		ldr r5, =matrizInicial
		mov r7,#0x3f
		ldrb r6, [r5,#33]
		strb r7,[r5,#33]
		ldrb r6, [r5,#42]
		strb r7,[r5,#42]
		ldrb r6, [r5,#60]
		strb r7,[r5,#60]
		ldrb r6, [r5,#67]
		strb r7,[r5,#67]
		ldrb r6, [r5,#82]
		strb r7,[r5,#82]
		ldrb r6, [r5,#104]
		strb r7,[r5,#104]
		ldrb r6, [r5,#126]
		strb r7,[r5,#126]
		ldrb r6, [r5,#141]
		strb r7,[r5,#141]
		ldrb r6, [r5,#144]
		strb r7,[r5,#144]
		ldrb r6, [r5,#150]
		strb r7,[r5,#150]
		ldrb r6, [r5,#163]
		strb r7,[r5,#163]
		ldrb r6, [r5,#188]
		strb r7,[r5,#188]
		ldrb r6, [r5,#200]
		strb r7,[r5,#200]
		ldrb r6, [r5,#203]
		strb r7,[r5,#203]
		ldrb r6, [r5,#237]
		strb r7,[r5,#237]
		ldrb r6, [r5,#277]
		strb r7,[r5,#277]
		ldrb r6, [r5,#256]
		strb r7,[r5,#256]
		ldrb r6, [r5,#253]
		strb r7,[r5,#253]
		ldrb r6, [r5,#302]
		strb r7,[r5,#302]
		ldrb r6, [r5,#321]
		strb r7,[r5,#321]
		ldrb r6, [r5,#327]
		strb r7,[r5,#327]
		ldrb r6, [r5,#339]
		strb r7,[r5,#339]
	pop {r0,r1,r2,r4,r5,r6,r7,lr}
	bx lr
	.fnend
.global main
main:


inicial:
                bl pantallaIncial
                bl leerLetraIngresada
                ldr r3,=letraIngresada
                ldrb r3,[r3]

                cmp r3,#'\n'   // si el usuario apretó enter comienza el juego
                bne inicial
                bl pantallaJuego
                bl mostrarFooter
		
cicloJuego:
                bl primerCoordenada
                bl segundaCoordenada
                bl sumarIntentos
                bl compararCaracteres

                ldr r0, =footer
                ldrb r1, [r0,#168]	//Me paro en el numero de vidas
                cmp r1,#0x30		//Si llego a 0 => gameOver
                bne cantErrores
                bl gameOver
		b fin
cantErrores:
		ldrb r1,[r0,#151]
		cmp r1,#0x35	//Si tiene 5 errores pierde
		bne cantAciertos
		bl pantallaVolverAJugar
		bl leerLetraIngresada
                ldr r3,=letraIngresada
                ldrb r3,[r3]
		cmp r3, #'y'
		beq reiniciarParametros
		bl gameOver
		b fin
reiniciarParametros:
		bl reiniciar
		bl pantallaJuego
		b inicial


cantAciertos:
		ldrb r1,[r0,#133]
		cmp r1,#0x31
		bne cantIntentos
		ldrb r1,[r0,#134]
		cmp r1, #0x30
		bgt masGrande //Adivino los 10 caracteres
		b cantIntentos
masGrande:
		bl ganador
		b fin
cantIntentos:
		ldrb r1,[r0,#114]
		cmp r1, #0x31
		beq cantEnDecena
		b cicloJuego
cantEnDecena:
		ldrb r1,[r0,#115]
		cmp r1,#0x35		//Si tiene 15 intentos pierde
		bne cicloJuego
		bl gameOver
fin:
        mov r7, #1 // Salida al sistema
        swi 0

