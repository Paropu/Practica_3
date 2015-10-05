
public class Vuelo {

	private String identificador; // Atributos.
	private String companhia;
	private String coste;
	private String horaSalida;
	private String horaLlegada;

	public Vuelo(String identificador, String companhia, String coste, String horaSalida, String horaLlegada) { // Método
																												// "constructor".
		this.identificador = identificador;
		this.companhia = companhia;
		this.coste = coste;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
	}

	public String getIdentificador() { // Métodos "getter"
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
}