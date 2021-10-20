package maven.reservaTickets;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 
 * @author Raúl Núñez Sebastián
 *
 */
public class Asientos {
	
	//Declaraci�n de variables de filas y columnas
	int filas = 10;
	int columnas = 2;
	
	Logger traza = LogManager.getLogger(Asientos.class);
	
	//Declaraci�n e inicializaci�n del array de los asientos del tren
	String[][] asientos = new String[filas][columnas];
	
	//M�todo que recorre el array y va rellenando cada fila y columna con una L de asiento libre
	public void rellenarAsientos() {
		for(int i = 0; i<filas; i++) {
			for(int j = 0; j<columnas; j++) {
				asientos[i][j]="L";
			}
		}
	}
	//M�todo que muestra el valor del array que contiene cada fila y columna
	public void mostrarAsientos() {
		for(int i = 0; i<filas; i++) {
			for(int j = 0; j<columnas; j++) {
				System.out.print(asientos[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
	//M�todo que va comprobando una a una las posiciones de los asientos hasta que encuentra una libre
	public void comprobarPrimerAsientoLibre() {
		boolean asientoLibre = false;
		for(int i = 0; i<filas && !asientoLibre; i++) {
			for(int j = 0; j<columnas && !asientoLibre; j++) {
				if(asientos[i][j].equals("L")) {
					asientoLibre = true;
					asientos[i][j]="O";
					System.out.println("Has comprado un billete para la fila "+(i+1)+" asiento "+(j+1));
				}
			}
		}
	}
	//M�todo que recibe por par�metro la fila y la columna que introduce el usuario y comprueba si esa posici�n est� o no libre
	public void comprarTicket(int fila, int columna) {
		if(asientos[fila-1][columna-1].equals("L")) {
			asientos[fila-1][columna-1]="O";
			System.out.println("Has comprado un billete para la fila "+fila+" asiento "+columna);
		}else {
			System.out.println("Ese asiento ya está ocupado");
			traza.info("El usuario ha elegido una fila o un asiento ocupado." + " Fila elegida: " + fila+"."+" Columna elegida: "+columna+".");
		}
	}
}