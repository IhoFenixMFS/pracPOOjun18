package Banco;
import java.util.ArrayList;
import java.util.Iterator;

import Banco.*;

public class Banco {
	/*
	 * Gestiona los clientes y la relación entre estos y el bróker.
	 */
	String nombre;
	GestorDeInversiones broker;
	ArrayList<Cliente> carteraClientes = new ArrayList<Cliente>();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public GestorDeInversiones getBroker() {
		return broker;
	}


	public void setBroker(GestorDeInversiones broker) {
		this.broker = broker;
	}

	public ArrayList<Cliente> getCarteraClientes() {
		return carteraClientes;
	}

	public void setCarteraClientes(ArrayList<Cliente> carteraClientes) {
		this.carteraClientes = carteraClientes;
	}
	
	public void nuevoCliente (Cliente cliente) {
		this.carteraClientes.add(cliente);	
	}

	public Banco(String nombre, GestorDeInversiones broker, ArrayList<Cliente> carteraClientes) {
		super();
		this.nombre = nombre;
		this.broker = broker;
		this.carteraClientes = carteraClientes;
	}
	
	public void borrarCliente (Cliente cliente) {
		Iterator<Cliente> cli = this.carteraClientes.iterator();
		while (cli.hasNext()) {
			if (cli.equals(cliente)) {
				this.carteraClientes.remove(cli);
			}
		}
	}

	public void mostrarClientes () {
		Iterator<Cliente> cli = this.carteraClientes.iterator();
		byte indice=1;
		for (Cliente cliente : carteraClientes) {
			System.out.println(indice + ")");
			cliente.mostarDatos('b');
		}
	}

	public void RealizarCopiaDeSeguridad(){
		//Realizar copia de seguridad de los clientes del banco en disco, es decir, de TODO el OBJETO "Banco".
		System.err.println("Completar método");
	}

	public void RestaurarCopiaDeSeguridad(){
		//Restaurar copia de seguridad.
		System.err.println("Completar método");
	}

	public static Cliente buscarClientePorNombre(String nomCli) {
    	//revisar método
		Cliente cli=null;
		ArrayList<Cliente> listaClientes = null/*this.getCarteraCLientes()*/;
		for (Cliente cliente : listaClientes) {
			if ( nomCli.equals(cliente.getNombre()) ) {
				cli = cliente;	
			}
		}
		return cli;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banco other = (Banco) obj;
		if (broker == null) {
			if (other.broker != null)
				return false;
		} else if (!broker.equals(other.broker))
			return false;
		if (carteraClientes == null) {
			if (other.carteraClientes != null)
				return false;
		} else if (!carteraClientes.equals(other.carteraClientes))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
