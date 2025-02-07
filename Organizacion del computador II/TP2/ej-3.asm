%include "io.inc"
extern printf                   ; Declarar printf como externa

section .data
    vector dd 1.5, 2.5, -3.5, 4.5, 5.0 
    vector_size equ ($ - vector) / 4    ; Calcula el tamaño del vector

    varsumatotal dq 0.0                 ; Variable para almacenar la suma total
    stringtotal db "La suma del vector es: %f", 10, 0

section .text
global CMAIN
CMAIN:
    mov ebp, esp ; Para una depuración correcta
    call sumar_vector ; Llama a la función para sumar el vector

    ; Imprimir el resultado
    push dword [varsumatotal+4]
    push dword [varsumatotal]
    push stringtotal
    call printf
    add esp, 12

    xor eax, eax
    ret

sumar_vector:
    fldz                   ; Inicializa ST(0) en 0.0 en la FPU (suma inicial)
    mov ecx, vector_size   ; Cargar el tamaño del vector en ecx para usarlo como contador
    mov esi, vector        ; Cargar la dirección base del vector en esi

sum_loop:
    fld dword [esi]        ; Cargar el siguiente valor del vector en la pila de la FPU
    fadd                   ; Sumar el valor en ST(0) con el acumulado en la pila FPU
    add esi, 4             ; Avanzar al siguiente elemento del vector (4 bytes por float)
    loop sum_loop          ; Repetir hasta que se procesen todos los elementos

    ; Almacenar el resultado final en varsumatotal
    fstp qword [varsumatotal] ; Guarda el resultado en varsumatotal y limpia ST(0)
    ret
