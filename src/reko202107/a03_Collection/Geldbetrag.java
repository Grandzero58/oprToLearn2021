package reko202107.a03_Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * Gegeben sei die Klasse Geldbetrag,
 * deren Objekte Geldbeträge in bestimmten Währungen repräsentieren.
 * Beispiele: new Geldbetrag("EUR", 12.75) repräsentiert 12,75 Euro.
 * new Geldbetrag("CHF", 20_000) repräsentiert 20.000,- Schweizer Franken.
 */

public class Geldbetrag {
    /**
     * Die Währung des Geldbetrags.
     */
    
    private String waehrung;
    /**
     * Der Betrag des Geldbetrags selbst.
     */
    
    private double betrag;
    /**
     * Erzeugt einen neuen Geldbetrag.
     * @param waehrung Die Währung des Geldbetrags.
     * @param betrag Der Betrag in der Währung.
     */
    
    public Geldbetrag(String waehrung, double betrag) {
        this.waehrung = waehrung;
        this.betrag = betrag;
    }
    /*
    Realisieren Sie in der Klasse Geldbetrag eine statische Methode
    summiere(Collection<Geldbetrag>),
    die eine Ansammlung von Geldbeträgen zusammenfasst.
    In der Zusammenfassung ist jeder vorkommenden Währung die Summe der
    Beträge in dieser Währung zugeordnet.
    
    Beispiel: Enthält die Ansammlung drei EUR-Beträge 12 EUR, 8 EUR und 30 EUR,
    dann enthält die Zusammenfassung einen Eintrag
    für die Währung EUR mit Wert 50.
    Iteriert man in der Zusammenfassung über die Währungen,
    sollen sie alphabetisch aufsteigend durchlaufen werden.
    Den Ergebnistyp der Methode müssen Sie nach dieser Beschreibung
    selbst festlegen.
    public static____________________summiere(Collection<Geldbetrag> betraege) {
    */
    public static Map<String, Double> summiere(Collection<Geldbetrag> betraege){
        
        Iterator<Geldbetrag> geldbetragsIterator = betraege.iterator();
        
        Geldbetrag naechsterGeldbetrag;
        
        Map<String, Double> waehrungen = new HashMap();
        
        while (geldbetragsIterator.hasNext()) {
            
            String waehrung;
            double betrag;
            naechsterGeldbetrag = geldbetragsIterator.next();
            
            waehrung = naechsterGeldbetrag.waehrung;
            betrag = naechsterGeldbetrag.betrag;
            /*
            1. Fall: Die Zuordnung enthält den Schlüssel noch nicht.
            */
            if (!waehrungen.containsKey(waehrung)) {
                /*
                Neuen Schlüssel anlegen!
                */
                waehrungen.put(waehrung, betrag);
                /*
                2. Fall: Die Zuordnung enthält den Schlüssel bereits.
                */
            } else if (waehrungen.containsKey(waehrung)) {
                /*
                Alte Werte vom Schluessel uebernehmen...
                */
                Double enthaltenerBetrag = waehrungen.get(waehrung);
                Double neuerBetrag = enthaltenerBetrag + betrag;
                /*
                Neu berechen und neue Berechnung zuordnen.
                */
                waehrungen.put(waehrung, neuerBetrag);
            }
        }
        return waehrungen;
    }
    public static void main(String[] args) {
        Geldbetrag geldbetragEUR1 = new Geldbetrag("EUR", 12);
        Geldbetrag geldbetragEUR2 = new Geldbetrag("EUR", 8);
        Geldbetrag geldbetragEUR3 = new Geldbetrag("EUR", 30);
        
        Geldbetrag fraenkli01 = new Geldbetrag("CHF", 12);
        Geldbetrag fraenkli02 = new Geldbetrag("CHF", 8);
        Geldbetrag fraenkli03 = new Geldbetrag("CHF", 30);
        
        Collection<Geldbetrag> betraege = new ArrayList();
        betraege.add(geldbetragEUR1);
        betraege.add(geldbetragEUR2);
        betraege.add(geldbetragEUR3);
        
        betraege.add(fraenkli01);
        betraege.add(fraenkli02);
        betraege.add(fraenkli03);
        System.out.println(summiere(betraege));
    }
}