package aufgabe001;

/**
 * Aufgabe 1(Template-Methode).
 * Die Klasse Zeichenobjekt soll die Oberklasse von Klassen sein,
 * deren Instanzen geometrische Objekte einer zweidimensionalen Zeichenanwendung
 * sind. Beispiele für solche Objekte sind Rechtecke, Kreise und Polygone.
 * Realisierren Sie die Klasse Zeichenobjekt so, dass folgende Forderungen
 * erfüllt sind:
 * 
 * 1. Man kann keine Objekte der Klasse Zeichenobjekt erzeugen.
 * 
 * 2. Die Klasse Zeichenobjekt enthält keine Instanzvariable.
 * 
 * 3. Jedes Objekt einer von Zeichenobjekt abgeleiteten Klasse kann durch
 * die Methode public boolean istGroesser(Zeichenobjekt) angeben,
 * ob es eine echt größere Fläche als das übergebene Zeichenobjekt besitzt.
 */

public abstract class Zeichenobjekt {
    /**
     * Ein Objekt das diese Methode aufruft kann durch diese Methode angeben,
     * ob es eine echt größere Fläche als das übergebene Zeichenobjekt besitzt.
     * @param obj das übergebene Zeichenobjekt mit dem verglichen wird.
     * @return <code>true</code>, wenn aufrufendes Objekt echt größere Fläche
     * als das übergebene Zeichenobjekt besitzt.
     */
    
    public boolean istGroesser(Zeichenobjekt obj) {
        return this.gibGroesse() > obj.gibGroesse();
    }
    /**
     * Liefert die Größe dieses Objekts.
     * @return die Größe dieses Objekts.
     */
    
    public abstract double gibGroesse();
}