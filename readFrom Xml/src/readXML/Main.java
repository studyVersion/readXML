package readXML;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.DOMException;



public class Main {
	 static Scanner in = new Scanner(System.in);
	 
	 
	public static void main(String[] args) throws DOMException, ParserConfigurationException, TransformerException, IOException {
		
		Jugador.grabarJugadorXML(pedirDatosJugador());
		
		// Menu para leer y escribir datos XML
		
	}//main
	private static List<Jugador> pedirDatosJugador() {
		List<Jugador> players = new ArrayList<>();
		Jugador datos = new Jugador();
		boolean on = false;
		
		
		
		while(!on) {
			
		System.out.println("1. Type data\n2. quit");
		int option = Integer.valueOf(in.nextLine());
		
		switch(option) {
		     
		case 1 :  
			       datos =pedir() ;
	               
		           players.add(datos);break;
		           
		case 2 : on = true; break;          
		}
	}
	return players;
	}//pedirDatosJugador
	public static Jugador pedir() {
		
		Jugador datosJugador = new Jugador();
		 System.out.println("Introduce el nombre:");
         datosJugador.setNombre(in.nextLine());
         System.out.println("Introduce el apellido:");
         datosJugador.setApellido(in.nextLine());
         System.out.println("Introduce la edad:");
         datosJugador.setEdad(Integer.parseInt(in.nextLine()));
         System.out.println("Introduce el dorsal:");
         datosJugador.setDorsal(Integer.parseInt(in.nextLine())); 
         
         return datosJugador;
	}
	// metodo para escribir en un fichero XML

}//class
