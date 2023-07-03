package tano_construcciones;

public class ServicioGas extends Servicio{
	protected int cantArtefactos;
	protected double costoFijo;
	
	public ServicioGas(String domicilio, Especialista especialista, String tipo, int cantArtefactos, double costoFijo) {
		super(domicilio, especialista, tipo);
		
		if(cantArtefactos <= 0 || costoFijo <= 0) {
			throw new RuntimeException("No se puede crear el servicio");
		}
		
		this.cantArtefactos = cantArtefactos;
		this.costoFijo = costoFijo;
	}
}