package co.edu.javeriana.cadenacines.negocio;

import java.util.ArrayList;
import java.util.List;

public class CentroComercial {
	
	private String nombre;
	private List<Cine> cines;
	
	public CentroComercial(String nombre) {
		this.nombre = nombre;
		this.cines = new ArrayList<Cine>();
	}

	@Override
	public String toString() {
		return "CentroComercial [nombre=" + nombre + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cine> getCines() {
		return cines;
	}

	public void setCines(List<Cine> cines) {
		this.cines = cines;
	}
	
	
	

}
