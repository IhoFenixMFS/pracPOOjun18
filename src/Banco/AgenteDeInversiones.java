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
			System.out.println("Comprar acción");
			break;
		case 1:
			System.out.println("Vender acción");
			break;
		case 2:
			System.out.println("Actualizar valores");
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
