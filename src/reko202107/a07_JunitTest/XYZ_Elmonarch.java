package reko202107.a07_JunitTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Elmonarch
 * 
 * Keine Klausuraufgabe!!!
 * 
 * Habe hier den Algo der Testaufgabe nachvollzogen und abgebildet.
 * Danach habe ich diesen Algo mit Java8-Streams umgesetzt.
 */
public class XYZ_Elmonarch {

    private Set<String> auschlussHs;

    public XYZ_Elmonarch() {
        auschlussHs = new HashSet<>();
        auschlussHs.add("wünsche");
//        auschlussHs.add("Ich");
    }

    public List<String> m(String s) {
        List<String> zwischenListe = new ArrayList<>();
        List<String> ergebnisListe = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(s, " ,.");

        while (st.hasMoreTokens()) {
            String next = st.nextToken();
            if (!auschlussHs.contains(next)) {
                zwischenListe.add(next);
            }
        }
        
        int anfang = 0;
        int mitte = zwischenListe.size()/2;
        int ende = zwischenListe.size();

        List<String> l1 = zwischenListe.subList(anfang, mitte);;
        List<String> l2 = zwischenListe.subList(mitte , ende);
        ergebnisListe.addAll(l2);
        ergebnisListe.addAll(l1);

        return ergebnisListe;
    }

    public List<String> mStream(String s) {
        List<String> zl = Collections.list(new StringTokenizer(s, " ,.")).stream()
                .map(token -> (String) token)
                .filter(worte -> !auschlussHs.contains(worte))
                .collect(Collectors.toList());

        int anfang = 0;
        int mitte = zl.size()/2;
        int ende = zl.size();
        
        return Stream.concat(zl.subList(mitte, ende).stream(), zl.subList(anfang, mitte).stream())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        XYZ_Elmonarch x = new XYZ_Elmonarch();
        String s = "Ich wünsche Ihnen viel Erfolg.";
        System.out.println(x.m(s));

        System.out.println(x.mStream(s));
    }
}
