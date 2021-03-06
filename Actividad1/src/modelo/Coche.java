package modelo;

import java.io.Serializable;

/**
 * Clase que define los atributos y métodos del objeto coche e implementa
 * Serializable.
 * 
 * @since 26.12.2021
 */
public class Coche implements Serializable {

	private static final long serialVersionUID = 7379045101357320838L;
	
	/**
	 * Atributos de los objetos coche
	 */
	private String id, matricula, marca, modelo, color;

	/**
	 * Constructor de la clase coche.
	 * 
	 * @param id        identificador único del coche.
	 * @param matricula matricula del coche.
	 * @param marca     marca del coche.
	 * @param modelo    modelo del coche.
	 * @param color     color del coche.
	 */
	public Coche(String id, String matricula, String marca, String modelo, String color) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
	}

	// Constructor sin parámetros de la clase coche.	 
	public Coche() {
		super();
	}

	// Getter y setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// Sobrescritura del método toString()
	@Override
	public String toString() {
		return "Coche [id=" + id + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color="
				+ color + "]";
	}
}