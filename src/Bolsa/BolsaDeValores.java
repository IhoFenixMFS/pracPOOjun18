package Bolsa;
import java.util.ArrayList;
import java.util.Iterator;

import Banco.Banco;
import Bolsa.Empresa;

public class BolsaDeValores {
	/*
	 *  Gestiona la cotización de las acciones de las empresas y recibe solicitudes codificadas del bróker.
	 */
	private String nombre;
	private ArrayList<Empresa> listaEmpresas;
	
	/*
	private static BolsaDeValores bolsaUnica;
	private BolsaDeValores() {
		super();
		this.nombre = "Bolsa";
		this.listaEmpresas = new ArrayList<Empresa>();
	}
	
	public static void iniciarBolsaDeValores() {
		bolsaUnica = new BolsaDeValores();
	}
	
	public static BolsaDeValores getBolsaDeValores() {
		if(bolsaUnica == null) {
			System.err.println("La instancia a la que desea acceder se ha corrompido.");
			return null;
		}
		else {
			return bolsaUnica;
		}
	}
	*/

	public String getNombre() {
		return nombre;
	}

	public BolsaDeValores(String nombre, ArrayList<Empresa> listaEmpresas) {
		super();
		this.nombre = nombre;
		this.listaEmpresas = listaEmpresas;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public  ArrayList<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public void setListaEmpresas(ArrayList<Empresa> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
	}
	
	public void nuevaEmpresa (BolsaDeValores bolsa, Banco banco, Empresa empresa) {
		bolsa.listaEmpresas.add(empresa);	
	}

	public void borrarEmpresa (BolsaDeValores bolsa, Banco banco, Empresa empresa) {
		Iterator<Empresa> emp = this.getListaEmpresas().iterator();
		while (emp.hasNext()) {
			if (emp.equals(empresa)) {
				bolsa.getListaEmpresas().remove(emp);
			}
		}
	}
	
	public void mostrarEmpresas(){
		byte indice=1;
		ArrayList<Empresa> listaEmpresas = this.getListaEmpresas();
		for (Empresa empresa : listaEmpresas) {
			System.out.println(indice + ")");
			empresa.mostrarEstado();
			indice++;
		}
	}

	public void RealizarCopiaDeSeguridad(BolsaDeValores bolsa, Banco banco){
		//Realizar copia de seguridad del estado de la bolsa en disco, es decir, de TODO el OBJETO "Bolsa".
		System.err.println("Completar método");
	}

	public void RestaurarCopiaDeSeguridad(BolsaDeValores bolsa, Banco banco){
		//Restaurar copia de seguridad.
		System.err.println("Completar método");
	}

	public Empresa buscarEmpresaPorNombre(String nomEmp) {
		//revisar método
		Empresa emp=null;
		
		ArrayList<Empresa> listaEmpresas = this.getListaEmpresas();
		for (Empresa empresa : listaEmpresas) {
			if ( nomEmp.equals(empresa.getNombre()) ) {
				emp = empresa;
			}
		}
		
		return emp;
	}

	public void ActualizarValores() {
		// TODO Auto-generated method stub
		System.err.println("implementar");
		
	}

}
