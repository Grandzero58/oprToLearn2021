package reko202107.a01_Template;

/**
 * Aufgabe 1(Template-Methode).
 * Die Klasse Zeichenobjekt2D soll die Oberklasse von Klassen sein, deren
 * Instanzen Zeichenobjekte einer zweidimensionalen Zeichenanwendung sind.
 * Beispiele für solche Objekte sind Rechtecke,
 * Kreise, Polygone und gruppierte Zeichenobjekte.
 * Realisieren Sie die Klasse Zeichenobjekt2D so, dass folgende Forderungen
 * erfüllt sind:
 * 
 * 1. Man kann keine Objekte der Klasse Zeichenobjekt2D erzeugen.
 * 
 * 2. Die Klasse Zeichenobjekt2D enhält keine Instanzvariable.
 * 
 * 3. Jedes Objekt einer Klasse, die von Zeichenobjekt2D abgeleitet ist,
 * kann durch die (Template-)
 * Methode public String gibInfo() eine textuelle Information über sich produzieren.
 * Die Information ist dreizeilig und hat folgendes Format (die konkreten
 * Angaben sind nur Beispiele):
 * 
 *  Gruppe
 *  Breite: 100
 *  Höhe: 25
 * 
 * Die erste Zeile enthält die Art des Zeichenobjekts, die zweite und dritte
 * seine Breite bzw. Höhe.
 */

public abstract class Zeichenobjekt2D {
    /**
     * Man sollte in dieser Klasse eine Template Methode String gibInfo()
     * schreiben, welche eine Ausgabe für Unterklassen kreieren sollte.
     * @return Ausgabe war: Umfang: 20 Fläche: 20.5
     */
    public String gibInfo() {
        return "" + gibGruppe() + "\nBreite: " + gibBreite() + "\nHöhe: "
                + gibHoehe();
    }
    public abstract String gibGruppe();
    
    public abstract int gibBreite();
    
    public abstract int gibHoehe();
}