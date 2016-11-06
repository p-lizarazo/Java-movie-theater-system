package co.edu.javeriana.cadenacines.negocio;


import java.util.Comparator;

/**
 * Clase de uso que implementando un comparator de Sillas
 * compara por cada una sus filas y numeros para poder ordenarlas
 * 
 * @author Juan Orozco
 * @author Santiago Lizarazo
 *
 */

public class SillaComparator implements Comparator<Silla> {

	@Override
	public int compare(Silla arg0, Silla arg1) {
		int compararSilla = arg0.getFila().compareTo(arg1.getFila());
		//Si son iguales, compare el numero
		if(compararSilla == 0){
			if(arg0.getNumero() < arg1.getNumero()){
				return -1;
			}
			if(arg0.getNumero() > arg1.getNumero()){
				return 1;
				
			}
			return 0;
		}
		return compararSilla;
	}

}