package reko202107.a07_JunitTest;

import reko202107.a07_JunitTest.XYZ;
import java.util.LinkedList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author fibo
 */

public class XYZTest {
    /**
     * 
     */
    
    private XYZ xyz;
    /**
     * 
     */
    
    private LinkedList<String> woerterliste;
    /**
     * 
     */
    
    @Before
    public void XYZTesUp() {
        xyz = new XYZ();
    }
    /**
     * 
     */
    
    @Test
    public void teste1MethodeMderKlasseXYZ() {
//        woerterliste.add("viel");
//        woerterliste.add("Erfolg");
//        woerterliste.add("Ich");
//        woerterliste.add("Ihnen");
        woerterliste = new LinkedList();
        woerterliste.add("Ich");
        woerterliste.add("wünsche");
        woerterliste.add("Ihnen");
        woerterliste.add("viel");
        woerterliste.add("Erfolg");
        
        String wort = woerterliste.get(0);
        
        assertEquals(woerterliste, xyz.m("Ich wünsche Ihnen viel Erfolg."));
    }
    @Ignore
    public void teste2MethodeMderKlasseXYZ() {
        woerterliste.add("viel");
        woerterliste.add("Erfolg");
        woerterliste.add("Ich");
        woerterliste.add("Ihnen");
        assertEquals(
                woerterliste.get(1), xyz.m(
                        "Ich wünsche Ihnene viel Erfolg."));
    }
    @Ignore
    public void teste3MethodeMderKlasseXYZ() {
        woerterliste.add("viel");
        woerterliste.add("Erfolg");
        woerterliste.add("Ich");
        woerterliste.add("Ihnen");
        assertEquals(
                woerterliste.get(3), xyz.m(
                        "Ich wünsche Ihnene viel Erfolg."));
    }
    @Ignore
    public void teste4MethodeMderKlasseXYZ() {
        woerterliste.add("viel");
        woerterliste.add("Erfolg");
        woerterliste.add("Ich");
        woerterliste.add("Ihnen");
        assertEquals(
                woerterliste.get(4), xyz.m(
                        "Ich wünsche Ihnene viel Erfolg."));
    }
}