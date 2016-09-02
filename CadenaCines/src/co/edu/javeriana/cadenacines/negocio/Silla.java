package co.edu.javeriana.cadenacines.negocio;

public class Silla {
	
	private String fila;
	private int numero;
	private Boleta boleta;
	
	
	public Silla(String fila, int numero, Boleta boleta) {
		this.fila = fila;
		this.numero = numero;
		this.boleta = boleta;
	}


	@Override
	public String toString() {
		return "Silla [fila=" + fila + ", numero=" + numero + ", boleta=" + boleta + "]";
	}


	public String getFila() {
		return fila;
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


	public Boleta getBoleta() {
		return boleta;
	}


	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}
	
	
	
	

}
