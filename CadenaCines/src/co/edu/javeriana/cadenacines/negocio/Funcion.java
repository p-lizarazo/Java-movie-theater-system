package co.edu.javeriana.cadenacines.negocio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Funcion {
	
	private static long CONSECUTIVO;
	private long id;
	private long tarifa;
	private LocalDateTime fecha;
	private List<Boleta> boletas;
	
	public Funcion(long id, long tarifa, LocalDateTime fecha) {
		this.id = CONSECUTIVO;
		CONSECUTIVO++;
		this.tarifa = tarifa;
		this.fecha = fecha;
		this.boletas = new ArrayList<Boleta>();
	
	}

	@Override
	public String toString() {
		return "Funcion [id=" + id + ", tarifa=" + tarifa + ", fecha=" + fecha + "]";
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

	public List<Boleta> getFuncionesPeliculas() {
		return funcionesPeliculas;
	}

	public void setFuncionesPeliculas(List<Boleta> funcionesPeliculas) {
		this.funcionesPeliculas = funcionesPeliculas;
	}

	public long getId() {
		return id;
	}
	
	
	

}
