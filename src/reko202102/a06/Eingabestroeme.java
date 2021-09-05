package aufgabe006;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;
/**
 * Realisieren Sie eine Methode boolean enthaelt(InputStream, Set<Byte>),
 * die angibt, ob der übergebene Eingabestrom alle byte-Werte aus der
 * übergebenen Menge enthält.
 * Deklarieren Sie das Werfen einer Ausnahme,
 * wenn Sie es für erforderlich halten.
 * 
 * Hinweis: Ist der übergebene Eingabestrom unendlich lang, kann die Methode
 * entweder true liefern (falls alle byte-Werte im Eingabestrom vorkommen)
 * oder endlos laufen.
 * Für einen unendlich langen Eingabestrom ist die Antwort false nicht möglich.
 * 
 * Hinweis: Es ist zulässig, die übergebene Menge zu verändern, z.B.
 * indem Sie daraus im Laufe der Verarbeitung byte-Werte entfernen.
 * 
 * public boolean enthaelt(InputStream is, Set<Byte> bytes) {
 */

public class Eingabestroeme {
    /**
     * Groesse des Puffers.
     */
    
    private static final int PUFFERGROESSE = 8;
    /**
     * Überprüft ob beide Eingabeströme gleich sind.
     * @param eingabestrom Der erste zu überprüfende Eingabestrom.
     * @param bytes Menge an Bytes die auf Existenz überprüft werden.
     * @return <code>true</code> Eingabestrom enthält Menge,
     * sonst <code>false</code>.
     * @throws java.io.IOException Ausnahmen bestätigen die Regeln!
     * @throws Error Fehler passieren nun einmal!
     */
    
    public boolean enthaelt(
            InputStream eingabestrom, Set<Byte> bytes)
            throws RuntimeException, IOException {
        /*
        Solange die Menge nicht leer ist, kann das byte im Stream vorkommen!
        */
        boolean enthalten = !bytes.isEmpty();
        /*
        Puffer für Eingabestrom.
        */
        byte[] puffer = new byte[PUFFERGROESSE];
        /*
        Aus Datenquelle lesen.
        */
        int liesBytes = eingabestrom.read(puffer);
        /*
        Das eingelesene Byte aus dem Eingabstrom.
        */
        byte dasEingeleseneByte = (byte) eingabestrom.read();
        /*
        Die Schleife bricht halt sofort ab,
        wenn ein Element nicht in der Menge enthalten ist.
        */
        while (//bytes.contains(eingabestrom.read(puffer))
                //&& enthalten
                enthalten
                && liesBytes > 0) {
            /*
            Liest Bytes aus Datenquelle.
            */
            liesBytes = eingabestrom.read(puffer);
            /*
            Iteriert über die Bytes-Menge
            und liefert das naechste Byte.
            */
            Iterator<Byte> bytesIteartor = bytes.iterator();
            
            if (!bytesIteartor.hasNext()) {
                throw new RuntimeException("Argh" + liesBytes);
                        
//                        "Datenquelle ist kuerzer als "
//                                + liesBytes + " Bytes: " + liesBytes);
            }
            
            while (bytesIteartor.hasNext()) {
                byte naechestesByte = bytesIteartor.next();
                /*
                Vergleich zwischem eingelesenem Byte
                und dem nächsten aus der Menge.
                */
                enthalten = dasEingeleseneByte == naechestesByte;
                /*
                Das Byte aus der Menge entfernen.
                */
                bytes.remove(bytesIteartor.next());
            }
//            if (liesBytes > 0) {
//                throw new RuntimeException(
//                        "Datenquelle ist kuerzer als "
//                                + liesBytes + " Bytes: " + liesBytes);
//            }
        }
        /*
        Die Datenquelle ist kürzer als n Zeichen.
        */
//        if (liesBytes > 0) {
//            throw new RuntimeException(
//                    "Datenquelle ist kuerzer als "
//                            + liesBytes + " Bytes: " + liesBytes);
//        }
        //liesBytes > 0
        return enthalten;
    }
}