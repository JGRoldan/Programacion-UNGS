%include "io.inc"

section .data
N1 dq 0x1111111122222222, 0x3333333344444444
N2 dq 0x3333333322222222, 0x1111111100000000
resultado dq 0x0000000000000000, 0x0000000000000000

section .bss

section .text
global CMAIN
CMAIN:
    mov ebp, esp; for correct debugging
    
    ;Sumar parte 0 a 31 bits = 32 bits
    mov eax, dword[N1] ;Cargo los 32 bits menos significativos de N1    
    mov ebx, dword[N2] ;Cargo los 32 bits menos significativos de N2     
    add eax,ebx
    mov [resultado],eax
    
    ;Sumar parte 32 a 63 bits 
    mov eax, dword[N1+4] ;Cargo los bits 32-63 de N1    
    mov ebx, dword[N2+4] ;Cargo los bits 32-63 de N2       
    adc eax,ebx ;La suma puede tener acarreo de la suma anterior
    mov [resultado+4],eax
    
    ;Sumar parte 64 a 95 bits
    mov eax, dword[N1+8] ;Cargo los bits 64-95 de N1    
    mov ebx, dword[N2+8] ;Cargo los bits 64-95 de N2       
    adc eax,ebx ;La suma puede tener acarreo de la suma anterior
    mov [resultado+8],eax
    
    ;Sumar parte 96 a 127 bits
    mov eax, dword[N1+12] ;Cargo los bits 96-127 de N1    
    mov ebx, dword[N2+12] ;Cargo los bits 96-127 de N2       
    adc eax,ebx ;La suma puede tener acarreo de la suma anterior
    mov [resultado+12],eax
    
    ; Terminar el programa
    mov eax, 1 ;Codigo de salida del sistema
    mov ebx,0 ;Codigo de salida "0"
    int 0x80 ;Llamada al sistema para salir