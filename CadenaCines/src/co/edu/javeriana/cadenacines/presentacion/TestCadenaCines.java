package co.edu.javeriana.cadenacines.presentacion;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import co.edu.javeriana.cadenacines.negocio.Boleta;
import co.edu.javeriana.cadenacines.negocio.CadenaCines;
import co.edu.javeriana.cadenacines.negocio.CentroComercial;
import co.edu.javeriana.cadenacines.negocio.Cine;
import co.edu.javeriana.cadenacines.negocio.Cliente;
import co.edu.javeriana.cadenacines.negocio.Funcion;
import co.edu.javeriana.cadenacines.negocio.Pelicula;
import co.edu.javeriana.cadenacines.negocio.Silla;
import co.edu.javeriana.cadenacines.negocio.SillaComparator;
import co.edu.javeriana.cadenacines.persintencia.ManejoArchivos;

/**
 * Clase de entrada al sistema de Cines
 * 
 * 
 * @author Juan Orozco
 * @author Santiago Lizarazo 
 *
 */

public class TestCadenaCines {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CadenaCines miCine = new CadenaCines("Papuu");
		ManejoArchivos a = new ManejoArchivos();
		int op = 0;
		Scanner in = new Scanner(System.in);
		Scanner leeString = new Scanner (System.in);
		do{
			op=menu(in);
			switch(op){
			case 1:
				a.agregarCentrosCinesSilla(miCine);
				// ingresar centros comerciales, cines y sillas asociadas
				break;
			case 2:
				generarReporteCentrosCinesSillas(miCine);
				// reporte de centros comerciales, cines y sillas asociadas
				break;
			case 3:
				//ingresar clientes
				a.ingresarClientes("Clientes.txt", miCine);
				
				break;
			case 4:
				//opcion 4: ingresar peliculas
				a.ingresarPeliculas("Peliculas.txt", miCine);
				break;
			case 5:
				//AgregaFunciones
				agregarFuncion(miCine,leeString);
				break;
			case 6:
				//consultar funciones para una pelicula
				consultarFunciones(miCine,leeString);
				break;
			case 7:
				//Comprar boletas para una funcion
				comprarBoletaFuncion(miCine);
				break;
				
			case 8:
				//Reporte de clientes con boletas compradas
				reporteClientesBoletasCompradas(miCine);
				break;
				
			case 9:
				in.close();
				leeString.close();
				break;
				
			
				
			
			}
		} while (op!=9);
		a.ingresarClientes("Clientes.txt", miCine);
		a.ingresarPeliculas("Peliculas.txt", miCine);	
		
	}

	private static int menu(Scanner in){
		System.out.println("SISTEMA BANCO \nopcion 1: ingresar centros comerciales, cines y sillas asociadas"
				+ "\nopcion 2: reporte de centros comerciales, cines y sillas asociadas"
				+ "\nopcion 3: ingresar clientes" + "\nopcion 4: ingresar peliculas"
				+ "\nopcion 5: agregar una funcion asociada a una pelicula y a un cine" + "\nopcion 6: consultar funciones para una pelicula"
				+ "\nopcion 7: comprar boletas para una funcion" + "\nopcion 8: reporte de clientes con boletas compradas"
				+ "\nopcion 9: salir");
		String l = in.nextLine();
		int i = Integer.parseInt(l);
		System.out.println(i);
		return i;
	}
	/**
	 * Toma todas las peliculas de la cadena de cines que recibe
	 * recorre cada pelicula y imprime toda su informacion sin la descripcion
	 * mediante el metodo toString
	 * @param <T>
	 * 
	 * @param miCine
	 */
	
	private static void mostrarPeliculasSD(CadenaCines miCine){
		TreeSet<Pelicula> peliculas = new TreeSet<Pelicula>();
		peliculas.addAll(miCine.getPeliculas());
		for(Pelicula pelicula: peliculas){
			System.out.println("   "+pelicula.toStringSD());
		}
	}
	
	/**
	 * Recorre todos los cines asociados a los centros comerciales
	 * de la cadena de cines que recibe y va imprimiendo la informacion
	 * de cada cine con el metodo toString de cada Cine
	 * 
	 * @param miCine
	 */
	private static void mostrarSalas(CadenaCines miCine){
		
		for(CentroComercial centros : miCine.getCentros()){	
			for(Cine cine : centros.getCines()){
				System.out.println("   "+cine.toStringSD());
				
			}
		}
		
	}
	
	/**
	 * Agrega una nueva funcion asociada a un cine
	 * Muestra las peliculas y cines del sistema
	 * le pide al usuario ingresar la informacion de la nueva funcion a agregar
	 * intancia una nueva funcion
	 * y se verifica que efectivamente se pudo agregar
	 * 
	 * 
	 * @param miCine
	 * @param in 
	 */
	
	
	private static void agregarFuncion(CadenaCines miCine,Scanner in){
		System.out.println("--- Se muestran las peliculas del sistema:");
		System.out.println("   codigo"+"    "+"nombre");
		System.out.println("   ----------------------------------------");
		mostrarPeliculasSD(miCine);
		System.out.println();
		System.out.println("--- Se muestran las salas de cine del sistema:");
		System.out.println("   id"+"    "+"sala"+"       "+"centro");
		System.out.println("   ----------------------------------------");
		mostrarSalas(miCine);
		System.out.println("Indique datos de la nueva Función:\ncodigo de pelicula, id de cine, fecha(yyyy/mm/dd), hora(hh:mm), tarifa, tipo(gala o corriente), requiere traje de etiqueta? (si o no)");
		long codigo=in.nextLong();
		long idCine = in.nextLong();
		in.nextLine();
		String fecha = in.nextLine();
		String hora = in.nextLine();
		long tarifa = in.nextLong();
		in.nextLine();
		String tipo = in.nextLine();
		String etiqueta = in.nextLine();
		if(tipo.equals("gala")){
			if(etiqueta.equals("si")){
				long a = miCine.agregarFuncionGala(codigo, idCine, fecha, hora, tarifa,true);
				if(a!=-1){
					System.out.println("Se agrego la nueva funcion con id : " + a);
				} else {
					System.out.println("No se pudo agregar la función");
				}
			}
			else{
				long a = miCine.agregarFuncionGala(codigo, idCine, fecha, hora, tarifa,false);
				if(a!=-1){
					System.out.println("Se agrego la nueva funcion con id : " + a);
				} else {
					System.out.println("No se pudo agregar la función");
				}
				
			}
				
			
		}
		else{
			
			long a=miCine.agregarFuncionCorriente(codigo, idCine, fecha, hora, tarifa);
			if(a!=-1){
				System.out.println("Se agrego la nueva funcion con id : " + a);
			} else {
				System.out.println("No se pudo agregar la función");
			}
			
		}
	
	}
	/**
	 * Recorre todas las peliculas del sistema 
	 * y imprime toda su informacion mediante el metodo toString
	 * 
	 * @param miCine
	 */
	
	private static void mostrarPeliculas(CadenaCines miCine){
		for(Pelicula pelicula:miCine.getPeliculas()){
			System.out.println(pelicula.toString());
		}
	}
	/**
	 * Se muestran las peliculas disponibles en el sistema
	 * con su id y nombre
	 * Se le pide al usuario que digite el codigo de la pelicula
	 * para la cual quiere ver sus funciones disponibles
	 * Se toman todas las funciones de la pelicula escogida
	 * y se le muestra la informacion
	 * 
	 * @param miCine
	 * @param in
	 */
	
	private static void consultarFunciones(CadenaCines miCine,Scanner in){
		System.out.println("-- Las peliculas son -- ");
		mostrarPeliculas(miCine);
		System.out.println("Indique el codigo de pelicula que quiere consultar");
		Pelicula a=miCine.buscarPelicula(in.nextLong());
		for(Funcion funcion:a.getFunciones()){
			System.out.println(funcion.toStringSC());
		}
	}
	
	
	/**
	 * Muestra todos los centros asociados a una cadena de cines
	 * por cada centro se recorre e imprimen su cines asociados
	 * y por cada cine se imprimiran las listas por orden,
	 * de acuerdo a la primera letra de la silla
	 * 
	 * @param cadenaC
	 */
	
	private static  void generarReporteCentrosCinesSillas(CadenaCines cadenaC){
		System.out.println("--REPORTE DE CENTROS COMERCIALES, CINES Y SILLAS");
		TreeSet<CentroComercial> centross = new TreeSet<CentroComercial>();
		centross.addAll(cadenaC.getCentros());
		for(CentroComercial centros : centross){
			System.out.println("--" +"CENTRO COMERCIAL " +  centros.toString());
			TreeSet<Cine> ciness = new TreeSet<Cine>();
			ciness.addAll(centros.getCines());
			for(Cine cines : ciness){
				System.out.print("CINE :  ");
				System.out.println(cines.toString());
				System.out.println("SILLAS:");
				Collections.sort((ArrayList<Silla>)cines.getSillas(),new SillaComparator());
				for(Silla sillas : cines.getSillas()){	
					if(sillas.isPrimera()){
								
						System.out.println(sillas.toString()+"(primera)");
					}	
					else{
						System.out.println(sillas.toString()+"(normal)");
					}
					
					}
				
				}
				System.out.println();
			}
		
		
	}
	/**
	 * Permite al usuario comprar boletas asociadas a una funcion
	 * Se imprimen todos los clientes del sistema
	 * recorriendo la lista en la cadena de cines
	 * se le pide al usuario que digite el id del cliente que hará
	 * la compra, el numero de boletas y el id de la funcion
	 * 
	 * se le muestran las sillas disponibles y se le permite escojer las sillas
	 * de acuerdo el numero de boletas a comprar, se procesa la compra
	 * y se imprime el costo total
	 * @param cadenaX
	 */
	
	
	 private static void comprarBoletaFuncion(CadenaCines cadenaX){
			int id,numBoletas,idFuncion;
			String id1,numBoletas1,idFuncion1;
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("--COMPRAR BOLETAS PARA UNA FUNCION");
			System.out.println();
			System.out.println("--Se muestran los clientes del sistema");
			System.out.println("    id"+"    "+"nombre");
			System.out.println("    ------------------------");
			for(Cliente clientes : cadenaX.getClientes()){
				System.out.println(clientes.getId() + "    " + clientes.getNombre());
			}
			System.out.println("--- Indique datos de compra:");
			System.out.println("id del cliente, numero de boletas, id de la funcion");
			System.out.println("id Cliente:");
			id1 = scanner.nextLine();
			System.out.println("numBoletas: ");
			numBoletas1 = scanner.nextLine();
			System.out.println("idFuncion: ");
			idFuncion1= scanner.nextLine();
			id = Integer.parseInt(id1);
			numBoletas = Integer.parseInt(numBoletas1);
			idFuncion = Integer.parseInt(idFuncion1);
			List <Cliente> comprador = new ArrayList<Cliente> (cadenaX.getClientes());
			Cliente com=null;
			for(Cliente comp : comprador){
				if(comp.getId()==id){
					com=comp;
				}
			}
			System.out.println("Se muestran las sillas disponibles para la funcion" + idFuncion + " :");
			System.out.println("    fila"+"    "+"numero");
			System.out.println("    ------------");
			Funcion x = Utils.buscarFuncionXId(cadenaX, idFuncion);
			Cine cin = x.getCine();
			for(Silla silla : cin.getSillas()){
					System.out.println(silla.toString());
			}
			System.out.println("---- Indique " + numBoletas + " sillas para las boletas que desea comprar");
			System.out.println("    fila"+"    "+"numero");
			System.out.println("    -----------");
			String fila,num1;
			int num;
			int numBoletas2=0;
			for(int i = 0; i<numBoletas;i++){
				fila = scanner.nextLine();
				num1 = scanner.nextLine();
				num = Integer.parseInt(num1);
				String tipo = scanner.nextLine();
				Silla nueva = null;
				if(tipo.equals("normal")){
					nueva = new Silla(fila,num,false);
				}
				else{
					nueva = new Silla(fila,num,true);
				}
				
				
				boolean comprada = false;
				for (Boleta boletas:x.getBoletas()){
					if(boletas.getSillas().equals(nueva)){
						comprada = true;
					}
					
				}
				if(!comprada){
					x.agregarBoleta(com, nueva);
					numBoletas2++;
				}
				else
					System.out.println("No se pudo comprar la boleta ya está ocupada");
			}
			System.out.println("** Se realizo la compra con exito por un valor de $ " + (x.getTarifa() * numBoletas2));
				
		}
	 
	 /**
	  * Se mostraran las boletas que cada cliente ha comprado en la cadena de cines
	  * por cada cliente se mostrara su informacion y las boletas que ha adquirido
	  * por cada boleta, su silla asociada, su cine y centro
	  * se mostrara toda la informacion de la funcion asociada a la boleta 
	  * y la infomormacion de la pelicula asociada a la funcion
	  * 
	  * @param cadenaX
	  */
	 
	 private static void reporteClientesBoletasCompradas(CadenaCines cadenaX){
			
			System.out.println("-- REPORTE DE CLIENTES CON BOLETAS COMPRADAS");
			System.out.println();
			System.out.println();
			for(Cliente clientes : cadenaX.getClientes()){
				if(clientes.getBoletas().size()>0){
					System.out.println(clientes.toString());
					for(Boleta boletas : clientes.getBoletas()){
						System.out.println(boletas.getSillas().toString());
						System.out.println(boletas.getFuncion().toStringSCPel());
					}
				}
			}
		}
	 
	
		 
		 
	 }



	}