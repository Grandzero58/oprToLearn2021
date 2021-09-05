package aufgabe004;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Realisieren Sie eine Klasse Zeitdauer.
 * Die Klasse soll einen Konstruktor Zeitdauer(int, int) besitzen, um ein Objekt
 * der Klasse durch Angabe einer Anzahl Stunden (1. Parameter) und einer
 * Anzahl Minuten (2. Parameter) zu erzeugen.
 * 
 * Die Klasse soll folgende Anforderungen erfüllen:
 * 
 * 1. Es sollen sich Objekte genau dann erzeugen lassen, wenn die Werte
 * beider Parameter größer oder gleich 0 sind.
 * 
 * 2. Ein HashSet<Zeitdauer> enthält niemals zwei Objekte, die die gleiche
 * Zeitdauer repräsentieren. Beispiel: 1 Stunde und 100 Minuten sind die gleiche
 * Zeitdauer wie 2 Stunden und 40 Minuten.
 * @author tut hier nichts zur Sache
 */

public class ZeitdauerTest {
    /**
     * Eine gültige aber kleine Zeitdauer für Tests.
     */
    
    Zeitdauer zd;
    /**
     * Eine gültige Zeitdauer für Tests.
     */
    
    Zeitdauer zeitdauer01;
    /**
     * Eine zweite gültige Zeitdauer für Tests.
     */
    
    Zeitdauer zeitdauer02;
    /**
     * Eine unzulässige Zeitdauer für Exception-Tests.
     */
    
    Zeitdauer zdFalsch;
    /**
     * 
     */
    @Before
    public void setUp() {
        zd = new Zeitdauer(0, 0);
        zeitdauer01 = new Zeitdauer(1, 100);
        zeitdauer02 = new Zeitdauer(2, 40);
    }
    @Test
    public void testeGleichheit1() {
        assertEquals(zeitdauer01.equals(zeitdauer02),
                zeitdauer02.equals(zeitdauer01));
    }
    @Test
    public void testeGleichheit2() throws RuntimeException {
        assertFalse(zeitdauer01.equals(zd));
    }
    @Test
    public void testeIllegalArgumentException() throws IllegalArgumentException{
        //Problem konkurrierender Exceptions!!!
        try {
            zdFalsch = new Zeitdauer(-1, -1);
        } catch (RuntimeException exc) {
            assertNull(exc.getMessage());
        }
    }
}