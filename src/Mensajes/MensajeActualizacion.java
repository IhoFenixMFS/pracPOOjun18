package Mensajes;
import General.Utilidades;
import Banco.AgenteDeInversiones;
import General.Escaner;

public class MensajeActualizacion extends Mensaje{
	public void RealizarPeticion()  throws Exception{
		//a�adir un elemento con id 3*** al arrayList de mensajes
		System.err.println("Completar m�todo");
	}
	
	public void ActualizarValores()  throws Exception{
		System.out.println("Se estan actualizando los valores . . .");
		System.out.println("Un momento por favor.");
		
		System.err.println("Completar m�todo");
		AgenteDeInversiones.actualizarValores();
	}
}
