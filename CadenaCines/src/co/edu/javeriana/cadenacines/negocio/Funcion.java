package co.edu.javeriana.cadenacines.negocio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Funcion {
	
	private static long CONSECUTIVO;
	private long id;
	private long tarifa;
	private LocalDateTime fecha;
	private Cine cine;
	private Pelicula pelicula;
	private List<Boleta> boletas;
	
	public Funcion(long tarifa, LocalDateTime fecha,Cine cine,Pelicula pelicula) {
		this.id = CONSECUTIVO;
		CONSECUTIVO++;
		this.tarifa = tarifa;
		this.fecha = fecha;
		this.cine = cine;
		this.boletas = new ArrayList<Boleta>();
		this.pelicula = pelicula;
	
	}

	@Override
	public String toString() {
		return "Funcion [id=" + id + ", tarifa=" + tarifa + ", fecha=" + fecha + "]";
	}
	
	

	public Cine getCine() {
		return cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public void setBoletas(List<Boleta> boletas) {
		this.boletas = boletas;
	}

	public long getTarifa() {
		return tarifa;
	}

	public void setTarifa(long tarifa) {
		this.tarifa = tarifa;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public List<Boleta> getBoletas() {
		return boletas;
	}

	public void setFuncionesPeliculas(List<Boleta> boletas) {
		this.boletas = boletas;
	}

	public long getId() {
		return id;
	}
	

}