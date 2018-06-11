package General;

import Bolsa.Empresa;
import Mensajes.Mensaje;
import Mensajes.MensajeRespuestaCompra;
import Banco.Banco;
import Bolsa.BolsaDeValores;

public class Utilidades {
	
	/*Generamos un número aleatorio decimal*/
	private static double numAleatt(Integer dsd, Integer hst) {
		return (Math.random()*(hst-1)+dsd);
		/**/
	}
	
	/*Generamos un número aleatorio entero*/
	public static int numAleatInt (Integer dsd, Integer hst) {
		int num = (int)(numAleatInt(dsd, hst));
		if (positivo()) {
			return num;
		} else {
			return -num;
		}
	}
	
	private static boolean positivo() {
		int p = (int) numAleatt(0,1);
		if (p==0) {
			return true;
		} else {
			return false;
		}
	}
	
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
		double invertido = importe - calcularImporteDevolver(empresa, importe);
		return invertido;
	}

	public static double calcularBeneficio(Empresa empresa, int acciones){
		double beneficio = acciones * empresa.getValorAcciones();
		return beneficio;
	}

	private static int primerNumero(int num){
		int numero=num;
		while (numero>10){
			numero/=10;
		}
		return numero;
	}
}