%include "io.inc"

section .data
    T db "Hola Mundo", 0 ; LENGTH = 10 => ":" (ascii) => 58 (DEC)

section .bss
    ; Espacio para almacenar los resultados
    resultado resb 1      ; Para el resultado de N1 + N2 (8 bits)
    
section .text
    global CMAIN

CMAIN:
    mov ecx, 0 ; inicializa el contador en 0
    mov esi, T ; carga la dirección de la cadena en esi
    ; bucle para recorrer la cadena de caracteres
LOOP:
    cmp byte [esi], 0 ; compara el byte apuntado por esi con 0
    je FIN ; si es 0, salta al final del bucle
    inc ecx ; incrementa el contador
    inc esi ; incrementa el puntero
    jmp LOOP ; salta al inicio del bucle

    ; al llegar al final de la cadena, muestra la longitud
FIN:
    mov eax, 4 ; (write)
    mov ebx, 1 ; (stdout)
    add ecx, 48
    mov [resultado], ecx
    mov ecx,resultado ; carga el valor del contador
    mov edx, 4 ; carga longitud del mensaje a imprimir
    int 0x80 ; llama a la función write

done:
    mov eax, 1 ; syscall: exit
    xor ebx, ebx ; código de salida 0
    int 0x80
       