package aufgabe007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
/**
* Ein ReaderTokenizer zerlegt den Inhalt einer endlichen, zeichen-
* orientierten Datenquelle in einzelne Wörter. Die Zerlegung erfolgt
* anhand der Trennzeichen, die im Konstruktor dieser Klasse übergeben werden.
*/

public class ReaderTokenizer {
    /**
     * 
     */
    
    private final BufferedReader gepuffterLeser;
    /**
     * Trennzeichen werden der besseren Effizienz wegen in einem HashSet
     * verwaltet.
     */
    
    private final HashSet<Character> alleTrennzeichen;
    /**
     * 
     */
    
    private int dasZeichen;
    /**
     * Erzeugt ein Objekt dieser Klasse für den übergebenen Reader und
     * die übergebenen Trennzeichen.
     * @param einReader Reader, dessen Zeichenstrom in Wörter zerlegt wird.
     * Es wird vorausgesetzt, dass der Zeichenstrom endlich ist.
     * @param trennzeichen Jedes Zeichen dieser Zeichenkette ist ein
     * Trenner (analog zu Trennzeichen bei StringTokenizer).
     * @throws java.io.IOException
     */
    
    public ReaderTokenizer(
            Reader einReader, String trennzeichen) throws IOException {
        
        this.gepuffterLeser = new BufferedReader(einReader);
        /*
        Liest zeichenweise aus der Datenquelle.
        */
        dasZeichen = einReader.read();
        
        this.alleTrennzeichen = new HashSet<>();
        for (int i = 0; i < trennzeichen.length(); i++) {
            this.alleTrennzeichen.add(trennzeichen.charAt(i));
        }
    }
    /**
     * 
     * @return
     * @throws IOException 
     */
    
    public String gibNaechstesWort() throws IOException {
        
        if (!hatNochZeichen()) {
            throw new NoSuchElementException();
        }
        
        String token = String.valueOf((char) dasZeichen);
        dasZeichen = gepuffterLeser.read();
        
        while (dasZeichen != -1
                && !alleTrennzeichen.contains((char) dasZeichen)) {
            
            token = token + (char) dasZeichen;
            dasZeichen = gepuffterLeser.read();
        }
        return token;
    }
    /**
     * 
     * @return
     * @throws IOException 
     */
    
    public boolean hatNochZeichen() throws IOException {
        while (dasZeichen != -1 && alleTrennzeichen.contains((char) dasZeichen)) {
            dasZeichen = gepuffterLeser.read();
        }
        return dasZeichen != -1;
    }
    /**
     * Liefert die Wörter des Zeichenstroms.
     * @return Alle gültigen Wörter des Zeichenstroms.
     * @throws java.io.IOException im Extremfall.
     */
    
    public Set<String> gibWoerter() throws IOException {
        Set<String> gibWoerter = new HashSet();
        String wort = "";
        while (hatNochZeichen()) {
            gibWoerter.add(gibNaechstesWort());
        }
        return gibWoerter;
    }
}