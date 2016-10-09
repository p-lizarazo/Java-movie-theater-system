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
	
	
	

}
