package co.edu.javeriana.cadenacines.presentacion;

import java.util.Scanner;

public class TestCadenaCines {

	package co.edu.javeriana.cadenacines.presentacion;

	import co.edu.javeriana.cadenacines.negocio.CadenaCines;
	import co.edu.javeriana.cadenacines.negocio.CentroComercial;
	import co.edu.javeriana.cadenacines.negocio.Cine;
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
						cont++;
					}
				}
			}
			
			
		}
	}
