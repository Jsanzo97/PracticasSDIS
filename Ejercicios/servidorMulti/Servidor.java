/**
 * Implementacion de una conexion tcp con multiples usuarios simultaneos, parte del servidor
 */
package servidorMulti;

import java.net.*;
import java.io.*;

public class Servidor {
    public static final int PUERTO = 2000;
    public static int num=0;
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(PUERTO); /* creación del socket */

        for (;;) {
            
                System.out.println("----Servidor aceptando conexiones----");
                try {
                	Socket sock = servidor.accept();
                    /********************************************
                     * Zona de servicio.
                     */
                	num++;
                    Runnable service = new Sirviente(sock, num);
                    new Thread(service).start();
                    System.out.println("Cliente "+num+" aceptado");
                    /********************************************
                     * Fin de la zona de servicio
                     */
                
                } catch (Exception e) {
                	e.printStackTrace(System.err);
                }      	             
        }
    }
}


