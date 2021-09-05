package reko202107.a11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;
import java.util.stream.Stream;
/**
 * @author spielt hier keine Rolle
 */

public class StreamOperationenLoesungen {
    /**
     * Zum Lesen und Bearbeiten der Datenquelle.
     */
    
    static BufferedReader r;
    static BufferedReader r2;
    /**
     * Zum Speichern für Ergebnisse.
     */
    
    static List<Integer> l;
    /**
     * Für Tests der ersten Rekoaufgabe.
     */
    
    private static void testeRekoAufgaben() {
        /*
        1.
        Realisieren Sie unter Verwendung von Streams einen Ausdruck,
        der die erste Zeile der Datenquelle in r liefert, deren Länge
        größer als 40 ist. Geben Sie den Typ des Ausdrucks an.
        */
        StringReader quelle = new StringReader(
                "Prof. Luis will 40 Zeilen in einer Liste haben. "
                        + "\nVor allem in der Klausur eine schwierige"
                        + " Aufgabe. Die hier aber notwendig ist. \nTraining"
                        + " macht einen besser.");
        /*
        Zum Lesen und Bearbeiten der Datenquelle.
        */
        r = new BufferedReader(quelle);
        /*
        Das Resultat.
        */
//        Optional<String> opti
//                = r.lines().filter(s -> s.length() > 40).findFirst();
        r.lines().filter(s -> s.length() > 40).forEach(System.out::println);
        /*.forEach(System.out::println);
        Textuelle Ausgabe zur Überprüfung.
        */
        //System.out.println(opti);
        /*
        Realisieren Sie unter Verwendung von Streams einen Ausdruck,
        der angibt, ob alle Zeilen von r eine Länge >= 10 haben.
        */
        StringReader quelle2 = new StringReader(
                "Prof. Luis will 40 Zeilen in einer Liste haben. " //48
                        + "\nVor allem in der Klausur eine schwierige" //40
                        + " Aufgabe. Die hier aber notwendig ist. \nTraining" //38
                        + " macht einen besser."); //28
//        StringReader quelle2 = new StringReader(
//                "Zu kurz"
//                        + "\n  "
//                        + "\n nö"
//                        + "\n.");
        /*
        Zum Lesen und Bearbeiten der Datenquelle.
        */
        r = new BufferedReader(quelle2);
        /*
        Das erste Resultat.
        */
        boolean istSoLang = r.lines().allMatch(s -> s.length() >= 10);
        /*
        Textuelle Ausgabe zur Überprüfung.
        */
        System.out.println(istSoLang);
        /*
        3.
        Realisieren Sie unter Verwendung von Streams ein Codestück,
        das die Menge aller gerdazahligen Elemente von l bildet.
        (Listenoperation via Streamoperationen)
        */
        l = new LinkedList();
        l.stream().filter(
                i -> i > 0 && i % 2 == 0).forEach(System.out::println);
        //System.out.println(l);
        /*
        4.
        Realisieren Sie unter Verwendung von LongStream.iterate einen Stream
        mit den Zahlen 0, 1, 3, 7, 15, 31, 63,.... Ignorieren Sie,
        dass es irgendwann einen Überlauf gibt.
        */
        //0, 1, 3, 7, , 15, 31, 63, .......
        LongStream.iterate(0, n -> n * 2 + 1);//.forEach(System.out::println);
        /*
        Die ersten Werte ohne Überlauf:
        0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383,
        32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607,
        16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823,
        2147483647, 4294967295, 8589934591, 17179869183, 34359738367, 68719476735,
        137438953471, 274877906943, 549755813887, 1099511627775, 2199023255551,
        4398046511103, 8796093022207, 17592186044415, 35184372088831,
        70368744177663, 140737488355327, 281474976710655, 562949953421311,
        1125899906842623, 2251799813685247, 4503599627370495, 9007199254740991,
        18014398509481983, 36028797018963967, 72057594037927935,
        144115188075855871, 288230376151711743, 576460752303423487,
        1152921504606846975, 2305843009213693951, 4611686018427387903,
        9223372036854775807
        */
    }
    /**
     * Haptmethode zum Testen der obigen.
     * @param args wird hier nicht verwendet.
     * @throws java.io.IOException gerade egal!
     */
    
    public static void main(String[] args) throws IOException {
        testeRekoAufgaben();
        
        //1. Ausdruck
        //r.lines().filter(s -> s.length() > 40).findFirst()
        //2. Ausdruck
        //r.lines().allMatch(s -> s.length() >= 10);
        //3. Ausdruck
        //l.stream().filter(i -> i > 0 && i % 2 == 0);
        //4. Ausdruck
        //LongStream.iterate(0, n -> n * 2 + 1);
        r.lines().filter(s -> s.length() > 40).findFirst();
        /*
        1.Ausdruck
        r.lines().filter(s -> s.length() > 40).forEach(System.out::println);
        
        2. Ausdruck
        boolean istSoLang = r.lines().allMatch(s -> s.length() >= 10);
        
        3. Ausdruck
        l = new LinkedList();
        l.stream().filter(i -> i > 0 && i % 2 == 0).forEach(System.out::println);
        
        4. Ausdruck für 0, 1, 3, 7, , 15, 31, 63, .......
        LongStream.iterate(0, n -> n * 2 + 1).forEach(System.out::println);
        */
    }
}