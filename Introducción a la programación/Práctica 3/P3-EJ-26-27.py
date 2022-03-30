#-------------------------
#-------------Ejercicio 26
#-------------------------

palabra='python'.lower()
letra='y'.lower()
apariciones = 0

for i in palabra:
    if i==letra:
        apariciones+=1
print(palabra,'tiene',apariciones, 'letras',letra)

#--------------

palabra='pythonnn'.lower()
letra='n'
contador = palabra.count(letra)

print(palabra,'tiene',contador,'letras',letra)



#-------------------------
#-------------Ejercicio 27
#-------------------------

palabra = input('Escribi una palabra y te digo si tiene diptongo').lower()
##solo esa combinacion de vocales
dipAE=palabra.find('ae')
dipAI=palabra.find('ai')
dipAO=palabra.find('ao')
dipAU=palabra.find('au')
if dipAE != -1 or dipAI != -1 or dipAO != -1 or dipAU != -1:
    print(palabra,'Tiene diptongo')
else:
    print(palabra, 'No diptongo')