package Banco;

import java.util.ArrayList;

import Bolsa.BolsaDeValores;
import Bolsa.Empresa;
import General.Escaner;
import Mensajes.MensajeCompra;
import Mensajes.MensajeVenta;

/**
* BROKER - Consejero
*/
public class GestorDeInversiones extends Persona {
	/*
	 * Es capaz de, a partir de la información de la bolsa,
	 * determinar qué inversión es recomendable (empresa con la mejor variación de precio).
	 */
	ArrayList<String> peticionesC = new ArrayList<String>();
	ArrayList<String> peticionesA = new ArrayList<String>();
	ArrayList<String> peticionesV = new ArrayList<String>();
	
	public ArrayList<String> getPeticionesC() {
		return peticionesC;
	}

	public void setPeticionesC(ArrayList<String> peticiones) {
		this.peticionesC = peticiones;
	}

	public ArrayList<String> getPeticionesV() {
		return peticionesV;
	}

	public void setPeticionesV(ArrayList<String> peticionesV) {
		this.peticionesV = peticionesV;
	}
	
	
	public GestorDeInversiones(String nombre, String dni) {
		super(nombre, dni);
		this.peticionesC = new ArrayList<String>();
		this.peticionesV = new ArrayList<String>();
	}
	
	
	@Override
	public String toString() {
		return "GestorDeInversiones [peticionesC=" + peticionesC + ", peticionesA=" + peticionesA + ", peticionesV="
				+ peticionesV + ", nombre=" + nombre + ", dni=" + dni + "]";
	}

	public String realizarRecomendacion(BolsaDeValores bolsa, Banco banco) {
		System.out.println("Estas son las empresas disponibles: ");
		Empresa emp = bolsa.mejorEmpresa();
		System.out.println();
		String recomendacion = emp.getNombre();
		System.out.println("La mejor empresa para invertir actualmente es: " + emp.getNombre());
		return recomendacion;
	}
	
	public void mostrarCompraP() {
		System.out.println("Las solicitudes de compra pendientes son:");
		int i=1;
		for (String com : peticionesC) {
			System.out.println(i+"- "+com);
		}
	}
	
	public void mostrarVentaP() {
		System.out.println("Las solicitudes de venta pendientes son:");
		int i=1;
		for (String ven : peticionesV) {
			System.out.println(i+"- "+ven);
		}
	}
	
	public void mostrarTodas() {
		this.mostrarCompraP();
		this.mostrarVentaP();
	}

	public void procesarTodas(BolsaDeValores bolsa, Banco banco) {
		this.procesarCompra(bolsa, banco);
		this.procesarVenta(bolsa, banco);
		
	}

	private void procesarVenta(BolsaDeValores bolsa, Banco banco) {
		for (String ven : peticionesV) {
			AgenteDeInversiones.procesarSolicitudVenta(bolsa, banco, ven);
		}
		
	}

	public void procesarCompra(BolsaDeValores bolsa, Banco banco) {
		for (String com : peticionesC) {
			AgenteDeInversiones.procesarSolicitudCompra(bolsa, banco, com);
		}
		
	}

	public void almacenarVenta(BolsaDeValores bolsa, Banco banco) {
		this.peticionesV.add(MensajeVenta.ventaAcciones(bolsa, banco));
	}
	
	public void almacenarCompra(BolsaDeValores bolsa, Banco banco) {
		this.peticionesC.add(MensajeCompra.compraAcciones(bolsa, banco));
	}
}
