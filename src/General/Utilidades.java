package General;

import Bolsa.Empresa;
import Bolsa.BolsaDeValores;

public class Utilidades {
	
	/*Generamos un número aleatorio decimal*/
	private double numAleatt(Integer dsd, Integer hst) {
		return (Math.random()*(hst-1)+dsd);
	}
	
	/*Generamos un número aleatorio entero*/
	public int numAleatInt (Integer dsd, Integer hst) {
		return (int)(numAleatInt(dsd, hst));
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
		System.err.println("Completar método");
		return 0;
	}
}
