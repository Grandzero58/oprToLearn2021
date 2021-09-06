package aufgabe007;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Erstellen Sie den Aufzählungstyp Zeiteinheit mit folgenden Anforderungen:
 * – Der Typ enthält TAG, STUNDE, MINUTE und SEKUNDE . (5 P)
 * – Der Typ enthält TAG, STUNDE, MINUTE und SEKUNDE und Zeiteinheit hat die
 * Instanzmethode int sekunden(), keine Fallunterscheidung ( if-else / switch )!
 * Beispiel: STUNDE.sekunden() soll 3600 ergeben. (5 P)
 */

public class ZeiteinheitTest {
    /**
     * Stunde einer Zeiteinheit.
     */
    
    private Zeiteinheit stunde;
    /**
     * Minute einer Zeiteinheit.
     */
    
    private Zeiteinheit minute;
    /**
     * Testdaten aufbauen.
     */
    
    @Before
    public void setUp() {
        stunde = Zeiteinheit.STUNDE;
        minute = Zeiteinheit.MINUTE;
    }
    /**
     * Testet: STUNDE.in(MINUTE).
     * Der Ausdruck STUNDE.in(MINUTE) soll z.B. den Wert 60.0 liefern.
     */
    
    @Test
    public void testStundeInMinuten() {
        assertEquals(3600, Zeiteinheit.STUNDE.sekunden());
    }
}