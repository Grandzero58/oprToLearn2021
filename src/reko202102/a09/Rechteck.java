package aufgabe009;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Ein Objekt dieser Klasse repräsentiert ein Rechteck in einer 2D-Ebene.
 * Die Seiten des Rechtecks liegen parallel bzw. senkrecht zur horizontalen
 * und vertikalen Koordinaten-Achse.
 */

public class Rechteck {
    /**
     * Breite dieses Rechtecks.
     */
    
    private int breite;
    /**
     * Höhe dieses Rechtecks.
     */
    
    private int hoehe;
    /**
     * Erzeugt ein Rechteck mit der angegebenen Breite und Höhe.
     * @param breite  Breite dieses Rechtecks
     * @param hoehe  Höhe dieses Rechtecks
     */
    
    public Rechteck(int breite, int hoehe) {
        this.breite = breite;
        this.hoehe = hoehe;
        
        Comparator<Rechteck> c = (p, q) -> p.gibHoehe() - q.gibHoehe();
        c.thenComparing((p, q) -> p.gibBreite()- q.gibBreite());
        
        TreeSet<Rechteck> rechtecke = new TreeSet(c);
        
        rechtecke = new TreeSet<>((p, q) -> {
            int vergleich = p.gibHoehe() - q.gibHoehe();
            if (vergleich == 0) {
                vergleich = p.gibBreite() - q.gibBreite();
            }
            return vergleich;
        });
    }
    /**
     * Liefert die Fläche dieses Rechtecks.
     * @return Fläche dieses Rechtecks
     */
    
    public int gibFlaeche() {
        return this.breite * this.hoehe;
    }
    /**
     * Liefert eine textuelle Repräsentation dieses Rechtecks.
     *
     * @return textuelle Repräsentation dieses Rechtecks mit
     *         Angabe seiner Koordinaten
     */
    public String gibAlsString() {
        return "Rechteck (Fläche = " + this.gibFlaeche()
                + ", Breite = " + this.gibBreite()
                + ", Höhe = "   + this.gibHoehe() + ")";
    }
    /**
     * 
     * @return breite
     */
    
    public int gibBreite() {
        return this.breite;
    }
    /**
     * 
     * @param hoehe 
     */
    
    public int gibHoehe() {
        return this.hoehe;
    }
    /**
     * 
     * @param breite 
     */
    
    public void setzeBreite(int breite) {
        this.breite = breite;
    }
    /**
     * 
     * @param hoehe 
     */
    
    public void setzeHoehe(int hoehe) {
        this.hoehe = hoehe;
    }
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Rechteck
                && this.gibHoehe() == ((Rechteck) obj).gibHoehe()
                && this.gibBreite() == ((Rechteck) obj).gibBreite();
    }
    @Override
    public int hashCode() {
        return this.hoehe + this.breite;
    }
}