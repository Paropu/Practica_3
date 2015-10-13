
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GestorVuelos {
	public static void main(String args[]) {

		FileInputStream flujo_entrada = null;
		try {
			// flujo_entrada = new FileInputStream("base_de_datos.txt"); // Uso del programa sin argumentos por linea de comandos.
			flujo_entrada = new FileInputStream(args[0]); // Se captura el nombre del fichero de entrada por linea de comandos.
		} // Se crea un flujo de datos al fichero.
		catch (FileNotFoundException excepcion1) { // Si el fichero no existe, salta excepcion y se muestra mensaje por pantalla.
			System.out.println("Fichero inexistente");
			System.exit(-1);
		}
		Scanner entrada = new Scanner(flujo_entrada);// Se crea un objeto para escanear la linea del fichero
		String linea = null; // Variable que contendra la informacion escaneada del fichero
		LinkedList<Vuelo> listaVuelos = new LinkedList<Vuelo>();
		while (entrada.hasNextLine()) { // Mientras hay lineas por leer...
			linea = entrada.nextLine(); // Escaneamos la linea.
			StringTokenizer separador = new StringTokenizer(linea, "*");
			while (separador.hasMoreTokens()) { // Separamos los elementos de la linea escaneada
				String identificador = separador.nextToken().replace(" ", "");
				String companhia = separador.nextToken();
				String coste = separador.nextToken().replace(" ", "");
				String horaSalida = separador.nextToken().replace(" ", "");
				String horaLlegada = separador.nextToken().replace(" ", "");
				String duracion = Vuelo.duracionVuelo(horaSalida, horaLlegada);
				// Construimos un objeto Vuelo en cada iteracion con los
				// parametros escaneados anteriormente.
				Vuelo vueloActual = new Vuelo(identificador, companhia, coste, horaSalida, horaLlegada, duracion);
				listaVuelos.add(vueloActual); // Añadimos el objeto creado a la lista enlazada.
			} // Fin del bucle de creacion de la lista dinamica que contiene la informacion de los vuelos extraida del txt
		}

		Collections.sort(listaVuelos); // Se ordena la lista por hora de salida.

		FileWriter fichero = null; // Enviamos la informacion a un fichero txt.
		PrintWriter pw = null;
		try {
			// fichero = new FileWriter("salida.txt"); //Uso del programa sin paso de parametros por linea de comandos.
			fichero = new FileWriter(args[1]); // Se captura el nombre del fichero de salida por linea de comandos.
			pw = new PrintWriter(fichero);
			for (Vuelo e : listaVuelos) { // Se envia la informacion al fichero de salida con el mismo formato que el fichero de entrada.
				pw.println(e.getIdentificador() + "*" + e.getCompanhia() + "*" + e.getCoste() + "*" + e.getHoraSalida() + "*"
						+ e.getHoraLlegada());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // Aseguramos que se cierra el fichero.
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// Se muestra por pantalla la lista ordenada.
		System.out.println("     |Identificador|\t| Companhia |\t\t| Precio |\t| Salida |\t| Llegada |\t| Duracion |\n");
		for (Vuelo e : listaVuelos)
			System.out.printf(e + "\n\n");

		// System.out.printf("\n\n*Fin de la ejecucion*\n\n"); //Herramienta
	}
}

/*
 * -----NOTAS-----
 * 
 * Creacion de una coleccion: TipoColeccion <TipoElemento> nombreDeLaColeccion = new tipoColeccion <tipoElemento>
 * 
 * Creacion y uso de un iterador: Iterator <Type> nombreIterador = nombreDeLaColeccion.iterator(); //Creacion while
 * (nombreIterador.hasNext()){ //Uso nombreIterador.next(); //Iterador sobre primer elemento de la coleccion. }
 * 
 * Uso del bucle ForEach: for (T t : this) action.accept(t);
 * 
 * Interfaz comparable: public interface Comparable<T> { public int compareTo(T o); }
 * 
 * Acceder al dato en la posición i de una lista que implemente el interfaz list: for(int i =0; i<lista.size(); i++){
 * System.out.println(lista.get(i).nombre); } or (Person person : list) { System.out.println(person.getName()+ "   "+ person.getAge()); }
 * 
 * Ordenar elementos de una colección, modificando el metodo sort de la clase Collections. Collections.sort(list,new PersonComparator());
 * public class PersonComparator implements Comparator<Person> {
 * 
 * @Override public int compare(Person obj1, Person obj2) { return obj1.getAge() - obj2.getAge(); } }
 */
