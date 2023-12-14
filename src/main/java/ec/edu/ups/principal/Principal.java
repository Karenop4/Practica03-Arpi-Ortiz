package ec.edu.ups.principal;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opc;//opción menu
		
		do {
			System.out.println("            MENU");
			System.out.println("============================");
			System.out.println("1. Bibliotecas");
			System.out.println("2. Usuarios");
			System.out.println("3. Libros");
			System.out.println("4. Préstamos");
			System.out.println("5. Salir");
			System.out.println("============================");
			opc = sc.nextInt();
			
			switch(opc) {
				case 1: //Biblioteca
					
					break;
				case 2: //Usuario
					break;
				case 3: //Libro
					break;
				case 4: //Prestamo
					break;
				case 5:
					System.out.println("Programa terminado");
					break;
				default:
					System.out.println("ERROR!! Elija otra opción");
			}
			
		}while(opc!=5);
		
		
	}

}
