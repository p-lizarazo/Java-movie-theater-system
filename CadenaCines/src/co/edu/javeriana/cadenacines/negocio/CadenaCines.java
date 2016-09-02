package co.edu.javeriana.cadenacines.negocio;

import java.util.ArrayList;
import java.util.List;

public class CadenaCines {
	
	private String nombre;
	private List<CentroComercial> centros;
	private List<Pelicula> peliculas;
	private List<Cliente> clientes;
	
	public CadenaCines(String nombre) {
		this.nombre = nombre;
		this.centros = new ArrayList<CentroComercial>();
		this.peliculas = new ArrayList<Pelicula>();
		this.clientes = new ArrayList<Cliente>();
	}

	@Override
	public String toString() {
		return "CadenaCines [nombre=" + nombre + "]";
	}
	

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<CentroComercial> getCentros() {
		return centros;
	}

	public void setCentros(List<CentroComercial> centros) {
		this.centros = centros;
	}
	
	
	
	

}
