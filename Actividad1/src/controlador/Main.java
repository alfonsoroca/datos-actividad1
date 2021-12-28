package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import modelo.Almacen;

public class Main {

	public static void main(String[] args) {

		Almacen almacen = null;
		// Gestión del fichero coches.dat
		File fichero = new File("coches.dat");

		System.out.println("Iniciando aplicación....");
		System.out.println("Creando almacén....");
		System.out.println("Almacén creado.");
		almacen = new Almacen();

		// Lógica que importa los datos al almacén cuando existe el fichero coches.dat.
		if (fichero.exists()) {

			try (FileInputStream fis = new FileInputStream(fichero);
					ObjectInputStream ois = new ObjectInputStream(fis)) {

				System.out.println("Importando datos al almacén.....");
				almacen = (Almacen) ois.readObject();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		// Asociamos el almacén al menu.
		Menu menu = new Menu(almacen);
	}
}