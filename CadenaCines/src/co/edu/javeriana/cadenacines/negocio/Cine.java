package co.edu.javeriana.cadenacines.negocio;

import java.util.ArrayList;
import java.util.List;

public class Cine {
	
	private static long CONSECUTIVO = 0;
	private long id;
	private String sala;
	private long capacidad;
	private CentroComercial centro;
	private List<Funcion> funciones;
	private List<Silla> sillas;
	
	public Cine(String sala, long capacidad, CentroComercial centro) {
		
		
		CONSECUTIVO++;
		this.id = CONSECUTIVO;
		this.sala = sala;
		this.capacidad = capacidad;
		this.funciones = new ArrayList<Funcion>();
		this.sillas = new ArrayList<Silla>();
		this.centro = centro;
	}

	@Override
	public String toString() {
		return String.format("%s-8(id) %s-3 - capacidad \n", this.id,this.capacidad);
	}
	public void agregarSillas(Silla silla){
		this.sillas.add(silla);
	}
	public void agragarFuncion(Funcion funcion){
		this.funciones.add(funcion);
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
