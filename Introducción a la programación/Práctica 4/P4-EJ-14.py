# -------------------
# ----------------- 14
# -------------------

def esPrimo(n):
	for i in range(2,n//2+1):
		if n%i==0:
			return False
	return True

n=int(input('Ingrese un numero: '))
i=n+1

while not esPrimo(i): #Cuando no sea primo que haga esto
	i+=1

print(i)

