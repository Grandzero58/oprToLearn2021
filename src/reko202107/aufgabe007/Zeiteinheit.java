package aufgabe007;
/*
Aufgabe 08 (5P + 5P, Gesamtpunktzahl nur wenn beides das erfüllt, was es soll.)
1. Aufzählungstyp Zeiteinheit mit TAG, STUNDE, MINUTE und SEKUNDE anlegen.
2. int sekunden anlegen, so dass STUNDE.sekunden = 3600 liefert.
3. Der Aufzählungstyp besitzt eine Instanzmethode double in(Zeiteinheit),
durch die eine Zeiteinheit angeben kann, wie groß sie in der übergebenen Einheit
ist. Der Ausdruck
STUNDE.in(MINUTE) soll z.B. den Wert 60.0 liefern. Der Ausdruck
MINUTE.in(STUNDE) soll 0.01666667 liefern, denn eine Minute ist 1/60
einer Stunde. Die Methode enthält keine Fallunterscheidung.
*/
public enum Zeiteinheit {
    /**
     * Ein Tag.
     */
    
    TAG(60 * 60 * 24),
    /**
     * Eine Stunde.
     */
    
    STUNDE(60 * 60),
    /**
     * Eine Mintue.
     */
    
    MINUTE(60),
    /**
     * Eine Sekunde.
     */
    
    SEKUNDE(1);
    /**
     * Die Zeiteinheit in Sekunden.
     */
    
    public int sekunden;
    /**
     * Zeiteinheit in Sekunden erzeugen.
     * @param Zeiteinheit in Sekunden.
     */
    
    private Zeiteinheit(int sekunden) {
        this.sekunden = sekunden;
    }
    /**
     * Die Zeiteinheit in Sekunden.
     * @return Die Zeiteinheit in Sekunden dargestellt.
     */
    
    public int sekunden() {
        return this.sekunden;
    }
}