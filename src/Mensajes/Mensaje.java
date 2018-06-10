package Mensajes;

import Banco.Banco;
import Bolsa.BolsaDeValores;

public class Mensaje {
	
	public static void errorMensaje(){
        System.out.println( "Formato de peticion incorrecta." );
    }

	public static void error() {
        System.out.println( "Se ha producido un error, disculpe las molestias:" );
    }
	
	public static void almacenarSolicitud(BolsaDeValores bolsa, Banco banco) {
		
	}
}
