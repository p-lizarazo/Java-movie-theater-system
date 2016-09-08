package co.edu.javeriana.cadenacines.negocio;

import java.util.HashSet;
import java.util.Set;

public class CentroComercial {
	
	private String nombre;
	private Set<Cine> cines;
	
	public CentroComercial(String nombre) {
		this.nombre = nombre;
		this.cines = new HashSet<Cine>();
	}

	@Override
	public String toString() {
		return String.format("CENTRO COMERCIAL %s-3  \n", this.nombre);
	}
	
	public void agregarCines(Cine cine){
		this.cines.add(cine);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Cine> getCines() {
		return cines;
	}

	public void setCines(Set<Cine> cines) {
		this.cines = cines;
	}
	
	
	

}
