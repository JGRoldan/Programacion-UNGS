%include "io.inc"
section .data
    vector1 dw 1,1,1,1 ;vector 1 con 4 elementos de 16 bits
    vector2 dw 10,20,30,40 ;vector 2 con 4 elementos de 16 bits
section .text
global CMAIN
CMAIN:
    mov ebp, esp; for correct debugging
   
   ;Cargar vector1 en registro mm0
    movq mm0,[vector1]
    
    ;Cargar vector en registro mm1
    movq mm1,[vector2]
    
    ;Sumar elementos de los vectores mm0 = mm0 + mm1
    paddw mm0,mm1
    
    ;Mover vector resultado de mm0 a mm6
    movq mm6,mm0
    
    ;Finaliza estado mmx para poder ejecutar instrucciones FPU
    emms
   
    xor eax, eax
    ret