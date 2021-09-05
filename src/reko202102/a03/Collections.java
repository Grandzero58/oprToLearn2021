package aufgabe003;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

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
        char schluessel;
        Collection<String> liste = new ArrayList();
        /*
        Alle Woerter aus dem Array in der Liste abspeichern.
         */
        for (String worte : woerter) {
            liste.add(worte);
        }
        /*
        Itartor zum Iterieren über die Liste erzeugen.
        */
        Iterator<String> woerterIterator = liste.iterator();
        String naechstesWort = "";
        /*
        Solange Itartor noch Woerter enthaelt...
        */
        while (woerterIterator.hasNext()) {
            /*
            Naechstes Wort + Schluessel
            */
            naechstesWort = woerterIterator.next();
            schluessel = naechstesWort.charAt(0);
            /*
            1. Fall: Die Zuordnung enthält den Schlüssel noch nicht.
            */
            if (!zuordnung.containsKey(schluessel)) {
                /*
                Neuen Schlüssel anlegen!
                */
                schluessel = naechstesWort.charAt(0);
                Collection<String> collect = new ArrayList();
                collect.add(naechstesWort);
                zuordnung.put(schluessel, collect);
                /*
                2. Fall: Die Zuordnung enthält den Schlüssel bereits.
                */
            } else if (zuordnung.containsKey(schluessel)) {
                /*
                Alte Werte von Schluessel uebernehmen.
                */
                Collection<String> collect = zuordnung.get(schluessel);
                /*
                Das Wort wird den Werten des Schlüssels hinzugefügt.
                */
                collect.add(naechstesWort);
                //Collections.sort((List<String>) collect);
                /*
                Neue Zuordnung zwischen Schlüssel und Werten.
                */
                zuordnung.put(schluessel, collect);
            }
        }
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