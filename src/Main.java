import java.util.Scanner;

import General.Escaner;
import General.InterfazDeUsuario;

public class Main {

	private static void menu() {
		System.out.println();
		System.out.println();
		System.out.println("0.- Salir");
		System.out.println("------------------ ESTADO --------------");
		System.out.println("1.- Imprimir estado de los clientes");
		System.out.println("2.- Imprimir estado de la bolsa");
		System.out.println("------------------- BANCO --------------");
		System.out.println("3.- Añadir cliente");
		System.out.println("4.- Eliminar cliente");
		System.out.println("5.- Realizar copia de seguridad");
		System.out.println("6.- Restaurar copia de seguridad");
		System.out.println("7.- Mejorar cliente a premium");
		System.out.println("8.- Solicita recomendación de inversión");
		System.out.println("------------------- BOLSA --------------");
		System.out.println("9.- Añadir empresa a la bolsa");
		System.out.println("10.- Eliminar empresa de la bolsa");
		System.out.println("11.- Actualización de valores");
		System.out.println("12.- Realizar copia de seguridad");
		System.out.println("13.- Restaurar copia de seguridad");
		System.out.println("------------- OPERACIONES --------------");
		System.out.println("14.- Solicitar compra de acciones");
		System.out.println("15.- Solicitar venta de acciones");
		System.out.println("16.- Solicitar actualización de valores");
		System.out.println("------------------- BRÓKER --------------");
		System.out.println("17.- Imprimir operaciones pendientes");
		System.out.println("18.- Ejecutar operaciones pendientes");
		System.out.println("-----------------------------------------");
	}
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer teclado;		
		try {
			do {
				menu();
				System.out.println();
				teclado = Escaner.leer();
				InterfazDeUsuario.seleccion(teclado);
			} while (teclado!=0);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error, la aplicación se cerrará");
			System.err.println("Puede volver a abrirla y esperar que el fallo no continúe.");
		}		
	}

}
