package co.edu.javeriana.cadenacines.negocio;
//Puto el que lo lea
import java.util.ArrayList;
import java.util.List;
//WTF
public class Boleta {
	//PERE
	private boolean comprada;
	private Cliente client;
	private List<Silla> sillas;
	
	
	public Boleta(boolean comprada, Cliente client) {
		this.comprada = comprada;
		this.client = client;
		this.sillas = new ArrayList<Silla>();
	}


	@Override
	public String toString() {
		return "Boleta [comprada=" + comprada + ", client=" + client + "]";
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
