%include "io.inc"
extern printf                   ; Declarar printf como externa

section .data
    val_a dq 0.0                    ; Define el valor 0.0
    val_b dq 1.0                    ; Define el valor 1.0
    val_c dq -1.0e10                ; Define el valor -1.0E10
    val_d dq 6.02e23                ; Define el valor 6.02E23
    val_e dq 3.14159265358979323846 ; Define el valor de Pi
    stringtotal db "La suma de todas las variables es: %f", 10, 0 ; Formato para printf con salto de línea
    
section .bss
    varsumatotal resq 1             ; Variable para almacenar el resultado de la suma

section .text
    global CMAIN
    
CMAIN:
    mov ebp, esp; for correct debugging
    
    ; Cargar valores en la FPU y sumarlos
    fld qword [val_a]               ; ST(0) = val_a
    fadd qword [val_b]              ; ST(0) = ST(0) + val_b
    fadd qword [val_c]              ; ST(0) = ST(0) + val_c
    fadd qword [val_d]              ; ST(0) = ST(0) + val_d
    fadd qword [val_e]              ; ST(0) = ST(0) + val_e

    ; Almacenar el resultado en la variable varsumatotal
    fstp qword [varsumatotal]

    ; Pasar los argumentos a printf
    push dword [varsumatotal+4]     ; Parte alta de varsumatotal
    push dword [varsumatotal]       ; Parte baja de varsumatotal
    push stringtotal                ; Cadena de formato
    call printf                     ; Llamar a printf

    add esp, 12                     ; Limpiar la pila

done:
    xor eax, eax
    ret
