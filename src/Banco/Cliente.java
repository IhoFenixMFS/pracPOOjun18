package Banco;

public class Cliente extends Persona{
	
	double saldo;
	PaqueteDeAcciones carteraDeAcciones[]=new PaqueteDeAcciones[10];
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public PaqueteDeAcciones[] getCarteraDeAcciones() {
		return carteraDeAcciones;
	}
	public void setCarteraDeAcciones(PaqueteDeAcciones[] carteraDeAcciones) {
		this.carteraDeAcciones = carteraDeAcciones;
	}
		
	
}