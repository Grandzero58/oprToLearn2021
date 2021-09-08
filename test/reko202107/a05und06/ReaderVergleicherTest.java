package aufgabe005und006;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
/**
 * Testklasse mit relevanten Testfällen.
 * Realisieren Sie eine setUp-Methode, die sinnvoll zum Test der Methode
 * sindGleich aus der vorherigen verwendet werden kann.
 * Ergänzen Sie dafür das unten stehende Codestück an den...-Stellen.
 * 
 * In der Methode sollen zwei Reader definiert werden,
 * die folgende Eigenschaften besitzen:
 * 
 * • Die Zeichenfolgen der Reader haben mindestens die Länge 10.
 * 
 * • Das erwartete Ergebnis für den Vergleich der ersten 8 Zeichen ist true,
 * für den Vergleich der ersten 9 Zeichen false.
 */

public class ReaderVergleicherTest {
    /**
     * Erster Eingabestrom zum Vergleichen.
     */
    
    private InputStream eingabequelle1;
    /**
     * Zweiter Eingabestrom zum Vergleichen.
     */
    
    private InputStream eingabequelle2;
    /**
     * Dritter Eingabestrom zum Vergleichen.
     */
    
    private InputStream eingabequelle3;
    /**
     * Vierter Eingabestrom zum Vergleichen.
     */
    
    private InputStream eingabequelle4;
    /**
     * Vorbereitung des Eingabestrom-Vergleichers für die Tests.
     */
    
    @Before
    public void setUp() {
        eingabequelle1 = new ByteArrayInputStream(new byte[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        });
        eingabequelle2 = new ByteArrayInputStream(new byte[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        });
        eingabequelle3 = new ByteArrayInputStream(new byte[] {
            '0', '1', '2'
        });
        eingabequelle4 = new ByteArrayInputStream(new byte[] {
            '3', '4', '5', '6', '7', '9', '0'
        });
    }
    /**
     * Testfall 1 für gleiche Eingabeströme mit gleichem Inhalt.
     * @throws IOException im Ausnahme-Fall.
     */
    
    @Test
    public void testeSindGleichBeiGleichenEingabestroemen02()
            throws IOException {
        assertTrue(
                ReaderVergleicher.sindGleich(
                        new InputStreamReader(eingabequelle1),
                        new InputStreamReader(eingabequelle2), (short) 8));
    }
    /**
     * Testfall 2 für ungleiche Eingabeströme mit unterschiedlichem Inhalt.
     * @throws IOException im im Ausnahme-Fall.
     */
    
    @Test
    public void testeNichtGleichBeiUnterschiedlichenGleichenEingabestroemen01()
            throws IOException {
        try {
            assertFalse(
                    ReaderVergleicher.sindGleich(
                            new InputStreamReader(eingabequelle3),
                        new InputStreamReader(eingabequelle4), (short) 9));
            fail("Es wurde keine Ausnahme geworfen!");
        } catch (RuntimeException exc) {
            assertEquals(
                    "Datenquelle ist kuerzer als 9 Bytes. 7", exc.getMessage());
        }
    }
}
