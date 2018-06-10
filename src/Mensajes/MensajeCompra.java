package Mensajes;
import General.Escaner;
import General.Utilidades;
import Mensajes.MensajeRespuestaCompra;

import Banco.AgenteDeInversiones;
import Banco.Banco;
import Bolsa.BolsaDeValores;
import Mensajes.Mensaje;

public class MensajeCompra extends Mensaje{
	public void RealizarPeticion() {
		//añadir un elemento con id 1*** al arrayList de mensajes
		System.err.println("Completar método");
	}

	public static String compraAcciones (BolsaDeValores bolsa, Banco banco){
		System.out.println("Ha seleccionado Comprar acciones.");
		System.out.println("Debe indicar la compra con el siguiente formato:");
		System.out.println("<id peticion>|<nombre cliente>|<nombre empresa>|<importe a invertir>");
		String compra=Escaner.leerS();
		return compra;
	}
}
