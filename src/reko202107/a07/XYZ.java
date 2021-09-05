package aufgabe007;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author fibo
 */

public class XYZ {
    public List<String> m(String s) {
        List<String> eineListe = new LinkedList();
        //String string = "Ich wünsche Ihnen viel Erfolg.";
        
        StringTokenizer tokenizer = new StringTokenizer(s, " .", false);
        eineListe.add(tokenizer.nextToken());
        eineListe.add(tokenizer.nextToken());
        eineListe.add(tokenizer.nextToken());
        eineListe.add(tokenizer.nextToken());
        eineListe.add(tokenizer.nextToken());
        return eineListe;
    }
}