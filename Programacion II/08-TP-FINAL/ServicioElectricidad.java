package tano_construcciones;

public class ServicioElectricidad extends Servicio{
	private int horas;
	private double valor_hora;
	
	public ServicioElectricidad(String domicilio, Especialista especialista, int horas, double valorHora) {
		super(domicilio, especialista, EmpresaDeServicios.ELECTRICIDAD);
		if(horas <= 0 || valorHora <= 0) {
			throw new RuntimeException("No se puede crear el servicio");
		}
		
		this.horas = horas;
		this.valor_hora = valorHora;
	}
	
	@Override
	public double cobrar(double costoMateriales) {
		// calculo el total
		double total = (valor_hora * horas) + costoMateriales;
		// actualizo el servicio con su costo total y su estado terminado
		return super.finalizar(total);
	}
}