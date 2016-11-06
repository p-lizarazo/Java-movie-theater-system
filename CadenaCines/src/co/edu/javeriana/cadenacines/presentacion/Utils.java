package co.edu.javeriana.cadenacines.presentacion;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.StringTokenizer;

import co.edu.javeriana.cadenacines.negocio.CadenaCines;
import co.edu.javeriana.cadenacines.negocio.CentroComercial;
import co.edu.javeriana.cadenacines.negocio.Cine;
import co.edu.javeriana.cadenacines.negocio.Funcion;

/**
 * Clase de uso para metodo utilitarios en el sistema
 * 
 * @author Juan Orozco
 * @author Santiago Lizarazo
 *
 */

public class Utils {
	
	/**
	 * Toma el String, lo procesa, luego se pasa a entero y se retorna el objeto localDate con el metodo of
	 * @param fecha
	 * @return Retorna un objeto LocalDate a partir de una string
	 */

	public static LocalDate convertirStringFecha (String fecha){
		String a[] = new String[3];
		int b[] = new int[3];
		StringTokenizer div = new StringTokenizer(fecha, "/");
		for(int i=0;div.hasMoreTokens();i++){
			a[i]= div.nextToken();
			b[i]= Integer.parseInt(a[i]);
		}
		
		return LocalDate.of(b[0],b[1],b[2]);
	}
	
	/**
	 * se toman las horas y minutos, se procesan y luego se convierntes en un
	 * objeto LocalTime con el metodo of
	 * @param horaYMinutos
	 * @return Retorna un objeto LocalTime con las horas y minutos
	 */
	
	public static LocalTime convertirStringHora (String horaYMinutos){
		StringTokenizer div = new StringTokenizer(horaYMinutos, ":");
		String a;
		int b,c;
		a=div.nextToken();
		b=Integer.parseInt(a);
		a=div.nextToken();
		c=Integer.parseInt(a);
		
		return LocalTime.of(b,c);
	}
	
	/**
	 * Busca una funcion asociada a un cine con un id Especifico
	 * Recorre la lista de centros, la de cines y por cines
	 * busca cada funcion con el id que se le pide
	 * 
	 * @param cadena
	 * @param idFuncion
	 * @return La funcion con el id que entra como parametro, o null si no esta
	 */

	
}
