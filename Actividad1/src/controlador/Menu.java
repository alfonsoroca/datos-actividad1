package controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import modelo.Almacen;
import modelo.Coche;

/**
 * Clase que define los atributos y métodos del objeto menu.
 * @author jalfonso
 * @since 26.12.2021
 */
public class Menu{		

	public Menu(Almacen almacen) {
				
		Scanner sc = new Scanner(System.in);
		String opcion = "";
		
		while (!opcion.equalsIgnoreCase("5")) {

			// Opciones del menú
			System.out.println("\n***************************************");
			System.out.println("---------Almacén concesionario---------");
			System.out.println("***************************************");
			System.out.println("	1. Añadir nuevo coche");
			System.out.println("	2. Borrar coche por id");
			System.out.println("	3. Consultar coche por id");
			System.out.println("	4. Listado de coches");
			System.out.println("	5. Terminar programa");
			System.out.println("	6. Exportar coches a archivo de texto\n");
			System.out.println("Elija una opción del 1 al 6 -> ");

			// Lectura de la elección del usuario			
			opcion = sc.nextLine();

			// Gestión de la elección del usuario en base a los requerimientos
			switch (opcion) {
			case "1":

				System.out.println("Vas a añadir un nuevo coche al almacen...");
				Coche coche = new Coche();
				System.out.println("Introduce el id del coche...");
				coche.setId(sc.nextLine());
				System.out.println("Introduce la matrícula del coche...");
				coche.setMatricula(sc.nextLine());
				System.out.println("Introduce la marca del coche...");
				coche.setMarca(sc.nextLine());
				System.out.println("Introduce el modelo del coche...");
				coche.setModelo(sc.nextLine());
				System.out.println("Introduce el color del coche...");
				coche.setColor(sc.nextLine());
				almacen.add(coche);
				break;

			case "2":

				System.out.println("Introduce el id del coche que quieres eliminar...");
				almacen.delete(sc.nextLine());
				break;

			case "3":
				
				System.out.println("Introduce el id del coche que quieres obtener...");
				almacen.getById(sc.nextLine());
				break;

			case "4":				
				System.out.println("Listado de coches en el almacén...");
				almacen.lista();
				break;
				
			case "5":				
				System.out.println("Grabando datos y saliendo....");
				
				// Proceso de persistencia de datos.
				File fichero = new File("coches.dat");
				try (FileOutputStream fos = new FileOutputStream(fichero);
				ObjectOutputStream oos = new ObjectOutputStream(fos);){
					
					oos.writeObject(almacen);
					System.out.println("Datos grabados....");
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// Cierre del scanner
				sc.close();
				
				System.out.println("Aplicación cerrada---------------");
				System.exit(0);

			case "6":				
				System.out.println("Exportando coches a fichero de texto \"coches.txt\"...");
				almacen.export();				
				break;
				
			default:
				System.out.println("Capullín, debes introducir un número del 1 al 6.");				
			}
		}		
	}
}