/**
 * Ejemplo basico de uso de un hilo paralelo al programa principal
 */
package ejercicioReloj;

public class RelojHilos implements Runnable{
	
	public void run() {
		while (true) {
			System.out.println(new java.util.Date());
	        try {
	        	Thread.sleep(1000); 
	        }catch (InterruptedException x) {
	        	
	        }
	    }
	}

	public static void main(String[ ] args) {
		Runnable tarea = new RelojHilos();
	    new Thread(tarea, "Hilo de TimePrinter").start();
	}
}

