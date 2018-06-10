package General;
import Banco.AgenteDeInversiones;
import Banco.Banco;
import Bolsa.BolsaDeValores;
import Mensajes.MensajeActualizacion;
import Mensajes.MensajeCompra;
import Mensajes.MensajeVenta;
import Banco.GestorDeInversiones;

public class InterfazDeUsuario {

	public static void menu() {
		System.out.println();
		System.out.println(" 0.- Salir");
		System.out.println("------------------ ESTADO --------------");
		System.out.println(" 1.- Imprimir estado de los clientes");
		System.out.println(" 2.- Imprimir estado de la bolsa");
		System.out.println("------------------- BANCO --------------");
		System.out.println(" 3.- Añadir cliente");
		System.out.println(" 4.- Eliminar cliente");
		System.out.println(" 5.- Realizar copia de seguridad");
		System.out.println(" 6.- Restaurar copia de seguridad");
		System.out.println(" 7.- Mejorar cliente a premium");
		System.out.println(" 8.- Solicita recomendación de inversión");
		System.out.println("------------------- BOLSA --------------");
		System.out.println(" 9.- Añadir empresa a la bolsa");
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

	public static void seleccion(BolsaDeValores bolsa, Banco banco, Integer opcion) throws Exception {
		switch (opcion) {
			case 0:		
				System.out.println("Adiós.");
				System.out.println("----------------------------------------------");
				break;
		  	case 1:	
		  		System.out.println("Imprimir el estado de los clientes");
		  		banco.mostrarDatos();
				System.out.println("----------------------------------------------");
				break;
			case 2:
				System.out.println("Imprimir el estado de la bolsa");
				bolsa.mostrarEstado();
				System.out.println("----------------------------------------------");
				break;
			case 3:
				System.out.println("Añade un cliente");
				banco.anadirCliente();
				System.out.println("----------------------------------------------");
				break;
			case 4:
				System.out.println("Elimina un cliente");
				banco.borrarCliente();
				System.out.println("----------------------------------------------");
				break;
			case 5:
				System.out.println("Realizar copia de seguridad del banco");
				banco.realizarCopiaDeSeguridad();
				System.out.println("----------------------------------------------");
				break;
			case 6:
				System.out.println("Restaurar copia de seguridad del banco");
				banco.restaurarCopiaDeSeguridad();
				System.out.println("----------------------------------------------");
				break;
			case 7:
				System.out.println("Mejorar categoría de un cliente a premium");
				banco.mejorar();
				System.out.println("----------------------------------------------");
				break;
			case 8:
				System.out.println("Solicitar recomendación de inversión");
				banco.getBroker().realizarRecomendacion(bolsa,banco);
				System.out.println("----------------------------------------------");
				break;
			case 9:
				System.out.println("Añadir una nueva empresa");
				bolsa.nuevaEmp();
				System.out.println("----------------------------------------------");
				break;
			case 10:
				System.out.println("Eliminar una empresa");
				bolsa.borrarEmpresa();
				System.out.println("----------------------------------------------");
				break;
			case 11:
				System.out.println("Actualizar valores");
				bolsa.actualizarValores();
				System.out.println("----------------------------------------------");
				break;
			case 12:
				System.out.println("Realizar copia de seguridad de la bolsa");
				bolsa.realizarCopiaDeSeguridad();
				System.out.println("----------------------------------------------");
				break;
			case 13:
				System.out.println("Restaurar copia de seguridad de la bolsa");
				bolsa.restaurarCopiaDeSeguridad();
				System.out.println("----------------------------------------------");
				break;
			case 14:
				System.out.println("Realizar solicitud de compra de acciones");
				MensajeCompra.almacenarSolicitud(bolsa,banco);
				System.err.println("Revisr fallo de lectura de peticion");
				System.out.println("----------------------------------------------");
				break;
			case 15:
				System.out.println("Realizar solicitud de venta de acciones");
				MensajeVenta.almacenarSolicitud(bolsa, banco);
				System.err.println("Revisr fallo de lectura de peticion");
				System.out.println("----------------------------------------------");
				break;
			case 16:
				System.out.println("Realizar solicitud de actualización de valores");
				bolsa.actualizarValores();
				System.out.println("----------------------------------------------");
				break;
			case 17:
				System.out.println("Imprimir operaciones pendientes de llevar a cabo");
				banco.getBroker().mostrarTodas();
				System.out.println("----------------------------------------------");
				break;
			case 18:
				System.out.println("Ejecutar operaciones pendientes");
				banco.getBroker().procesarTodas(bolsa, banco);
				System.out.println("----------------------------------------------");
				break;
			default:
				System.out.println("Seleccione una opción válida por favor");
				
				System.out.println("----------------------------------------------");
				break;
		}
	}


}
