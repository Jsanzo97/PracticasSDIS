/**
 * Implementacion de una conexion tcp con multiples usuarios simultaneos, parte que permite
 * la simultaneidad de los clientes en distintos hilos
 */
package servidorMulti;

import java.net.*;
import java.io.*;
public class Sirviente implements Runnable{
	
	private Socket sock;
	private int num;
	
	public Sirviente(Socket sock, int num) {
		this.sock = sock;
		this.num = num;
	}
	
	public void run(){
		try{
			servicio();
		}catch(IOException ex){
		}
	}

	public void servicio() throws IOException{
		
		InputStream in = sock.getInputStream(); /* entrada socket */
        
        Reader r1 = new InputStreamReader(in);
        PrintStream outred;
        try (BufferedReader inred = new BufferedReader(r1)) {
            OutputStream out = sock.getOutputStream(); /* salida socket */
            outred = new PrintStream(out);
            String linea;
            /* bucle de ECHO */
            while ((linea = inred.readLine()) != null) { /* lee de la red */
                
                System.out.println("Cliente "+num+": "+linea); /* echo por la pantalla */
                outred.println(linea); /* echo al cliente */
                if (linea.equals("Adios."))   {    break;   }
            }
        } /* salida socket */
		
        outred.close();
        outred.close();
	}
}