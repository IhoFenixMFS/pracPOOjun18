package Banco;

public class PaqueteDeAcciones {
	/*
	 * Incluye el nombre de la empresa, el número de títulos que posee el cliente
	 * y el precio total del paquete. También, opcionalmente,
	 * puede almacenar el precio original de compra y la variación desde ese momento
	 * del precio de cada título o la rentabilidad total de la inversión que hizo el cliente.
	 */
	private String nombreEmpresa; 
	private Integer numTitulos;
	private double valorTitulo;
	private double totalPaquete;
	
/* Cada paquete de acciones de un cliente es un listado de las distintas acciones que posee.
 * Por cada elemento del paquete se guarda un conjunto de acciones de una empresa.
 * Por ejemplo:
 *
 *	[	nombreEmpresa	|	numTitulos	|	valorTitulo	|	totalPaquete	]
 *	[		Empresa1	|		10		|		 5.20	|		52.00		]
 *	[		Empresa2	|		5		|		 3.70	|		18.50		]
 *	[		Empresa3	|		1		|		10.0	|		10.00		]
 *	[		Empresa4	|		7		|		 2.50	|		17.50		]
 *	[		Empresa5	|		3		|		 1.20	|		 3.60		]
 *
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
		return totalPaquete;
	}

	public void setTotalPaquete(integer numTitulos, double valorTitulo) {
		this.totalPaquete = numTitulos * valorTitulo;
	}

	public void mostarDatos() {
    	System.out.println("   Nombre de la empresa: " + getNombreEmpresa());
    	System.out.println("   Numero de títulos: " + getNumTitulos());
    	System.out.println("   Valor de cada título: " + getValorTitulo());
    	System.out.println("   Total del paquete: " + getTotalPaquete());
    }
	
}
