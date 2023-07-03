package tano_construcciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class EmpresaDeServicios {
	static String PINTURA = "Pintura";
	static String PINTURA_ALTURA = "PinturaEnAltura";
	static String ELECTRICIDAD = "Electricidad";
	static String GASISTA_INSTALACION = "GasistaInstalacion";
	static String GASISTA_REVISION = "GasistaRevision";
	
	private HashMap<Integer, Especialista> especialistas;
	private HashMap<Integer, Cliente> clientes;
	private HashMap<Integer, Servicio> servicios;
	private ArrayList<String> prestaciones;
	private HashMap<String, Double> facturacionPorTipoServicio;
	private double facturacionTotal;
	
	public EmpresaDeServicios() {
		this.especialistas = new HashMap<Integer, Especialista>();
		this.clientes = new HashMap<Integer, Cliente>();
		this.servicios = new HashMap<Integer, Servicio>();
		this.prestaciones = new ArrayList<String>();
		this.facturacionPorTipoServicio = new HashMap<String, Double>();
		this.facturacionTotal = 0;
		this.prestaciones.add(EmpresaDeServicios.PINTURA);
		this.prestaciones.add(EmpresaDeServicios.PINTURA_ALTURA);
		this.prestaciones.add(EmpresaDeServicios.ELECTRICIDAD);
		this.prestaciones.add(EmpresaDeServicios.GASISTA_INSTALACION);
		this.prestaciones.add(EmpresaDeServicios.GASISTA_REVISION);
		
		this.facturacionPorTipoServicio.put(EmpresaDeServicios.PINTURA, 0.0);
		this.facturacionPorTipoServicio.put(EmpresaDeServicios.PINTURA_ALTURA, 0.0);
		this.facturacionPorTipoServicio.put(EmpresaDeServicios.ELECTRICIDAD, 0.0);
		this.facturacionPorTipoServicio.put(EmpresaDeServicios.GASISTA_INSTALACION, 0.0);
		this.facturacionPorTipoServicio.put(EmpresaDeServicios.GASISTA_REVISION, 0.0);
	}
	
	
	/**
	* Registra un nuevo cliente en el sistema dado su:
	* - dni,
	* - nombre y
	* - teléfono de contacto.
	*
	* Si el dni ya está en el sistema se debe generar una
	* excepción.
	*/
	public void registrarCliente(int dni, String nombre, String telefono) {
		if(this.clientes.get(dni) != null) {
			throw new RuntimeException("El cliente ya existe");
		}
		Cliente cliente = new Cliente(nombre, telefono, dni);
		this.clientes.put(cliente.getDni(), cliente);
	}
	
	/**
	* Registra un nuevo especialista en el sistema dados su:
	* - nroEspecialista,
	* - nombre,
	* - teléfono y
	* - tipo De servicio en el que se especializa.
	*
	* Si el nroEspecialista ya está registrado en el sistema
	* se debe generar una excepción.
	*/
	public void registrarEspecialista(int nroEspecialista, String nombre, String telefono, String especialidad) {
		if(this.especialistas.get(nroEspecialista) != null) {
			throw new RuntimeException("El especialista ya existe");
		}
		if(!this.prestaciones.contains(especialidad)) {
			throw new RuntimeException("No existe la especialidad del especialista");
		}
		Especialista especialista = new Especialista(nroEspecialista, nombre, telefono, especialidad);
		this.especialistas.put(especialista.getNroEspecialista(), especialista);
	}
	
	/**
	* Se registra la prestación de un servicio de tipo Electricidad en el sistema
	* ingresando los datos necesarios para solicitar un servicio y además:
	* - precio por hora de trabajo del especialista
	* - cantidad de horas estimadas que llevará realizar el trabajo.
	*
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	* Si el precio por hora o las horas de trabajo estimado son menores o
	* iguales a 0, se debe generar una excepción.
	*/
	public int solicitarServicioElectricidad(int dni, int nroEspecialista, String direccion, double precioPorHora, int horasTrabajadas) {
		// valido que el cliente exista
		this._validarCliente(dni);
		
		// valido que el especialista exista y que pueda realizar el servicio que se pretende
		Especialista especialista = this.especialistas.get(nroEspecialista);
		this._validarEspecialista(especialista, EmpresaDeServicios.ELECTRICIDAD);
		
		ServicioElectricidad serElectricidad = new ServicioElectricidad(direccion, especialista, horasTrabajadas, precioPorHora);
		this.servicios.put(serElectricidad.getId(), serElectricidad);
		
		return serElectricidad.getId();
	} 


	/**
	* Se registra la prestación de un servicio de tipo Pintura en el sistema
	* ingresando los datos necesarios para solicitar un servicio y además:
	* - precio por pintar un metro cuadrado
	* - cantidad de metros cuadrados a pintar.
	*
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	* Si el precio por metro cuadrado o los metros cuadrados son menores o
	* iguales a 0, se debe generar una excepción.
	5 de 7
	*/
	public int solicitarServicioPintura(int dni, int nroEspecialista, String direccion, int metrosCuadrados, double precioPorMetroCuadrado) {
		// valido que el cliente exista
		this._validarCliente(dni);
		
		// valido que el especialista exista y que pueda realizar el servicio que se pretende
		Especialista especialista = this.especialistas.get(nroEspecialista);
		this._validarEspecialista(especialista, EmpresaDeServicios.PINTURA);
		
		ServicioPintura servicio = new ServicioPintura(direccion, especialista, metrosCuadrados, precioPorMetroCuadrado);
		this.servicios.put(servicio.getId(), servicio);
		
		return servicio.getId();
	}
	
	/**
	* Se registra la prestación de un servicio de tipo PinturaEnAltura en el
	* sistema ingresando los datos necesarios para solicitar un servicio y además:
	* - precio por pintar un metro cuadrado
	* - cantidad de metros cuadrados a pintar
	* - nro de piso en el que se realizará el trabajo.
	* - costo del seguro
	* - costo del alquiler de los andamios.
	*
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	* Si el precio por metro cuadrado o los metros cuadrados o el piso o el costo
	* del seguro o el costo del alquiler de los andamios son menores o iguales a 0,
	* se debe generar una excepción.
	*/
	public int solicitarServicioPintura(int dni, int nroEspecialista, String direccion, int metrosCuadrados, double precioPorMetroCuadrado, int piso, double seguro, double alqAndamios) {
		// valido que el cliente exista
		this._validarCliente(dni);
		
		// valido que el especialista exista y que pueda realizar el servicio que se pretende
		Especialista especialista = this.especialistas.get(nroEspecialista);
		this._validarEspecialista(especialista, EmpresaDeServicios.PINTURA_ALTURA);
		
		ServicioPinturaEnAltura servicio = new ServicioPinturaEnAltura(direccion, especialista, metrosCuadrados, precioPorMetroCuadrado, piso, seguro, alqAndamios);
		this.servicios.put(servicio.getId(), servicio);
		
		return servicio.getId();
	}
	
	/**
	* Se registra la prestación de un servicio de tipo GasistaInstalacion en el
	* sistema ingresando los datos necesarios para solicitar un servicio y además:
	* - cantidad de artefactos a instalar
	* - precio por la instalación de un artefacto.
	*
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	* Si el precio de instalación o la cantidad de artefactos a instalar son
	* menores o iguales a 0, se debe generar una excepción.
	*/
	public int solicitarServicioGasistaInstalacion(int dni, int nroEspecialista, String direccion, int cantArtefactos, double precioPorArtefacto) {
		// valido que el cliente exista
		this._validarCliente(dni);
		
		// valido que el especialista exista y que pueda realizar el servicio que se pretende
		Especialista especialista = this.especialistas.get(nroEspecialista);
		this._validarEspecialista(especialista, EmpresaDeServicios.GASISTA_INSTALACION);
		
		ServicioGasInstalacion servicio = new ServicioGasInstalacion(direccion, especialista, cantArtefactos, precioPorArtefacto);
		this.servicios.put(servicio.getId(), servicio);
		
		return servicio.getId();
	}
	
	/**
	* Se registra la prestación de un servicio de tipo GasistaRevison en el
	* sistema ingresando los datos necesarios para solicitar un servicio y además:
	* - cantidad de artefactos a revisar
	* - precio por la revisión de un artefacto.
	*
	* Se devuelve el código único del servicio a realizar.
	*
	* Si el dni o el nroEspecialista no están registrados en el sistema se debe
	* generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	6 de 7
	* una excepción.
	* Si el precio de instalación o la cantidad de artefactos a revisar son
	* menores o iguales a 0, se debe generar una excepción.
	*/
	public int solicitarServicioGasistaRevision(int dni, int nroEspecialista, String direccion, int cantArtefactos, double precioPorArtefacto) {
		// valido que el cliente exista
		this._validarCliente(dni);
		
		// valido que el especialista exista y que pueda realizar el servicio que se pretende
		Especialista especialista = this.especialistas.get(nroEspecialista);
		this._validarEspecialista(especialista, EmpresaDeServicios.GASISTA_REVISION);
		
		ServicioGasRevision servicio = new ServicioGasRevision(direccion, especialista, cantArtefactos, precioPorArtefacto);
		this.servicios.put(servicio.getId(), servicio);
		
		return servicio.getId();
	}
	
	/**
	* Se registra que el servicio solicitado ya fué concluido. Para esto se debe
	* ingresar el costo de los materiales utilizados para poder realizar el
	* trabajo.
	*
	* Se devuelve el precio que se debe facturar al cliente.
	* Este precio se obtiene sumando el costo de los materiales con el costo del
	* servicio realizado. Cada tipo de servicio tiene su forma de calcular el
	* costo del trabajo.
	*
	* Si el código de servicio no está en el sistema o el mismo ya fué finalizado,
	* se debe generar una excepción.
	*
	* Se debe realizar esta operación en O(1).
	*/
	public double finalizarServicio(int codServicio, double costoMateriales) {
		Servicio servicio = this.servicios.get(codServicio);
		if(servicio == null || servicio.isTerminado()) {
			throw new RuntimeException("No se puede finalizar este servicio");
		}
		double total = servicio.cobrar(costoMateriales); //Total del servicio
		
		double oldFacturacionTotalServicio = this.facturacionPorTipoServicio.get(servicio.getTipo()); //Facturacion vieja del servicio
		double currentFacturacionTotalServicio = oldFacturacionTotalServicio + total; //Actualizo facturacion del servicio 
		this.facturacionPorTipoServicio.put(servicio.getTipo(), currentFacturacionTotalServicio); //Actualizo HASHMAP con la facturacion NUEVA
		
		this.facturacionTotal += total;
		
		return total;
	}
	
	/**
	* Devuelve un diccionario cuya clave es el tipo de servicio y el valor es la
	* cantidad de servicios realizados de ese tipo.
	* Si un tipo de servicio no tuvo ninguna demanda, el valor de esa entrada debe
	* ser 0.
	*/
	public HashMap<String,Integer> cantidadDeServiciosRealizadosPorTipo(){
		//Creo mapa de las prestaciones y cantidad de serivicios que realizo ese tipo de Servicio
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(String p : prestaciones) {
			map.put(p, 0);
		}
		
//		this.prestaciones.forEach((prestacion) -> {
//			map.put(prestacion, 0);
//		});
		
		//Recorro servicios
		//Pregunto si esta terminado
		//Me guardo el tipo de servicio
		//Obtengo la cantidad de prestaciones en MAP.
		//Actualizo el contador de servicios de MAP 
//		this.servicios.forEach((id,servicio) -> {
//			if(servicio.isTerminado()) {
//				String tipoServicio = servicio.getTipo();
//				Integer valorContadorActual = map.get(tipoServicio);
//				
//				map.put(tipoServicio, valorContadorActual + 1);				
//			}
//		});
		
		for(Servicio s : servicios.values()) {
			if(s.isTerminado()) {
				String tipoServicio = s.getTipo();
				Integer valorContadorActual = map.get(tipoServicio);
				
				map.put(tipoServicio, valorContadorActual + 1);				
			}
		}
		
		return map;
	}
	
	/**
	* Devuelve la suma del precio facturado de todos los servicios finalizados que
	* son del tipo pasado por parámetro.
	* Si el tipo de servicio es invalido, debe generar una excepción.
	*
	* Se debe realizar esta operación en O(1).
	*/
	public double facturacionTotalPorTipo(String tipoServicio) {
		if(!this.facturacionPorTipoServicio.containsKey(tipoServicio)) {
			throw new RuntimeException("No existe el tipo de servicio");
		}
		return this.facturacionPorTipoServicio.get(tipoServicio);
	}
	
	/**
	* Devuelve la suma del precio facturado de todos los servicios finalizados que
	* realizó la empresa.
	*/
	public double facturacionTotal() {
		return this.facturacionTotal;
	}
	
	/**
	* Debe cambiar el especialista responsable del servicio.
	* Si código de Servicio o el nroEspecialista no están registrados en el sistema
	* se debe generar una excepción.
	* Si el especialista no se especializa en este tipo de servicio se debe generar
	* una excepción.
	*
	*
	* Se debe realizar esta operación en O(1).
	*/
	public void cambiarResponsable(int codServicio, int nroEspecialista) {
		Servicio servicio = this.servicios.get(codServicio);
		Especialista especialista = this.especialistas.get(nroEspecialista);
		
		this._validarServicio(servicio);
		this._validarEspecialista(especialista, servicio.getTipo());
		
		servicio.cambiarEspecialista(especialista);
	}
	
	/**
	* Devuelve un String con forma de listado donde cada renglón representa un
	* servicio realizado.
	* Cada renglón debe respetar el siguiente formato:
	* " + [ codServicio - GasistaInstalacion ] Dirección"
	* por ejemplo:
	* " + [ 1492 - GasistaInstalacion ] uan María Gutiérrez 1150"
	* Si el nroEspecialista no está registrado en el sistema, se debe generar una excepción.
	* Si el especialista no ha realizado ningún servicio hasta el momento, se debe devolver un string vacio
	*/
	public String listadoServiciosAtendidosPorEspecialista(int nroEspecialista) {
		StringBuilder output = new StringBuilder();
		Especialista especialista = this.especialistas.get(nroEspecialista);
		if(especialista == null) {
			throw new RuntimeException("No existe el especialista");
		}
	
		this.servicios.forEach((id, servicio) -> {
			if(servicio.getEspecialista().getNroEspecialista() == nroEspecialista) {
				output.append(" + [ ").append(id).append(" - ").append(servicio.getTipo()).append(" ] ").append(servicio.getDomicilio()).append("\n");
			}
		});
//	    for (Entry<Integer, Servicio> entry : this.servicios.entrySet()) {
//	        Integer id = entry.getKey();
//	        Servicio servicio = entry.getValue();
//
//	        if (servicio.getEspecialista().getNroEspecialista() == nroEspecialista) {
//	            output.append(" + [ ").append(id).append(" - ").append(servicio.getTipo()).append(" ] ").append(servicio.getDomicilio()).append("\n");
//	        }
//	    }
		
		return output.toString();
	}
	
	
	@Override
	public String toString() {
		return "Empresa tiene: \n\n Especialistas: \n [especialistas=" + especialistas + ", \n\n clientes: \n" + clientes + ", \n\n prestaciones: \n" + prestaciones;
	}


	/**
	 * Verifica si un cliente existe
	 * @param dni
	 * @param nroEspecialista
	 * @param especialidad
	 * @return Especialista asignado al servicio
	 */
	private void _validarCliente(int dni) {
		if(!this.clientes.containsKey(dni)) {
			throw new RuntimeException("el cliente no existe");
		}
		return;
	}
	
	/**
	 * Verifica si el servicio existe
	 * @param servicio
	 */
	private void _validarServicio(Servicio servicio) {
		if(servicio == null) {
			throw new RuntimeException("el servicio no existe");
		}
		return;
	}
	
	
	/**
	 * Valida que el especialista exista y que pueda cumplir el trabajo pasado por parametro
	 * @param especialista
	 * @param tipoServicio
	 */
	private void _validarEspecialista(Especialista especialista, String tipoServicio) {
		if(especialista == null) {
			throw new RuntimeException("el especialista no existe");
		}
		especialista.puedeHacerEspecialidad(tipoServicio);
		return;
	}
	
}