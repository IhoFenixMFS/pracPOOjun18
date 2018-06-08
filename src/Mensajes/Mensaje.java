package Mensajes;
import java.util.ArrayList;

import General.Escaner;

public class Mensaje {
	/*
	 * Implementar clase de captura de errores.
	 * Hacer un ArrayList<String> de peticiones
	*/
	ArrayList<String> peticiones = new ArrayList<String>();
	
	/*public Mensaje(ArrayList<String> peticiones) {
		super();
		this.peticiones = peticiones;
	}*/

	public ArrayList<String> getPeticiones() {
		return peticiones;
	}

	public void setPeticiones(ArrayList<String> peticiones) {
		this.peticiones = peticiones;
	}

	public static void errorMensaje() throws Exception {
        System.out.println( "Formato de petición incurrecto." );
    }

	static void error() throws Exception {
        System.out.println( "Se ha producido el siguiente error, disculpe las molestias:" );
        throw new Exception();
    }
}
