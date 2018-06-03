package Banco;

public class PaqueteDeAcciones {
	

	/*
	 * Incluye el nombre de la empresa, el n�mero de t�tulos que posee el cliente
	 * y el precio total del paquete. Tambi�n, opcionalmente,
	 * puede almacenar el precio original de compra y la variaci�n desde ese momento
	 * del precio de cada t�tulo o la rentabilidad total de la inversi�n que hizo el cliente.
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

	public void setTotalPaquete(Integer numTitulos, double valorTitulo) {
		this.totalPaquete = numTitulos * valorTitulo;
	}

	public void mostrarDatos() {
		System.out.println( "   Nombre de la empresa: " + this.getNombreEmpresa());
		System.out.println("   Numero de t�tulos: " + this.getNumTitulos());
		System.out.println("   Valor de cada t�tulo: " + this.getValorTitulo());
		System.out.println("   Total del paquete: " + this.getTotalPaquete() );
    }
	
	public PaqueteDeAcciones(String nombreEmpresa, Integer numTitulos, double valorTitulo) {
		super();
		this.nombreEmpresa = nombreEmpresa;
		this.numTitulos = numTitulos;
		this.valorTitulo = valorTitulo;
		this.totalPaquete = numTitulos * valorTitulo;
	}
	
}
