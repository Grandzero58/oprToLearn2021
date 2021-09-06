package aufgabe001;

import java.util.Set;
/**
 * Aufgabe 1(Template-Methode).
 * Klasse Shopartikel implementieren, die folgende Anforderungen erfüllt:
 * – Keine Objekte sind von Klasse Shopartikel erzeugbar
 * – Es gibt keine Instanzvariablen
 * – Die Template-Methode public boolean passtZu(String wort) soll existieren
 * 
 * Beispiel: Ein Shopartikel mit den Suchbegriffen „Java“, „OPR“, „Eintrag“
 * soll mit passtZu(“Eintrag“) true liefern.
 */

public abstract class Shopartikel {
    /**
     * Definierte Suchbegriffe.
     * @return die Suchbegriffe.
     */
    
    public abstract Set<String> gibSuchbegriffe();
    /**
     * Liefert <code>true</code>, wenn übergebener Begriff eingetragen ist.
     * Sonst <code>false</code>.
     * @param begriff
     * @return <code>true</code>, wenn übergebener Begriff eingetragen ist,
     * sonst <code>false</code>.
     */
    
    public boolean passtZu(String begriff) {
        return gibSuchbegriffe().contains(begriff);
    }
}