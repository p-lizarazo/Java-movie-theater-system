package co.edu.javeriana.cadenacines.negocio;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase abstracta para modelar la relacion 
 *entre cines y las peliculas que se presentaran en
 *el sistema
 * 
 * @author Juan Orozco
 * @author Santiago Lizarazo
 *
 */


public abstract class Funcion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static long CONSECUTIVO = 0;
	public static void setCONSECUTIVO(long cONSECUTIVO) {
		CONSECUTIVO = cONSECUTIVO;
	}

	private long id;
	protected long tarifa;
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

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d	H:mm");
		return ""+id+"	"+fecha.format(formatter) +"	"+tarifa+"	"+this.cine.getSala()+"	"+this.cine.getCentro().getNombre()+"	";
	}
	
	public String toStringSCPel() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d	H:mm");
		return ""+id+"	"+fecha.format(formatter) +"	$"+tarifa+"	";
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
	
	/**
	 * instancia una nueva boleta en el sistema
	 * se le agrega su silla asociada, cliente y funcion
	 * 
	 * @param client
	 * @param sillas
	 */
	
	public void agregarBoleta(Cliente client, Silla sillas, String fila, int numero){
		Boleta bol= buscarBoleta(fila, numero);
		client.getBoletas().add(bol);
		bol.setComprada(false);
	}
	
	public boolean sillaDisponible(Silla a){
		for(Boleta boleta:boletas){
			if(boleta.getSillas().equals(a)){
				return false;
			}
		}
		return true;
	}
	
	public abstract long calcularValorBoleta();
	
	public Boleta buscarBoleta(String fila, int numero)
	{
		Boleta boletaRetornar = null;
		List<Boleta> boletasFuncion = this.getBoletas();
		for(Boleta actual: boletasFuncion)
		{
			if(actual.getSillas().getFila() == fila&& actual.getSillas().getNumero()==numero)
			{
				boletaRetornar = actual;
			}
		}
		return boletaRetornar;
	}

}