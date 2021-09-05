package aufgabe003.professioneller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
/**
 * 
 * @author egal
 */

public class Collections {
    /*
    Dann enthält die resultierende Zuordnung folgende Einträge:
    F → [Fahrstuhl, Fahrrad]
    1 → [123 Abflussreinigung]
    f → [frische Blumen]
    P → [Pfirsich]
    
    Die Schreibweise [...] soll in diesem Beispiel eine Collection
    mit den jeweiligen Wörtern bezeichnen.
    
    public static Map<____, Collection<String>> erzeugeIndex(String[] woerter) {
    */
    public static Map<Character, Collection<String>>
        erzeugeIndex(String[] woerter) {
        /*
        Alle wichtigen Variablen bereitstellen.
        */
        TreeMap<Character, Collection<String>> zuordnung = new TreeMap();
        Arrays.stream(woerter).forEach(wort -> {
            char schluessel = wort.charAt(0);
            if (!zuordnung.containsKey(schluessel)) {
                zuordnung.put(schluessel, new ArrayList(
                        Arrays.asList(wort)));
            } else {
                zuordnung.get(schluessel).add(wort);
            }
        });
        return zuordnung;
        }
        /**
         * @param args 
         */
        
        public static void main(String[] args) {
            String[] woerter = new String[] {
                "Fahrstuhl", "Fahrrad",
                "123 Abflussreinigung", "frische Blumen", "Pfirsich"
            };
            Map<Character, Collection<String>> index = erzeugeIndex(woerter);
            System.out.println(index);
    }
}