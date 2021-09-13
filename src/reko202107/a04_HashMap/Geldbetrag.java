package reko202107.a04_HashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
/**
 * 
 * Gegeben sei die Klasse Geldbetrag, deren Objekte repräsentieren Geldbeträge.
 * Verändern und erweitern Sie die Klasse Geldbetrag,
 * sodass folgende Anforderungen erfüllt sind:
 * 
 * 1. Es sollen sich Objekte der Klasse genau dann erzeugen lassen,
 * wenn das Währungskürzel die Länge 3 hat.
 * 
 * Beispiel: ISKR ist kein zulässiges Währungskürzel, deshalb soll sich
 * durch new Geldbetrag("ISKR", 100) kein Objekt der Klasse erzeugen lassen.
 * 
 * 2. Geldbeträge sollen als Schlüssel einer HashMap verwendbar sein.
 * Geldbeträge sind dann gleich, wenn sie den gleichen Betrag in der gleichen
 * Währung haben.
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
        /*
        Verhindert, dass ein Geldbetrag mit einem Kürzel ungleich 3 entsteht.
        */
        if (waehrung.length() < 3 || waehrung.length() > 3) {
            throw new IllegalArgumentException();
        }
        this.waehrung = waehrung;
        
        this.betrag = betrag;
    }
    /**
     * 
     * @param betraege
     * @return 
     */
    
    public static HashMap<String, Double> summiere(
            Collection<Geldbetrag> betraege) {
        
        Iterator<Geldbetrag> geldbetragsIterator = betraege.iterator();
        
        Geldbetrag naechsterGeldbetrag;
        
        HashMap<String, Double> waehrungen = new HashMap();
        
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
    /**
     * Generiert den Hash-Code des Obejekts.
     * @return Gibt den generierten Hash-Code dieses Objekts zurück.
     */
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = hash * this.waehrung.hashCode()
                + (int) (Double.doubleToLongBits(this.betrag) ^ (
                Double.doubleToLongBits(this.betrag) >>> 32));
        return hash;
    }
    /**
     * Überprüft, ob der Geldbetrag, im Sinne von equals(), gleich ist.
     * @param obj Ein übergebenes Objekt mit dem das aufrufende verglichen wird.
     * @return Ist gleich oder nicht.
     */
    
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Geldbetrag
                && this.waehrung.equalsIgnoreCase(
                        ((Geldbetrag) obj).waehrung)
                && this.betrag == ((Geldbetrag) obj).betrag;
    }
}