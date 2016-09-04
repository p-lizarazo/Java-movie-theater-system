package co.edu.javeriana.cadenacines.negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;



public class CadenaCines {


	private String nombre;
	private List<CentroComercial> centros;
	private Collection<Pelicula> peliculas;
	private Collection<Cliente> clientes;
	// Cambio de List a Collection para crear un HashSet
	
	public CadenaCines(String nombre) {
		this.nombre = nombre;
		this.centros = new ArrayList<CentroComercial>();
		this.peliculas = new HashSet<Pelicula>();
		this.clientes = new HashSet<Cliente>();
	}

	@Override
	public String toString() {
		return "CadenaCines [nombre=" + nombre + "]";
	}
	public void agregarCentro(CentroComercial centroC){
		centros.add(centroC);
	}
	

	public Collection<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Collection<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
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
	
	
	public void agregarClientes(String nombre, String email){
		
		Cliente a =new Cliente (nombre,email);
		this.clientes.add(a);
		
	}
	
	public void agregarPeliculas(long codigo, String nombre, String descripcion){
		
		Pelicula a = new Pelicula(codigo,nombre,descripcion);
		this.peliculas.add(a);
		
	}
	
	

}
