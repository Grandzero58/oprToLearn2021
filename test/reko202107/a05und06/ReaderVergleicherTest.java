package aufgabe005und006;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
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
     * Der Eingabestrom-Vergleicher für Eingabestrom-Vergleiche.
     */
    
    private ReaderVergleicher vergleicher;
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
        vergleicher = new ReaderVergleicher();
        
        eingabequelle1 = new ByteArrayInputStream(new byte[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        });
        eingabequelle2 = new ByteArrayInputStream(new byte[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        });
        eingabequelle3 = new ByteArrayInputStream(new byte[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '9', '0'
        });
        eingabequelle4 = new ByteArrayInputStream(new byte[] {});
    }
    
    /**
     * Testfall 1 für gleiche Eingabeströme mit Zahlenfolge.
     * @throws IOException Ausnahme im Unfäll-Fall.
     */
    
    @Test
    public void testeSindGleichBeiGleichenEingabestroemen01()
            throws IOException {
        assertTrue(
                vergleicher.sindGleich(new InputStreamReader(eingabequelle1),
                        new InputStreamReader(eingabequelle2), (short) 5));
    }
    /**
     * Testfall 2 für gleiche Eingabeströme mit Zeichenfolge.
     * @throws IOException Ausnahme im Unfäll-Fall.
     */
    
    @Test
    public void testeSindGleichBeiGleichenEingabestroemen02()
            throws IOException {
        assertTrue(
                vergleicher.sindGleich(new InputStreamReader(eingabequelle1),
                        new InputStreamReader(eingabequelle2), (short) 7));
    }
    /**
     * Testfall 3 für ungleiche Eingabeströme mit unterschiedlichem Inhalt.
     * @throws IOException Ausnahme im Unfäll-Fall.
     */
    
    @Test
    public void testeNichtGleichBeiUnterschiedlichenGleichenEingabestroemen01()
            throws IOException {
        try {
            assertFalse(
                vergleicher.sindGleich(new InputStreamReader(eingabequelle2),
                        new InputStreamReader(eingabequelle3), (short) 9));
            fail("Es wurde keine Ausnahme geworfen!");
        } catch (RuntimeException exc) {
            assertEquals("Datenquelle ist kuerzer als 9"
                    + " Bytes: 8", exc.getMessage());
        }
    }
    /**
     * Testfall 4 für ungleiche Eingabeströme mit unterschiedlichem Inhalt.
     * @throws IOException Ausnahme im Unfäll-Fall.
     */
    
    @Test
    public void testeNichtGleichBeiUnterschiedlichenGleichenEingabestroemen02()
            throws IOException {
        try {
            assertFalse(
                vergleicher.sindGleich(new InputStreamReader(eingabequelle1),
                        new InputStreamReader(eingabequelle3), (short) 9));
            fail("Es wurde keine Ausnahme geworfen!");
        } catch (RuntimeException exc) {
            assertEquals("Datenquelle ist kuerzer als 9"
                    + " Bytes: 8", exc.getMessage());
        }
    }
    /**
     * Testfall 5 für ungleiche Eingabeströme mit unterschiedlichem Inhalt.
     * Es wird das Werfen einer RuntimeException getestet.
     * @throws IOException Ausnahme im Unfäll-Fall.
     */
    
    @Test
    public void testeWerfenEinerRuntimeException01() throws IOException {
        try {
            vergleicher.sindGleich(new InputStreamReader(eingabequelle1),
                        new InputStreamReader(eingabequelle4), (short) 10);
            fail("Es wurde keine Ausnahme geworfen!");
        } catch (RuntimeException exc) {
            assertEquals("Datenquelle ist kuerzer als 10"
                    + " Bytes: 8", exc.getMessage());
        }
    }
    /**
     * Testfall 6 für ungleiche Eingabeströme mit unterschiedlichem Inhalt.
     * Es wird das Werfen einer RuntimeException getestet.
     * @throws IOException Ausnahme im Unfäll-Fall.
     */
    
    @Test
    public void testeWerfenEinerRuntimeException02() throws IOException {
        try {
            vergleicher.sindGleich(new InputStreamReader(eingabequelle1),
                        new InputStreamReader(eingabequelle3), (short) 10);
            fail("Es wurde keine Ausnahme geworfen!");
        } catch (RuntimeException exc) {
            assertEquals("Datenquelle ist kuerzer als 10"
                    + " Bytes: 8", exc.getMessage());
        }
    }
    /**
     * Testfall 9 für ungleiche Eingabeströme mit unterschiedlichem Inhalt.
     * @throws IOException Ausnahme im Unfäll-Fall.
     */
    
    @Test
    public void testeWerfenEinerRuntimeException04() throws IOException {
        try {
            Reader r1 = new InputStreamReader(eingabequelle2);
            Reader r2 = new InputStreamReader(eingabequelle1);
            vergleicher.sindGleich(r1, r2, (short) 9);
            fail("Es wurde keine Ausnahme geworfen!");
        } catch (RuntimeException exc) {
            assertEquals("Datenquelle ist kuerzer als 9"
                    + " Bytes: 8", exc.getMessage());
        }
    }
    /**
     * Testfall 10 für ungleiche Eingabeströme mit unterschiedlichem Inhalt.
     * Es wird das Werfen einer RuntimeException getestet.
     * @throws IOException Ausnahme im Unfäll-Fall.
     */
    
    @Test
    public void testeWerfenEinerRuntimeException05() throws IOException {
        try {
            Reader r1 = new InputStreamReader(eingabequelle1);
            Reader r2 = new InputStreamReader(eingabequelle2);
            vergleicher.sindGleich(r1, r2, (short) 10);
            fail("Es wurde keine Ausnahme geworfen!");
        } catch (RuntimeException exc) {
            assertEquals("Datenquelle ist kuerzer als 10"
                    + " Bytes: 8", exc.getMessage());
        }
    }
}