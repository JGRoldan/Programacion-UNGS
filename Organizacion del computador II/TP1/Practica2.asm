%include "io.inc"
section .data
N1 db 5;entero 8 bits sin signo
N2 db 10;entero 8 bits sin signo

N3 dw 49;Entero 16bits
N4 dw 50;Entero 16bits

N5 dd 5;Entero 32bits
N6 dd 48;Entero 32bits

N7 dq 64563;Entero 64bits
N8 dq -7542;Entero de 64 bits

F1 dd 2.231234;Punto flotante precision simple

T db "Practica orga 2",0 ;Cadena caracteres ASCII 

section .bss
;RESB Reserva Byte 8 bits
;RESW Reserva Word 16 bits
;RESD Reserva Doubleword 32 bits
;RESQ Reserva Quadword 64 bits
resultadoN1N2 resb 1;Rtado N1+N2
resultadoN3N4 resw 1;Rtado N3-N4
resultadoMulN1N2 resw 1;Rtado N1*N2
cocienteDivN3N4 resw 1;Cociente N3/N4
restoDivN3N4 resw 1;Resto N3/N4
resultadoN5N6 resd 1;Rtado N5+N6
resultadoN7N8 resq 1;
cocienteDivN5N6 resd 1;
restoDivN5N6 resd 1;

section .text
global CMAIN
CMAIN:
    mov ebp, esp; for correct debugging
    
    ;a. N1+N2
    mov al,[N1] ;al registro 8bits
    mov bl,[N2] ;bl registro 8 bits
    add al,bl ;Sumar registro N1 y N2
    mov [resultadoN1N2], al;Guardar rtado en la variable
    
    ;b. N1-N2
    mov ax,[N3]
    mov bx,[N4]
    sub ax,bx
    mov [resultadoN3N4], ax
   
    ;c. N1*N2
    mov al,[N1]
    mov bl,[N2]
    mul bl;AL * 8bit source = AH AL -> AX
    mov [resultadoMulN1N2],ax;
    
    ;d. N3/N4
    mov ax,[N3]
    mov bx,[N4]
    xor dx,dx ;Poner en 0 registro dx
    div bx; ax/bx Cociente -> AX y Resto -> DX
    mov [cocienteDivN3N4], ax
    mov [restoDivN3N4], dx
    
    ;e. N5+N6
    mov eax,[N5]
    mov ebx,[N6]
    add eax,ebx
    mov [resultadoN5N6],eax
    
    ;f. N7 + N8 con registros 32bits
    mov eax,[N7]
    mov ebx,[N8]
    add eax,ebx
    mov dword [resultadoN7N8],eax
    
    mov eax,[N7+4];Me muevo 4  bytes  
    mov eax,[N8+4];Me muevo 4 bytes
    mov dword [resultadoN7N8+4],eax
    
    ;g. Cociente y resto de la divison N5 / N6
    mov eax,[N5]
    xor edx,edx 
    cdq         ;Extender EAX a EDX:EAX
    idiv dword [N6] ;IDIV for signed data
    mov [cocienteDivN5N6], eax;EAX -> Cociente
    mov [restoDivN5N6],edx;EDX -> Resto
    
   
    ;Mostrar resultado
    mov eax,4
    mov ebx,1
    mov ecx,resultadoN5N6
    mov edx,1
    int 0x80
    
    ; Terminar el programa
    mov eax, 1 ;Codigo de salida del sistema
    mov ebx,0 ;Codigo de salida "0"
    int 0x80 ;Llamada al sistema para salir