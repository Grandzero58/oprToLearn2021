package aufgabe008;

import java.util.Collection;
import java.util.stream.Collectors;

public class EineCollection {
    /*
    Aufgabe 8: 10 Punkte
    Folgendes Code-Stück neu schreiben,
    wobei keine Schleifen oder if-Anweisungen verwendet werden sollen:
    */
//    public Collection<String> m(Collection<String> woerter) {
//        ArrayList<String> ergebnis = new ArrayList();
//        for (String wort : woerter) {
//            if (wort.length() >= 5) {
//                String s = wort.substring(wort.length() / 2);
//                if (s.charAt(0) >= 'a') {
//                    ergebnis.add(s.toUpperCase());
//                }
//            }
//        }
//        return ergebnis;
//    }
    public Collection<String> m(Collection<String> woerter) {
        return woerter.stream()
                .filter((wort -> wort.length() >= 5))
                .map((wort) -> wort.substring(wort.length() / 2))
                .filter(wort -> wort.charAt(0) >= 'a')
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    };
}