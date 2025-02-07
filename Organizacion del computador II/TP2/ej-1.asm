%include "io.inc"

section .data
    val_a dq 0.0                    ; Define el valor 0.0
    val_b dq 1.0                    ; Define el valor 1.0
    val_c dq -1.0e10                ; Define el valor -1.0E10
    val_d dq 6.02e23                ; Define el valor 6.02E23
    val_e dq 3.14159265358979323846 ; Define el valor de Pi

section .bss
section .text

global CMAIN

CMAIN:
    mov ebp, esp; for correct debugging
    fld qword [val_a] ; Cargar 0.0 en ST(0)
    fld qword [val_b] ; Cargar 1.0 en ST(0), 0.0 pasa a ST(1)
    fld qword [val_c] ; Cargar -1.0E10 en ST(0), 1.0 pasa a ST(1), 0.0 a ST(2)
    fld qword [val_d] ; Cargar 6.02E23 en ST(0), -1.0E10 pasa a ST(1), etc.
    fld qword [val_e] ; Cargar Pi en ST(0), 6.02E23 pasa a ST(1), etc.

done:
    mov eax, 1 ; syscall: exit
    xor ebx, ebx ; código de salida 0
    int 0x80
