package co.edu.javeriana.cadenacines.negocio;


import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

/**
 * Clase concreta que extiende de Funcion para modelar
 * las funciones corrientes dentro del sitema
 * 
 * @author Santiago Lizarazo
 * @author Juan Orozco
 *
 */

public class FuncionCorriente extends Funcion{

	public FuncionCorriente(long tarifa, LocalDateTime fecha, Cine cine, Pelicula pelicula) {
		super(tarifa, fecha, cine, pelicula);
		// TODO Auto-generated constructor stub
	}

	@Override
	public long calcularValorBoleta() {
		// TODO Auto-generated method stub
		
		return tarifa;
	}
	
	public String toStringSCPel() {
		return super.toStringSCPel() + "corriente";
		
	}
	
	

}
