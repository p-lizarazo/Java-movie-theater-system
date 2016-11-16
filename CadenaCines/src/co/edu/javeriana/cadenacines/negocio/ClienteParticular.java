package co.edu.javeriana.cadenacines.negocio;

public class ClienteParticular extends Cliente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



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
