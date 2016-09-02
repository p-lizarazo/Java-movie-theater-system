package co.edu.javeriana.cadenacines.negocio;

import java.util.ArrayList;
import java.util.List;

public class Cine {
	
	private static long CONSECUTIVO = 0;
	private long id;
	private String sala;
	private long capacidad;
	private List<Funcion> funciones;
	private List<Silla> sillas;
	
	public Cine(long id, String sala, long capacidad) {
		
		this.id = CONSECUTIVO;
		CONSECUTIVO++;
		this.sala = sala;
		this.capacidad = capacidad;
		this.funciones = new ArrayList<Funcion>();
		this.sillas = new ArrayList<Silla>();
	}

	@Override
	public String toString() {
		return "Cine [id=" + id + ", sala=" + sala + ", capacidad=" + capacidad + "]";
	}
	

	public List<Silla> getSillas() {
		return sillas;
	}

	public void setSillas(List<Silla> sillas) {
		this.sillas = sillas;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public long getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(long capacidad) {
		this.capacidad = capacidad;
	}

	public List<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(List<Funcion> funciones) {
		this.funciones = funciones;
	}

	public long getId() {
		return id;
	}
	
	
	
	
	

}
