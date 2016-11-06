package co.edu.javeriana.cadenacines.negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de uso para el manejo de los centrosComerciales
 * en el sistema
 * 
 * @author Santiago Lizarazo
 * @author Juan Orozco
 *
 */
public class CentroComercial implements Comparable<CentroComercial>,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private List<Cine> cines;
	
	public CentroComercial(String nombre) {
		this.nombre = nombre;
		this.cines = new ArrayList<Cine>();
	}

	@Override
	public String toString() {
		return String.format("%-2s \n", nombre);
	}
	
	/**
	 * {@inheritDoc}
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		CentroComercial other = (CentroComercial) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Cine> getCines() {
		return (ArrayList<Cine>) cines;
	}

	public void setCines(ArrayList<Cine> cines) {
		this.cines = cines;
	}
	
	/**
	 * Busca una Cine por codigo
	 * se recorre cada Cine asociada a los cines del centro buscando si su codigo es igual
	 * al parametro que se recibe, si es asi se retorna el Cine
	 * 
	 * @param codigo
	 * @return cine que coincida con el codigo recibido o -null si no se encontro
	 */
	
	public Cine buscarCine(long id){
		for(Cine cine : this.getCines()){
			if(cine.getId()==id)
				return cine;
		}
		return null;
	}
	
	public void agregarCines(Cine cine){
		this.cines.add(cine);
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public int compareTo(CentroComercial arg0) {
		// TODO Auto-generated method stub
		return this.nombre.compareTo(arg0.nombre);
	}
	

}
