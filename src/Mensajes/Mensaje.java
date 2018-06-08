package Mensajes;

import Banco.Banco;
import Bolsa.BolsaDeValores;
import General.Escaner;

public class Mensaje {
	
	public static void errorMensaje(BolsaDeValores bolsa, Banco banco){
        System.out.println( "Formato de peticion incorrecta." );
    }

	public static void error() {
        System.out.println( "Se ha producido un error, disculpe las molestias:" );
        
    }
}
