package Bolsa;

import Mensajes.MensajeRespuestaActualizacion;

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
	
	public Empresa(String nombre, double valorAcciones) {
		super();
		this.nombre = nombre;
		this.valorAcciones = valorAcciones;
		this.valorPrevio = 0;
		this.incremento = 0;
	}

	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", valorAcciones=" + valorAcciones + ", valorPrevio=" + valorPrevio
				+ ", incremento=" + incremento + "]";
	}
	public void mostrarEstado(){
    	System.out.println("Estado de la empresa " + this.getNombre());
    	System.out.println("   Valor actual: " + this.getValorAcciones());
    	System.out.println("   Variación: " + this.getIncremento());
		System.out.println("----------------------------------------------");
	}
	public void actualizarV(int incremento) {
		this.setValorPrevio(this.getValorAcciones());
		this.setIncremento(incremento/100);
		this.setValorAcciones(this.getValorAcciones()*this.getIncremento());
		MensajeRespuestaActualizacion.actualizandoEmpresa(incremento, this.getNombre());
		
	}
	
}
