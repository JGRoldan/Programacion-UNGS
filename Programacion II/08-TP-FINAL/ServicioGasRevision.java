package tano_construcciones;

public class ServicioGasRevision extends ServicioGas{

	public ServicioGasRevision(String domicilio, Especialista especialista, int cantArtefactos, double costoFijo) {
		super(domicilio, especialista, EmpresaDeServicios.GASISTA_REVISION, cantArtefactos, costoFijo);
	}
	
	@Override
	public double cobrar(double costoMateriales) {
		double total = this.cantArtefactos * this.costoFijo;
		int porcentaje_descuento = 0;
		if(this.cantArtefactos > 10) {
			porcentaje_descuento = 15;
		}else if(this.cantArtefactos > 5) {
			porcentaje_descuento = 10;
		}
		total = (total * porcentaje_descuento) / 100;
		
		total += costoMateriales;
		
		return super.finalizar(total);
	}
	
}
