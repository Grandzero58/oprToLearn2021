package aufgabe005;

import java.util.Date;
/**
 * @author egal
 */

public class Benutzerverwalter {
    private final Protokollierer protokollierer;
    
    public Benutzerverwalter(Protokollierer protokollierer) {
        this.protokollierer = protokollierer;
    }
    /**
     * Prüft, ob zu dem Benutzernamen mit dem angegebenen Passwort ein
     * Benutzer gefunden werden kann.
     * @param benutzername Der Benutzername des Benutzers.
     * @param passwort Das Passwort des Benutzers.
     * @return null genau dann, wenn die Anmeldung erfolglos war,
     * sonst den entsprechenden Benutzer.
     */
    
    public Benutzer login(String benutzername, String passwort) {
        Date loginzeit = new Date();
        loginzeit.getTime();
        Benutzer benutzer = null;
//        
//        if (true) {//<Passwort richtig>) {
//            benutzer = <Benutzerdaten werden ermittelt>
//        } else {
//            benutzer = null;
//        }
        this.protokollierer.protokolliere(
                benutzername, loginzeit, benutzer != null);
        return benutzer;
    }
}