package aufgabe003;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
/**
 * @author fibo
 */

public class Adressverwalter {
    /**
     * 
     */
    
    private Map<Adresse, Set<String>> adresseZuPersonen;
    /**
     * 
     */
    
    public Adressverwalter() {
        adresseZuPersonen = new HashMap();
    }
    /**
     * Gibt alle Personen an der angegebenen Adresse.
     * @param plz Die Postleitzahl der Adresse.
     * @param strasse Die Straße der Adresse.
     * @return Alle Personen an der angegebenen Adresse in einer Set.
     * @throws IllegalArgumentException, wenn an der angegebenen Adresse
     * noch nichts eingetragen wurde.
     */
    public Set<String> gibPersonen(String plz, String strasse) {
        
        Set<String> personen = adresseZuPersonen.get(new Adresse(plz, strasse));
        
        if (personen == null) {
            throw new IllegalArgumentException();
        }
        return personen;
    }
    /**
     * Fügt eine Person an der angegebenen Adresse diesem Adressverwalter hinzu.
     * @param plz Die Postleitzahl der Adresse.
     * @param strasse Die Straße der Adresse.
     * @param person Der Name der Person.
     */
    
    public void fuegeHinzu(String plz, String strasse, String person) {
        
        Adresse adresse = new Adresse(plz, strasse);
        
        if (!adresseZuPersonen.containsKey(adresse)) {
            adresseZuPersonen.put(adresse, new HashSet());
        }
        
        adresseZuPersonen.get(adresse).add(person);
    }
}