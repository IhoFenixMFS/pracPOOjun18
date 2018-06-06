package Banco;
import Bolsa.BolsaDeValores;
import Bolsa.Empresa;
import Banco.*;
import Mensajes.MensajeCompra;
import Mensajes.MensajeRespuestaCompra;
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

	private void procesarSolicitudBroker(Integer opc) {
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

	public void ComprarAccion(){
		System.out.println("Comprar acción. . .");
		//compraAcciones();
	}
	
	public void VenderAccion(){
		System.out.println("Vender acción. . .");
		//venderAcciones();
	}

	public void ActualizarBolsa(){
		System.out.println("Actualizar valores. . .");
		//ActualizarValores();
	}
	
	public static void procesarSolicitudCompra(String solicitud) {
		int cant= Utilidades.contarCaracter(solicitud, '|');
		
		if (cant!=3) {
			MensajeRespuestaCompra.errorCompraAcciones();
		} else {
			try {
				String[] corte = solicitud.split("|");
				String parte1 = corte[0];
				String nomCli = corte[1];
				String nomEmp = corte[2];
				String parte4 = corte[3];

				int id = Integer.parseInt(parte1);
				double importe = Double.parseDouble(parte1);
				
				realizarPeticion(id, nomCli, nomEmp, importe);
		    	
			}  catch (Exception e) {
				// TODO: handle exception
				MensajeRespuestaCompra.errorCompraAcciones();
			}

		}
	}

	

	private static void realizarPeticion(int id, String nomCli, String nomEmp, double importe) throws Exception{
		//Recibimos el objeto Empresa al que deseamos comprarle acciones.
		Empresa empresa = BolsaDeValores.buscarEmpresaPorNombre(nomEmp);
		//almacenamos en numAcciones el valor maximo de acciones completas que se pueden comprar.
		int numAcciones = (int) Utilidades.calcularMaxAcciones(empresa, importe);
		//calculamos lo que ha invertido.
		double invertido = numAcciones * empresa.getValorAcciones();
		//calculamos el dinero que le sobra.
		double devolver = importe - invertido;
		//buscar entre todos los clientes del banco el elegido.
		Cliente cli = Banco.buscarPorNombre(nomCli);
		Cliente.actualizarValoresCliente(cli, invertido, numAcciones, nomEmp);
		
		MensajeRespuestaCompra.mensajeCompraAcciones(id, nomCli, nomEmp, importe, numAcciones, invertido, devolver);
	}
}
