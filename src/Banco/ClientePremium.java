package Banco;
import java.util.ArrayList;

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

	public ClientePremium (String nombre, String dni, double saldo, String nombreBroker) {
		super(nombre,dni,saldo);
		this.nombreBroker = nombreBroker;
        this.catPremium = true;
    }
   
	public ClientePremium (String nombre, String dni, double saldo, String nombreBroker, boolean catPremium) {
		super(nombre,dni,saldo);
		this.nombreBroker = nombreBroker;
       this.catPremium = catPremium;
	}
	   
	public ClientePremium (String nombre, String dni, double saldo, String nombreBroker, ArrayList<PaqueteDeAcciones> carteraDeAcciones) {
		super(nombre,dni, saldo);
		this.nombreBroker = nombreBroker;
		this.catPremium = true;
	}
       
	public ClientePremium (String nombre, String dni, double saldo, String nombreBroker, ArrayList<PaqueteDeAcciones> carteraDeAcciones, boolean catPremium) {
    	super(nombre,dni, saldo);
		this.nombreBroker = nombreBroker;
        this.catPremium = catPremium;
        //this.carteraDeAcciones=(ArrayList<PaqueteDeAcciones>) carteraDeAcciones.clone();
	}



	

}