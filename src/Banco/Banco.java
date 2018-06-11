package Banco;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import Banco.*;
import General.Escaner;

public class Banco {
	/*
	 * Gestiona los clientes y la relación entre estos y el bróker.
	 */
	
	String nombre;
	GestorDeInversiones broker;
	ArrayList<Cliente> carteraClientes = new ArrayList<Cliente>();
	
	public String getNombre(){
		return nombre;
		/**/
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		/**/
	}

	public GestorDeInversiones getBroker() {
		return broker;
		/**/
	}

	public void setBroker(GestorDeInversiones broker) {
		this.broker = broker;
		/**/
	}

	public ArrayList<Cliente> getCarteraClientes() {
		return carteraClientes;
		/**/
	}

	public void setCarteraClientes(ArrayList<Cliente> carteraClientes) {
		this.carteraClientes = carteraClientes;
		/**/
	}
	
	public void nuevoCliente (Cliente cliente) {
		this.carteraClientes.add(cliente);	
		/**/
	}

	public Banco(String nombre, GestorDeInversiones broker, ArrayList<Cliente> carteraClientes) {
		super();
		this.nombre = nombre;
		this.broker = broker;
		this.carteraClientes = carteraClientes;
	}

	@Override
	public String toString() {
		return "Banco [nombre=" + nombre + ", broker=" + broker + ", carteraClientes=" + carteraClientes + "]";
		/**/
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
	
	public void borrarCliente() {
		System.out.println("Indique los siguientes datos del cliente que desea eliminar:");
		System.out.println("<nombre>|<dni>");
		String peticion = Escaner.leerS();
		this.procesarBorrarCliente(peticion);
	}
	
	public void mejorar() {
		System.out.println("Indique los siguientes datos del cliente que desea mejorar:");
		System.out.println("<nombre>|<dni>");
		String peticion = Escaner.leerS();
		this.procesarMejora(peticion);
	}
	
	private void procesarMejora(String p) {
		try {
			String[] corte = p.split("|");
			String nombre = corte[0];
			String dni = corte[1];
			Cliente c = this.buscarClientePorNombre(nombre);
			if (this.existeCliente(nombre, dni)) {
				ClientePremium cp = new ClientePremium();
				cp = ClientePremium.mejorarAPremium(c, this.getBroker(), this);
				System.out.println("Solicitud procesada correctamente.");
			} else {
				System.err.println("Error, el cliente no existía.");
			}
		} catch (Exception e) {
			System.err.println("Error: la solicitud no se ha procesado.");
			System.err.println("¿Desea volver a intentarlo? 0-SI, 1-NO");
			int i = Escaner.leer();
			if (i==0) {
				this.mejorar();
			}
		}
	}
	
	private void procesarBorrarCliente(String p) {
		try {
			String[] corte = p.split("|");
			String nombre = corte[0];
			String dni = corte[1];
			Cliente c = this.buscarClientePorNombre(nombre);
			if (this.existeCliente(nombre, dni)) {
				this.eliminarCliente(c);
				System.out.println("Solicitud procesada correctamente.");
			} else {
				System.err.println("Error, el cliente no existía.");
			}
		} catch (Exception e) {
			System.err.println("Error: la solicitud no se ha procesado.");
			System.err.println("¿Desea volver a intentarlo? 0-SI, 1-NO");
			int i = Escaner.leer();
			if (i==0) {
				this.borrarCliente();
			}
		}
	}

	public void eliminarCliente (Cliente cliente) {
		if (this.carteraClientes.contains(cliente)) {
			this.carteraClientes.remove(cliente);
		}
	}

	public void mostrarClientes () {
		byte indice=1;
		for (Cliente cliente : this.carteraClientes) {
			System.out.println(indice + ")");
			cliente.mostarDatos('b');
			indice++;
		}
	}

	public Cliente buscarClientePorNombre(String nomCli) {
		Cliente cli=null;
		for (Cliente cliente : this.getCarteraClientes()) {
			if ( nomCli==cliente.getNombre() ) {
				cli = cliente;	
			}
		}
		return cli;
	}
	
	public Cliente buscarCliente(Cliente cli) {
		Cliente c = new Cliente();
		if (this.carteraClientes.contains(cli)) {
			int i = this.carteraClientes.indexOf(cli);
			c = this.carteraClientes.get(i);
		}
		return c;
	}
																									
	public void mostrarDatos () {
		System.out.println("Nombre : " + this.getNombre());
		this.mostrarClientes();
	}

	public void anadirCliente() {
		System.out.println("Indique los datos del nuevo cliente con el siguiente formato:");
		System.out.println("<nombre>|<dni>|<saldo>");
		String peticion = Escaner.leerS();
		this.procesarAltaCliente(peticion);
	}

	private void procesarAltaCliente(String p) {
		try {
			String r = "\\|";
			String[] corte = p.split(r);
			String nombre = corte[0];
			String dni = corte[1];
			double saldo = Double.parseDouble(corte[2]);
			Cliente c = new Cliente(nombre, dni, saldo);
			if (this.getCarteraClientes().contains(c)) {
				System.err.println("Error, el cliente ya existe.");
			} else {
				this.nuevoCliente(c);
			}
		} catch (Exception e) {
			System.err.println("Error: la solicitud no se ha procesado.");
			System.err.println("¿Desea volver a intentarlo? 0-SI, 1-NO");
			int i = Escaner.leer();
			if (i==0) {
				this.anadirCliente();
			}
		}
	}

	private boolean existeCliente(String nombre, String dni) {
		Cliente cli = this.buscarClientePorNombre(nombre);
		
		if (cli.getDni().equals(dni)) {
			return true;
		} else {
			return false;
		}
	}

	public void realizarCopiaDeSeguridad(){
		try {
			 ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream("banco.dat") );
	            escribiendoFichero.writeObject(this.toString());
	            escribiendoFichero.close();
		} catch (Exception e) {
			System.err.println("Se ha producido un error, disculpe las molestias.");
		}
	}

	public Banco restaurarCopiaDeSeguridad(){
		Banco b = this;
		try {
			ObjectInputStream leyendoFichero = new ObjectInputStream( 
            new FileInputStream("objetos.dat") );
            b = ( Banco )leyendoFichero.readObject();
            leyendoFichero.close();
		} catch (Exception e) {
			System.err.println("Se ha producido un error, disculpe las molestias.");
		}
		return b;
	}

}
