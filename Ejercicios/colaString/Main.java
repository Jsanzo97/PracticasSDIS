/**
 * Crea la cola, el productor y el consumidor
 * @author cllamas
 */

package colaString;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ColaStrings cola = new ColaStrings() ;
        Runnable genera = new Productor(cola) ;
        Runnable come = new Consumidor(cola) ;

        new Thread(genera).start();
        new Thread(come).start();

    }

}