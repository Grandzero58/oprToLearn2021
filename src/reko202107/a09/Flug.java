package aufgabe009;

/**
 * @author fibo
 */

public class Flug {
    /**
     * Startflughafen dieses Flugs.
     */
    
    private String start;
    /**
     * Zielflughafen dieses Flugs.
     */
    
    private String ziel;
    /**
     * Flughafen dieses Flugs.
     */
    
    private String ort;
    /**
     * Erzeugt einen neuen Flug.
     * @param ort Flughafen des Flugs.
     */
    
    public Flug(String ort) {
        this.ort = ort;
    }
    /**
     * Erzeugt einen neuen Flug.
     * @param start mit einem Startflughafen.
     */
//    public Flug(String start) {
//        this.start = start;
//    }
    /**
     * Erzeugt einen neuen Flug.
     * @param start mit einem Startflughafen.
     * @param ziel mit einem Zielflughafen.
     */
    
    public Flug(String start, String ziel) {
        this(start);
        this.ziel = ziel;
    }
    @Override
    public boolean equals(Object obj) {
        boolean istGleich = false;
        if (obj instanceof Flug) {
            istGleich = this.start.equals(((Flug) obj).start)
                    && this.ziel.equals(((Flug) obj).ziel);
        }
        return istGleich;
    }
    @Override
    public int hashCode() {
        int hash = 7 * (this.start.hashCode() + this.ziel.hashCode());
        return hash;
    }
}