#-------------------------
#-------------Ejercicio 25
#-------------------------

palabra='JAVASCRIPT'
filas=3
for i in range(1,filas+1):
  if i==1 or i==3:
    print('*'*((len(palabra))+4))
  else:
    print('*',palabra,'*')
    
 #-------------------------

palabra='* '+'JAVASCRIPT'+' *'
filas=3

for i in range(1,filas+1):
  if i==1 or i==3:
    print('*'*(len(palabra)))
  else:
    print(palabra)
