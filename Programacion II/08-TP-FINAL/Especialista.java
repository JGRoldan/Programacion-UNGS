package tano_construcciones;

public class Especialista extends Persona{
	private int nroEspecialista;
	private String especialidad;
	
	public Especialista(int nroEspecialista, String nombre, String telefono, String especialidad) {
		super(nombre, telefono);
		
		if(!validarDatos(nombre, telefono, especialidad))
			throw new RuntimeException("Los datos del especialista son invalidos");
		
		this.nroEspecialista = nroEspecialista;
		this.especialidad = especialidad;
	}
	
	
	//---------------------
	//VALIDACIONES INTERNAS
	//---------------------
	private boolean validarDatos(String nombre, String telefono, String especialidad) {
		if(nombre=="" || telefono=="" || especialidad=="")
			return false;
		return true;
	}
	
	public boolean puedeHacerEspecialidad(String tipoEspecialidad) {
		if(this.especialidad != tipoEspecialidad) {
			throw new RuntimeException("El especialista no tiene asiganda la especialidad requerida");
		}
		
		return true;
	}

	public int getNroEspecialista() {
		return nroEspecialista;
	}
	
	public String getEspecialidad() {
		return this.especialidad;
	}
	
	@Override
	public String toString() {
		return "Especialista: nombre=" + this.nombre + ", especialidad=" + this.especialidad + ", telefono=" + this.telefono;
	}

}