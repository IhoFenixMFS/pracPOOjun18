package Banco;
import java.util.ArrayList;
import java.util.Iterator;

import Banco.AgenteDeInversiones;
import Banco.*;

public class Banco {
	/*
	 * Gestiona los clientes y la relación entre estos y el bróker.
	 */
	String nombre;
	AgenteDeInversiones broker;
	ArrayList<Cliente> carteraClientes = new ArrayList<Cliente>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public AgenteDeInversiones getBroker() {
		return broker;
	}


	public void setBroker(AgenteDeInversiones broker) {
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

	public static Cliente buscarPorNombre(String nomCli) {
		// TODO Auto-generated method stub
    	System.err.println("Completar método");
		return null;
	}

}
