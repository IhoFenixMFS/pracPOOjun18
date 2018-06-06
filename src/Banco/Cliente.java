package Banco;
import java.util.ArrayList;

import Banco.PaqueteDeAcciones;

public class Cliente extends Persona{

	double saldo;
	ArrayList <PaqueteDeAcciones> carteraDeAcciones = new ArrayList<PaqueteDeAcciones>();
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public ArrayList<PaqueteDeAcciones> getCarteraDeAcciones() {
		return carteraDeAcciones;
	}

	public void setCarteraDeAcciones(ArrayList<PaqueteDeAcciones> carteraDeAcciones) {
		this.carteraDeAcciones = carteraDeAcciones;
	}
	
	public Cliente(String nombre, String dni) {
		super(nombre, dni);
		// TODO Auto-generated constructor stub
	}
	
	public Cliente (String nombre, String dni, double saldo) {
		super(nombre,dni);
        this.saldo = saldo;
    }

    public void mostrarAcciones(ArrayList<PaqueteDeAcciones> carteraDeAcciones) {
    	if (carteraDeAcciones.isEmpty()) {
    		System.out.println("El cliente aún no posee cartera de acciones.");
    	} else {
    		byte indice=1;
    		for (PaqueteDeAcciones acciones: carteraDeAcciones) {
    			System.out.println(indice + ")");
    			acciones.mostrarDatos();
    		}	
    	/*
    		Iterator <PaqueteDeAcciones> acciones = carteraDeAcciones.iterator();
    		while (acciones.hasNext()) {
    			acciones.mostrarDatos();
    		}
    	*/
    	}
    }
    public void mostarDatos(char c) {
		System.out.println("----------------------------------------------");
    	System.out.println("Datos del cliente:");
    	System.out.println("   Nombre: " + this.getNombre());
    	System.out.println("   DNI: " + this.getDni());
    	System.out.println("   Saldo: " + this.getSaldo());
    	switch (c){
    		case 'b':
    			double totalP = 0;
    			for (PaqueteDeAcciones acc: carteraDeAcciones) {
    				totalP+=acc.getTotalPaquete();
    			}
    			System.out.println("   Valor paquete: " + totalP);
    		break;
    		default:
    			mostrarAcciones(this.getCarteraDeAcciones());
    	}
		System.out.println("----------------------------------------------");
    }
}

