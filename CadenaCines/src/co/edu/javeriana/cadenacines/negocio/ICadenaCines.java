/**
 * 
 */
package co.edu.javeriana.cadenacines.negocio;

import java.io.Serializable;

/**
 * Interfaz encargada de modelar las principales
 * operaciones del sistema de cines
 * 
 * la interfaz cuenta con los sigiuentes metodos
 * 
 * @author Juan Orozco
 * @author Santiago Lizarazo
 *
 */
public interface ICadenaCines extends Serializable {
	
	//metodo para agregar centros comerciales al sistema
	public void agregarCentroComercial(CentroComercial centroNuevo);
	
	//metodo para agregar cines al sistema, y su centro asociado
	public void agregarCine(Cine cine, CentroComercial centro);
	
	//metodo para agregar peliculas al sistema, tomando como parametros su codigo,nombre,descripcion
	public void agregarPelicula(long codigo, String nombre, String descripcion);
	
	//metodo para agregar una funcion Gala al sistema tomando los parametros requeridos
	public long agregarFuncionGala(long codigo,long idCine,String fecha,String hora, long tarifa, boolean trajeE);
	
	//metodo que agrega una funcion corriente al sistema tomando los parametros necesarios
	public long agregarFuncionCorriente(long codigo,long idCine,String fecha,String hora, long tarifa);
	
	//metodo que agrega un cliente miembro al sistema
	public void agregarClienteMiembro(ClienteMiembro nuevo);
	
	//metodo que agregar un cliente normal al sistema
	public void agregarClienteParticular(Cliente nuevo);
	
	//metodo que tomando los parametros necesario tiene toda la informacion para comprar boletas en el sistema
	public long comprarBoleta(String fila, int numero,Funcion funcion,Cliente cliente);


}
