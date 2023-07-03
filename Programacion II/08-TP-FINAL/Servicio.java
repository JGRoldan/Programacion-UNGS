package tano_construcciones;

public abstract class Servicio {
	private int id; //Identifica el servicio
	private String domicilio;
	private double costoTotal; // costo total del servicio
	private Especialista especialista; // Especialista asignado para realizar al trabajo

	private boolean terminado;
	private String tipo;
	
	static int ultimoCodigoAsignado = 0;
	
	public Servicio(String domicilio, Especialista especialista, String tipo) {
		this.domicilio = domicilio;
		this.especialista = especialista;
		this.tipo = tipo;
		this.terminado = false;
		
		ultimoCodigoAsignado++;
		this.id = ultimoCodigoAsignado;
	}
	
	public double cobrar(double costoTotal) {
		return this.finalizar(costoTotal);
	};
	
	/**
	 * Setea el costo total del trabajo
	 * Incrementa el acumulador de facturacion total de TODOS los servicios
	 * Setea el trabajo como terminado
	 * @param costoTotal
	 * @return costoTotal
	 */
	public double finalizar(double costoTotal) {
		this.costoTotal = costoTotal;
		this.terminado = true;
		
		return this.costoTotal;
	}
	
	public void cambiarEspecialista(Especialista especialista) {
		this.especialista = especialista;
		return;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public boolean isTerminado() {
		return terminado;
	}
	
	public Especialista getEspecialista() {
		return especialista;
	}
	
	public String getDomicilio() {
		return domicilio;
	}

	@Override
	public String toString() {
		return "\nServicio [id=" + id + ", domicilio=" + domicilio + ", especialista=" + especialista + ", tipo=" + tipo
				+ "]";
	}
	
	
	
}