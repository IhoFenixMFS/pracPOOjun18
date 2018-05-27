package General;

public class InterfazDeUsuario {

	public static void menu() {
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

	@SuppressWarnings("unused")
	public static void seleccion(Integer opcion) {
		switch (opcion) {
		case 0:
			System.out.println("Adiós.");
			//se cierra
			break;
		
	  	case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		case 7:
			
			break;
		case 8:
			
			break;
		case 9:
			
			break;
		case 10:
			
			break;
		case 11:
			
			break;
		case 12:
			
			break;
		case 13:
			
			break;
		case 14:
			
			break;
		case 15:
			
			break;
		case 16:
			
			break;
		case 17:
			
			break;
		case 18:
			
			break;
		 

		default:
			System.out.println("Seleccione una opción válida por favor");
			break;
		}
	}


}
