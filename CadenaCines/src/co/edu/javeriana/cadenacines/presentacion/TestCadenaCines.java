package co.edu.javeriana.cadenacines.presentacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

import co.edu.javeriana.cadenacines.negocio.Boleta;
import co.edu.javeriana.cadenacines.negocio.CadenaCines;
import co.edu.javeriana.cadenacines.negocio.CentroComercial;
import co.edu.javeriana.cadenacines.negocio.Cine;
import co.edu.javeriana.cadenacines.negocio.Cliente;
import co.edu.javeriana.cadenacines.negocio.Funcion;
import co.edu.javeriana.cadenacines.negocio.FuncionGala;
import co.edu.javeriana.cadenacines.negocio.ICadenaCines;
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
		ICadenaCines miCine = new CadenaCines("Papuu");
		ManejoArchivos a = new ManejoArchivos();
		int op = 0;
		Scanner in = new Scanner(System.in);
		Scanner leeString = new Scanner (System.in);
		do{
			op=menu(in);
			switch(op){
			case 1:
				a.agregarCentrosCinesSilla((CadenaCines)miCine);
				// ingresar centros comerciales, cines y sillas asociadas
				break;
			case 2:
				generarReporteCentrosCinesSillas((CadenaCines)miCine);
				// reporte de centros comerciales, cines y sillas asociadas
				break;
			case 3:
				//ingresar clientes
				a.ingresarClientes(leeString.nextLine(), (CadenaCines)miCine);
				
				break;
			case 4:
				//opcion 4: ingresar peliculas
				a.ingresarPeliculas(leeString.nextLine(), (CadenaCines)miCine);
				break;
			case 5:
				//AgregaFunciones
				agregarFuncion((CadenaCines)miCine,leeString);
				break;
			case 6:
				//consultar funciones para una pelicula
				consultarFunciones((CadenaCines)miCine,leeString);
				break;
			case 7:
				//Comprar boletas para una funcion
				try {
					comprarBoletaFuncion((CadenaCines)miCine);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 8:
				//Reporte de clientes con boletas compradas
				reporteClientesBoletasCompradas((CadenaCines)miCine);
				break;
				
			case 9:
				in.close();
				leeString.close();
				System.out.println("HASTA LUEGO, GRACIAS POR USAR POO CINES");
				break;
				
			
				
			
			}
		} while (op!=9);
		
	}

	private static int menu(Scanner in){
		System.out.println("SISTEMA CADENACINES \nopcion 1: ingresar centros comerciales, cines y sillas asociadas"
				+ "\nopcion 2: reporte de centros comerciales, cines y sillas asociadas"
				+ "\nopcion 3: ingresar clientes" + "\nopcion 4: ingresar peliculas"
				+ "\nopcion 5: agregar una funcion asociada a una pelicula y a un cine" + "\nopcion 6: consultar funciones para una pelicula"
				+ "\nopcion 7: comprar boletas para una funcion" + "\nopcion 8: reporte de clientes con boletas compradas"
				+ "\nopcion 9: salir");
		String l = in.nextLine();
		int i = Integer.parseInt(l);
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
	
	private static void mostrarPeliculasSD(ICadenaCines miCine){
		Map<Long,Pelicula> pelis = new TreeMap<Long,Pelicula>();
		pelis.putAll(((CadenaCines) miCine).getPeliculas());
		for(Pelicula pelicula:  pelis.values()){
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
	 * Muestra las peliculas(ordenadas por codigo) y cines del sistema(ordenados
	 * por id) le pide al usuario ingresar la informacion
	 * de la nueva funcion a agregar(se le pregunta si la funcion es de gala o no)
	 * si es de gala, se le preguntara si requiere traje de etiquet
	 * intancia una nueva funcion(de gala o corriente)
	 * y se verifica que efectivamente se pudo agregar
	 * se le muestra el id al usuario
	 * 
	 * @param miCine
	 * @param in 
	 */
	
	
	private static void agregarFuncion(CadenaCines miCine,Scanner in){
		System.out.println("--AGREGAR UNA FUNCION ASOCIADA A UN CINE Y A UNA PELICULA");
		System.out.println();
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
		if(tipo.equals("gala")){
			String etiqueta = in.nextLine();
			if(etiqueta.equals("si")){
				long a = miCine.agregarFuncionGala(codigo, idCine, fecha, hora, tarifa,true);
				if(a!=-1){
					System.out.println("**Se agrego la nueva funcion con id : " + a);
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
	 * se ordenan, de acuerdo al id de cada pelicula
	 * y imprime toda su informacion mediante el metodo toString
	 * 
	 * @param miCine
	 */
	
	private static void mostrarPeliculas(CadenaCines miCine){
		Map<Long,Pelicula> pelis = new TreeMap<Long,Pelicula>();
		pelis.putAll(miCine.getPeliculas());
		for(Pelicula pelicula: pelis.values()){
			System.out.println(pelicula.toString());
		}
	}
	/**
	 * Se muestran las peliculas disponibles en el sistema
	 * ordenadas por id  con su id y nombre
	 * Se le pide al usuario que digite el codigo de la pelicula
	 * para la cual quiere ver sus funciones disponibles
	 * Se toman todas las funciones de la pelicula escogida
	 * y se le muestra la informacion
	 * 
	 * @param miCine
	 * @param in
	 */
	
	private static void consultarFunciones(CadenaCines miCine,Scanner in){
		System.out.println("CONSULTAR FUNCIONES PARA UNA PELICULA");
		System.out.println();
		System.out.println("--- Se muestran las peliculas del sistema: ");
		System.out.println("codigo	nombre		descripción");
		System.out.println(" ---------------------------------------------------");
		mostrarPeliculas(miCine);
		System.out.println("--Indique el codigo de pelicula que quiere consultar");
		Pelicula a=miCine.buscarPelicula(in.nextLong());
		System.out.println("--Funciones para la pelicula" + a.getCodigo() + " " + a.getNombre());
		System.out.println("id	fecha		hora	tarifa	sala		centro		tipo	etiqueta");
		System.out.println(" ---------------------------------------------------------------------------------");
		for(Funcion funcion:a.getFunciones()){
			if(funcion instanceof FuncionGala){
				System.out.println((funcion.toString()));
			}
			else{
				System.out.println(funcion.toStringSC());
			}
		}
	}
	
	
	/**
	 * Muestra todos los centros asociados a una cadena de cines
	 * por cada centro se imprime ordenados por nombre
	 *  se recorre e imprimen su cines asociados ordenados por sala
	 * y por cada cine se imprimiran las sillas ordenadas por fila y numero
	 * @param cadenaC
	 */
	
	private static  void generarReporteCentrosCinesSillas(CadenaCines cadenaC){
		System.out.println("--REPORTE DE CENTROS COMERCIALES, CINES Y SILLAS");
		System.out.println("");
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
					System.out.println(sillas);
				}
				
			}
		System.out.println();
		}
		
		
	}
	/**
	 * Permite al usuario comprar boletas asociadas a una funcion
	 * Se imprimen todos los clientes del sistema(ordenados por nombre)
	 * recorriendo la lista en la cadena de cines
	 * se le pide al usuario que digite el id del cliente que hará
	 * la compra, el numero de boletas y el id de la funcion
	 * 
	 * se le muestran las sillas disponibles con su tipo y se le permite escojer las sillas
	 * de acuerdo el numero de boletas a comprar, se procesa la compra
	 * y se imprime el costo total
	 * @param cadenaX
	 * @throws IOException 
	 */
	
	
	 private static void comprarBoletaFuncion(CadenaCines cadenaX) throws IOException{
			int numBoletas;
			long id,idFuncion;
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("--COMPRAR BOLETAS PARA UNA FUNCION");
			System.out.println();
			System.out.println("--Se muestran los clientes del sistema");
			System.out.println("    id"+"    "+"nombre" + "	" + "tipo");
			System.out.println("    ------------------------");
			List <Cliente> sortedList = new ArrayList<Cliente>(cadenaX.getClientes());
			Collections.sort(sortedList);
			for(Cliente clientes : sortedList){
				System.out.println("    "+ clientes.toString());
			}
			System.out.println("--- Indique datos de compra:");
			System.out.println("	id del cliente, numero de boletas, id de la funcion");
			System.out.println("id Cliente:");
			id = scanner.nextLong();
			System.out.println("numBoletas: ");
			numBoletas=scanner.nextInt();
			System.out.println("idFuncion: ");
			idFuncion=scanner.nextLong();
			Cliente com=cadenaX.buscarCliente(id);
			Funcion func=cadenaX.buscarFuncion(idFuncion);
			
			System.out.println("Se muestran las sillas disponibles para la funcion " + idFuncion + " :");
			System.out.println("	fila"+"    "+"numero" + "	tipo");
			System.out.println("    ---------------------------------");
			for(Silla silla : func.getCine().getSillas()){
				if(func.sillaDisponible(silla)){
					System.out.println("	" +silla.toStringTipo());
				}
			}
			System.out.println("---- Indique " + numBoletas + " sillas para las boletas que desea comprar");
			System.out.println("    fila"+"    "+"numero");
			System.out.println("    ---------------");
			long suma=0;
			for(int i=0;i<numBoletas;i++){
				scanner.nextLine();
				String fila = scanner.nextLine();
				int numero = scanner.nextInt();
				
				long valor=com.valorBoletas(cadenaX.comprarBoleta(fila,numero,func,com));
				if(valor>0){
					suma=suma+valor;
				} else {
					System.out.println("No se pudo comprar esta boleta");
				}
			}
			System.out.println("**Se realizo la compra con exito por un valor de " + suma );
			
		}
	 
	 /**
	  * Se mostraran las boletas que cada cliente ha comprado en la cadena de cines
	  * clientes, ordenados por nombre
	  * por cada cliente se mostrara su informacion incluyendo tipo y fecha membresia
	  * si el cliente es miembro, junto con las boletas que ha adquirido
	  * ordenadas por id de funcion a la que pertenece
	  * por cada boleta, su silla asociada, su cine y centro
	  * se mostrara toda la informacion de la funcion asociada junto
	  * con el tipo de la funcion y si requiere traje de etiqueta 
	  * y la infomormacion de la pelicula asociada a la funcion
	  * 
	  * @param cadenaX
	  */
	 
	 private static void reporteClientesBoletasCompradas(CadenaCines cadenaX){
			
			System.out.println("-- REPORTE DE CLIENTES CON BOLETAS COMPRADAS");
			System.out.println();
			System.out.println();
			
			List <Cliente> sortedList = new ArrayList<Cliente>(cadenaX.getClientes());
			Collections.sort(sortedList);
			for(Cliente clientes : sortedList){
				if(!clientes.getBoletas().isEmpty()){
					
					System.out.println("--CLIENTE " + clientes.toString8());
					System.out.println();
					Collections.sort(clientes.getBoletas());
					
					for(Boleta boleta : clientes.getBoletas()){
						System.out.println(boleta.toString());
						System.out.println();
					}
				}
			}
			
		}
	 }



