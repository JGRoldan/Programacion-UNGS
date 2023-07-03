package tano_construcciones;

public class ServicioGasInstalacion extends ServicioGas{
	public ServicioGasInstalacion(String domicilio, Especialista especialista, int cantArtefactos, double costoFijo) {
		super(domicilio, especialista, EmpresaDeServicios.GASISTA_INSTALACION, cantArtefactos, costoFijo);
	}
	
	@Override
	public double cobrar(double costoMateriales) {
		double total = (this.cantArtefactos * this.costoFijo) + costoMateriales;
		return super.finalizar(total);
	}

}