package aufgabe003;

/**
 * Den nachstehenden Code sinnvoll und performant für Adressverwalter ergänzen,
 * wenn nötig auch für Adresse:
 */

public class Adresse {
    /**
     * Die Postleitzahl dieser Adresse.
     */
    
    private final String plz;
    /**
     * Die Straße dieser Adresse.
     */
    
    private final String strasse;
    /**
     * Erzeugt ein neues Objekt dieser Klasse.
     * @param plz
     * @param strasse
     */
    
    public Adresse(String plz, String strasse) {
        this.plz = plz;
        this.strasse = strasse;
    }

    @Override
    public int hashCode() {
        return plz.hashCode() + strasse.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean equals = obj instanceof Adresse;
        if (equals) {
            Adresse adresse = (Adresse) obj;
            equals = plz.equals(adresse.plz)
                    && strasse.equals(adresse.strasse);
        }
        return equals;
    }
}