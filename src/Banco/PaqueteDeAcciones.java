package Banco;

public class PaqueteDeAcciones {
	/*
	 * incluye el nombre de la empresa, el número de títulos que posee el cliente
	 * y el precio total del paquete. También, opcionalmente,
	 * puede almacenar el precio original de compra y la variación desde ese momento
	 * del precio de cada título o la rentabilidad total de la inversión que hizo el cliente.
	 */
	private String nombreEmpresa; 
	private Integer numTitulos;
	private double valorTitulo;
	private double totalPaquete;
	
/*	Paquete de acciones del Sr. David
 * [	0		1		2		3		...]
 * 		aa		bb		cc		dd		...
 * 		4		4		4		4		...
 * 		10		15		5		12		...
 * 		42		42		42		42		...
 */
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public Integer getNumTitulos() {
		return numTitulos;
	}
	public void setNumTitulos(Integer numTitulos) {
		this.numTitulos = numTitulos;
	}
	public double getValorTitulo() {
		return valorTitulo;
	}
	public void setValorTitulo(double valorTitulo) {
		this.valorTitulo = valorTitulo;
	}
	public double getTotalPaquete() {
		/*
		 * total de la lista de paquetes
		 */
		return totalPaquete;
	}
	public void setTotalPaquete(double totalPaquete) {
		this.totalPaquete = totalPaquete;
	}
	
}
