package General;

public class Simulador {
	
	//aqui se definen algunos clientes y bancos para pruebas
	
	public void simular() {
		// TODO Auto-generated method stub
		Integer teclado;		
		try {
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
