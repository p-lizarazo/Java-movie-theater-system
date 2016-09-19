package co.edu.javeriana.cadenacines.negocio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase de uso para el manejo de Cines
 * 
 * @author Santiago Lizarazo
 * @author Juan Orozco
 *
 */

public class Cine implements Comparable<Cine>  {
	
	private static Long CONSECUTIVO = 0L;
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
		return String.format("(%-1d) %-2s - capacidad %-1s ", id,sala,capacidad);
	}
	
	public String toStringSD() {
		return String.format("%-5d  %-1s  %-1s", id,sala,this.getCentro());
	}
	
	
	/**
	 * {@inheritDoc}
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sala == null) ? 0 : sala.hashCode());
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
		Cine other = (Cine) obj;
		if (sala == null) {
			if (other.sala != null)
				return false;
		} else if (!sala.equals(other.sala))
			return false;
		return true;
	}

	public Collection<Silla> getSillas() {
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
	
	public CentroComercial getCentro() {
		return centro;
	}
	
	/**
	 * Toma un objeto de tipo Silla
	 * y lo agrega a la lista de sillas del Cine
	 * 
	 * @param silla
	 */
	
	public void agregarSillas(Silla silla){
		this.sillas.add(silla);
	}
	
	/**
	 * Recibe los datos necesarios para agregar una funcion
	 * y la agrega a la lista de funciones de una pelicula recibida
	 * 
	 * @param tarifa
	 * @param fecha
	 * @param pelicula
	 * @return Id de la funcion creada
	 */
	public long agregarFuncionCorriente(long tarifa, LocalDateTime fecha,Pelicula pelicula){
		
		Funcion a=new Funcion(tarifa,fecha,this,pelicula);
		pelicula.agregarFuncion(a);
		this.funciones.add(a);
		return a.getId();
		
	}
	
	public long agregarFuncionGala(long tarifa, LocalDateTime fecha,Pelicula pelicula,boolean trajeE){
		
		Funcion a=new FuncionGala(tarifa,fecha,this,pelicula,trajeE);
		pelicula.agregarFuncion(a);
		this.funciones.add(a);
		return a.getId();
		
	}

	@Override
	public int compareTo(Cine o) {
		// TODO Auto-generated method stub
		return this.sala.compareTo(o.sala);
	}

	
	
	

}