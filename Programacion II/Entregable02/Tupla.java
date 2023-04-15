package estacionamiento;

public class Tupla<S1, S2> {
	private int horaEntrada;
	private String sector;
	
	public Tupla(String sector,int horaEntrada) {
		this.horaEntrada = horaEntrada;
		this.sector = sector;
	}
	
	public int getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(int horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	@Override
	public String toString() {
		return "(sector=" + sector + ", horaEntrada=" + horaEntrada+")";
	}
}
