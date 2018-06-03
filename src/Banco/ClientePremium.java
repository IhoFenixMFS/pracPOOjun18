package Banco;
import Banco.Cliente;

public class ClientePremium extends Cliente {
	boolean catPremium;

	public boolean getCatPremium() {
		return catPremium;
	}

	public void setCatPremium(boolean catPremium) {
		this.catPremium = catPremium;
	}

	public ClientePremium (String nombre, String dni, double saldo) {
		super(nombre,dni,saldo);
        this.catPremium = true;
    }
   
	public ClientePremium (String nombre, String dni, double saldo, boolean catPremium) {
		super(nombre,dni,saldo);
       this.catPremium = catPremium;
	}
	   
	public ClientePremium (String nombre, String dni, double saldo, PaqueteDeAcciones carteraDeAcciones[]) {
		super(nombre,dni, saldo, carteraDeAcciones);
		this.catPremium = true;
	}
       
	public ClientePremium (String nombre, String dni, double saldo, PaqueteDeAcciones carteraDeAcciones[], boolean catPremium) {
    	super(nombre,dni, saldo, carteraDeAcciones);
           this.catPremium = catPremium;
	}

}