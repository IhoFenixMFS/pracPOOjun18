package Banco;
import Banco.PaqueteDeAcciones;

public class Cliente extends Persona{

	double saldo;
	PaqueteDeAcciones carteraDeAcciones[] = new PaqueteDeAcciones[10];
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public PaqueteDeAcciones[] getCarteraDeAcciones() {
		return carteraDeAcciones;
	}

	public void setCarteraDeAcciones(PaqueteDeAcciones[] carteraDeAcciones) {
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

    public Cliente (String nombre, String dni, double saldo, PaqueteDeAcciones carteraDeAcciones[]) {
		super(nombre,dni);
        this.saldo = saldo;
        this.carteraDeAcciones = carteraDeAcciones;
    }

    public void mostarDatos() {
		System.out.println("----------------------------------------------");
    	System.out.println("Datos del cliente:");
    	System.out.println("   Nombre: " + getNombre());
    	System.out.println("   DNI: " + getDni());
    	System.out.println("   Saldo: " + getSaldo());
    	try {
    		System.out.println("- Cartera:");
    		for (byte i = 0; i < carteraDeAcciones.length; i++ ) {
    			carteraDeAcciones[i].mostrarDatos();
	
    		}
    	}
    	catch (Exception e) {
    		System.out.println("El cliente aún no posee cartera de acciones.");
    	}
		System.out.println("----------------------------------------------");
    }
}

