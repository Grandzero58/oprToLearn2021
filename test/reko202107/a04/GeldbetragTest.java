package aufgabe004;

import reko202107.a04_HashMap.Geldbetrag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
/**
 * Gegeben sei die Klasse Geldbetrag,
 * deren Objekte Geldbeträge in bestimmten Währungen repräsentieren.
 * Beispiele: new Geldbetrag("EUR", 12.75) repräsentiert 12,75 Euro.
 * new Geldbetrag("CHF", 20_000) repräsentiert 20.000,- Schweizer Franken.
 */

public class GeldbetragTest {
    /**
     * 
     */
    
    private Geldbetrag geldbetragEUR1;
    /**
     * 
     */
    
    private Geldbetrag geldbetragEUR2;
    /**
     * 
     */
    
    private Geldbetrag geldbetragEUR3;
    /**
     * 
     */
    
    private Geldbetrag fraenkli01;
    /**
     * 
     */
    
    private Geldbetrag fraenkli02;
    /**
     * 
     */
    
    private Geldbetrag fraenkli03;
    /**
     * 
     */
    
    @Before
    public void setUp() {
        geldbetragEUR1 = new Geldbetrag("EUR", 12);
        geldbetragEUR2 = new Geldbetrag("EUR", 8);
        geldbetragEUR3 = new Geldbetrag("EUR", 30);
        fraenkli01 = new Geldbetrag("CHF", 12);
        fraenkli02 = new Geldbetrag("CHF", 8);
        fraenkli03 = new Geldbetrag("CHF", 30);
    }
    /**
     * Test der Methode summiere() der Klasse Geldbetrag.
     */
    
    @Test
    public void testeSummiere() {
        Collection<Geldbetrag> betraege = new ArrayList();
        betraege.add(geldbetragEUR1);
        betraege.add(geldbetragEUR2);
        betraege.add(geldbetragEUR3);
        betraege.add(fraenkli01);
        betraege.add(fraenkli02);
        betraege.add(fraenkli03);
        //Geldbetrag.summiere(betraege);
        
        HashMap<String, Double> vergleichsbetraege = new HashMap();
        vergleichsbetraege.put("EUR", 50.);
        vergleichsbetraege.put("CHF", 50.);
        
        assertEquals(vergleichsbetraege, Geldbetrag.summiere(betraege));
        //assertEquals(betraege, Geldbetrag.summiere(betraege));
        //assertEquals("{CHF=50.0, EUR=50.0}", Geldbetrag.summiere(betraege));
    }
    /*
    expected:<[
    aufgabe04.Geldbetrag@402d442a,
    aufgabe04.Geldbetrag@4025442a,
    aufgabe04.Geldbetrag@4043442a,
    aufgabe04.Geldbetrag@402d1685,
    aufgabe04.Geldbetrag@40251685,
    aufgabe04.Geldbetrag@40431685]>
    
    but was:<{CHF=50.0, EUR=50.0}>
    */
}