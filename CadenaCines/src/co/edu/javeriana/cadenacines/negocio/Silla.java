package co.edu.javeriana.cadenacines.negocio;

/**
 * Clase de uso para modelar las sillas 
 * que estan asociadas a determinado cine
 * 
 * @author Santiago Lizarazo
 * @author Juan Orozco
 *
 */

public class Silla {
	
	private String fila;
	private int numero;
	private boolean primera;
	
	
	public Silla(String fila, int numero,boolean primera) {
		this.fila = fila;
		this.numero = numero;
		this.primera = primera;
		
	
	}


	@Override
	public String toString() {
		return String.format("%-2s  %-1d", fila,numero);
	}


	public String getFila() {
		return fila;
	}
	
	
	

	/**
	 * @return the primera
	 */
	public boolean isPrimera() {
		return primera;
	}


	/**
	 * @param primera the primera to set
	 */
	public void setPrimera(boolean primera) {
		this.primera = primera;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fila == null) ? 0 : fila.hashCode());
		result = prime * result + numero;
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
