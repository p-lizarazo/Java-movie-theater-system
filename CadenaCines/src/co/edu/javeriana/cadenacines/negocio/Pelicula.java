package co.edu.javeriana.cadenacines.negocio;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	
	private long codigo;
	private String nombre;
	private String descripcion;
	private List<Funcion> funciones;
	
	
	public Pelicula(long codigo, String nombre, String descripcion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.funciones = new ArrayList<Funcion>();
	}


	@Override
	public String toString() {
		return "Pelicula [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}


	public long getCodigo() {
		return codigo;
	}


	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public List<Funcion> getFunciones() {
		return funciones;
	}


	public void setFunciones(List<Funcion> funciones) {
		this.funciones = funciones;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
	

}
