%include "io.inc"

section .data

N1 dd 4;N1 es de 8 bits
N2 dd 5;N2 es de 8 bits
mensaje_si db "N1 es mayor que N2",10,0
len1 equ $ - mensaje_si
mensaje_no db "N1 no es mayor que N2",10,0
len2 equ $ - mensaje_no

N3 dd 2;8 bits
N4 dd 3;8 bits
mensaje_cero db "El resultado de N3 - N4 es cero",10,0
len3 equ $ - mensaje_cero
mensaje_no_cero db "El resultado de N3 - N4 NO es cero",10,0
len4 equ $ - mensaje_no_cero

N5 dd 0xFFFFFFFF ;
N6 dd 1 ;
mensaje_overflow db "La suma N5 + N6 produce overflow",10,0
len5 equ $ - mensaje_overflow
mensaje_no_overflow db "La suma N5 + N6 NO produce overflow",10,0
len6 equ $ - mensaje_no_overflow

mensaje_negativo db "N5 es negativo",10,0
len7 equ $ - mensaje_negativo
mensaje_positivo db "N5 es positivo",10,0
len8 equ $ - mensaje_positivo

N7 dd 0xFFFFFFFF;
N8 dd 0x00000001;
mensaje_acarreo db "La suma N7 + N8 produce acarreo",10,0
len9 equ $ - mensaje_acarreo
mensaje_no_acarreo db "La suma N7 + N8 NO produce acarreo",10,0
len10 equ $ - mensaje_no_acarreo

mensaje_par db "El resultado de la suma N5 + N6 tiene paridad par",10,0
len11 equ $ - mensaje_par
mensaje_impar db "El resultado de la suma N5 + N6 tiene paridad impar",10,0
len12 equ $ - mensaje_impar

section .bss

section .text
global CMAIN
CMAIN:
    mov ebp, esp; for correct debugging
_A:
    ;Comparar
    mov al,[N1]
    mov bl,[N2]
    cmp al,bl
    ;Si N1 > N2
    jg MAYOR
    ;Si N1 < N2
    jl MENOR
    
    MAYOR:
        mov eax,4
        mov ebx,1
        lea ecx,[mensaje_si]
        mov edx,len1
        int 0x80
        jmp _B
     
    MENOR:
        mov eax,4
        mov ebx,1
        lea ecx,[mensaje_no]
        mov edx,len2
        int 0x80
        jmp _B
        
_B:;SI el resultado de N3 - N4 es cero
        mov ax,[N4]
        mov bx,[N3]
        sub ax,bx 
        jz CERO
        jnz NOCERO
        
    CERO:
        mov eax,4
        mov ebx,1
        lea ecx,[mensaje_cero]
        mov edx,len3
        int 0x80
        jmp _C
        
    NOCERO:
        mov eax,4
        mov ebx,1
        lea ecx,[mensaje_no_cero]
        mov edx,len4
        int 0x80
        jmp _C
        
  _C: ;Si N5 + N6 produce overflow
        mov eax,[N5]
        mov ebx,[N6]
        add eax,ebx
        jo SIOVERFLOW;jo Jump if Overflow
        jno NOOVERFLOW;jno Jump if No Overflow
        
     SIOVERFLOW:
        mov eax,4
        mov ebx,1
        lea ecx,[mensaje_overflow]
        mov edx,len5
        int 0x80
        jmp _D
        
     NOOVERFLOW:
        mov eax,4
        mov ebx,1
        lea ecx,[mensaje_no_overflow]
        mov edx,len6
        int 0x80
        jmp _D
     
    _D:;Si N5 es negativo
        mov eax,[N5]
        mov ebx, 0
        cmp eax,ebx
        jl NEGATIVO
        jg POSITIVO
      
      NEGATIVO:
        mov eax,4
        mov ebx,1
        lea ecx,[mensaje_negativo]
        mov edx,len7
        int 0x80
        jmp _E
        
      POSITIVO:
        mov eax,4
        mov ebx,1
        lea ecx,[mensaje_positivo]
        mov edx,len8
        int 0x80
        jmp _E
   
   _E:;Si N7 + N8 produce acarreo
        mov eax,[N7]
        mov ebx,[N8]
        add eax,ebx
        jc ACARREO;Jump if Carry
        jnc NOACARREO;Jump if No Carry
        
     ACARREO:
        mov eax,4
        mov ebx,1
        lea ecx,[mensaje_acarreo]
        mov edx,len9
        int 0x80
        jmp _F
     
     NOACARREO:
        mov eax,4
        mov ebx,1
        lea ecx,[mensaje_no_acarreo]
        mov edx,len10
        int 0x80
        jmp _F
        
   _F:;Si el resultado de N5 + N6 tiene paridad par
      mov eax,[N5]
      mov ebx,[N6]
      add eax,ebx
      cmp eax,0
      jp PAR ;Jump Parity
      jnp IMPAR ;Jump No Parity
      
     PAR:
        mov eax,4
        mov ebx,1
        lea ecx,[mensaje_par]
        mov edx,len11
        int 0x80
        jmp salir
     IMPAR:
        mov eax,4
        mov ebx,1
        lea ecx,[mensaje_impar]
        mov edx,len12
        int 0x80
        jmp salir
          
    salir:
        mov eax,1
        xor ebx,ebx
        int 0x80
    
    
    