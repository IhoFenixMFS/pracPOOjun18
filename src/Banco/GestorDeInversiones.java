package Banco;

import java.util.ArrayList;

import Bolsa.BolsaDeValores;
import Bolsa.Empresa;
import General.Escaner;

/**
* BROKER - Consejero
*/
public class GestorDeInversiones extends Persona {

	ArrayList<String> peticiones = new ArrayList<String>();
	
	public ArrayList<String> getPeticiones() {
		return peticiones;
	}

	public void setPeticiones(ArrayList<String> peticiones) {
		this.peticiones = peticiones;
	}
	
	public GestorDeInversiones(String nombre, String dni) {
		super(nombre, dni);
	}

	/*
	 * Es capaz de, a partir de la información de la bolsa,
	 * determinar qué inversión es recomendable (empresa con la mejor variación de precio).
	 */
	
	public String realizarRecomendacion(BolsaDeValores bolsa, Banco banco) {
		String recomendacion=" ";
		System.out.println("Estas son las empresas disponibles: ");
		//BolsaDeValores.mostrarEmpresas();
		System.err.println("Completar método.");
		System.out.println("Indique la empresa en la que desea invertir,");
		System.out.println("escribiendo el nombre de la misma:");
		String eleccion = Escaner.leerS();
		Empresa emp ;
		
		return recomendacion;
	}


}
