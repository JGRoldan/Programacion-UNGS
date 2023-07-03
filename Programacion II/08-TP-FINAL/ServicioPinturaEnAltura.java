package tano_construcciones;

public class ServicioPinturaEnAltura extends ServicioPintura{
	private int nro_piso;
	private double costo_seguro;
	private double costo_alquiler_andamios;
	
	public ServicioPinturaEnAltura(String direccion, Especialista especialista, int superficie, double costoMt2, int piso, double seguro, double alqAndamios) {
		super(direccion, especialista, EmpresaDeServicios.PINTURA_ALTURA, superficie, costoMt2);
		
		if(piso <= 0 || seguro <= 0 || alqAndamios <= 0) {
			throw new RuntimeException("No se puede crear el servicio");
		}
		
		this.nro_piso = piso;
		this.costo_seguro = seguro;
		this.costo_alquiler_andamios = alqAndamios;
	}
	
	@Override
	public double cobrar(double costoMateriales) {
		double total = costoMateriales + (this.superficie * this.costo_mt2) + this.costo_seguro + this.costo_alquiler_andamios;
		return super.finalizar(total);
	}

}
