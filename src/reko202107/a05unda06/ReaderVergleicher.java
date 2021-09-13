package reko202107.a05unda06;

import java.io.IOException;
import java.io.Reader;

/**
 * Klasse vergleicht 2 Eingabeströme mit einer Methode boolean sindGleich(). Die Methode liefert true, wenn eine der
 * folgenden Bedingungen erfüllt ist:
 *
 * • Beide Eingabeströme sind mindestens n Bytes lang (3. Parameter) und stimmen in den Folgen ihrer jeweils ersten n
 * Bytes überein.
 *
 * • Beide Eingabeströme sind gleich lang, die Länge ist jedoch kürzer als n Bytes, und sie stimmen in ihren Bytefolgen
 * überein.
 */

public class ReaderVergleicher {

    /**
     * Groesse des Puffers.
     */

    private static final int PUFFERGROESSE = 8;

    /**
     * Überprüft ob beide Eingabeströme gleich sind.
     *
     * @param eingabestrom1 Der erste zu überprüfende Eingabestrom.
     * @param eingabestrom2 Der zweite zu überprüfende Eingabestrom.
     * @param n Die Länge auf deren Grundlage die Ströme geprüft werden.
     * @return <code>true</code>, wenn beide Ströme gleich, sonst <code>false</code>.
     * @throws IOException Bei Unfällen, tritt die Ausnahme auf.
     */

    public static boolean sindGleich(
            Reader eingabestrom1,
            Reader eingabestrom2, short n) throws IOException {

        boolean sindGleich = true;
        long geleseneBytesInsgesamt = 0;
        char[] puffer1 = new char[PUFFERGROESSE];
        char[] puffer2 = new char[PUFFERGROESSE];

        int geleseneBytes = Math.max(
                eingabestrom1.read(puffer1),
                eingabestrom2.read(puffer2)
        );

        while (geleseneBytes > 0 && geleseneBytesInsgesamt < n) {

            int anzahl = (int) Math.min(
                    geleseneBytes, n - geleseneBytesInsgesamt);

            int i = 0;

            while (i < anzahl && puffer1[i] == puffer2[i]) {
                i++;
            }
            sindGleich = sindGleich && (i == anzahl);

            geleseneBytesInsgesamt = geleseneBytesInsgesamt + geleseneBytes;
            geleseneBytes = Math.min(
                    eingabestrom1.read(puffer1), eingabestrom2.read(puffer2)
            );
        }
        if (geleseneBytesInsgesamt < n) {
            throw new RuntimeException(
                    "Datenquelle ist kuerzer als "
                    + n + " Bytes. " + geleseneBytesInsgesamt);
        }
        return sindGleich;
    }
}
