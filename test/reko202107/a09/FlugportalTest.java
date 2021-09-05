package aufgabe009;

import org.junit.Before;
import org.junit.Test;
/**
 * @author fibo
 */

public class FlugportalTest {
    /**
     * 
     */
    private Protokollierer protokollierer;
    /**
     * 
     */
    
    private Flugportal einFlugportal;
    /**
     * 
     */
    @Before
    public void setUp() {
        protokollierer = new Wunschziele();
        einFlugportal = new Flugportal(protokollierer);
    }
    @Test
    public void testeUp() {
    }
}