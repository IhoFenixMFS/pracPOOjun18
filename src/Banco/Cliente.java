package Banco;

public class Cliente extends Persona{
	
	Double saldo;
	PaqueteDeAcciones carteraDeAcciones[]=new PaqueteDeAcciones[10];
	
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public PaqueteDeAcciones[] getCarteraDeAcciones() {
		return carteraDeAcciones;
	}
	public void setCarteraDeAcciones(PaqueteDeAcciones[] carteraDeAcciones) {
		this.carteraDeAcciones = carteraDeAcciones;
	}
		
	
}