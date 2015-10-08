
public class Vuelo {

	private String identificador; // Atributos.
	private String companhia;
	private String coste;
	private String horaSalida; //CAMBIAR
	private String horaLlegada; //CAMBIAR

	public Vuelo(String identificador, String companhia, String coste, String horaSalida, String horaLlegada) { // Metodo "constructor".
		this.identificador = identificador;
		this.companhia = companhia;
		this.coste = coste;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
	}

	public String getIdentificador() { // Metodos "getter"
		return identificador;
	}

	public String getCompanhia() {
		return companhia;
	}

	public String getCoste() {
		return coste;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public String getHoraLlegada() {
		return horaLlegada;
	}
	
	public String toString () { //Metodo toString() modificado para mostrar las propiedades del vuelo.
		String mensaje = identificador + " " + companhia + " " + coste + " " + horaSalida + " " + horaLlegada + " " + "Duracion: ..." ;
return mensaje;
	}
	
	//CREAR METODO QUE CALCULE LA DURACION DEL VUELO

}