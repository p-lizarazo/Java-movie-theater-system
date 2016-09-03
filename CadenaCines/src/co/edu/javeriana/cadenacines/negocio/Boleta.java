package co.edu.javeriana.cadenacines.negocio;

//Prueba
public class Boleta {
	
	private boolean comprada;
	private Cliente client;
	private Silla sillas;
	

	public Boleta(boolean comprada, Cliente client, Silla sillas) {
		this.comprada = comprada;
		this.client = client;
		this.sillas = sillas;
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
	

}