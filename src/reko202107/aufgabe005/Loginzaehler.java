package aufgabe005;

import java.util.Date;

/**
 * @author egal
 */

public class Loginzaehler implements Protokollierer {
    /**
     * Erfolgreiche Logins.
     */
    
    private int erfolgreicheLogins = 0;
    /**
     * Erfolglose Logins.
     */
    
    private int erfolgloseLogins = 0;
    /**
     * 
     * @param benutzername
     * @param loginzeit
     * @param warErfolgreich 
     */
    
    @Override
    public void protokolliere(
            String benutzername, Date loginzeit, boolean warErfolgreich) {
        if (warErfolgreich) {
            erfolgreicheLogins = erfolgreicheLogins + 1;
        } else {
            erfolgloseLogins = erfolgloseLogins + 1;
        }
    }
    /**
     * 
     * @return 
     */
    
    public int gibAnzahlErfolgreicherLogins() {
        return this.erfolgreicheLogins;
    }
    /**
     * 
     * @return 
     */
    
    public int gibAnzahlErfolgloserLogins() {
        return this.erfolgloseLogins;
    }
}