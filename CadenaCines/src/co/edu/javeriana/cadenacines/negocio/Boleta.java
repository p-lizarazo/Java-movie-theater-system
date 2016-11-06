package co.edu.javeriana.cadenacines.negocio;

import java.io.Serializable;

/**
	 * Clase para el manejo de las boletas del sistema
	 * 
	 * @author Santiago Lizarazo
	 * @author Juan Orozco
	 *
	 */

public class Boleta implements Comparable<Boleta>,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean comprada = false;
	private Cliente client;
	private Silla sillas;
	private Funcion funcion;
	
	

	public Boleta(Cliente client, Silla sillas,Funcion funcion) {
		this.comprada = true;
		this.client = client;
		this.sillas = sillas;
		this.funcion=funcion;
	}




	@Override
	public String toString() {
		return "Boleta:" + sillas.toStringTipo() + "	" + funcion.getCine().getSala() + "	" + funcion.getCine().getCentro().getNombre() + "	" 
				+ "\n	" + "FUNCION: "+funcion.toStringSCPel() +"\n	PELICULA:	" + funcion.getPelicula().toStringSD();
	}
	

	public Silla getSillas() {
		return sillas;
	}


	public void setSillas(Silla sillas) {
		this.sillas = sillas;
	}


	public boolean isComprada() {
		return comprada;
	}


	public void setComprada(boolean comprada) {
		this.comprada = comprada;
	}


	public Cliente getClient() {
		return client;
	}
	


	public void setClient(Cliente client) {
		this.client = client;
	}
	
	public Funcion getFuncion() {
		return funcion;
	}


	/**
	 * {@inheritDoc}
	 */

	@Override
	public int compareTo(Boleta o) {
		// TODO Auto-generated method stub
		return (int) (funcion.getId()-o.getFuncion().getId());
	}
	

}
