package Mensajes;

public class MensajeRespuestaActualizacion extends MensajeActualizacion{

	public static void actualizandoEmpresa(int incremento, String nombre) {
		System.out.println("Las acciones de la empresa \"" + nombre + "\" han subido un " + incremento + "%");
	}
}
