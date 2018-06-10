package Mensajes;

import Banco.Banco;
import Bolsa.BolsaDeValores;
import General.Escaner;
import General.Utilidades;

public class MensajeVenta extends Mensaje{
	public void RealizarPeticion()  throws Exception{
		//añadir un elemento con id 2*** al arrayList de mensajes
		System.err.println("Completar método");
	}

	public static String ventaAcciones (BolsaDeValores bolsa, Banco banco) {
		System.out.println("Ha seleccionado Vender acciones.");
		System.out.println("Debe indicar la venta con el siguiente formato:");
		System.out.println("<id peticion>|<nombre cliente>|<nombre empresa>|<numero de acciones a vender>");
		String venta=Escaner.leerS();
		return venta;
	}
	
}
