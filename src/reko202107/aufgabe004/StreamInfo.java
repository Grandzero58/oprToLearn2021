package aufgabe004;

import java.io.IOException;
import java.io.InputStream;
/**
 * Quersummen-Funktion mit Eingabestrom realisiert.
 * Addiert alle Bytes eines InputStreams auf.
 * Sonst wird eine IOException mit Nachricht:
 * "Stream ist zu kurz", wenn der InputStream kürzer ist als n bytes, geworfen.
 */

public class StreamInfo {
    /**
     * Groesse des Puffers.
     */
    
    private static final int PUFFERGROESSE = 8;
    /**
     * Addiert alle Bytes eines InputStreams auf.
     * @param eingabestrom Ein InputStream, dessen bytes addiert werden.
     * @param n Die Anzahl der zu lesenden Bytes.
     * @return Die Summe aller Byte-Werte.
     * @throws IOException mit Nachricht
     * "Stream ist zu kurz", wenn der InputStream kürzer ist als n bytes.
     */
    
    public static long quersumme(
            InputStream eingabestrom, int n) throws IOException {
        /*
        Puffer für's Lesen aus dem Eingabestrom.
        */
        byte[] puffer = new byte[PUFFERGROESSE];
        
        long summeInsgesamt = 0;
        /*
        Obergrenze damit Werte beim Iterieren nicht doppelt gezaehlt werden.
        */
        int obergrenze = eingabestrom.read(puffer);
        
        while (obergrenze != -1) {
            
            for (int i = 0; i < obergrenze; i = i + 1) {
                summeInsgesamt = summeInsgesamt + puffer[i];
            }
            obergrenze = eingabestrom.read(puffer);
        }
        return summeInsgesamt;
    }
}