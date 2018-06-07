package Banco;
import java.util.ArrayList;

import java.util.Iterator;


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
    		System.out.println("El cliente a�n no posee cartera de acciones.");
    	} else {
    		byte indice=1;
    		for (PaqueteDeAcciones acciones: carteraDeAcciones) {
    			System.out.println(indice + ")");
    			acciones.mostrarDatos();
    		}	
    	
    		Iterator <PaqueteDeAcciones> acciones = carteraDeAcciones.iterator();
    		while (acciones.hasNext()) {
    			((PaqueteDeAcciones) acciones).mostrarDatos();
    		}
    	
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
    			for (PaqueteDeAcciones acc: this.carteraDeAcciones) {
    				totalP+=acc.getTotalPaquete();
    			}
    			System.out.println("   Valor paquete: " + totalP);
    		break;
    		default:
    			mostrarAcciones(this.getCarteraDeAcciones());
    	}
		System.out.println("----------------------------------------------");
    }
    
    public static void actualizarValoresCliente(double invertido,int numAcciones,Empresa empresa) {
        //PaqueteDeAcciones(String nombreEmpresa, Integer numTitulos, double valorTitulo)
        boolean encontrado=false;
        ArrayList<PaqueteDeAcciones> cartera = this.carteraDeAcciones, 
        String nomEmp = empresa.getNombre();
        double valor = empresa.getValorAcciones();
        
        //recorremos la lista de paquetes de acciones en busca de acciones previas de la misma empresa
        Iterator<PaqueteDeAcciones> paq = cartera.iterator();
        while (paq.hasNext()){
            String nombre = paq.getNombreEmpresa();
            if (nombre.equals(nomEmp)) {
                paq.actualizarPaquete(numAcciones, valor);
                encontrado = true;
            }
        }
        
        /*
         * Si no hab�a acciones previas, se crea un nuevo paquete con las acciones compradas
         * se controla que se est�n comprando acciones,
          * ya que si se venden el numero de acciones que se pasa es negativo.
        */
        if (!encontrado && numAcciones > 0) {
            this.carteraDeAcciones.add(PaqueteDeAcciones(nomEmp, numAcciones, valor));
        }

        /*
         * El importe en compra se pasa en negativo, por lo que se restar�a al saldo del cliente,
         * y en venta se pasa en positivo, por lo que se sumar�a.
        */
        double saldoFinal = this.getSaldo + invertido;
    	this.setSaldo(saldoFinal)
    }


}

