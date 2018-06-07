package Mensajes;
import General.Escaner;

public class Mensaje {
	/*
	 * Implementar clase de captura de errores.
	 * Hacer un ArrayList<String> de peticiones
	*/
	/* v Revisar v */
	ArrayList<String> peticiones = new ArrayList<String>();

	public ArrayList<String> getPeticiones(){
		return this.peticiones;
	}

	public void setPeticiones(String mensaje){
		this.mensaje=mensaje;
	}
	/* ^ Revisar ^ */
	static void errorMensaje() throws Exception {
        System.out.println( "Formato de petición incurrecto." );
    }

	static void error() throws Exception {
        System.out.println( "Se ha producido el siguiente error, disculpe las molestias:" );
        throw new Exception();
    }
}
