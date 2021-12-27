package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import modelo.Menu;

public class Main {

	public static void main(String[] args) {
		
		Almacen almacen = null;
		// Gestión del fichero coches.dat		
		File fichero = new File ("coches.dat");

		// Lógica que controla la creación o importación de datos al almacén.

		// Si el fichero no existe, creamos un almacen.
		if (!fichero.exists()) {
			System.out.println("No existe ningún almacén creado....");
			System.out.println("	Creando almacén nuevo....");
			System.out.println("Almacén creado.");
			almacen = new Almacen();
			
		// Si el fichero existe, importamos sus datos y los pasamos al almacen.	
		} else {

			try (FileInputStream fis = new FileInputStream(fichero); ObjectInputStream ois = new ObjectInputStream(fis)){
				
				System.out.println("Importando datos del almacén.....");
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