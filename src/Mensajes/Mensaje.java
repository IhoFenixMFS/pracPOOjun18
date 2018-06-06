package Mensajes;
import General.Escaner;

public class Mensaje {
	/*
	* Implementar clase de captura de errores.
	*/
	
	static void error() throws Exception {
        System.out.println( "Se ha producido el siguiente error, disculpe las molestias:" );
        throw new Exception();
    }
}
