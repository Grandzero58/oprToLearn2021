package aufgabe005;

import java.util.Date;
/**
 * @author egal
 */

@FunctionalInterface
public interface Protokollierer {
    void protokolliere(
            String benutzername,
            Date loginzeit, boolean warErfolgreich);
}