%include "io.inc"
extern printf

section .data
    ; Definimos dos vectores de números de punto flotante (precisión simple)
    vector1 dd 1.0, 1.0, 1.0, 1.0, 1.0  ; Primer vector
    vector2 dd 1.0, 1.0, 1.0, 1.0, 1.0  ; Segundo vector
    vector_size equ 5     ; Calcula el tamaño del vector (número de elementos)

    product_total dq 0.0                  ; Variable para almacenar el producto escalar total
    stringtotal db "El producto escalar de los vectores es: %f", 10, 0

section .text
global CMAIN

CMAIN:
    mov ebp, esp  ; Para una depuración correcta
    call producto_escalar  ; Llama a la función para calcular el producto escalar

    ; Imprimir el resultado
    push dword [product_total + 4]  ; Poner la parte alta del double en la pila
    push dword [product_total]      ; Poner la parte baja del double en la pila
    push stringtotal               ; Poner el formato del string
    call printf                    ; Llamar a printf
    add esp, 12                    ; Limpiar la pila

    xor eax, eax                   ; Retorno 0
    ret

producto_escalar:
    fldz                            ; Inicializa ST(0) en 0.0 en la FPU (acumulador para el producto escalar)
    mov ecx, vector_size            ; Cargar el tamaño del vector en ecx como contador
    mov esi, vector1                ; Cargar la dirección base de vector1 en esi
    mov edi, vector2                ; Cargar la dirección base de vector2 en edi

producto_loop:
    fld dword [esi]                 ; Cargar el siguiente valor de vector1 en ST(0)
    fmul dword [edi]                ; Multiplicar ST(0) por el valor correspondiente de vector2
    fadd                            
    add esi, 4                      ; Avanzar al siguiente elemento de vector1 (4 bytes)
    add edi, 4                      ; Avanzar al siguiente elemento de vector2 (4 bytes)
    loop producto_loop              ; Repetir hasta que se procesen todos los elementos

 ; Almacenar el resultado final en product_total
    fstp qword [product_total]       ; Guarda el resultado en product_total y limpia ST(0)
    ret
