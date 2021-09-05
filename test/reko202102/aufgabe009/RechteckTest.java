package aufgabe009;

import java.util.HashSet;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Diese Klasse dient dazu, Konstruktoren und Methoden der Klasse
 * Rechteck zu testen und deren Funktionsweise zu veranschaulichen.
 */

public class RechteckTest {
    /**
     * Variable des Typs Rechteck deklarieren.
     */
    private Rechteck r1;
    private Rechteck r2;
    private Rechteck r3;
    private Rechteck r4;
    private Rechteck r5;
    
    @Before
    public void setUp() {
        r1 = new Rechteck(1, 8);
        r2 = new Rechteck(3, 8);
        r3 = new Rechteck(2, 6);
        r4 = new Rechteck(4, 5);
        r5 = new Rechteck(6, 5);
    }
    /**
     * Veranschaulicht die Identität von Objekten.
     * Testausgabe, um Identität der Werte beider Variablen festzustellen.
     */
    
//    @Test
//    public void testeGleicheheit() {
//        assertFalse(r1.equals(r2));
//    }
//    @Test
//    public void testeEtwas() {
//        System.out.println(r1.gibAlsString());
//        System.out.println(r2.gibAlsString());
//        System.out.println(r3.gibAlsString());
//        System.out.println(r4.gibAlsString());
//        System.out.println(r5.gibAlsString());
//    }
    @Test
    public void testeGleich() {
        r1 = r2;
        HashSet rechtecke = new HashSet();
        rechtecke.add(r1);
        rechtecke.add(r2);
        rechtecke.add(r3);
        rechtecke.add(r4);
        rechtecke.add(r5);
        
        Iterator<Rechteck> rechteckIterator = rechtecke.iterator();
        
        while (rechteckIterator.hasNext()) {
            System.out.println(rechteckIterator.next().gibAlsString());
        }
    }
//    @Test
//    public void testeIdentitaet() {
//        r1 = r2;
//        assertSame(r1.gibAlsString() == r2.gibAlsString(),
//                r2.gibAlsString() == r1.gibAlsString());
//    }
}