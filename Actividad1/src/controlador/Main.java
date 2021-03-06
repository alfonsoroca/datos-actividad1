package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import modelo.Almacen;

/**
 * Clase que contiene el método main, inicializa el almacen y el menu de la
 * aplicación. Además se encarga de importar los datos al almacen desdes el
 * fichero "coches.dat" en el caso de que éste último exista.
 * 
 * @since 26.12.2021
 */
public class Main {

	public static void main(String[] args) {

		Almacen almacen = new Almacen();
		// Gestión del fichero coches.dat
		File fichero = new File("coches.dat");

		System.out.println("Iniciando aplicación....");
		System.out.println("Creando almacén....");
		System.out.println("Almacén creado.");

		// Lógica que importa los datos al almacén cuando existe el fichero coches.dat.
		if (fichero.exists()) {

			try (FileInputStream fis = new FileInputStream(fichero);
					ObjectInputStream ois = new ObjectInputStream(fis)) {

				System.out.println("Importando datos desde el almacén.....");
				almacen = (Almacen) ois.readObject();
				System.out.println("Importación de datos completada.");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		// Asignación del almacen al menu
		new Menu(almacen);
	}
}