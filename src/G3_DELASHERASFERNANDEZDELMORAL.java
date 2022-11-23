package practica;

import java.util.*;
import java.io.*;

public class G3_DELASHERASFERNANDEZDELMORAL {
	final static Scanner teclado= new Scanner(System.in);
	
	public static void main(String[]args) {
		System.out.println("--BIENVENIDO AL MENÚ DE CONSULTAS DE LA PROTECTORA--\n");
		Protectora protectora= new Protectora();
		Ayuntamiento ayto= new Ayuntamiento("926254678",25);
		Clinica_veterinaria clinica= new Clinica_veterinaria("Kivet","926215247",25);
		
		try {
			leerfichero(protectora);
		
			int opcion=0;
			do {
				try {
					opcion=menu();
					if (opcion<1||opcion>8) throw new ExceptionIntervalo("Numero fuera de rango[1-8]");
					consultas(protectora,ayto,clinica,opcion);
					
				} 
				catch (ExceptionIntervalo ex) { //excepcion fuera del intervalo
					
					System.out.println(ex.getMessage());
					
				}
				catch (InputMismatchException ex) { //excepcion caracter no numerico
					
					System.out.println("Incorrecto.Seleccione un caracter numerico");
					teclado.next();
					
				}
				
			}while(opcion!=8);	
	
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}
	}
	
	//mostrar menu y elegir opcion
	
	public static int menu() {
		
		System.out.println("Seleccione que desea hacer\n 1. Mostrar toda la informacion de los animales de la protectora\n"
				+ " 2. Realizar solicitud de adopcion o acogida\n 3. Consultar el listado de solicitudes de adopcion de un animal\n"
				+ " 4. Mostrar gastos veterinarios anuales de la protectora\n"
				+ " 5. Calcular coste de campaña de esterilizacion de gatas\n"
				+ " 6. calcular cantidad de pienso para un semana( en Kg)\n"
				+ " 7. calcular subvencion que concederia el Ayuntamiento\n 8. Salir");
		
		int opcion=teclado.nextInt();
		return opcion;
	}
	
	//consultas
	
	public static void consultas(Protectora protectora, Ayuntamiento Ayto, Clinica_veterinaria clinica,int opcion) throws ExceptionIntervalo {
		switch (opcion) {
		case 1:
			consulta1(protectora);
			break;
		case 2:
			consulta2(protectora);
			break;
		case 3:
			consulta3(protectora);
			break;
		case 4:
			consulta4(protectora);
			break;
		case 5:
			consulta5(protectora,clinica);
			break;
		case 6:
			consulta6(protectora);
			break;
		case 7:
			consulta7(protectora,Ayto);
			break;
		case 8:
			System.out.println("Fin del programa");
			break;
		
		}
	}
	
	//consulta 1
	
	public static void consulta1(Protectora protectora) {
		System.out.println(protectora.mostrarAnimales());
	}
	
	//consulta 2
	
	public static void consulta2(Protectora protectora) throws ExceptionIntervalo{
		System.out.println("Introduzca el nombre del animal que quiere apadrinar o acoger");
		String nombre=teclado.next();
		boolean existe=protectora.existencia(nombre);
		if (!existe) {
			System.out.println("El animal no existe");
		}else {
		
		System.out.println("Introduzca el tipo de solicitud(acogida-->0 adopcion-->1");
		boolean correcto=false;
		int tipo=0;
		do {
		try {
			tipo=teclado.nextInt();
			if(tipo!=1&&tipo!=0)throw new ExceptionIntervalo("Error. Seleccione 0 para acogida o 1 para adopcion");
			correcto=true;
			System.out.println("Introduzca un numero de contacto");
			String telefono=teclado.next();
			System.out.println(protectora.addSol(nombre, tipo, telefono));
			
		}catch (ExceptionIntervalo e) {
			System.out.println(e.getMessage());
		}catch (InputMismatchException e) {
			System.out.println("Introduzca un caracter numerico");
			teclado.next();
		}
		}while(!correcto);
		}
	}
	
	//consulta 3
	
	public static void consulta3(Protectora protectora) {
		System.out.println("Elija un animal para ver sus solicitudes");
		String animal=teclado.next();
		boolean existe=protectora.existencia(animal);
		if (!existe) {
			System.out.println("El animal no existe");
		}else {
		System.out.println(protectora.mostrarsol(animal) +"\n");
		}
	}
	
	//consulta 4
	
	public static void consulta4(Protectora protectora) {
		System.out.println("Los gastos anuales de la protectora son: "+ protectora.calcGastos() + " euros");	
	}
	
	//consulta 5
	
	public static void consulta5(Protectora protectora, Clinica_veterinaria clinica) {
		System.out.println("El coste de la campaña de esterilizacion es: " + protectora.campEsterilizacion(clinica) + " euros\n");	
	}
	
	//consulta 6
	
	public static void consulta6(Protectora protectora) {
		double cantidad=protectora.calcPienso();
		
			System.out.printf("%.2f Kg por semana\n",cantidad);
			
	}
	//consulta 7
	public static void consulta7(Protectora protectora, Ayuntamiento Ayto) {
		System.out.println("La subvencion que recibira la protectora por parte del ayuntamiento es de: " 
				+ protectora.calcSubvencion(Ayto) + " euros\n");	
	}
	
	//leer fichero y crear animales 
	public static void leerfichero(Protectora protectora) throws FileNotFoundException {
			
			Scanner escaner =new Scanner(new File("Animales.txt"));
			
			Animal newAnimal = null;
			
			char tipoAnimal,sexo;
			String nombre,raza;
			int edad,tamano;
			boolean sociable,apadrinado,ppp,leishmania,esterilizado;
			
			while(escaner.hasNext()) {
				
				tipoAnimal=(escaner.next()).charAt(0);
				nombre=escaner.next();
				sexo=(escaner.next()).charAt(0);
				edad=escaner.nextInt();
				sociable=escaner.nextBoolean();
				apadrinado=escaner.nextBoolean();
				
				if (tipoAnimal=='p') {
					
					raza=escaner.next();
					tamano=escaner.nextInt();
					ppp=escaner.nextBoolean();
					leishmania=escaner.nextBoolean();
					
					
					newAnimal= new Perro(nombre,sexo,edad,sociable,apadrinado,raza,tamano,ppp,leishmania);
					
					
				}else {
					esterilizado=escaner.nextBoolean();
					
					newAnimal= new Gato(nombre,sexo,edad,sociable,apadrinado,esterilizado);
				}
				protectora.addAnimales(newAnimal);
			}
			escaner.close();
		
		
	}

}
