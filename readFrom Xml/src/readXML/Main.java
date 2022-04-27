package readXML;

import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.DOMException;



public class Main {
	 static Scanner in = new Scanner(System.in);
	public static void main(String[] args) throws DOMException, ParserConfigurationException, TransformerException {
		
		Jugador player1 = pedirDatosJugador() ;
		player1.grabarJugadorXML();
		
		// Menu para leer y escribir datos XML
		
	}//main
	private static Jugador pedirDatosJugador() {
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
	}//pedirDatosJugador
	
	// metodo para escribir en un fichero XML

}//class
