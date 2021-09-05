package aufgabe006;

import aufgabe006.Eingabestroeme;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Ignore;
/**
 * Testfälle!
 */

public class EingabestroemeTest {
    /**
     * Der Eingabestrom-Vergleicher für Eingabestrom-Vergleiche.
     */
    
    private Eingabestroeme vergleicher;
    /**
     * Eingabestrom zum Testen.
     */
    
    private InputStream eingabequelle;
    /**
     * Eingabestrom zum Testen.
     */
    
    private InputStream eingabequelle2;
    /**
     * Speichert alle Bytes in einer Menge.
     */
    
    private Set<Byte> vieleBytes;
    /**
     * Vorbereitung des Eingabestrom-Vergleichers für die Tests.
     */
    
    @Before
    public void setUp() {
        vergleicher = new Eingabestroeme();
        
        eingabequelle = new ByteArrayInputStream(new byte[] {
            'b', 'e', 'r', 'g', '-', '-', 'B', 'e', 'r', 'g', '2', '-', '-',
            'b', 'e', 'r', 'g', '-', '-', 'B', 'e', 'r', 'g', '-', '-', '2',
            'B', 'e', 'r', 'g', '-', '-', 'B', 'e', 'r', 'g', '-', '-', 'B',
            'e', 'r', '-', '-', 'B', 'e', 'r', 'g', '1', 'b', 'e', 'r', 'g',
            '-', '-', 'B', 'e', 'r', 'g', '2', '-', '-', 'b', 'e', 'r', 'g',
            '-', '-', 'B', 'e', 'r', 'g', '-', '-', '2', 'B', 'e', 'r', 'g',
            '-','-', 'B', 'e', 'r', 'g', '-', '-', 'B', 'e', 'r', '-', '-',
            'B', 'e', 'r', 'g', '1', 'b', 'e', 'r', 'g', '-', '-', 'B', 'e',
            'r', 'g', '2', '-', '-', 'b', 'e', 'r', 'g', '-', '-', 'B', 'e',
            'r', 'g', '-', '-', '2', 'B', 'e', 'r', 'g', '-', '-', 'B', 'e',
            'r', 'g', '-', '-', 'B', 'e', 'r', '-', '-', 'B', 'e', 'r', 'g',
            '1'
        });
        eingabequelle2 = new ByteArrayInputStream(new byte[] {});
//        byte[] bytesFuerDieMenge = new byte[] {
//            'b', 'e', 'r', 'g', '-', '-', 'B', 'e', 'r', 'g', '2', '-', '-',
//            'b', 'e', 'r', 'g', '-', '-', 'B', 'e', 'r', 'g', '-', '-', '2',
//            'B', 'e', 'r', 'g', '-', '-', 'B', 'e', 'r', 'g', '-', '-', 'B',
//            'e', 'r', '-', '-', 'B', 'e', 'r', 'g', '1', 'b', 'e', 'r', 'g',
//            '-', '-', 'B', 'e', 'r', 'g', '2', '-', '-', 'b', 'e', 'r', 'g',
//            '-', '-', 'B', 'e', 'r', 'g', '-', '-', '2', 'B', 'e', 'r', 'g',
//            '-','-', 'B', 'e', 'r', 'g', '-', '-', 'B', 'e', 'r', '-', '-',
//            'B', 'e', 'r', 'g', '1', 'b', 'e', 'r', 'g', '-', '-', 'B', 'e',
//            'r', 'g', '2', '-', '-', 'b', 'e', 'r', 'g', '-', '-', 'B', 'e',
//            'r', 'g', '-', '-', '2', 'B', 'e', 'r', 'g', '-', '-', 'B', 'e',
//            'r', 'g', '-', '-', 'B', 'e', 'r', '-', '-', 'B', 'e', 'r', 'g',
//            '1'
//        };
        byte[] bytesFuerDieMenge = new byte[] {
            'A', 'l', 'g', '-', '-', 'B', 'r', 'z', 'j',
        };
        /*
        Vorbereitung der Menge für die Tests.
        */
        this.vieleBytes = new HashSet();
        for (int i = 0; i < bytesFuerDieMenge.length; i++) {
            vieleBytes.add(bytesFuerDieMenge[i]);
        }
    }
    /**
     * Alles funktionert!
     * @throws IOException Mist!
     */
    
    @Test
    public void testeMethodeEnthaelt() throws IOException {
        assertTrue(vergleicher.enthaelt(eingabequelle, vieleBytes));
    }
    /**
     * Alles funktionert!
     * @throws IOException Mist!
     */
    
    /**
     * Testfall 10 für ungleiche Eingabeströme mit unterschiedlichem Inhalt.
     * Es wird das Werfen einer RuntimeException getestet.
     * @throws IOException Ausnahme im Unfäll-Fall.
     */
    
    @Ignore
    public void testeWerfenEinerRuntimeException05() throws IOException {
        try {
            assertNull(vergleicher.enthaelt(eingabequelle2, vieleBytes));
            //fail("Es wurde keine Ausnahme geworfen!");
        } catch (RuntimeException exc) {
            //assertEquals("Pferd", exc.getMessage());
//            assertEquals("Datenquelle ist kuerzer als 0"
//                    + " Bytes: 8", exc.getMessage());
        }
    }
}