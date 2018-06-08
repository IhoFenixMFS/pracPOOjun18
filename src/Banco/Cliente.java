package Banco;
import java.util.ArrayList;

import java.util.Iterator;


import Banco.PaqueteDeAcciones;
import Bolsa.Empresa;

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
	
	public Cliente(String nombre, String dni, double saldo, ArrayList<PaqueteDeAcciones> carteraDeAcciones) {
		super(nombre, dni);
		this.carteraDeAcciones = carteraDeAcciones;
		this.saldo = saldo;
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
    
    public void actualizarValoresCliente(double invertido,int numAcciones,Empresa empresa) {
        //PaqueteDeAcciones(String nombreEmpresa, Integer numTitulos, double valorTitulo)
        boolean encontrado=false;
        ArrayList<PaqueteDeAcciones> cartera = this.carteraDeAcciones;
        String nomEmp = empresa.getNombre();
        double valor = empresa.getValorAcciones();
        
        //recorremos la lista de paquetes de acciones en busca de acciones previas de la misma empresa
        Iterator<PaqueteDeAcciones> paq = cartera.iterator();
        while (paq.hasNext()){
            String nombre = ((PaqueteDeAcciones) paq).getNombreEmpresa();
            if (nombre.equals(nomEmp)) {
                ((PaqueteDeAcciones) paq).actualizarPaquete(numAcciones, valor);
                encontrado = true;
            }
        }
        
        /*
         * Si no había acciones previas, se crea un nuevo paquete con las acciones compradas
         * se controla que se estén comprando acciones,
          * ya que si se venden el numero de acciones que se pasa es negativo.
        */
        if (!encontrado && numAcciones > 0) {
        	PaqueteDeAcciones paquete = new PaqueteDeAcciones(nomEmp, numAcciones, valor);
            this.carteraDeAcciones.add(paquete);
        }

        /*
         * El importe en compra se pasa en negativo, por lo que se restaría al saldo del cliente,
         * y en venta se pasa en positivo, por lo que se sumaría.
        */
        double saldoFinal = this.getSaldo() + invertido;
    	this.setSaldo(saldoFinal);
    }

	public void clone(Cliente cliente3) {
		this.saldo = cliente3.saldo;
		
		
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (carteraDeAcciones == null) {
			if (other.carteraDeAcciones != null)
				return false;
		} else if (!carteraDeAcciones.equals(other.carteraDeAcciones))
			return false;
		if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))
			return false;
		return true;
	}


}

