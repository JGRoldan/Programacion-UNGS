%include "io.inc"
    vector1 dw 1,48,1,48 ;vector1 con 4 elementos de 16 bits
section .text
global CMAIN
CMAIN:
    mov ebp, esp; for correct debugging
    
    ;Cargar vector1 en registro mm0
    movq mm0,[vector1]
    
    ;PXOR del registro mm0 con mm0. 
    ;XOR es Exclusive OR
    ;1 XOR 1 = 0 
    ;0 XOR 0 = 0
    ;Al hacer XOR con el mismo registro, se pone todo en 0
    pxor mm0,mm0
    
    ;Finaliza estado mmx para poder ejecutar instrucciones FPU
    emms
    
    xor eax, eax
    ret