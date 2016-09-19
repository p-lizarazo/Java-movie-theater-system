package co.edu.javeriana.cadenacines.negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.time.LocalDateTime;

import co.edu.javeriana.cadenacines.presentacion.Utils;

/**
 * Clase de negocio del sistema
 * encargada de manejar todo el sistema en conjunto
 * 
 * @author Juan Orozco
 * @author Santiago Lizarazo
 *
 */

public class CadenaCines implements ICadenaCines {


	private String nombre;
	private List<CentroComercial> centros;
	private Collection<Pelicula> peliculas;
	private Collection<Cliente> clientes;
	// Cambio de List a Collection para crear un HashSet
	
	public CadenaCines(String nombre) {
		this.nombre = nombre;
		this.centros = new ArrayList<CentroComercial>();
		this.peliculas = new HashSet<Pelicula>();
		this.clientes = new HashSet<Cliente>();
	}

	@Override
	public String toString() {
		return String.format("%-5s \n", nombre);
	}
	
	

	public Collection<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Collection<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public Collection<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<CentroComercial> getCentros() {
		return centros;
	}

	public void setCentros(ArrayList<CentroComercial> centros) {
		this.centros = centros;
	}
	
	
	
	
	
	
	
	/**
	 * Busca una pelicula por codigo
	 * se recorre cada pelicula buscando si su codigo es igual
	 * al parametro que se recibe, si es asi se retorna la pelicula
	 * 
	 * @param codigo
	 * @return Pelicula que coincida con el codigo recibido o -1 si no se encontro
	 */
	
	public Pelicula buscarPelicula(long codigo){
		for(Pelicula pelicula: this.getPeliculas()){
			if(codigo==pelicula.getCodigo()){
				return pelicula;
			}
		}
		return null;
	}
	
	/**
	 * Busca una Cine por codigo
	 * se recorre cada Cine asociada a un centro buscando si su codigo es igual
	 * al parametro que se recibe, si es asi se retorna el Cine
	 * 
	 * @param codigo
	 * @return cine que coincida con el codigo recibido o -null si no se encontro
	 */
	
	public Cine buscarCine(long idCine){
		for(CentroComercial centroComercial: this.getCentros()){
			if(centroComercial.buscarCine(idCine)!=null){
				return centroComercial.buscarCine(idCine);
			}
		}
		return null;
	}
	
	/**
	 * Agrega un nuevo centro comercial a la lista de centros de la cadena
	 * toma un objeto de tipo centrocomercial y lo añade
	 * 
	 * @param centroNuevo
	 */
	

	@Override
	public void agregarCentroComercial(CentroComercial centroNuevo) {
		this.centros.add(centroNuevo);
		
	}

	@Override
	public void agregarCine(Cine nuevo, CentroComercial centro) {
		centro.agregarCines(nuevo);
		
	}

		
		/**
		 * Agrega una nueva pelicula a la lista de peliculas en la cadena de cine
		 * 
		 * @param codigo
		 * @param nombre
		 * @param descripcion
		 */	
		
	
	@Override
	public void agregarPelicula(long codigo, String nombre, String descripcion) {
		Pelicula a = new Pelicula(codigo,nombre,descripcion);
		this.peliculas.add(a);
		
	}

	@Override
	public long agregarFuncionGala(long codigo,long idCine,String fecha,String hora, long tarifa, boolean trajeE) {
		Cine a=this.buscarCine(idCine);
		Pelicula b=this.buscarPelicula(codigo);
		if(a!=null && b!=null){
			return a.agregarFuncionGala(tarifa, LocalDateTime.of(Utils.convertirStringFecha(fecha),Utils.convertirStringHora(hora)),b,trajeE);
		} else {
			return -1;
			//Si retorna -1 significa que no se pudo agregar la funcion
		}
		
	}
	
	/**
	 * Agrega una nueva funcion corriente asociada a un cine y una pelicula
	 * se verifica que el cine y la pelicula existan, si es así
	 * se añade la funcion.
	 * 
	 * 
	 * @param codigo
	 * @param idCine
	 * @param fecha
	 * @param hora
	 * @param tarifa
	 * @return id, que se le asigna a la funcion
	 */
	

	@Override
	public long agregarFuncionCorriente(long codigo,long idCine,String fecha,String hora, long tarifa) {
		Cine a=this.buscarCine(idCine);
		Pelicula b=this.buscarPelicula(codigo);
		if(a!=null && b!=null){
			return a.agregarFuncionCorriente(tarifa, LocalDateTime.of(Utils.convertirStringFecha(fecha),Utils.convertirStringHora(hora)),b);
		} else {
			return -1;
			//Si retorna -1 significa que no se pudo agregar la funcion
		}
		
	}
	
	/**
	 * Agrega un nuevo clienteMiembro a la lista de clientes en la cadena de cine
	 * 
	 * @param ClienteMiembro nuevo
	 * 
	 */
	

	@Override
	public void agregarClienteMiembro(ClienteMiembro nuevo) {
		this.clientes.add(nuevo);
		
		
	}
	
	/**
	 * Agrega un nuevo cliente particular a la lista de clientes en la cadena de cine
	 * 
	 * @param Cliente nuevo
	 * 
	 */

	@Override
	public void agregarClienteParticular(Cliente nuevo) {
		this.clientes.add(nuevo);
		
	}

	@Override
	public void comprarBoleta() {
		// TODO Auto-generated method stub
		
	}
	
}
