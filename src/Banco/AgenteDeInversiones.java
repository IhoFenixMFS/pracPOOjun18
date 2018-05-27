package Banco;

public class AgenteDeInversiones extends Persona{
	/*
	 * intermediario entre el banco y la bolsa.
	 * Recibe peticiones del banco y las codifica adecuadamente para la bolsa.
	 */
	
	private void procesarSolicitudBroker(Integer opc) {
		// TODO Auto-generated method stub
		switch (opc) {
		case 0:
			System.out.println("comprar acción");
			break;
		case 1:
			System.out.println("vender acción");
			break;
		case 2:
			System.out.println("actualizar valores");
			break;

		default:
			break;
		}
		
		/*
		 * comprar
		 * vender
		 * actualizar
		 */

	}
	
	
}
