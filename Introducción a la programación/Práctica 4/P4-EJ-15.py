# -------------------
# ----------------- 15
# -------------------

def ast(cadena):
    lon=len(cadena)+4

    for i in range(3):
        if i==0 or i==2:
            print('*'*lon)
        else:
            print('*',cadena,'*')

ast('Sobrevivir')