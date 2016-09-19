/**
 * 
 */
package co.edu.javeriana.cadenacines.negocio;

/**
 * @author Juan Orozco
 * @author Santiago Lizarazo
 *
 */
public interface ICadenaCines {
	
	public void agregarCentroComercial(CentroComercial centroNuevo);
	
	public void agregarCine(Cine cine, CentroComercial centro);
	
	public void agregarPelicula(long codigo, String nombre, String descripcion);
	
	public long agregarFuncionGala(long codigo,long idCine,String fecha,String hora, long tarifa, boolean trajeE);
	
	public long agregarFuncionCorriente(long codigo,long idCine,String fecha,String hora, long tarifa);
	
	public void agregarClienteMiembro(ClienteMiembro nuevo);
	
	public void agregarClienteParticular(Cliente nuevo);
	
	public void comprarBoleta();

}
