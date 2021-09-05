package aufgabe005und006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
/**
 * Realisieren Sie eine Methode sindGleich(Reader, Reader, short), die angibt,
 * ob zwei Zeichenfolgen in ihren n Zeichen (3. Parameter) miteinander
 * übereinstimmen.
 * Ist mindestens eine der Zeichenfolgen kürzer als n, soll die Übereinstimmung
 * auf dem kürzesten Anfangsstück überprüft werden.
 * 
 * Deklarieren Sie das Werfen von Ausnahmen,
 * wenn Sie es für erforderlich halten.
 * 
 * public boolean sindGleich(Reader r1, Reader r2, short n) {
 */

public class ReaderVergleicher {
    /**
     * Groesse des Puffers.
     */
    
    private static final int PUFFERGROESSE = 8;
    /**
     * Überprüft ob beide Eingabeströme gleich sind.
     * @param quelle1 Der erste zu überprüfende Eingabestrom.
     * @param quelle2 Der zweite zu überprüfende Eingabestrom.
     * @param n Die Länge auf deren Grundlage die Ströme geprüft werden.
     * @return <code>true</code>, wenn beide Ströme gleich,
     * sonst <code>false</code>.
     * @throws IOException Bei Unfällen, tritt die Ausnahme auf.
     */
    
    public boolean sindGleich(
            Reader quelle1, Reader quelle2, short n) throws IOException{
        /*
        Gepuffte Zeichenleser.
        */
        BufferedReader zeichenleser1 = new BufferedReader(quelle1);
        BufferedReader zeichenleser2 = new BufferedReader(quelle2);
        /*
        Indikator für Gleichheit der beiden Eingabeströme.
        */
        boolean sindGleich = true;
        int anzahl1;
        int anzahl2;
        /*
        Anzahl der bisher jeweils aus den beiden Datenquellen gelesenen Bytes.
        */
        long geleseneBytesInsgesamt = 0;
        /*
        Erter Puffer für ersten Eingabestrom.
        */
        char[] puffer1 = new char[PUFFERGROESSE];
        /*
        Zweiter Puffer für zweiten Eingabestrom.
        */
        char[] puffer2 = new char[PUFFERGROESSE];
        /*
        Aus Datenquelle lesen und berechnen, wie viele der gelesenen Bytes
        maximal verglichen werden können.
        */
        anzahl1 = zeichenleser1.read(puffer1);
        anzahl2 = zeichenleser2.read(puffer2);
        int geleseneBytes = Math.max(anzahl1,anzahl2);
        sindGleich = anzahl1 == anzahl2;
        /*
        Beide Eingabeströme sind mindestens n Bytes lang
        und stimmen in den Folgen ihrer jeweils ersten n Bytes überein.
        */
        while (geleseneBytes > 0 && geleseneBytesInsgesamt < n) {
            /*
            Berechnen, wie viele Bytes aus dem letzten Ladevorgang
            verglichen werden muessen.
            */
            int anzahl = (int) Math.min(
                    geleseneBytes, n - geleseneBytesInsgesamt);
            int i = 0;
            /*
            Beide Eingabeströme sind gleich lang,
            die Länge ist jedoch kürzer als n Bytes,
            und sie stimmen in ihren Bytefolgen überein.
            */
            while (i < anzahl && puffer1[i] == puffer2[i]) {
                i++;
            }
            sindGleich = sindGleich && (i == anzahl);
            
            geleseneBytesInsgesamt = geleseneBytesInsgesamt + geleseneBytes;
            geleseneBytes = Math.min(
                    quelle1.read(puffer1), quelle2.read(puffer2)
            );
        }
        /*
        Die Datenquelle ist kürzer als n Zeichen.
        */
        if (geleseneBytesInsgesamt < n) {
            throw new RuntimeException(
                    "Datenquelle ist kuerzer als "
                            + n + " Bytes: " + geleseneBytesInsgesamt);
        }
        return sindGleich;
    }
}