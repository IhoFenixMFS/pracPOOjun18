package General;

import Bolsa.Empresa;
import Bolsa.BolsaDeValores;

public class Utilidades {
//	
	/*Generamos un número aleatorio decimal*/
	private double numAleatt(Integer dsd, Integer hst) {
		return (Math.random()*(hst-1)+dsd);
	}
	
	/*Generamos un número aleatorio entero*/
	public int numAleatInt (Integer dsd, Integer hst) {
		return (int)(numAleatInt(dsd, hst));
	}
//	
	public static int contarCaracter(String texto, char c) {
        int pos, cont = 0;
        pos = texto.indexOf(c);
        while (pos != -1) {
            cont++;           
            pos = texto.indexOf(c, pos + 1);
        }
        return cont;
	}

	public static int calcularMaxAcciones(Empresa empresa, double importe) {
		double valAccion = empresa.getValorAcciones();
		int maxAcc = (int) (importe / valAccion);
		return maxAcc;
	}

	public static double calcularImporteDevolver(Empresa empresa, double importe) {
		double valAccion = empresa.getValorAcciones();
		int maxAcc = calcularMaxAcciones(empresa, importe);
		double devolver = importe - (maxAcc * valAccion);
		return devolver;
	}

	public static double calcularImporteInvertido(Empresa empresa, double importe) {
		double invertido = importe - calculaeImporteDevolver(empresa, importe);
		return invertido;
	}

	public static double calcularBeneficio(Empresa empresa, int acciones){
		double beneficio = acciones * empresa.getValorAcciones();
		return beneficio;
	}

	private int primerNumero(int num){
		int numero=num;
		while (numero>10){
			numero/=numero;
		}
		return ini;
	}

	public static void almacenarSolicitud(String solicitud) {
		int cant= contarCaracter(solicitud, '|');
		try {

			String[] corte = solicitud.split("|");
				String parte1 = corte[0];
				int id = Integer.parseInt(parte1);
				int iniId = primerNumero(id); 
			if (iniId == 1 | iniId == 2) {
				if (cant!=3) {
				Mensaje.errorMensaje();
				} else if (iniId == 1) {
					almacenarSolicitudCompra(id, solicitud);
				} else if (ini==2){

				}
			} else if (iniId==3) {
				
			} 
		} catch (Exception e) {
					// TODO: handle exception
					MensajeRespuestaCompra.errorCompraAcciones();
		}	
	}

	private void almacenarSolicitudCompra(int id, String solicitud){
		try {//<id peticion>|<nombre cliente>|<nombre empresa>|<numero de acciones a vender>
			String[] corte = solicitud.split("|");
			//int ultId = this.getUltId();
			String resto = corte[1]+corte[2]+corte[3];
			//id=(int)....1+ultid;
			
			//realizarPeticionCompra(id, nomCli, nomEmp, acciones);
	    	
		}  catch (Exception e) {
			// TODO: handle exception
			MensajeRespuestaCompra.errorCompraAcciones();
		}
	}

	
}
