package co.edu.javeriana.cadenacines.negocio;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

/**
 * Clase concreta que hereda de cliente para modelar clientes miembros
 * en el sistema de cines
 * 
 * @author Juan Orozco
 * @author Santiago Lizarazo
 *
 */
public class ClienteMiembro extends Cliente{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate fechaMembresia;

	public ClienteMiembro(String nombre, String email,LocalDate fecha) {
		super(nombre, email);
		this.fechaMembresia = fecha;
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	@Override
	public String toString() {
		return super.toString() + "	" + "miembro";
	}

	

	/**
	 * @return the fechaMembresia
	 */
	public LocalDate getFechaMembresia() {
		return fechaMembresia;
	}

	/**
	 * @param fechaMembresia the fechaMembresia to set
	 */
	public void setFechaMembresia(LocalDate fechaMembresia) {
		this.fechaMembresia = fechaMembresia;
	}


	/**
	 * Metodo que retorna el valor de la boleta aplicado el descuento del cliente miembro
	 * @param retorno
	 * @return valor de la boleta aplicado el despuento por ser cliente miembro
	 */

	@Override
	public long valorBoletas(long retorno) {
		return (long) (retorno-retorno*0.2);
		// TODO Auto-generated method stub
	}




	@Override
	public String toString8() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d	H:mm");
		// TODO Auto-generated method stub
		return super.toString()+ "	" + super.getEmail() + "  -  " + "miembro desde" + fechaMembresia.format(formatter);
	}
	
	
	
	
	

}
