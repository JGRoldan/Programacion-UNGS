# -------------------
# ----------------- 8
# -------------------

# ----A

def cantDiv(n):
    cant=0
    for i in range(1,n+1):
        if n%i==0:
            cant+=1
    return cant

print('Cantidad de div: ',cantDiv(int(input('Ingrese un numero: '))))

# ----B

def esPrimo(n):
    cant=0
    for i in range(1,n//2+1):
        if n%i==0:
            cant+=1
    if cant>2:
        return False
    else:
        return True

print(esPrimo(int(input('Ingrese un numero: '))))

# ----D





