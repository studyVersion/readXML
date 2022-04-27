package readXML;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Jugador {
	static Scanner in = new Scanner(System.in);
	private static String nombre;
	private static String apellido;
	private static int edad;
	private static int dorsal;
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
	 public static void grabarJugadorXML(List<Jugador> players) throws ParserConfigurationException, DOMException, TransformerException, IOException {
		 System.out.println("Type the name of the file: ");
		 String file = in.nextLine();
		 String nombreFichero = file+".xml";
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
		 DocumentBuilderFactory docFac = DocumentBuilderFactory.newInstance();
		 
         DocumentBuilder docBuilder = docFac.newDocumentBuilder();
		 
         Document doc = docBuilder.newDocument();
         
         
         // root elements
         
         Element equipo = doc.createElement("Equipo");
         doc.appendChild(equipo);
         
         for(Jugador player : players ) {
        	 Element Jugadors = doc.createElement("Jugador");
             equipo.appendChild(Jugadors);
         // child element
         Element nombreJ = doc.createElement("Nombre");
         nombreJ.setTextContent(nombre);
         Jugadors.appendChild(nombreJ);
         
         // child element
         Element apellidoJ = doc.createElement("Apellido");
         apellidoJ.setTextContent(apellido);
         Jugadors.appendChild(apellidoJ);
         
         // child element
         Element dorsalJ = doc.createElement("Dorsal");
         dorsalJ.setTextContent(String.valueOf(dorsal));
         Jugadors.appendChild(dorsalJ);
         
         // child element
         Element edadJ = doc.createElement("Edad");
         edadJ.setTextContent(String.valueOf(edad));
         Jugadors.appendChild(edadJ);
       
         OutputStream output = new FileOutputStream(ficheroXML);
         writeXml(doc, output);
         }
	 }// grabar jugador

	 // metodo parra escribir doc en stream output
	 public static void writeXml(Document doc, OutputStream output) throws TransformerException {
		 TransformerFactory transformerFactory = TransformerFactory.newInstance();
	      Transformer transformer = transformerFactory.newTransformer();
	      
	      // make XML look orgonized
	     transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	     
	     DOMSource source = new DOMSource(doc);
	     StreamResult result = new StreamResult(output);

	     transformer.transform(source, result);
	 }
	 
	
}//clase

