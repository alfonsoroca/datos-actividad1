package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import modelo.Coche;

//Clase que define los atributos y métodos del objeto almacen e implementa Serializable.
public class Almacen implements Serializable {

	private static final long serialVersionUID = 2471564759041568181L;

	List<Coche> almacen = new ArrayList<>();

	/**
	 * Método que añade coche al almacén siempre que no existan duplicidades de id o
	 * matrícula.
	 * 
	 * @param coche que se desea añadir al almacén.
	 */
	public void add(Coche coche) {

		boolean cocheRepetido = false;

		// Comprobamos que no exista un coche con el mismo id o matrícula que el que
		// queremos añadir.
		for (Coche c : almacen) {
			if (coche.getId().equalsIgnoreCase(c.getId()) || coche.getMatricula().equalsIgnoreCase(c.getMatricula())) {
				cocheRepetido = true;
			}
		}

		// Lógica para añadir un coche al almacén.
		if (cocheRepetido == false) {
			almacen.add(coche);
			System.out.println("Se ha añadido al almacén el " + coche);
		} else {
			System.out.println("Ya existe un coche con ese id o matrícula en el almacén.");
		}
	}

	/**
	 * Método que elimina coche del almacén por id del coche.
	 * 
	 * @param id del coche que se desea eliminar del almacén.
	 */
	public void delete(String id) {

		Coche cocheEliminar = null;

		// Buscamos el coche con id solicitado en el almacén
		for (Coche c : almacen) {
			if (id.equalsIgnoreCase(c.getId())) {
				cocheEliminar = c;
			}
		}

		// Lógica de eliminación del coche
		if (cocheEliminar != null) {
			almacen.remove(cocheEliminar);
			System.out.println("	Se ha eliminado el " + cocheEliminar);
		} else {
			System.out
					.println("	No se puede eliminar el coche porque no hay en el almacén un coche con el id: " + id);
		}
	}

	/**
	 * Método que obtiene un coche del almacén por id del coche.
	 * 
	 * @param id del coche que se quiere localizar en el almacén,
	 */
	public void getById(String id) {

		boolean cocheExiste = false;
		for (Coche c : almacen) {
			if (id.equalsIgnoreCase(c.getId())) {
				cocheExiste = true;
				System.out.println("	Has solicitado el " + c);
			}
		}
		if (cocheExiste == false) {
			System.out.println("	No existe en el almacén un coche con id: " + id);
		}
	}

	/**
	 * Método que devuelve la lista de coches del almacén.
	 */
	public void lista() {
		if (almacen.isEmpty()) {
			System.out.println("	El almacen de coches está vacío.");
		} else {
			for (Coche c : almacen) {
				System.out.println("	" + c);
			}
			System.out.println("Listado de coches en el almacén finalizado.");
		}
	}
}