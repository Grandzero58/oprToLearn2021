package reko202107.a05unda06;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

/**
 *
 * @author Elmonarch
 */
public class ReaderVergleicher_Elmonarch {
    
    public static boolean sindGleich(Reader r1, Reader r2, short n){
        Reader b1 = r1;
        
        return true;
    }
    
    public static void main(String[] args) {
        
        Reader r1 = new BufferedReader(new StringReader("Dieser Text ist nicht besonders lang\n um Platz zu sparen"));
        Reader r2 = new BufferedReader(new StringReader("Dieser Text ist nicht besonders lang\n um Platz zu sparen"));
        Reader r3 = new BufferedReader(new StringReader("Dieser Text ist\n nicht besonders lang um Platz zu sparen"));
        Reader r4 = new BufferedReader(new StringReader("Dieser Text ist besonders lang\n um Platz zu sparen"));
        Reader r5 = new BufferedReader(new StringReader("Dieser Text ist nicht besonders lang"));
        
        boolean b = sindGleich(r1, r2, (short) 0);
        System.out.println(b);
        
    }
    
}
