package co.edu.javeriana.cadenacines.persintencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

import co.edu.javeriana.cadenacines.negocio.CadenaCines;
import co.edu.javeriana.cadenacines.negocio.CentroComercial;
import co.edu.javeriana.cadenacines.negocio.Cine;
import co.edu.javeriana.cadenacines.negocio.Cliente;
import co.edu.javeriana.cadenacines.negocio.ClienteMiembro;
import co.edu.javeriana.cadenacines.negocio.ClienteParticular;
import co.edu.javeriana.cadenacines.negocio.ICadenaCines;
import co.edu.javeriana.cadenacines.negocio.Silla;
import co.edu.javeriana.cadenacines.presentacion.Utils;

/**
 * Clase de usp para el manejo de archivos del sistema
 * 
 * @author Santiago Lizarazon
 * @author Juan Orozco
 *
 */
public class ManejoArchivos {
	
	/**
	 * Permite cargar, a partir de un archivo los centros comerciales
	 * sus cines asociados y sillas asociadas
	 * 
	 * Lee los centros comerciales, verifica que no existe este centro y si es as� lo agrega
	 * luego lee los cines asociados a este centro y se empiezan a agregar a la lista de cines del centro
	 * por ultimo se agregan las sillas asociadas al cine
	 * 
	 * @param cadenaC
	 */
	
	public void agregarCentrosCinesSilla(ICadenaCines cadenaC,String nombre){
		Scanner scanner = new Scanner(System.in);
		File inFile = new File("./", nombre);
		Scanner input = null;
		try {
			input = new Scanner(inFile);
			String linea = input.nextLine().trim();
			System.out.println(linea);
			while(!linea.equals("#FIN")){
				input.nextLine().trim();
				String centro = input.nextLine();
				CentroComercial centroNuevo = new CentroComercial(centro);
				cadenaC.agregarCentroComercial(centroNuevo);
				input.nextLine();
				String line = input.nextLine().trim();
				while(!line.equals("#FIN CENTRO")){
					line = input.nextLine().trim();
					StringTokenizer tokens = new StringTokenizer(line,"*");
					String sala = tokens.nextToken().trim();
					String cap = tokens.nextToken().trim();
					long capacidad = Long.parseLong(cap);
					Cine cine = new Cine(sala,capacidad,centroNuevo);
					cadenaC.agregarCine(cine, centroNuevo);
					input.nextLine();
					input.nextLine();
					String line1 = input.nextLine().trim();
					while(!line1.equals("0")){
						StringTokenizer token = new StringTokenizer(line1,"*");
						String fila = token.nextToken().trim();
						String num = token.nextToken().trim();
						int numero = Integer.parseInt(num);
						String tipo = token.nextToken().trim();
						if(tipo.equals("normal")){
							Silla sillaNueva= new Silla(fila,numero,"normal");
							cine.agregarSillas(sillaNueva);	
						}
						else{
							Silla sillaNueva= new Silla(fila,numero,"primera");
							cine.agregarSillas(sillaNueva);	
						}
						line1= input.nextLine().trim();
					}
					line = input.nextLine().trim();
				}
				linea = input.nextLine().trim();
				
			}
			
		} catch (Exception e) {
			System.out.println("nulo");
			System.out.println(e.getMessage());
		}
		finally{
			input.close();
		}
	}
	
	/**
	 * Carga los clientes al sistema desde un archivo de texto
	 * 
	 * se verifica que hayan clientes en el archivo
	 * se procesa el texto que contiene la informacion del cliente
	 * y se agrega un nuevo cliente al sitema con : nombre y email
	 * 
	 * 
	 * @param nombre
	 * @param cadena
	 */
	
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
					String nombreC = token.nextToken().trim();
					String email = token.nextToken().trim();
					String tipo = token.nextToken().trim();
					if(tipo.equals("miembro")){
						String fecha = token.nextToken().trim();
						Cliente nuevo = new ClienteMiembro(nombreC,email,Utils.convertirStringFecha(fecha));
						cadena.agregarClienteMiembro((ClienteMiembro)nuevo);
					}
					else{
						Cliente nuevo = new ClienteParticular(nombreC,email);
						cadena.agregarClienteParticular(nuevo);
					}
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
	/**
	 * Permite cargar las peliculas al sistema
	 * 
	 * Lee la linea que contiene la informacion de la pelicula y la procesa
	 * toma el codigo , nombre y descripcion de la pelicula
	 * y agrega la pelicula a la lista de peliculas de la Cadena de cines
	 * 
	 * 
	 * @param nombre
	 * @param cadena
	 */
	
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
					cadena.agregarPelicula(Integer.parseInt(token.nextToken().trim()), token.nextToken().trim(), token.nextToken().trim());
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
	
	public static void SerializarCadenaCines(ICadenaCines miCine) throws IOException {
		File archivo = new File("./miBanco.dat");
		OutputStream flujo = new FileOutputStream(archivo);
		ObjectOutputStream flujoObjetos = new ObjectOutputStream(flujo);
		flujoObjetos.writeObject(miCine);
		flujoObjetos.close();
	}
	
	public static ICadenaCines DesserializarCadenaCines() throws ClassNotFoundException, IOException {
		ICadenaCines cadenaC;
		File archivo = new File("./miBanco.dat");
		InputStream flujo = new FileInputStream(archivo);
		ObjectInputStream flujoObjetos = new ObjectInputStream(flujo);
		cadenaC = (CadenaCines) flujoObjetos.readObject();
		flujoObjetos.close();		
		return cadenaC;
	}


}
