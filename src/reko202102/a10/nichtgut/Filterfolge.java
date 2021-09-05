//package aufgabe010.nichtgut;
//
//import java.util.NoSuchElementException;
//
///**
// * Ein Objekt dieser Klasse liefert die Zeichenketten einer
// * Textfolge, die eine bestimmte Mindestlänge haben.
// */
//public class Filterfolge {
//    private final Filterkriterium kriterium;
//    
//    public Filterfolge(Filterkriterium kriterium) {
//        this.kriterium = kriterium;
//        geheZumNaechstenElement();
//    }
//    
//    public boolean hatNaechstes() {
//        return kriterium.hatNaechstes();
//    }
//    public String gibNaechstes() throws NoSuchElementException {
//    
//        String element = kriterium.gibNaechstes();
//        geheZumNaechstenElement();
//        return element;
//    }
//    
//    private void geheZumNaechstenElement() {
//        
//        boolean weiteresElementVorhanden = false;
//        while (folge.hatNaechstes() && !weiteresElementVorhanden) {
//            String weiteresElement = folge.gibNaechstes();
//            if (kriterium.laesstDurch(weiteresElement)) {
//                folge.schreibeZurueck(weiteresElement);
//                weiteresElementVorhanden = true;
//            }
//        }
//    }
//    
//    public static void main(String[] args) {
//        
//        EndlicheFolge f = new EndlicheFolge("Tor", "Haus", "", "Fahrrad", "", "Hof");
//        
//        Filterkriterium kriterium = new Filter() {
//            @Override
//            public boolean laesstDurch(String s) {
//                return s.length() >= 4;
//            }
//        };
//        
//        Filterfolge folge;
//        folge = new Filterfolge(f, filter);
////         folge = new Filterfolge(f, String::isEmpty);
//        
//        while (folge.hatNaechstes()) {
//            System.out.println(folge.gibNaechstes());
//        }
//    }
//}