package clasesPropias;

public class Fecha {
	int dia;
	int mes;
	int anio;
		
	public Fecha(int dia, int mes, int anio) {
			this.dia=dia;
			this.mes = mes;
			this.anio = anio;
		}	
		
	public static boolean bisiesto(int anio) {
			if (anio % 4 == 0 && anio % 100 != 0)
				return true;
			else if (anio % 400 == 0)
				return true;
			else
				return false;
		}
		
	public void imprimir() {
			System.out.println(this.dia+"/" + this.mes + "/" + this.anio);
		}
	
	//Devuelve la cantidad de días del mes dado, en el año dado.
	public static int diasDelMes(int mes, int anio) {
		if(bisiesto(anio) && mes==2) return 29;
		else if (mes==2) return 28;
		else if(mes==4 || mes==6 || mes==9) return 30;
		else return 31;
	}
	
	//Devuelve true si la fecha es válida, y false en caso contrario.
	public boolean esValida() {
		if(this.mes<1 || this.mes>12) return false;
		else if(diasDelMes(this.mes,this.anio)<=this.dia || this.dia<1) return false;
		return true;
	}
	
	//Hace avanzar un día a la fecha.
	public void avanzarDia() {
		if(this.dia == diasDelMes(this.mes, this.anio)){
			this.dia = 1;
			if(this.mes == 12){
				this.mes = 1;
				this.anio++;
			}
			else
				this.mes++;
		}
		else
			this.dia++;
	}
	
	//Devuelve true si la fecha está antes que la fecha recibida como parámetro.
	public boolean antesQue(Fecha otra) {
		if(this.anio > otra.anio) {
			return false;
		}else if(this.mes>otra.mes) {
			return false;
		}else if(this.dia>otra.dia) {
			return false;
		}else {
			return true;
		}
	}
	
	
	//Devuelve el número del día en el año que representa la fecha (debe ser un número entre 1 y 365).
	public int diaDelAnio() {
		int cantDias=0;
		for(int mes=1; mes<this.mes;mes++) {
			cantDias+=diasDelMes(mes,this.anio);
		}
		return cantDias + this.dia;
	}

	public int diasDeDiferencia(Fecha otra) {
		int diferenciaAnio1=diaDelAnio();
		int diferenciaAnio2=otra.diaDelAnio();
		return Math.abs(diferenciaAnio1 - diferenciaAnio2);
	}
}
