package aufgabe010;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/*
3. Der Aufzählungstyp besitzt eine Instanzmethode double in(Zeiteinheit),
durch die eine Zeiteinheit angeben kann, wie groß sie in der übergebenen Einheit
ist. Der Ausdruck
STUNDE.in(MINUTE) soll z.B. den Wert 60.0 liefern. Der Ausdruck
MINUTE.in(STUNDE) soll 0.01666667 liefern, denn eine Minute ist 1/60
einer Stunde.
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
        Double wert = 60d;
        assertEquals(wert, stunde.in(minute), 0.0);
    }
    /**
     * Testet: MINUTE.in(STUNDE).
     * Der Ausdruck MINUTE.in(STUNDE) soll 0.01666667 liefern,
     * denn eine Minute ist 1/60
     */
    
    @Test
    public void testMinuteInStunden() {
        Double wert = 0.016666666666666666;
        assertEquals(wert, minute.in(stunde), 0.0);
    }
}