package co.edu.javeriana.cadenacines.negocio;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Clase de uso para modelar las sillas 
 * que estan asociadas a determinado cine
 * 
 * @author Santiago Lizarazo
 * @author Juan Orozco
 *
 */

public class Silla implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fila;
	private int numero;
	private String tipo;
	
	
	public Silla(String fila, int numero,String tipo) {
		this.fila = fila;
		this.numero = numero;
		this.tipo = tipo;
		
	
	}


	@Override
	public String toString() {
		return String.format("%-2s %-1d", fila,numero) + " (" + tipo+")";
	}
	
	public String toStringTipo(){
		return fila + "	" + numero + "	" + tipo;
	}


	public String getFila() {
		return fila;
	}
	
	
	/**
	 * 
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * {@inheritDoc}
	 */


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fila == null) ? 0 : fila.hashCode());
		result = prime * result + numero;
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
		Silla other = (Silla) obj;
		if (fila == null) {
			if (other.fila != null)
				return false;
		} else if (!fila.equals(other.fila))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}


	public void setFila(String fila) {
		this.fila = fila;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	
	

}
