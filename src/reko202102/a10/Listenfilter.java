package aufgabe010;

import java.util.List;
import java.util.ArrayList;
/**
 * 
 * @author hier egal
 */

public class Listenfilter {
    /**
     * 
     * @param elemente
     * @param anfang
     * @return 
     */
    
//    public static List<String> filter(List<String> elemente, char anfang) {
//        
//        ArrayList<String> gefilterteElemente = new ArrayList<>();
//        for (String element : elemente) {
//            if (!element.isEmpty() && element.charAt(0) == anfang) {
//                gefilterteElemente.add(element);
//            }
//        }
//        return gefilterteElemente;
//    }
    public static List<String> filter(List<String> elemente, char anfang) {
        
        ArrayList<String> gefilterteElemente = new ArrayList<>();
        for (String element : elemente) {
            if (!element.isEmpty() && element.charAt(0) == anfang) {
                gefilterteElemente.add(element);
            }
        }
        return gefilterteElemente;
    }
    /*
    1. Definieren Sie eine Schnittstelle Filterkriterium mit einer geeigneten
    Methode. Ein Filterkriterium soll entscheiden, ob ein Wert durchkommt
    oder nicht.
    
    2. Definieren Sie eine statische Methode
    List<String> filter(List<String>, Filterkriterium), die eine Liste aller
    Elemente aus der übergebenen Liste liefert, die vom Filterkriterium
    durchgelassen werden.
    
    3. Realisieren Sie eine Klasse, die Filterkriterium implementiert und die
    alle Zeichenketten durchlässt deren Länge echt größer als 10 ist.
    */
}