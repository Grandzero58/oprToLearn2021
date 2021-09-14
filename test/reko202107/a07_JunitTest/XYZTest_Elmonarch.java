package reko202107.a07_JunitTest;

import reko202107.a07_JunitTest.XYZ_Elmonarch;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ego
 */
public class XYZTest_Elmonarch {

    private XYZ_Elmonarch x;
    private String s;
    private ArrayList<String> zielErgebnis;

    @Before
    public void setUp() {
        x = new XYZ_Elmonarch();
        s = "Ich wünsche Ihnen viel Erfolg.";
        zielErgebnis = new ArrayList();
        zielErgebnis.add("viel");
        zielErgebnis.add("Erfolg");
        zielErgebnis.add("Ich");
        zielErgebnis.add("Ihnen");
    }

    @Test
    public void testM() throws Exception {
        assertEquals(zielErgebnis, x.m(s));
    }

    @Test
    public void testMStream() throws Exception {
        assertEquals(zielErgebnis, x.mStream(s));
    }

    @Test
    public void testMStreamFail() throws Exception {
        try {
            assertNotEquals(null, x.mStream(s));
//            assertEquals(null, x.mStream(s));
//            fail("Fehler hätte geworfe werden müssen");
        } catch (Exception e) {
            assertEquals("Eingabestrom zu kurz", e.getMessage());
        }
    }
}
