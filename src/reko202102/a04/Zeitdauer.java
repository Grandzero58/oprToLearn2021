package aufgabe004;

import java.util.HashSet;
/**
 * @author egal
 */

public class Zeitdauer {
    /**
     * Stunden einer Zeitdauer.
     */
    
    private int stunden;
    /**
     * Minuten einer Zeitdauer.
     */
    
    private int minuten;
    /**
     * Sammelt unterschiedliche Zeiteinheiten ein.
     * Ein HashSet<Zeitdauer> enthält niemals zwei Objekte,
     * die die gleiche Zeitdauer repräsentieren.
     */
    
    private HashSet<Zeitdauer> zeiteinheiten;
    /**
     * Erzeugt ein Objekt vom Typ Zeitdauer mit Stunden- und Minutenanteil.
     * @param stunden Anteil an Stunden einer Zeitdauer.
     * @param minuten Anteil an Minuten einer Zeitdauer.
     */
    
    public Zeitdauer(int stunden, int minuten) {
        this.stunden = stunden;
        this.minuten = minuten;
        if (this.stunden < 0  && this.minuten < 0) {
            throw new IllegalArgumentException();
        }
//        this.stunden = this.stunden / 60;
//        this.minuten = this.minuten % 60;
    }
    @Override
    public boolean equals(Object obj) {
        boolean istGleich = false;
        if (obj instanceof Zeitdauer) {
                Zeitdauer zeitdauer = (Zeitdauer) obj;
                istGleich = this.stunden == zeitdauer.stunden
                        && this.minuten == zeitdauer.minuten;
        }
        return istGleich;
    }
    @Override
    public int hashCode() {
        return this.stunden / 60 + this.minuten % 60;
    }
}