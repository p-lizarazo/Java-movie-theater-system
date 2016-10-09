package co.edu.javeriana.cadenacines.negocio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase de uso para modelar la relacion 
 *entre cines y las peliculas que se presentaran en
 *el sistema
 * 
 * @author Juan Orozco
 * @author Santiago Lizarazo
 *
 */


public class Funcion {
	
	private static long CONSECUTIVO = 0;
	private long id;
	private long tarifa;
	private LocalDateTime fecha;
	private Cine cine;
	private Pelicula pelicula;
	private List<Boleta> boletas;
	
	public Funcion(long tarifa, LocalDateTime fecha,Cine cine,Pelicula pelicula) {
		
		CONSECUTIVO++;
		this.id = CONSECUTIVO;
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
	
	public String toStringSC() {
		return ""+id+"  "+fecha+"  "+tarifa+"  "+this.cine.getSala()+"  "+"  "+this.cine.getCentro().getNombre()+" ";
	}
	
	public String toStringSCPel() {
		return "Funcion [id=" + id + ", fecha=" + fecha + ", tarifa=" + tarifa + ", sala=" + this.cine.getSala()   + ", centro=" + 
				this.cine.getCentro().getNombre() + " " + this.pelicula.toStringSD() + "]";
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
	
	public void agregarBoleta(Cliente client, Silla sillas){
		Boleta bol = new Boleta(client,sillas,this);
		this.boletas.add(bol);
		client.getBoletas().add(bol);
	}
	
	

}