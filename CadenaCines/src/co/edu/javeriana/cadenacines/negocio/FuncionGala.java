package co.edu.javeriana.cadenacines.negocio;

import java.time.LocalDateTime;

/**
 * Clase concreta que hereda de Funcion para el manejo
 * de las funciones de Gala dentro del sistema
 * 
 * @author Juan Orozco
 * @author Santiago Lizarazo
 *
 */

public class FuncionGala extends Funcion {
	
	private boolean trajeEtiqueta ;

	public FuncionGala(long tarifa, LocalDateTime fecha, Cine cine, Pelicula pelicula,boolean trajeEtiqueta) {
		super(tarifa, fecha, cine, pelicula);
		this.trajeEtiqueta = trajeEtiqueta;
		
	}

	/**
	 * @return the trajeEtiqueta
	 */
	public boolean isTrajeEtiqueta() {
		return trajeEtiqueta;
	}

	/**
	 * @param trajeEtiqueta the trajeEtiqueta to set
	 */
	public void setTrajeEtiqueta(boolean trajeEtiqueta) {
		this.trajeEtiqueta = trajeEtiqueta;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (this.trajeEtiqueta){
			return super.toStringSC() + "gala  si";
		}
		return super.toStringSC() + "gala  no";
		
	}

	@Override
	public long calcularValorBoleta() {
		// TODO Auto-generated method stub
		
		
		return tarifa*10;
	}
	
	public String toStringSCPel() {
		if(trajeEtiqueta){
			return super.toStringSCPel() + "gala(etiqueta)";
		} else {
			return super.toStringSCPel() + "gala";
		}
		
		
	}
	

}
