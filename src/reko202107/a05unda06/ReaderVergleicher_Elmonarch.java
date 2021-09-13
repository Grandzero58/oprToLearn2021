package reko202107.a05unda06;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

/**
 *
 * @author Elmonarch
 */
public class ReaderVergleicher_Elmonarch {
    
    private static final int PUFFERGROESSE = 5;

    public static boolean sindGleich(Reader r1, Reader r2, short n) throws IOException {
        char[] puffer1 = new char[PUFFERGROESSE];
        char[] puffer2 = new char[PUFFERGROESSE];
        int gelesen1 = r1.read(puffer1);
        int gelesen2 = r2.read(puffer2);
        boolean sindGleich = true;

        while (gelesen1 != -1 && gelesen2 != -1 && n > 0 && sindGleich) {
            for (int i = 0; i < gelesen1 && i < gelesen2 && n > 0 && sindGleich; i++) {
                sindGleich = (puffer1[i] == puffer2[i]);
//                System.out.println(puffer1[i] + " : " + puffer2[i] + " = " + sindGleich + ". n=" + n);
                n--;
            }
            gelesen1 = r1.read(puffer1);
            gelesen2 = r2.read(puffer2);
        }
        r1.close();
        r2.close();
        return sindGleich;
    }

    public static void main(String[] args) throws IOException {

        Reader r1 = new StringReader("Dieser Text ist nicht besonders lang\n um Platz zu sparen");
        Reader r2 = new StringReader("Dieser Text ist nicht besonders lang\n um Platz zu sparen");
        Reader r3 = new StringReader("Dieser Text ist\n nicht besonders lang um Platz zu sparen");
        Reader r4 = new StringReader("Dieser Text ist besonders lang\n um Platz zu sparen");
        Reader r5 = new StringReader("Dieser Text ist nicht");
        Reader r6 = new StringReader("Dieser Text");
        Reader r7 = new StringReader("Dieser Text xst nicht besonders lang\n um Platz zu sparen");

        boolean b = sindGleich(r1, r4, (short) 25);
        boolean b2 = sindGleich(r6, r7, (short) 25);
        System.out.println(b);
        System.out.println(b2);

    }

}
