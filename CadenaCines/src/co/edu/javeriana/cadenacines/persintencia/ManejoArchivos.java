package co.edu.javeriana.cadenacines.persintencia;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ManejoArchivos {
	
		
	public void agregarCentrosCinesSilla(){
		Scanner scanner = new Scanner(System.in);
		String nomArchivo = scanner.nextLine();
		File inFile = new File("./", nomArchivo);
		Scanner input = null;
		try {
			input.nextLine();
			String linea = input.nextLine().trim();
			while(!linea.equals("#FIN")){
				String centro = input.nextLine();
				String line = input.nextLine().trim();
				while(!line.equals(line)){
					input.nextLine();
					line = input.nextLine().trim();
					StringTokenizer tokens = new StringTokenizer(line,"*");
					String sala = tokens.nextToken().trim();
					String cap = tokens.nextToken().trim();
					int capacidad = Integer.parseInt(cap);
					String line1 = input.nextLine();
					while(!line1.equals("0")){
						StringTokenizer token = new StringTokenizer(line1,"*");
						String fila = token.nextToken().trim();
						String num = token.nextToken().trim();
						line1 = input.nextLine();
						
					}
					
					
				}
			}
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	

}
