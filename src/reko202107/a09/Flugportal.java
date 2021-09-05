package aufgabe009;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fibo
 */

public class Flugportal {
    /**
     * 
     */
    
    private Map<String, Flug> datenbestand;
    /**
     * Flugverbindungen ab dem Start.
     */
    
    private List<Flug> verbindungen;
    /**
     * 
     */
    
    private Protokollierer protokollierer;
    /**
     * Erzeugt ein neues Flugportal.
     * @param protokollierer
     */
    
    public Flugportal(Protokollierer protokollierer) {
        datenbestand = new HashMap();
        verbindungen = new ArrayList();
        this.protokollierer = protokollierer;
    }
    /**
     * 
     * @param start
     * @param ziel
     * @return 
     */
    
    public List<Flug> sucheDirektfluege(String start, String ziel) {
        
        Flug gesuchterFlug = new Flug(start);//, ziel);
        
        if (datenbestand.containsKey(start)) {
            
            verbindungen.add(datenbestand.get(start));
            
        } else if (!datenbestand.containsKey(start)) {
            
            List<Flug> neueVerbindungen = new ArrayList();
            
            datenbestand.put(start, gesuchterFlug);
            neueVerbindungen.add(datenbestand.get(start));
        }
        return (List<Flug>) this.datenbestand.values();
    }
}