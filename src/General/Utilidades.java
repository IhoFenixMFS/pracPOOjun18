package General;

public class Utilidades {
	
	/*Generamos un n�mero aleatorio decimal*/
	private double numAleatt(Integer dsd, Integer hst) {
		return (Math.random()*(hst-1)+dsd);
	}
	
	/*Generamos un n�mero aleatorio entero*/
	public int numAleatInt (Integer dsd, Integer hst) {
		return (int)(numAleatInt(dsd, hst));
	}
	
	
}
