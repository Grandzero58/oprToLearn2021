package aufgabe007;

import aufgabe007.ReaderTokenizer;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
/**
 * Testet den ReaderTokenizer hinsichtlich seiner korrekten Funktionalität.
 * Realisieren Sie eine Testklasse ReaderTokenizerTest mit zwei Testfällen für
 * die Methode gibWoerter.
 * Für beide Testfälle soll der Reader den Zeichenstrom Viel Erfolg bei OPR.
 * enthalten.
 * Im ersten Testfall sind die Trenner ". " (Punkt und Leerzeichen).
 * Erwartet werden die vier Wörter des Textes.
 * Im zweiten Testfall sind die Trenner ".,!".
 * Das Leerzeichen ist somit kein Trenner.
 */

public class ReaderTokenizerTest {
    /**
     * Der zu testende ReaderTokenizer.
     */
    
    ReaderTokenizer separator;
    /**
     * Realisieren Sie eine Testklasse ReaderTokenizerTest mit zwei Testfällen
     * für die Methode gibWoerter.
     * Für beide Testfälle soll der Reader den Zeichenstrom
     * "Viel Erfolg bei OPR." enthalten.
     * Im ersten Testfall sind die Trenner ". " (Punkt und Leerzeichen).
     * Erwartet werden die vier Wörter des Textes.
     * @throws IOException Läuft etwas nicht richtig kommt es zur Ausnahme.
     */
    
    @Test
    public void testeMethodeGibWoerter1() throws IOException {
        String datenquelle = "Viel Erfolg bei OPR.";
        separator = new ReaderTokenizer(
                new StringReader(datenquelle), ". ");
        Set<String> testErgebnis = new HashSet();
        testErgebnis.add(datenquelle);
        assertEquals(testErgebnis, separator.gibWoerter());
    }
    /**
     * Realisieren Sie eine Testklasse ReaderTokenizerTest mit zwei Testfällen
     * für die Methode gibWoerter.
     * Für beide Testfälle soll der Reader den Zeichenstrom
     * "Viel Erfolg bei OPR." enthalten.
     * Im ersten Testfall sind die Trenner ". " (Punkt und Leerzeichen).
     * Erwartet werden die vier Wörter des Textes.
     * Im zweiten Testfall sind die Trenner ".,!".
     * Das Leerzeichen ist somit kein Trenner.
     * @throws IOException Läuft etwas nicht richtig kommt es zur Ausnahme.
     */
    
//    @Test
//    public void testeMethodeGibWoerter2() throws IOException {
//        String datenquelle = "Viel Erfolg bei OPR.";
//        separator = new ReaderTokenizer(
//                new StringReader(datenquelle), ". ");
//        Set<String> testErgebnis = new HashSet();
//        assertEquals(testErgebnis, separator.gibWoerter());
//    }
}