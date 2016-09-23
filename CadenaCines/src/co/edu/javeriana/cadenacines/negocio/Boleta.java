public esto no sirve{
	gg wtf
}



package co.edu.javeriana.cadenacines.negocio;

	/**
	 * Clase para el manejo de las boletas del sistema
	 * 
	 * @author Santiago Lizarazo
	 * @author Juan Orozco
	 *
	 */

public class Boleta {
	
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
		return "Boleta [comprada=" + comprada + ", client=" + client + "]";
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
	

}
