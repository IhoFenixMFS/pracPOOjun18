package Banco;
import Bolsa.BolsaDeValores;
import Bolsa.Empresa;
import Banco.*;
import Mensajes.Mensaje;
import Mensajes.MensajeCompra;
import Mensajes.MensajeRespuestaCompra;
import Mensajes.MensajeRespuestaVenta;
import Mensajes.MensajeVenta;
import sun.util.BuddhistCalendar;
import General.Escaner;
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
	}

	public static void solicitarComprarAccion(BolsaDeValores bolsa, Banco banco) {
		System.out.println("Comprar acción. . .");
		MensajeCompra.compraAcciones(bolsa, banco);
	}
	
	public static void solicitarVenderAccion(BolsaDeValores bolsa, Banco banco) {
		System.out.println("Vender acción. . .");
		
	}

	public static void procesarSolicitudCompra(BolsaDeValores bolsa, Banco banco, String solicitud) {
		try {
			String[] corte = solicitud.split("|");
			String parte1 = corte[0];
			String nomCli = corte[1];
			String nomEmp = corte[2];
			String parte4 = corte[3];

			int id = Integer.parseInt(parte1);
			double importe = Double.parseDouble(parte4);
			
			realizarPeticionCompra(bolsa, banco, id, nomCli, nomEmp, importe);
	    	
		}  catch (Exception e) {
			// TODO: handle exception
			MensajeRespuestaCompra.errorCompraAcciones();
		}
	}

	public static void procesarSolicitudVenta(BolsaDeValores bolsa, Banco banco, String solicitud) {
		try {//<id peticion>|<nombre cliente>|<nombre empresa>|<numero de acciones a vender>
			String[] corte = solicitud.split("|");
			String parte1 = corte[0];
			String nomCli = corte[1];
			String nomEmp = corte[2];
			String parte4 = corte[3];

			int id = Integer.parseInt(parte1);
			int acciones = Integer.parseInt(parte4);
			
			realizarPeticionVenta(bolsa, banco, id, nomCli, nomEmp, acciones);
	    	
		}  catch (Exception e) {
			MensajeRespuestaCompra.errorCompraAcciones();
		}
	}

	private static void realizarPeticionCompra(BolsaDeValores bolsa, Banco banco, int id, String nomCli, String nomEmp, double importe) throws Exception{

		//Recibimos el objeto Empresa al que deseamos comprarle acciones.
		Empresa empresa = bolsa.buscarEmpresaPorNombre(nomEmp);
			//revisar
		//almacenamos en numAcciones el valor maximo de acciones completas que se pueden comprar.
		int numAcciones = Utilidades.calcularMaxAcciones(empresa, importe);
		//calculamos lo que ha invertido en negativo
		double invertido = - Utilidades.calcularImporteInvertido(empresa, importe);
			//revisar
		//calculamos el dinero que le sobra.
		double devolver = Utilidades.calcularImporteDevolver(empresa, importe);
		
		//buscar entre todos los clientes del banco el elegido.
		Cliente cli = banco.buscarClientePorNombre(nomCli);
			if (cli.equals(null)) {
				System.err.println("El cliente no existe.");
			} else {
				//Se acctualica la cartera de valores del cliente
				cli.actualizarValoresCliente(invertido, numAcciones, empresa);
				
				MensajeRespuestaCompra.mensajeCompraAcciones(id, nomCli, nomEmp, importe, numAcciones, invertido, devolver);
			}
	}

	private static void realizarPeticionVenta(BolsaDeValores bolsa, Banco banco, int id, String nomCli, String nomEmp, int acciones) throws Exception{

		//Recibimos el objeto Empresa al que deseamos comprarle acciones.
		Empresa empresa = bolsa.buscarEmpresaPorNombre(nomEmp);
			//revisar		
		//calculamos lo que ha invertido en negativo
		double beneficio = Utilidades.calcularBeneficio(empresa, acciones);
		//calculamos el dinero que le sobra.
		
		//buscar entre todos los clientes del banco el elegido.
		Cliente cli = banco.buscarClientePorNombre(nomCli);
		if (cli.equals(null)) {
			System.err.println("El cliente no existe.");
		} else {
			//Se acctualica la cartera de valores del cliente.
			cli.actualizarValoresCliente(beneficio, acciones, empresa);
			
			//recibimmos el saldo tras la venta.
			double saldoFinal = cli.getSaldo();
	
			MensajeRespuestaVenta.mensajeVentaAcciones(id, nomCli, nomEmp, beneficio, acciones, saldoFinal);
		}
	}

}
