package co.edu.javeriana.cadenacines.negocio;

import java.io.Serializable;

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
	private TipoSilla tipo;

	public Silla(String fila, int numero,TipoSilla tipo) {
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
	

	/**
	 * @return the tipo
	 */
	public TipoSilla getTipo() {
		return tipo;
	}


	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoSilla tipo) {
		this.tipo = tipo;
	}
	

}
