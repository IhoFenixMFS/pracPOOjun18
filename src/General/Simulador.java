package General;

import java.util.ArrayList;

import Banco.Cliente;
import Banco.ClientePremium;
import Banco.PaqueteDeAcciones;
import Bolsa.Empresa;

public class Simulador {

	Cliente cliente1;
	Cliente cliente2;
	Cliente cliente3;
	Cliente cliente4;
	Cliente cliente5;

	ArrayList <PaqueteDeAcciones> cartera1 = new ArrayList<PaqueteDeAcciones>();
	ArrayList <PaqueteDeAcciones> cartera2 = new ArrayList<PaqueteDeAcciones>();
	ArrayList <PaqueteDeAcciones> cartera3 = new ArrayList<PaqueteDeAcciones>();
	ArrayList <PaqueteDeAcciones> cartera4 = new ArrayList<PaqueteDeAcciones>();
	
	Empresa empresa1;
	Empresa empresa2;
	Empresa empresa3;
	Empresa empresa4;
	Empresa empresa5;
	
	public void CrearObjetosDePruebas() 
	{
	//Asignar valores a las empresas
		empresa1 = new Empresa("Empresa1",25.00,22.50,10);
		empresa2 = new Empresa("Empresa2",10.00,11.50,-1.5);
		empresa3 = new Empresa("Empresa3",10.25,20.50,50);
		empresa4 = new Empresa("Empresa4",6.00,6.00,00);
/*
	//Asignar valores a las carteras
		cartera1[0] = new PaqueteDeAcciones("Empresa1", 2, 5.20);
		cartera2[0] = new PaqueteDeAcciones("Empresa2", 5, 5.20);
		cartera2[1] = new PaqueteDeAcciones("Empresa3", 10, 2.00);
		cartera2[2] = new PaqueteDeAcciones("Empresa4", 3, 3.70);
		cartera3[0] = new PaqueteDeAcciones("Empresa4", 2, 12.50);

	//Asignar valores a los clientes
		cliente1 = new Cliente("Cliente1", "00000000A", 1500);
		cliente2 = new Cliente("Cliente2", "11111111B", 12500, cartera2);
		cliente3 = new ClientePremium("Cliente3", "22222222C", 123500, cartera1);
		cliente4 = new Cliente("Cliente4", "33333333D");
		cliente5 = cliente3;
		cliente5.setCarteraDeAcciones(cartera3);
*/
	}
	
	public void simular() {
		Integer teclado;		
		try {
			CrearObjetosDePruebas();
			do {

				InterfazDeUsuario.menu();
				System.out.println();
				teclado = Escaner.leer();
				InterfazDeUsuario.seleccion(teclado);
			} while (teclado!=0);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error, la aplicación se cerrará");
			System.err.println("Puede volver a abrirla y esperar que el fallo no continúe.");
			System.err.println(":)");
		}
	}
	
}
