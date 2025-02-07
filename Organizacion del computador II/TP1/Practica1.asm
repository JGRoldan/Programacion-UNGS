%include "io.inc"
section .data
;Datos inicializados
N1 DB 1;entero 8 bits sin signo
N2 DB 3;entero 8 bits sin signo

N3 DW 148;Entero 16bits
N4 DW -148;Entero 16bits

N5 DD 3532;Entero 32bits
N6 DD -3424;Entero 32bits

N7 DQ 64563;Entero 64bits
N8 DQ -7542;Entero de 64 bits

F1 DD 2.231234;Punto flotante precision simple

T DB 'Practica orga 2',0 ;Cadena caracteres ASCII

section .text
global CMAIN
CMAIN:
    ;write your code here
    xor eax, eax
    ret