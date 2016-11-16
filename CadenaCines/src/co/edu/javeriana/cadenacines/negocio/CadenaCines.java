package co.edu.javeriana.cadenacines.negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.time.LocalDateTime;

import co.edu.javeriana.cadenacines.presentacion.Utils;

/**
 * Clase de negocio del sistema
 * encargada de manejar las cadenas de cines
 * con ayuda de la interfaz ICadenaCines
 * 
 * @author Juan Orozco
 * @author Santiago Lizarazo
 *
 */

public class CadenaCines implements ICadenaCines {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private List<CentroComercial> centros;
	private Map<Long,Pelicula> peliculas;
	private List<Cliente> clientes;
	public CadenaCines(String nombre) {
		this.nombre = nombre;
		this.centros = new ArrayList<CentroComercial>();
		this.peliculas = new HashMap<Long,Pelicula>();
		this.clientes = new ArrayList<Cliente>();
	}

	@Override
	public String toString() {
		return String.format("%-5s \n", nombre);
	}
	
	

	

	

	/**
	 * @return the peliculas
	 */
	public Map<Long, Pelicula> getPeliculas() {
		return peliculas;
	}

	/**
	 * @param peliculas the peliculas to set
	 */
	public void setPeliculas(Map<Long, Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
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
	 * se toma la clave y se le busca la clave asociada una pelicula
	 * si no esta se devuelve null
	 * 
	 * @param codigo
	 * @return Pelicula que coincida con el codigo recibido o -1 si no se encontro
	 */
	
	public Pelicula buscarPelicula(Long codigo){
		return peliculas.get(codigo);
		
	}
	
	/**
	 * Busca un Cine por codigo
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
	 * Busca un cliente por codigo
	 * recorre la lista de clientes del sistema
	 * y si encuentra el cliente con el id que entra
	 * como parametro se devuelve el cliene
	 * 
	 * @param id
	 * @return Cliente asociado al id indicado, o null si no está
	 */
	

	public Cliente buscarCliente(long id){
		for(Cliente comp : clientes){
			if(comp.getId()==id){
				return comp;
			}
		}
		return null;
	}
	
	/**
	 * Recorre la lista de peliculas del sistema en busca
	 * de las funciones asociadas, y si el id de alguna funcion
	 * coincide con el id ingresado se devuelve la funcion
	 * 
	 * @param peliId
	 * @return Funcion con id que se recibe , o null si no se encuentra
	 */
	
	public Funcion buscarFuncion(long peliId){
		Funcion funcion;
		for(Entry<Long, Pelicula> peli:peliculas.entrySet()){
			funcion=peli.getValue().buscarFuncion(peliId);
			if(funcion!=null){
				return funcion;
			};
		}
		return null;
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	

	@Override
	public void agregarCentroComercial(CentroComercial centroNuevo) {
		this.centros.add(centroNuevo);
	

	/**
	 * {@inheritDoc}
	 */
		
	}

	@Override
	public void agregarCine(Cine nuevo, CentroComercial centro) {
		centro.agregarCines(nuevo);
		
	}

		
	/**
	 * {@inheritDoc}
	 */	
	
	@Override
	public void agregarPelicula(long codigo, String nombre, String descripcion) {
		Pelicula a = new Pelicula(codigo,nombre,descripcion);
		Long key = codigo;
		this.peliculas.putIfAbsent(key, a);
		
	}
	
	/**
	 * {@inheritDoc}
	 */

	@Override
	public long agregarFuncionGala(long codigo,long idCine,String fecha,String hora, long tarifa, boolean trajeE) {
		Cine a=this.buscarCine(idCine);
		Pelicula b=this.buscarPelicula(codigo);
		List<Silla> sillasCine = (List<Silla>) a.getSillas();
		if(a!=null && b!=null){
			Funcion funcionNueva = a.agregarFuncionGala(tarifa, LocalDateTime.of(Utils.convertirStringFecha(fecha),Utils.convertirStringHora(hora)),b,trajeE);
			for(Silla actual: sillasCine)
			{
				Boleta nuevaBoleta = new Boleta(null, actual, funcionNueva);
				funcionNueva.getBoletas().add(nuevaBoleta);
			}
			return funcionNueva.getId();
		} else {
			return -1;
			//Si retorna -1 significa que no se pudo agregar la funcion
		}
		
	}
	
	/**
	 * {@inheritDoc}
	 */

	@Override
	public long agregarFuncionCorriente(long codigo,long idCine,String fecha,String hora, long tarifa) {
		Cine a=this.buscarCine(idCine);
		Pelicula b=this.buscarPelicula(codigo);
		List<Silla> sillasCine = (List<Silla>) a.getSillas();
		if(a!=null && b!=null){
			Funcion nuevaFuncion = a.agregarFuncionCorriente(tarifa, LocalDateTime.of(Utils.convertirStringFecha(fecha),Utils.convertirStringHora(hora)),b);
			for(Silla actual: sillasCine)
			{
				Boleta nuevaBoleta = new Boleta(null, actual, nuevaFuncion);
				nuevaFuncion.getBoletas().add(nuevaBoleta);
			}
			return nuevaFuncion.getId();
		} else {
			return -1;
			//Si retorna -1 significa que no se pudo agregar la funcion
		}
		
	}

	/**
	 * {@inheritDoc}
	 */

	@Override
	public void agregarClienteMiembro(ClienteMiembro nuevo) {
		this.clientes.add(nuevo);
		
		
	}
	
	/**
	 * {@inheritDoc}
	 */

	@Override
	public void agregarClienteParticular(Cliente nuevo) {
		this.clientes.add(nuevo);
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	

	@Override
	public long comprarBoleta(String fila, int numero, Funcion funcion, Cliente cliente) {
		Silla a=funcion.getCine().buscarSilla(fila, numero);
		if(a!=null){
				funcion.agregarBoleta(cliente, a, fila, numero);
				if(a.getTipo().equals(TipoSilla.PRIMERA)){
					return (long) (funcion.calcularValorBoleta()+funcion.calcularValorBoleta()*0.3);
				} else{
					return funcion.calcularValorBoleta();
				}
		}
		
		return 0;
	}
	
	public  Map<Long,Pelicula> mostrarPeliculasSD(ICadenaCines miCine){
		Map<Long,Pelicula> pelis = new TreeMap<Long,Pelicula>();
		pelis.putAll(((CadenaCines) miCine).getPeliculas());
		return pelis;
		
	}
	
	public boolean buscarNombreSala(String nombreSala, List<Cine> nuevosCines)
	{
		boolean estado = false;
		for(Cine actual: nuevosCines)
		{
			if(actual.getSala().equalsIgnoreCase(nombreSala))
			{
				estado = true;
			}
		}
	
		return estado;
	}
	
	public boolean buscarCentro(CentroComercial centroNuevo)
	{
		boolean estado = false;
		List<CentroComercial> centrosComerciales = (List<CentroComercial>) this.getCentros();
		String nombreCentro = centroNuevo.getNombre();
		for(CentroComercial actual: centrosComerciales)
		{
			if(actual.getNombre().equalsIgnoreCase(nombreCentro))
			{
				estado = true;
			}
		}
		return estado;
	}
	
	public boolean buscarCliente(String nombre)
	{
		boolean estado = false;
		List<Cliente> clientes = (List<Cliente>) this.getClientes();
		for(Cliente actual: clientes)
		{
			if(actual.getNombre().equalsIgnoreCase(nombre))
			{
				estado = true;
			}
		}
		return estado;
	}
	
	public boolean buscarPelicula(String nombre)
	{
		boolean estado = false;
		Map<Long, Pelicula> peliculas = this.getPeliculas();
		for(Pelicula actual: peliculas.values())
		{
			if(actual.getNombre().equalsIgnoreCase(nombre))
			{
				estado = true;
			}
		}
		return estado;	
	}
	
}
