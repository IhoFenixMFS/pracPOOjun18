package Banco;
import java.util.ArrayList;
import java.util.List;

import Banco.Cliente;

public class ClientePremium extends Cliente {
	GestorDeInversiones broker;

	public GestorDeInversiones getBroker() {
		return broker;
	}

	public void setBroker(GestorDeInversiones broker) {
		this.broker = broker;
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
    }
   	   	
	public ClientePremium(Cliente c, GestorDeInversiones broker) {
		super(c.nombre, c.dni, c.saldo);
		this.broker = broker;
	}
	public void MejorarAPremium (ClientePremium p, Cliente c, GestorDeInversiones b, Banco ba) {
		p = new ClientePremium(c,b);
				ba.borrarCliente(c);
		ba.carteraClientes.add(p);
	}
	

}