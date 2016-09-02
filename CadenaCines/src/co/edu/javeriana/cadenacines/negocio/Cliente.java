package co.edu.javeriana.cadenacines.negocio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private static int CONSECUTIVO = 0;
	private long id;
	private String nombre;
	private String email;
	private List<Boleta> boletas;
	
	
	public Cliente(String nombre, String email) {
		
		this.id = CONSECUTIVO;
		CONSECUTIVO++;
		this.nombre = nombre;
		this.email = email;
		this.boletas = new ArrayList<Boleta>();
		
	}


	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Boleta> getBoletas() {
		return boletas;
	}


	public void setBoletas(List<Boleta> boletas) {
		this.boletas = boletas;
	}


	public long getId() {
		return id;
	}

}