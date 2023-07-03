package tano_construcciones;

public class ServicioPintura extends Servicio{
	protected int superficie;
	protected double costo_mt2;
	
	/**
	 * Constructor para servicio de pintura
	 * @param domicilio
	 * @param especialista
	 * @param superficie
	 * @param costoMt2
	 */
	public ServicioPintura(String domicilio, Especialista especialista, int superficie, double costoMt2) {
		super(domicilio, especialista, EmpresaDeServicios.PINTURA);
		
		if(superficie <= 0 || costoMt2 <= 0) {
			throw new RuntimeException("No se puede crear el servicio");
		}
		
		this.superficie = superficie;
		this.costo_mt2 = costoMt2;
	}
	
	/**
	 * Constructor para servicio de pintura en altura
	 * @param domicilio
	 * @param especialista
	 * @param tipo
	 * @param superficie
	 * @param costoMt2
	 */
	protected ServicioPintura(String domicilio, Especialista especialista, String tipo, int superficie, double costoMt2) {
		super(domicilio, especialista, tipo);
		
		this.superficie = superficie;
		this.costo_mt2 = costoMt2;
	}
	
	@Override
	public double cobrar(double costoMateriales) {
		double total = (this.costo_mt2 * this.superficie) + costoMateriales;
		return super.finalizar(total);
	}

	
}
