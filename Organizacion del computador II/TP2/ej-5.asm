%include "io.inc"
section .data
    vector1 dw 55555, 2, 3, 4 ; vector 1 con 4 elementos de 16 bits
    vector2 dw 2, 2, 2, 2 ; vector 2 con 4 elementos de 16 bits
    
section .text
global CMAIN
CMAIN:
    mov ebp, esp; for correct debugging
  
    ;Formato little endian en registros mmx
    ;Ejemplo numero 55555 en mmx = {0x3, 0xd9}
    ;Para convertir de hexadecimal a decimal
    ;11011001 00000011 <bin--decimal >55555
    ;D903 <hexa --- decimal> 55555
    
    ;Cargar vector1 en registro mm3
    movq mm3,[vector1]
    
    ;Cargar vector2 en registro mm4
    movq mm4,[vector2]
    
    ;MUltiplicar elementos mm3 = mm3 x mm4
    pmullw mm3, mm4
    
    ;Mover el resultado de mm3 a mm5 por enunciado
    movq mm5,mm3
    
    ;Finaliza estado mmx para poder ejecutar instrucciones FPU
    emms
  
    xor eax, eax
    ret