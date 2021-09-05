package aufgabe010.nichtgut;
//import java.awt.List;

import java.util.List;

@FunctionalInterface
public interface Filterkriterium {
    public boolean laesstDurch(List<String> l, String laenge);
}