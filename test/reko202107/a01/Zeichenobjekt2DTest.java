package reko202107.a01;

import reko202107.a01_Template.Zeichenobjekt2D;

/**
 * @author fibo
 */

public abstract class Zeichenobjekt2DTest {
    public static void main(String[] args) {
        Zeichenobjekt2D zeichenobjekt = new Rechteck(1, 4);
        System.out.println(zeichenobjekt.gibInfo());
    }
}