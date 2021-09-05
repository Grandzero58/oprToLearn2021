package aufgabe008;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
/**
 * Bei Auswertung des Ausdrucks "Haus".charAt(4) kommt es zu einer
 * StringIndexOutOfBoundsException.
 * Die Meldung dieser Ausnahme ist String index out of range: 4.
 * 
 * Realisieren Sie einen JUnit-Testfall (d.h. eine Testmethode), der genau
 * das überprüft. Der Testfall soll erfolgreich sein, wenn bei Auswertung
 * des Ausdrucks die Ausnahme mit der angegebenen Meldung auftritt.
 * Der Testfall soll scheitern, wenn dies nicht der Fall ist.
 * Sie können sich in dieser Aufgabe rein auf die Testmethode konzentrieren.
 * Das public class ...drum herum denken wir uns.
 * @author fibo
 */
public class StringTest {
    @Test
    public void testStringIndexOutOfRange() {
        try {
            "Haus".charAt(4);
            fail("Es wurde keine Ausnahme geworfen.");
        } catch (IndexOutOfBoundsException exc) {
            assertEquals("String index out of range: 4", exc.getMessage());
        }
    }
}