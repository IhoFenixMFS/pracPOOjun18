package Bolsa;

public class Empresa {
	/*
	 * Mantiene la información de las acciones: valor, valor anterior e incremento.
	 */
	private String nombre;
	private double valorAcciones;
	private double valorPrevio;
	private double incremento;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getValorAcciones() {
		return valorAcciones;
	}
	public void setValorAcciones(double valorAcciones) {
		this.valorAcciones = valorAcciones;
	}
	public double getValorPrevio() {
		return valorPrevio;
	}
	public void setValorPrevio(double valorPrevio) {
		this.valorPrevio = valorPrevio;
	}
	public double getIncremento() {
		return incremento;
	}
	public void setIncremento(double incremento) {
		this.incremento = incremento;
	}
	
	public Empresa(String nombre, double valorAcciones, double valorPrevio, double incremento) {
		super();
		this.nombre = nombre;
		this.valorAcciones = valorAcciones;
		this.valorPrevio = valorPrevio;
		this.incremento = incremento;
	}

	public void mostrarEstado(){
    	System.out.println("Estado de la empresa " + this.getNombre());
    	System.out.println("   Valor actual: " + this.getValorAcciones());
    	System.out.println("   Variación: " + this.getIncremento());
		System.out.println("----------------------------------------------");
	}
	
}
