package Banco;
import Bolsa.Empresa;
import Banco.*;
import Mensajes.*;
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
		compraAcciones();
	}
	
	public void VenderAccion(){
		System.out.println("Vender acción. . .");
		venderAcciones();
	}

	public void ActualizarBolsa(){
		System.out.println("Actualizar valores. . .");
		ActualizarValores();
	}
	
	private boolean procesarSolicitudCompra(String solicitud) {
		byte cant=0;
		for(i=0; i<texto.length; i++){
      		if (numeros.indexOf(texto.charAt(i),0)!="|"){
         		cant++;
			}
		}
		if (cant!=3) {
			return false;
		} else {
			try {
				String[] corte = string.split("|");
				String parte1 = corte[0];
				String nomCli = corte[1];
				String nomEmp = corte[2];
				String parte4 = corte[3];

				int id = Integer.parseInt(parte1);
				double importe = Double.parseDouble(parte1);
				
				//buscar entre todos los clientes de la bolsa el elegido.
				Cliente cli = buscarPorNombre(nomCli);
				
				realizarCompra(id, nomCli, nomEmp, importe);


				actualizarCliente(cli);

				return true;
			}
			catch (Exception) {
				return false;
			}

		}
	}

	private void realizarPeticion(int id, String nomCli, String nomEmp, double importe){
		//Recibimos el objeto Empresa al que deseamos comprarle acciones.
		Empresa empresa = buscarNombre(nomEmpresa);
		//almacenamos en numAcciones el valor maximo de acciones completas que se pueden comprar.
		int numAcciones = (int) calcularMaxAcciones(empresa, importe);
		//calculamos lo que ha invertido.
		double invertido = numAcciones * empresa.getValorAcciones();
		//calculamos el dinero que le sobra.
		double devolver = importe - invertido;

		mensajeCompraAcciones(id, nomCli, nomEmp, importe, numAcciones, invertido, devolver);
	}
}
