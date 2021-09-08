package aufgabe004;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/**
 * Testklasse mit vier relevanten Testfällen.
 */

public class StreamInfoTest {
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
     * Vorbereitung des Eingabestrom-Vergleichers für die Tests.
     */
    
    @Before
    public void setUp() {
        eingabequelle1 = new ByteArrayInputStream(new byte[] {
            10, 9, 8, 7, 6, 5, 4, 3, 2, 1
        });
        eingabequelle2 = new ByteArrayInputStream(new byte[] {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        });
        eingabequelle3 = new ByteArrayInputStream(new byte[] {
            0, 3, 0
        });
    }
    /**
     * Testfall 1 für Eingabestrom mit Länge 10.
     * @throws IOException Ausnahme im Unfäll-Fall.
     */
    
    @Test
    public void testeQuersumme01() throws IOException {
        assertEquals(55, StreamInfo.quersumme(eingabequelle1, 10));
    }
    /**
     * Testfall 2 für Eingabestrom mit Länge 10.
     * @throws IOException Ausnahme im Unfäll-Fall.
     */
    
    @Test
    public void testeQuersumme02() throws IOException {
        assertEquals(55, StreamInfo.quersumme(eingabequelle2, 10));
    }
    /**
     * Testfall 3 für Eingabestrom mit Länge 10.
     * @throws IOException Ausnahme im Unfäll-Fall.
     */
    
    @Test
    public void testeQuersumme03() throws IOException {
        assertEquals(3, StreamInfo.quersumme(eingabequelle3, 3));
    }
    /**
     * Testfall 4 für Eingabestrom mit Länge 3.
     * @throws IOException Ausnahme im Unfäll-Fall.
     */
    
    @Test
    public void testeQuersumme04() throws IOException {
        /*
        Getestet wird das werfen einer Exception im Falle
        einer zu kurzen Datenquelle.
        */
        try {
            StreamInfo.quersumme(eingabequelle3, 2);
            fail("Es wurde keine Ausnahme geworfen.");
        } catch (RuntimeException exc) {
            assertEquals("Stream ist zu kurz.", exc.getMessage());
        }
    }
}