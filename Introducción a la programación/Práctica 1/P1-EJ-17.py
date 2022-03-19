#PLATA 5660

#Billetes [1000,500,200,100,50]

# 0 - 5660//1000 ----> 5 de $1000. Resto 5660%1000 ---->660

# 1 - 660//500 -----> 1 de $500. Resto 660%500 ---->160

# 2 - 160//200 -----> 0 de $200. Resto 160%200 -----> 160

# 3 - 160//100 ----> 1 de $100. Resto 160%100 -----> 60

# 4 - 60//50 -----> 1 de $50. Resto 60%50 -----> 10

dinero = int(input('Extraer dinero -----> Ingrese un monto: '))
print('Usted quiere retirar: $',dinero)

#billetes=[1000,500,200,100]

#for i in range(len(billetes)):
#    resto = dinero//billetes[i]
#    if resto>0:
#        print('Recibira',resto,'billetes de $',billetes[i])
#        dinero %= billetes[i]

d1=dinero//1000
r1=dinero%1000
d2=r1//500
r2=r1%500
d3=r2//200
r3=r2%200
d4=r3//100
r4=r3%100

print('Usted recibira: ',d1,'billete de $1000 ',d2,'billete de $500 ',d3,'billete de $200 ',d4, 'billete de $100 ')
