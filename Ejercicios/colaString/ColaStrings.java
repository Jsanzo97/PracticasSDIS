/**
 * Clase que implementa una cola donde se guardan los String del productor y de donde
 * los consume el consumidor
 * @author Jorge
 */

package colaString;

import java.util.*;

public class ColaStrings {

    private List<String> lista = new ArrayList<String>();

    public synchronized void push(final String p) {
    	System.out.println("String introducido");
        lista.add(p);
        this.notify(); // hace saber que ha llegado un String
    }

    public synchronized String pop() {
    	System.out.println("Esperando string");
        while (lista.size() == 0)
            try { 
            	this.wait(); // espera la llegada de un String
            	System.out.println("String consumido");
            } catch (final InterruptedException e) { }
        return lista.remove(0);
    }
}

