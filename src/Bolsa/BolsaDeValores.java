package Bolsa;
import java.util.ArrayList;
import java.util.Iterator;

import Bolsa.Empresa;

public class BolsaDeValores {
	/*
	 * Gestiona la cotización de las acciones de las empresas y recibe solicitudes codificadas del bróker.
	 */
	String nombre;
	ArrayList<Empresa> listaEmpresas = new ArrayList<Empresa>();
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Empresa> getListaEmpresas() {
		return listaEmpresas;
	}

	public void setListaEmpresas(ArrayList<Empresa> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
	}
	
	public void nuevaEmpresa (Empresa empresa) {
		this.listaEmpresas.add(empresa);	
	}

	public void borrarEmpresa (Empresa empresa) {
		Iterator<Empresa> emp = this.getListaEmpresas().iterator();
		while (emp.hasNext()) {
			if (emp.equals(empresa)) {
				//this.getCarteraClientes.remove(emp);
				this.getListaEmpresas().remove(emp);
			}
		}
	}
	
	public void mostrarEmpresas(){
		Iterator<Empresa> cli = this.getListaEmpresas().iterator();
		byte indice=1;
		for (Empresa empresa : listaEmpresas) {
			System.out.println(indice + ")");
			empresa.mostrarEstado();
			indice++;
		}
	}

	public void RealizarCopiaDeSeguridad(){
		//Realizar copia de seguridad del estado de la bolsa en disco, es decir, de TODO el OBJETO "Bolsa".
	}

	public void RestaurarCopiaDeSeguridad(){
		//Restaurar copia de seguridad.
	}

}
