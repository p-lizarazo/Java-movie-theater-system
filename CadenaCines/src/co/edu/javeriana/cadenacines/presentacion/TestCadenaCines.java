package co.edu.javeriana.cadenacines.presentacion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import co.edu.javeriana.cadenacines.negocio.Boleta;
import co.edu.javeriana.cadenacines.negocio.CadenaCines;
import co.edu.javeriana.cadenacines.negocio.CentroComercial;
import co.edu.javeriana.cadenacines.negocio.Cine;
import co.edu.javeriana.cadenacines.negocio.Cliente;
import co.edu.javeriana.cadenacines.negocio.Funcion;
import co.edu.javeriana.cadenacines.negocio.Pelicula;
import co.edu.javeriana.cadenacines.negocio.Silla;

public class TestCadenaCines {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		
		
		
		System.out.println("SISTEMA CADENACINES");
		System.out.println("    "+"opcion 1:   ingresar centros comerciales, cines y sillas asociadas");
		System.out.println("    "+"opcion 2:   reporte de centros comerciales, cines y sillas asociadas");
		System.out.println("    "+"opcion 3:   ingresar clientes");
		System.out.println("    "+"opcion 4:   ingresar peliculas");
		System.out.println("    "+"opcion 5:   agregar una funcion asociada a una pelicula y a un cine");
		System.out.println("    "+"opcion 6:   consultar funciones para una pelicula");
		System.out.println("    "+"opcion 7:   comprar boletas para una funcion");
		System.out.println("    "+"opcion 8:   reporte de clientes con boletas compradas");
		System.out.println("    "+"opcion 9:   salir");
		
		System.out.println("Digite una opcion : ");
		String x = scanner.nextLine();
		int opcion = Integer.parseInt(x);
		
		if(opcion == 1){
			
		}
		
		else if(opcion == 2){
			TestCadenaCines.generarReporteCentrosCinesSillas(cadenaC);
					
		}

		else if(opcion == 3){
			
		}


		else if(opcion == 4){
			
		}



		else if(opcion == 5){
			
		}

		else if(opcion == 6){
			
		}

		else if(opcion == 7){
			TestCadenaCines.comprarBoletaFuncion(cadenaX);
			
		}

		else if(opcion == 8){
			
		}


		else if(opcion == 9){
			
		}
		
		

	}
	
	 private static  void generarReporteCentrosCinesSillas(CadenaCines cadenaC){
		int cont = 0;
		System.out.println("--REPORTE DE CENTROS COMERCIALES, CINES Y SILLAS");
		for(CentroComercial centros : cadenaC.getCentros()){
			System.out.println("--" + centros.toString());
			System.out.println();
			System.out.println();
			for(Cine cines : centros.getCines()){
				System.out.println("  CINE : " + cines.toString());
				for(Silla sillas : cines.getSillas()){
					System.out.println("   SILLAS:");
					if(sillas.getFila().indexOf(cont) > sillas.getFila().indexOf(cont + 1)){
						System.out.print(sillas.toString() + "   ");	
					}
					else{
						System.out.println();
						System.out.print(sillas.toString() + "   ");
					}
				}
			}
		}
		
		
	}
	 
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
			
			System.out.println("Se muestran las sillas disponibles para la funcion" + idFuncion + " :");
			System.out.println("    fila"+"    "+"numero");
			System.out.println("    ------------");
			//ahí que acceder a la funcion con id : idFuncion
			Funcion x = cadenaX.getPeliculas().funciones.get(idFuncion);
			
			for(Boleta boletas : x.getBoletas()){
				if(boletas.isComprada()){
					boletas.getSillas().toString();
				}
			}
			System.out.println("---- Indique "+numBoletas + " sillas para las boletas que desea comprar");
			System.out.println("    fila"+"    "+"numero");
			System.out.println("    -----------");
			String fila,num1;
			int num;
			for(int i = 0; i<numBoletas;i++){
				fila = scanner.nextLine();
				num1 = scanner.nextLine();
				num = Integer.parseInt(num1);
				Silla nueva = new Silla(fila,num);
				x.getCine().agregarSillas(nueva);
				
			}
			System.out.println("** Se realizo la compra con exito por un valor de $ " + (x.getTarifa() * numBoletas));
				
		}
			
	 
	private static void reporteClientesBoletasCompradas(CadenaCines cadenaX){
		
		System.out.println("-- REPORTE DE CLIENTES CON BOLETAS COMPRADAS");
		System.out.println();
		System.out.println();
		for(Cliente clientes : cadenaX.getClientes()){
			CentroComercial x = cadenaX.getCentros().get((int) clientes.getId());
			Cine y = x.getCines().get((int)clientes.getId());
			System.out.println("--Cliente" + clientes.getId()+"-"+clientes.getNombre()+" "+"("+clientes.getEmail()+")");
			for(Boleta boletas : clientes.getBoletas()){
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				LocalDateTime fechaL = LocalDateTime.parse(cadenaX.getPeliculas().get((int) clientes.getId().getFecha),formatter);
				System.out.println("    "+"BOLETA :  " + boletas.getSillas().getFila()+boletas.getSillas().getNumero()+"   "+ y.getSala()+"    "+ x.getNombre());
				System.out.println("    "+ "FUNCION:" + "  "+y.getFunciones().get((int) clientes.getId()) + fechaL +"  "+ y.getFunciones().get((int) clientes.getId()).getTarifa());
				System.out.println("    "+ cadenaX.getPeliculas().get((int)clientes.getId())+"  "+ cadenaX.getPeliculas().get((int) clientes.getId()).getNombre());
				
			}
		}
		
	}