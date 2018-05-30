package General;

import java.util.Scanner;

public class Escaner {
	
	private static int numero;
	
	public static int leer() {
		Scanner reader = new Scanner(System.in);
		numero = reader.nextInt();
		return numero;
	}
	
}
