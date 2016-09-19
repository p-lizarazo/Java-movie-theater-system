package co.edu.javeriana.cadenacines.negocio;

import java.time.LocalDate;
public class ClienteMiembro extends Cliente{
	
	
	private LocalDate fechaMembresia;

	public ClienteMiembro(String nombre, String email,LocalDate fecha) {
		super(nombre, email);
		this.fechaMembresia = fecha;
		// TODO Auto-generated constructor stub
	}
	
	
	

	@Override
	public String toString() {
		return "ClienteMiembro [fechaMembresia=" + fechaMembresia + ", toString()=" + super.toString() + "]";
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
	
	
	
	
	

}
