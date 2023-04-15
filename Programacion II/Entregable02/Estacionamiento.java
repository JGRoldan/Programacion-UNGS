package estacionamiento;

import java.util.HashMap;

public class Estacionamiento {
	
	private HashMap<String, Tupla<String, Integer>> autos;
	private Alumno alumnos;
	private Docente docentes;
	private General general;
	private int totalRecaudado;
	
	public Estacionamiento() {
		autos = new HashMap<>();
		alumnos = new Alumno();
		docentes = new Docente();
		general = new General();
		totalRecaudado = 0;
	}
	
	public void registrarIngresoAuto(String matricula, String sector,int horaEntrada) {
		if(autos.containsKey(matricula))
			throw new RuntimeException("El auto ya esta registrado");
		if(horaEntrada<6 || horaEntrada>23)
			throw new RuntimeException("El horario debe estar entra las 6 y 23hs");
		
		if(!sector.equals("Alumnos") && !sector.equals("Docentes") && !sector.equals("General"))
			throw new RuntimeException("Estacionamientos disponibles: Alumnos - Docentes - General");
		
		Tupla<String, Integer> nuevoAuto = new Tupla<>(sector,horaEntrada);
		autos.put(matricula, nuevoAuto);
		restarEspacioEstacionamiento(sector);
	}
	
	private void restarEspacioEstacionamiento(String sector){
		if(sector.equals("Alumnos")) {
			alumnos.restarEspacios();
		}
		
		else if(sector.equals("Docentes")) {
			docentes.restarEspacios();
		}
		else {
			general.restarEspacios();
		}
	}

	public void registrarSalidaAuto(String matricula, int horaSalida) {
		if(!autos.containsKey(matricula))
			throw new RuntimeException("El auto no ingreso al estacionamiento");
		
		Tupla<String, Integer> auto = autos.get(matricula);
		sumarEspacioEstacionamiento(auto.getSector(), auto.getHoraEntrada(), horaSalida);
		autos.remove(matricula);
	}
	
	private void sumarEspacioEstacionamiento(String sector, int horaEntrada, int horaSalida){
		if(sector.equals("Alumnos")) {
			totalRecaudado += alumnos.precioTotal(horaEntrada, horaSalida);	
			alumnos.sumarEspacios();
		}
		
		else if(sector.equals("Docentes")) {
			totalRecaudado += docentes.precioTotal(horaEntrada, horaSalida);
			docentes.sumarEspacios();
		}
		else {
			totalRecaudado += general.precioTotal(horaEntrada, horaSalida);	
			general.sumarEspacios();
		}
	}
	
	public boolean estaAutoEnHora(String matricula, int hora) {
		if(!autos.containsKey(matricula))
			throw new RuntimeException("El auto no ingreso al estacionamiento");
		
		Tupla<String, Integer> auto = autos.get(matricula);
		if(hora < auto.getHoraEntrada())
			return false;
		return true;
	}
	
	public int totalRecaudado() {
		return this.totalRecaudado;
	}
	
	public HashMap<String, Tupla<String, Integer>> dameTodo(){
		return autos;
	}
	
}
