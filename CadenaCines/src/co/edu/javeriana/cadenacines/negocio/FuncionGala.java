package co.edu.javeriana.cadenacines.negocio;

import java.time.LocalDateTime;

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
	
	

}
