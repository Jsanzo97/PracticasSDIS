/**
 * Implementacion basica de una conexion tcp, parte del cliente echo
 */
package tcp;

import java.net.*;
import java.io.*;

public class Cliente {
    public static final int PUERTO = 2000;

    public static void main(String[] args) throws IOException {
    	System.out.println("CLIENTE");
    	Reader t1 = new InputStreamReader(System.in);
        BufferedReader inteclado = new BufferedReader(t1);
        String linea = null;
	    
        Socket cliente = new Socket("localhost", PUERTO); /* creación del socket */
   	    
        InputStream in = cliente.getInputStream(); /* entrada socket */
	    Reader r1 = new InputStreamReader(in);
	    BufferedReader inred = new BufferedReader(r1);
	
	    OutputStream out = cliente.getOutputStream(); /* salida socket */
	    PrintStream outred = new PrintStream(out);
	
	    while ((linea = inteclado.readLine()) != null) { /* lee de la red */
	    	outred.println(linea);
	    	linea = inred.readLine();
	    	System.out.println("Recibido: "+linea);
	    	
	    	if (linea.equals("Adios.")){
	    		break;
	    	}
	    }
    }
}