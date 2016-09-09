package co.edu.javeriana.cadenacines.presentacion;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
	
	public LocalDateTime convertirStringFecha(String anio,String mes, String dia, String hora,String minutos){
		String fecha = anio+"-"+mes+"-"+dia+" "+hora+":"+minutos;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime fechaL = LocalDateTime.parse(fecha,formatter);
		
		return fechaL;
		
	}

}
