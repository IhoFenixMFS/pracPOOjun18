package Mensajes;

public class MensajeRespuestaVenta extends MensajeVenta{
	public static void mensajeVentaAcciones(int id, String nomCli, String nomEmp, double beneficio,
		int acciones, double saldoFinal)  throws Exception{

		System.out.println(id+"|"+nomCli+"|"+nomEmp+"|"+acciones+"|false|"+beneficio+"|"+saldoFinal);
	}
	
	public static void errorVentaAcciones(){
		System.out.println("Se ha producido un error y no se ha llevado a cabo la venta, diculpe las molestias");
	}
}
