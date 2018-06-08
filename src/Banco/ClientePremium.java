package Banco;
import java.util.ArrayList;
import java.util.List;

import Banco.Cliente;

public class ClientePremium extends Cliente {
	boolean catPremium;
	GestorDeInversiones broker;

	public GestorDeInversiones getBroker() {
		return broker;
	}

	public void setBroker(GestorDeInversiones broker) {
		this.broker = broker;
	}

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

	public ClientePremium (String nombre, String dni, double saldo, GestorDeInversiones broker) {
		super(nombre,dni,saldo);
		this.broker = broker;
        this.catPremium = true;
    }
   
	public ClientePremium (String nombre, String dni, double saldo, GestorDeInversiones broker, boolean catPremium) {
		super(nombre,dni,saldo);
		this.broker = broker;
       this.catPremium = catPremium;
	}
	   
	public ClientePremium (String nombre, String dni, double saldo, GestorDeInversiones broker, ArrayList<PaqueteDeAcciones> carteraDeAcciones) {
		super(nombre,dni, saldo);
		this.broker = broker;
		this.catPremium = true;
		ArrayList<PaqueteDeAcciones> clone = new ArrayList<PaqueteDeAcciones>(carteraDeAcciones.size());
        for (PaqueteDeAcciones item : carteraDeAcciones) {
        	clone.add(item.clone());
        }
        this.carteraDeAcciones=clone;
	}
       
	public ClientePremium (String nombre, String dni, double saldo, GestorDeInversiones broker, ArrayList<PaqueteDeAcciones> carteraDeAcciones, boolean catPremium) {
    	super(nombre,dni, saldo);
		this.broker = broker;
        this.catPremium = catPremium;
        
        ArrayList<PaqueteDeAcciones> clone = new ArrayList<PaqueteDeAcciones>(carteraDeAcciones.size());
        for (PaqueteDeAcciones item : carteraDeAcciones) {
        	clone.add(item.clone());
        }
        this.carteraDeAcciones=clone;
	}
	
	private ClientePremium(Cliente c, GestorDeInversiones broker) {
		super(c.nombre, c.dni, c.saldo);
		this.broker = broker;
        this.catPremium = true;
	}
	public void MejorarAPremium (ClientePremium p, Cliente c, GestorDeInversiones b) {
		p = new ClientePremium(c,b);
		//borrarCliente(c);
	}
	

}