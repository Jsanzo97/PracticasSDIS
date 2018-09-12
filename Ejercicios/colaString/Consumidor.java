/**
 * Clase que imprime los Strings leidos por el productor
 * @author Jorge
 */

package colaString;

public class Consumidor implements Runnable {
    private final ColaStrings cola ;

    public Consumidor(ColaStrings c) {
        this.cola = c;
    }

    public void run() {
        String linea;

        while (true) {
            linea = cola.pop();
            System.out.println(">> " + linea); // imprime
        }
    }
}
