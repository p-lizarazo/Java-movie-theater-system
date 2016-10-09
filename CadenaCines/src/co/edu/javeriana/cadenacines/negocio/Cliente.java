package co.edu.javeriana.cadenacines.negocio;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de uso para modelar los clientes del sistema
 * 
 * @author Juan Orozco
 * @author Santiago Lizarazo
 *
 */


public abstract class Cliente {
	
	private static int CONSECUTIVO = 0;
	private long id;
	private String nombre;
	private String email;
	private List<Boleta> boletas;
	
	
	
	public Cliente(String nombre, String email) {
		CONSECUTIVO++;
		this.id = CONSECUTIVO;
		this.nombre = nombre;
		this.email = email;
		this.boletas = new ArrayList<Boleta>();
	}

	public String getNombre() {
		return nombre;
	}
	
	public void agregarBoleta(Boleta bol){
		this.boletas.add(bol);
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
	
	public abstract long valorBoleta();

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}
	
	/**
	 * {@inheritDoc}
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	// Metodos sobreescritos para poder comparar los correos de los clientes y no existan repetidos al agregar
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	}

}