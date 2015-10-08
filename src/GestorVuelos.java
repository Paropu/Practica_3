import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GestorVuelos {
	public static void main(String args[]) {

		FileInputStream flujo_entrada = null;
		try {
			flujo_entrada = new FileInputStream("base_de_datos.txt"); // CAMBIAR A LINEA DE COMANDOS
		} // Se crea un flujo de datos al fichero.
		catch (FileNotFoundException excepcion1) { // Si el fichero no existe, salta excepciOn
			System.out.println("Fichero inexistente");// y mostramos mensaje por pantalla
			System.exit(-1);
		}
		Scanner entrada = new Scanner(flujo_entrada);// Se crea un objeto para escanear la linea del fichero
		String linea = null; // Variable que contendra la informacion escaneada del fichero
		int n = 0;
		LinkedList<Vuelo> listaVuelos = new LinkedList<Vuelo>();
		while (entrada.hasNextLine()) { // Mientras hay lineas por leer...
			n++; // Herramienta
			linea = entrada.nextLine(); // Escaneamos la linea.
			StringTokenizer separador = new StringTokenizer(linea, "*");
			while (separador.hasMoreTokens()) { // Separamos los elementos de la linea escaneada
				String identificador = separador.nextToken().replace(" ", "");
				String companhia = separador.nextToken();
				String coste = separador.nextToken().replace(" ", "");
				String horaSalida = separador.nextToken().replace(" ", ""); // PASAR A FORMATO HORA
				String horaLlegada = separador.nextToken().replace(" ", ""); // PASAR A FORMATO HORA
				String duracion = Vuelo.duracionVuelo(horaSalida, horaLlegada);
				// Construimos un objeto Vuelo en cada iteracion con los
				// parametros escaneados anteriormente.
				Vuelo vueloActual = new Vuelo(identificador, companhia, coste, horaSalida, horaLlegada, duracion);
				listaVuelos.add(vueloActual);

				// System.out.println(n + vueloActual.getIdentificador() + " - " + vueloActual.getCompanhia() + " - " +
				// vueloActual.getCoste()
				// + " - " + vueloActual.getHoraSalida() + " - " + vueloActual.getHoraLlegada()); // Herramienta
			}
		} // Fin del bucle de creacion de la lista dinamica que contiene la informacion de los vuelos extraida del txt

		// ORDENAR LISTA POR HORA DE SALIDA

		// ENVIAR LISTA ORDENADA A TXT

		// MOSTRAR POR PANTALLA LA LISTA ORDENADA
		Iterator<Vuelo> itr = listaVuelos.iterator();
		while (itr.hasNext()) {
			Object element = itr.next();
			System.out.println(element.toString()); // Muestra informacion del vuelo.
		}
		System.out.printf("\n\n*Fin de la ejecucion*"); // Herramienta
	}
}

/*
 * Creacion de una coleccion: TipoColeccion <TipoElemento> nombreDeLaColeccion = new tipoColeccion <tipoElemento>
 * 
 * Creacion y uso de un iterador: Iterator <Type> nombreIterador = nombreDeLaColeccion.iterator(); //Creacion while
 * (nombreIterador.hasNext()){ //Uso nombreIterador.next(); //Iterador sobre primer elemento de la coleccion. }
 * 
 * Uso del bucle ForEach: for (T t : this) action.accept(t);
 * 
 */
