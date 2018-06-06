package Mensajes;

public class MensajeRespuestaCompra extends MensajeCompra{
	public void mensajeCompraAcciones(int id, String nomCli, String nomEmp, 
		double importe, int numAcciones, double invertido, double devolver){
		System.out.println(id+"|"+nomCli+"|"+nomEmp+"|"+importe+"|"+numAcciones+"|"+invertido+"|"+devolver);
	}

}
