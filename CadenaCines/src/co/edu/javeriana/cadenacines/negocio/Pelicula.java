package co.edu.javeriana.cadenacines.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de uso para modelar las
 * peliculas del sistema
 * 
 * @author Juan Orozco
 * @author Santiago Lizarazo
 *
 */

public class Pelicula implements Comparable<Pelicula>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String nombre;
	private String descripcion;
	private List<Funcion> funciones;
	
	
	public Pelicula(Long codigo, String nombre, String descripcion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.funciones = new ArrayList<Funcion>();
	}

	/**
	 * por cada funcion revisa si las boletas asociadas
	 * estan compradas o no 
	 * 
	 * @return true si la boleta esta comprada, falso de lo contrario
	 */
	public boolean tieneBoletas(){
		for(Funcion fun : this.getFunciones()){
			for(Boleta boletas : fun.getBoletas()){
				if(boletas.isComprada() == true){
					return false;
				}
			}
			
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("%-1d   %-1s     %-1s", codigo,nombre,descripcion);
	}
	
	public String toStringSD() {
		return String.format("%-5d %-4s", codigo,nombre);
	}


	public long getCodigo() {
		return codigo;
	}


	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public List<Funcion> getFunciones() {
		return funciones;
	}


	public void setFunciones(List<Funcion> funciones) {
		this.funciones = funciones;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
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
		Pelicula other = (Pelicula) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	/**
	 * Toma un objeto de tipo funcion y añade la funcion
	 * a la lista de funciones en la clase peliculas
	 * 
	 * @param funcion
	 */
	
	public void agregarFuncion(Funcion funcion){
		this.funciones.add(funcion);
	}
	
	/**
	 * {@inheritDoc}
	 */

	@Override
	public int compareTo(Pelicula arg0) {
		// TODO Auto-generated method stub
		return this.codigo.compareTo(arg0.codigo);
	}
	
	/**
	 * Recorre la lista de las funciones asociadas
	 * si encuentra la que coincida con el id ingresado se retorna esa funcion
	 * 
	 * @param id
	 * @return funcion asociada al id ingresado, null si no esta
	 */
	
	public Funcion buscarFuncion(long id){
		for(Funcion funcion:funciones){
			if(id==funcion.getId()){
				return funcion;
			}
		}
		return null;
		
	}
	

}
