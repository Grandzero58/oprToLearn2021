package aufgabe008;
//import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Reader;
import java.util.Comparator;
//import java.util.HashMap;
//import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fibo
 */

public class Typvertraeglichkeit {
    OutputStream os = new ByteArrayOutputStream();
    //long v = 12.5f; Typunvertraeglichkeit
    Float v = 12.5f;
    Object vi = "Java".substring(3);
    public Reader m(){
        return null;
    }
    //BufferedReader v = m(); Typunvertraeglichkeit
    /*
    Retten:
    BufferedReader vii = (BufferedReader) m();
    */
    //HashSet<String> v = new HashMap<String, Integer>().keySet(); Typunvertraeglichkeit
    /*
    Retten:
    HashSet<String> vii = (HashSet<String>) new HashMap<String, Integer>().keySet();
    */
    //List<String> vo = new LinkedList<String>();//Redundant aber typvertraeglich!
    List<String> vo = new LinkedList<>();
    Comparator<String> vio = (s, t) -> s.length() - t.length();
}