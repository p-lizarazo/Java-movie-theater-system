package co.edu.javeriana.cadenacines.negocio;

import java.time.format.DateTimeFormatter;

public class ClienteParticular extends Cliente {

	public ClienteParticular(String nombre, String email) {
		super(nombre, email);
		
	}
	
	
	
	public String toString() {
		return super.toString() + "	" + "particular";
	}



	@Override
	public long valorBoletas(long retorno) {
		// TODO Auto-generated method stub
		return retorno;
	}



	@Override
	public String toString8() {
		// TODO Auto-generated method stub
		return super.toString()+ "	" + super.getEmail() + "  -  " + "particular";
	}
	
	

}
