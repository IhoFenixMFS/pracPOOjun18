package Mensajes;

import General.Escaner;
import General.Utilidades;

public class MensajeVenta extends Mensaje{
	public void RealizarPeticion()  throws Exception{
		//añadir un elemento con id 2*** al arrayList de mensajes
		System.err.println("Completar método");
	}

	public static void ventaAcciones () throws Exception{
		System.out.println("Ha seleccionado Vender acciones.");
		System.out.println("Debe indicar la venta con el siguiente formato:");
		System.out.println("<id peticion>|<nombre cliente>|<nombre empresa>|<numero de acciones a vender>");
		String venta=Escaner.leerS();
		Utilidades.almacenarSolicitud(venta);
	}
	
}
