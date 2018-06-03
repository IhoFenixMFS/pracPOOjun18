package General;

public class Utilidades {
	
	/*Generamos un número aleatorio decimal*/
	private double numAleatt(Integer dsd, Integer hst) {
		return (Math.random()*(hst-1)+dsd);
	}
	
	/*Generamos un número aleatorio entero*/
	public int numAleatInt (Integer dsd, Integer hst) {
		return (int)(numAleatInt(dsd, hst));
	}
	
	
}
