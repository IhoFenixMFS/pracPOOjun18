package Banco;
import Banco.AgenteDeInversiones;
public class Banco {
	/*
	 * Gestiona los clientes y la relación entre estos y el bróker.
	 */
	String nombre;
	AgenteDeInversiones broker;
	ArrayList<Cliente> carteraClientes = new ArrayList<Cliente>;

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

	public void borrarCliente (Cliente clilente) {
		Iterator<Cliente> cli = this.getCarteraClientes.iterator();
		while (cli.hasNext()) {
			if (cli.equals(cliente)) {
				//this.getCarteraClientes.remove(cli);
				remove(cli);
			}
		}
	}

	public void mostrarClientes () {
		Iterator<Cliente> cli = this.getCarteraClientes.iterator();
		byte indice=1;
		for (Cliente cli : carteraClientes) {
			System.out.println(indice + ")");
			cli.mostrarDatos('b');
		}
	}

	public void RealizarCopiaDeSeguridad(){
		//Realizar copia de seguridad de los clientes del banco en disco, es decir, de TODO el OBJETO "Banco".
	}

	public void RestaurarCopiaDeSeguridad(){
		//Restaurar copia de seguridad.
	}

}
