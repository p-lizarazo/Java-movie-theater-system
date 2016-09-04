package co.edu.javeriana.cadenacines.persintencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.Throwable;

import co.edu.javeriana.cadenacines.negocio.CadenaCines;

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
	
	
	public void ingresarClientes(String nombre,CadenaCines cadena){
	
		File inFile = new File("./" + nombre);
		Scanner  input = null;
		String linea;
		StringTokenizer token;
		try {
			input = new Scanner(inFile);
			input.nextLine();
			linea=input.nextLine();
			if(!linea.equals("#FIN") ){
				linea=input.nextLine();
				while(!linea.equals("#FIN")){
					
					token=new StringTokenizer(linea,"*");
					cadena.agregarClientes(token.nextToken().trim(),token.nextToken().trim());
					linea=input.nextLine();
				}
			}
		} catch(FileNotFoundException e) {
			System.out.println("No se pudo encontrar el archivo de usuarios");
		} catch (NoSuchElementException a){
			System.out.println("No se pudo leer de manera adecuada los usuarios");
		}
		finally {
			input.close();
		}
		
	}
	
	public void ingresarPeliculas(String nombre,CadenaCines cadena){
		
		File inFile = new File("./" + nombre);
		Scanner input = null;
		String linea;
		StringTokenizer token;
		try {
			input = new Scanner(inFile);
			input.nextLine();
			linea=input.nextLine();
			if(!linea.equals("#FIN") ){
				linea=input.nextLine();
				while(!linea.equals("#FIN")){
					token=new StringTokenizer(linea,"*");
					cadena.agregarPeliculas(Integer.parseInt(token.nextToken().trim()), token.nextToken().trim(), token.nextToken().trim());
					linea=input.nextLine();
				}
			}
		} catch(FileNotFoundException e) {
			System.out.println("No se pudo encontrar el archivo de Peliculas");
		} catch (NoSuchElementException a){
			System.out.println("No se pudo leer de manera adecuada las Peliculas");
		}
		finally {
			input.close();
		}
		
		
		
	}
	
	

}
