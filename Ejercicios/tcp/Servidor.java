/**
 * Implementacion basica de una comuniccion tcp, parte del servidor echo
 */
package tcp;

import java.net.*;
import java.io.*;

public class Servidor {
    public static final int PUERTO = 2000;

    public static void main(String[] args) throws IOException {
    	System.out.println("SERVIDOR");
        
    	ServerSocket servidor = new ServerSocket(PUERTO); /* creación del socket */
    	Socket sock = servidor.accept();
        
    	System.out.println("Conectado!");
    	
    	InputStream in = sock.getInputStream(); /* entrada socket */
        Reader r1 = new InputStreamReader(in);
        BufferedReader inred = new BufferedReader(r1);
        
        OutputStream out = sock.getOutputStream(); /* salida socket */
        PrintStream outred = new PrintStream(out);
        
        String linea;
        
        while ((linea = inred.readLine()) != null) { /* lee de la red */
            System.out.println("Echoing: "+linea); /* echo por la pantalla */
            outred.println(linea); /* echo al cliente */
            if (linea.equals("Adios.")){
            	break;
            }
        }
    } 
}

