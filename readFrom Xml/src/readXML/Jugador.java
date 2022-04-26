package readXML;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Jugador {
	private String nombre, apellido;
	private int edad, dorsal;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getDorsal() {
		return dorsal;
	}
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	@Override
	public String toString() {
		return nombre+','+ apellido+','+ edad +','+dorsal+',';
	}
	public void imprimirConsolaJugador() {
		System.out.println("#-------------------------------#");
		System.out.println("Datos del jugador: ");
		System.out.println("Nombre: "  +this.nombre + '\t'+" Apellidos: "+ this.apellido);
		System.out.println("Dorsal: "+ this.dorsal + '\t'+" Edad: "+ this.edad+ '\t');
		System.out.println("#-------------------------------#");
	}// imprimir consola jugador
	
	
	// metodo para escribir en un fichero XML
	 public static void grabarJugadorXML(String a) throws ParserConfigurationException {
		 String nombreFichero = a;
		 File ficheroXML = new File(nombreFichero);
		 if (ficheroXML.exists()) {
			 System.out.println("El fichero "+ficheroXML+" existe.");
			 if (ficheroXML.canWrite() &&  ficheroXML.canRead()) {
				 System.out.println("Permisos L/E OK.");
			 }
		 }else {
			 System.out.println("El fichero NO existe.");
		 }
		 // Creamos la estructura para manejar el XML
		 DocumentBuilderFactory db = DocumentBuilderFactory.newInstance();
		 
         DocumentBuilder documentBuilder = db.newDocumentBuilder();
		 
	 }// grabar jugador

	
}//clase

