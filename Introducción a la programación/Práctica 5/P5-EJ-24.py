def pagara(numeroCliente,localidad):
	
	# Funciones ya creadas

	cobertura=cobertura(numeroCliente) #string oro o plata
	cantidadDeUsos=usados(numeroCliente)#number cantidad de veces q uso el sistema
	estaCubierto=radioDeCobertura(numeroCliente,localidad)#Boolean

	if estaCubierto:
		if cobertura=='oro':
			print('El servicio es gratis') 
		else:
			if cantidadDeUsos<=5:
				print('El servicio es gratis')
			else:
				print('El servicio serian $50')
	else:
		if cobertura=='oro':
			print('El servicio serian $30')
		else:
			if cantidadDeUsos<=5:
				print('El servicio serian $30')
			else:
				print('El servicio serian $50 + $30')

# USUARIO

numeroCliente=int(input('Ingresa el numero de cliente: '))
localidad=input('Ingrese localidad: ')

pagara(numeroCliente,localidad)
