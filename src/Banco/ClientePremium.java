package Banco;
import Banco.Cliente;

public class ClientePremium extends Cliente {
	boolean catPremium;
	String nombreBroker;

	public boolean getCatPremium() {
		return catPremium;
	}

	public void setCatPremium(boolean catPremium) {
		this.catPremium = catPremium;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ClientePremium (String nombre, String dni, double saldo, String nombreB) {
		super(nombre,dni,saldo);
		this.nombreB = nombreB;
        this.catPremium = true;
    }
   
	public ClientePremium (String nombre, String dni, double saldo, String nombreB, boolean catPremium) {
		super(nombre,dni,saldo);
		this.nombreB = nombreB;
       this.catPremium = catPremium;
	}
	   
	public ClientePremium (String nombre, String dni, double saldo, String nombreB, PaqueteDeAcciones carteraDeAcciones[]) {
		super(nombre,dni, saldo, carteraDeAcciones);
		this.nombreB = nombreB;
		this.catPremium = true;
	}
       
	public ClientePremium (String nombre, String dni, double saldo, String nombreB, PaqueteDeAcciones carteraDeAcciones[], boolean catPremium) {
    	super(nombre,dni, saldo, carteraDeAcciones);
		this.nombreB = nombreB;
        this.catPremium = catPremium;
	}

}