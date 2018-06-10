package Bolsa;
import java.util.ArrayList;
import java.util.Iterator;

import Banco.Banco;
import Banco.Cliente;
import Bolsa.Empresa;
import General.Escaner;
import General.Utilidades;
import Mensajes.MensajeActualizacion;

public class BolsaDeValores {
	/*
	 *  Gestiona la cotización de las acciones de las empresas y recibe solicitudes codificadas del bróker.
	 */
	private String nombre;
	private ArrayList<Empresa> listaEmpresas;

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
	
	public void nuevaEmpresa (Empresa empresa) {
		this.listaEmpresas.add(empresa);	
	}

	public void borrarEmpresa (Empresa empresa) {
		if (this.listaEmpresas.contains(empresa)) {
			this.listaEmpresas.remove(empresa);
		}
	}
	
	public void mostrarEmpresas(){
		byte indice=1;
		for (Empresa empresa : this.getListaEmpresas()) {
			System.out.println(indice + ")");
			empresa.mostrarEstado();
			indice++;
		}
	}

	public void realizarCopiaDeSeguridad(){
		//Realizar copia de seguridad del estado de la bolsa en disco, es decir, de TODO el OBJETO "Bolsa".
		System.err.println("Completar método");
	}

	public void restaurarCopiaDeSeguridad(){
		//Restaurar copia de seguridad.
		System.err.println("Completar método");
	}

	public Empresa buscarEmpresaPorNombre(String nomEmp) {
		Empresa emp=null; 
		for (Empresa empresa : this.getListaEmpresas()) {
			if ( nomEmp.equals(empresa.getNombre()) ) {
				emp = empresa;
			}
		}
		
		return emp;
	}

	public void actualizarValores() {
		int incremento = Utilidades.numAleatInt(0,100);
		MensajeActualizacion.actualizarValores();
		for (Empresa empresa : this.getListaEmpresas()) {
			empresa.actualizarV(incremento);

		}
		
	}

	public void mostrarEstado() {
		System.out.println("Nombre: " + this.getNombre());
		this.mostrarEmpresas();
	}

	public Empresa mejorEmpresa() {
		Empresa mejor= null;
		double vAcc=0;
		for (Empresa empresa : this.listaEmpresas) {
			if (empresa.getValorAcciones()<vAcc) {
				vAcc=empresa.getValorAcciones();
				mejor=empresa;
			}
		}
		return mejor;
	}
	
	public void borrarEmpresa() {
		System.out.println("Indique el nombre de la empresa que desea eliminar:");
		System.out.println("<nombre>");
		String peticion = Escaner.leerS();
		this.procesarBorrarEmpresa(peticion);
	}

	private void procesarBorrarEmpresa(String nombre) {
		try {
			Empresa e = this.buscarEmpresaPorNombre(nombre);
			if (this.existeEmpresa(nombre)) {
				this.borrarEmpresa(e);
				System.out.println("Solicitud procesada correctamente.");
			} else {
				System.err.println("Error, el cliente no existía.");
			}
		} catch (Exception e) {
			System.err.println("Error: la solicitud no se ha procesado.");
			System.err.println("¿Desea volver a intentarlo? 0-SI, 1-NO");
			int i = Escaner.leer();
			if (i==0) {
				this.borrarEmpresa();
			}
		}
		
	}

	private boolean existeEmpresa(String nombre) {
		Empresa emp = this.buscarEmpresaPorNombre(nombre);
		if (emp!=null) {
			return true;
		} else {
			return false;
		}
	}


	public void nuevaEmp() {
		System.out.println("Indique los datos de la nueva empresa con el siguiente formato:");
		System.out.println("<nombre>|<valor acciones>");
		String peticion = Escaner.leerS();
		this.procesarAltaEmpresa(peticion);
		
	}
	
	private void procesarAltaEmpresa(String p) {
		try {
			String[] corte = p.split("|");
			String nombre = corte[0];
			double valAcciones = Double.parseDouble(corte[1]);
			Empresa e = new Empresa(nombre, valAcciones);
			if (this.existeEmpresa(nombre)) {
				System.err.println("Error, la empresa ya existe.");
			} else {
				this.nuevaEmpresa(e);
			}
		} catch (Exception e) {
			System.err.println("Error: la solicitud no se ha procesado.");
			System.err.println("¿Desea volver a intentarlo? 0-SI, 1-NO");
			int i = Escaner.leer();
			if (i==0) {
				this.nuevaEmp();
			}
		}
	}

}
