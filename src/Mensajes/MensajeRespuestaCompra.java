package Mensajes;

public class MensajeRespuestaCompra extends MensajeCompra{
	public void mensajeCompraAcciones(int id, String nomCli, String nomEmp, 
		double importe, int numAcciones, double invertido, double devolver)  throws Exception{
		System.out.println(id+"|"+nomCli+"|"+nomEmp+"|"+importe+"|"+numAcciones+"|"+invertido+"|"+devolver);
	}
	public void errorCompraAcciones(){
		System.out.println("Se ha producido un error y no se ha llevado a cabo la compra, diculpe las molestias");
	}

}
