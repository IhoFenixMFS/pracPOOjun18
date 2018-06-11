package General;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import Banco.Banco;
import Banco.Cliente;
import Banco.ClientePremium;
import Banco.GestorDeInversiones;
import Banco.PaqueteDeAcciones;
import Bolsa.BolsaDeValores;
import Bolsa.Empresa;

public class Simulador {
	
	BolsaDeValores bolsa;
	Banco banco;
	GestorDeInversiones broker;
	
	Cliente cliente1, cliente2,cliente3;

	ArrayList <PaqueteDeAcciones> cartera1 = new ArrayList<PaqueteDeAcciones>();
	ArrayList <PaqueteDeAcciones> cartera2 = new ArrayList<PaqueteDeAcciones>();
	ArrayList <PaqueteDeAcciones> cartera3 = new ArrayList<PaqueteDeAcciones>();
	
	Empresa empresa1, empresa2, empresa3;
	
	public void CrearObjetosDePruebas() 
	{
		//Asignar valores a las empresas
			empresa1 = new Empresa("Empresa1",25.00,22.50,10);
			empresa2 = new Empresa("Empresa2",10.00,11.50,-1.5);
			empresa3 = new Empresa("Empresa3",10.25,20.50,50);

		//Asignar valores a las carteras
			PaqueteDeAcciones p1= new PaqueteDeAcciones("Empresa1", 2, 5.20);
			PaqueteDeAcciones p2= new PaqueteDeAcciones("Empresa2", 7, 12.50);
			PaqueteDeAcciones p3= new PaqueteDeAcciones("Empresa3", 5, 3.45);
			PaqueteDeAcciones p4= new PaqueteDeAcciones("Empresa4", 3, 1.80);
			
			cartera1.add(p1);
			cartera2.add(p2);
			cartera2.add(p3);
			cartera2.add(p4);
			cartera3.add(p4);
	
		//Crear Broker
			broker = new GestorDeInversiones("Broker1", "01234567I");

		//Asignar valores a los clientes
			cliente1 = new Cliente("Cliente1", "00000000A", 1500);
			cliente2 = new Cliente("Cliente2", "11111111B", 12500, cartera2);
			cliente3 = new Cliente();
			cliente3.clone(cliente2);
			cliente3.setCarteraDeAcciones(cartera3);
	}
	
	private void CrearBasePruebas() {
		ArrayList<Empresa>listaEmp= new ArrayList<Empresa>();
		listaEmp.add(empresa1);
		listaEmp.add(empresa2);
		listaEmp.add(empresa3);
		bolsa = new BolsaDeValores("Bolsa única", listaEmp);
		
		ArrayList<Cliente> listaCli = new ArrayList<Cliente>();
		listaCli.add(cliente1);
		listaCli.add(cliente2);
		listaCli.add(cliente3);

		banco = new Banco("Banco", broker, listaCli);
	}
	
	public void simular() {
		Integer teclado;		
		try {
			CrearObjetosDePruebas();
			CrearBasePruebas();
			do {
				InterfazDeUsuario.menu();
				System.out.println();
				teclado = Escaner.leer();
				InterfazDeUsuario.seleccion(bolsa, banco, teclado);
			} while (teclado!=0);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error, la aplicación se cerrará");
			System.err.println("Puede volver a abrirla y esperar que el fallo no continúe.");
			System.err.println(":)");
		}
	}
}
