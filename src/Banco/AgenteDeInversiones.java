package Banco;
import Bolsa.BolsaDeValores;
import Bolsa.Empresa;
import Banco.*;
import Mensajes.MensajeCompra;
import Mensajes.MensajeRespuestaCompra;
import Mensajes.MensajeRespuestaVenta;
import Mensajes.MensajeVenta;
import General.Utilidades;
/*
 * BROKER - Actuador
*/
public class AgenteDeInversiones extends Persona{
	/*
	 * intermediario entre el banco y la bolsa.
	 * Recibe peticiones del banco y las codifica adecuadamente para la bolsa.
	 */
	
	public AgenteDeInversiones(String nombre, String dni) {
		super(nombre, dni);
		// TODO Auto-generated constructor stub
	}

	public static void procesarSolicitudBroker(Integer opc) throws Exception {
		// TODO Auto-generated method stub
		switch (opc) {
		case 0:
			ComprarAccion();
			break;
		case 1:
			VenderAccion();
			break;
		case 2:
			ActualizarBolsa();
			break;

		default:
			System.out.println("No se ha podido procesar la solicitud.");
		}
	}

	public static void ComprarAccion() throws Exception{
		System.out.println("Comprar acción. . .");
		MensajeCompra.compraAcciones();
	}
	
	public static void VenderAccion() throws Exception{
		System.out.println("Vender acción. . .");
		MensajeVenta.ventaAcciones();
	}

	public static void ActualizarBolsa(){
		System.out.println("Actualizar valores. . .");
		//ActualizarValores();
	}
	

	public static void procesarSolicitudCompra(String solicitud) {
		try {
			String[] corte = solicitud.split("|");
			String parte1 = corte[0];
			String nomCli = corte[1];
			String nomEmp = corte[2];
			String parte4 = corte[3];

			int id = Integer.parseInt(parte1);
			double importe = Double.parseDouble(parte4);
			
			realizarPeticionCompra(id, nomCli, nomEmp, importe);
	    	
		}  catch (Exception e) {
			// TODO: handle exception
			MensajeRespuestaCompra.errorCompraAcciones();
		}
	}

	public static void procesarSolicitudVenta(String solicitud) {
		try {//<id peticion>|<nombre cliente>|<nombre empresa>|<numero de acciones a vender>
			String[] corte = solicitud.split("|");
			String parte1 = corte[0];
			String nomCli = corte[1];
			String nomEmp = corte[2];
			String parte4 = corte[3];

			int id = Integer.parseInt(parte1);
			int acciones = Integer.parseInt(parte4);
			
			realizarPeticionCompra(id, nomCli, nomEmp, acciones);
	    	
		}  catch (Exception e) {
			// TODO: handle exception
			MensajeRespuestaCompra.errorCompraAcciones();
		}
	}


	private static void realizarPeticionCompra(int id, String nomCli, String nomEmp, double importe) throws Exception{

		//Recibimos el objeto Empresa al que deseamos comprarle acciones.
		Empresa empresa = BolsaDeValores.buscarEmpresaPorNombre(nomEmp);
			//revisar
		//almacenamos en numAcciones el valor maximo de acciones completas que se pueden comprar.
		int numAcciones = Utilidades.calcularMaxAcciones(empresa, importe);
		//calculamos lo que ha invertido en negativo
		double invertido = - Utilidades.calcularImporteInvertido(empresa, importe);
			//revisar
		//calculamos el dinero que le sobra.
		double devolver = Utilidades.calcularImporteDevolver(empresa, importe);
		
		//buscar entre todos los clientes del banco el elegido.
		Cliente cli = Banco.buscarClientePorNombre(nomCli);
			//revisar
		//Se acctualica la cartera de valores del cliente
		cli.actualizarValoresCliente(invertido, numAcciones, empresa);
		
		MensajeRespuestaCompra.mensajeCompraAcciones(id, nomCli, nomEmp, importe, numAcciones, invertido, devolver);
	}

	private static void realizarPeticionVenta(int id, String nomCli, String nomEmp, int acciones) throws Exception{

		//Recibimos el objeto Empresa al que deseamos comprarle acciones.
		Empresa empresa = BolsaDeValores.buscarEmpresaPorNombre(nomEmp);
			//revisar		
		//calculamos lo que ha invertido en negativo
		double beneficio = Utilidades.calcularBeneficio(empresa, acciones);
		//calculamos el dinero que le sobra.
		
		//buscar entre todos los clientes del banco el elegido.
		Cliente cli = Banco.buscarClientePorNombre(nomCli);
			//revisar
		//Se acctualica la cartera de valores del cliente.
		cli.actualizarValoresCliente(beneficio, acciones, empresa);
		
		//recibimmos el saldo tras la venta.
		double saldoFinal = cli.getSaldo();

		MensajeRespuestaVenta.mensajeVentaAcciones(id, nomCli, nomEmp, beneficio, acciones, saldoFinal);
	}

	public static void actualizarValores() {
		// TODO Auto-generated method stub
		System.err.println("Completar método.");
		
	}
}
