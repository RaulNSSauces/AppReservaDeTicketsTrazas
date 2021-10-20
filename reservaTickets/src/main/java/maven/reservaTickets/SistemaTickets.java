package maven.reservaTickets;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 
 * @author Raúl Núñez Sebastián
 *
 */
public class SistemaTickets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado=new Scanner(System.in);
		
		Logger traza = LogManager.getLogger(SistemaTickets.class);
		
		Asientos asientos = new Asientos();
		
		int opcion;
		int fila, columna;
		
		asientos.rellenarAsientos();
		
		traza.info("El usuario a iniciado la aplicación");
		
		
		do{
			System.out.println("----MENÚ OBTENER TICKET TREN----");
			System.out.println("1.-Visualizar asientos.");
			System.out.println("2.-Adquirir primer asiento libre.");
			System.out.println("3.-Elegir y adquirir asiento libre.");
			System.out.println("0.-Salir.");
			System.out.println("--------------------------------");
			opcion=teclado.nextInt();
            teclado.nextLine();
            	switch(opcion) {
            	case 1: System.out.println("Visualización de los asientos libres (L) y ocupados (O) del tren:");
            			asientos.mostrarAsientos();
            			traza.info("El usuario ha elegido la opción: "+opcion);
            		break;
            	case 2:
            			asientos.comprobarPrimerAsientoLibre();
            			traza.info("El usuario ha elegido la opción: "+opcion);
            		break;
            	case 3: try {
            				System.out.print("Introduce fila (1-10): ");
            				fila=teclado.nextInt();
            				System.out.print("Introduce asiento (1-2): ");
            				columna=teclado.nextInt();
            				asientos.comprarTicket(fila, columna);
    					}catch(ArrayIndexOutOfBoundsException exc) {
    						System.out.println("Fila o asiento no encontrada");
    						traza.error("El usuario se ha salido de los límites del array. ",exc);
    					}
            				traza.info("El usuario ha elegido la opción: "+opcion);
            		break;
            	default:
            	}
		}while(opcion!=0);
	}
}