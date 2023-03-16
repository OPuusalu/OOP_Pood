import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<Integer, Toode> tootedMüügil = loebFailist("tooted.txt");
        System.out.println(tootedMüügil);
    }

    static HashMap<Integer, Toode> loebFailist (String failiNimi) throws FileNotFoundException {
        java.io.File fail = new java.io.File(failiNimi);
        HashMap<Integer, Toode> kõikTooted = new HashMap<Integer, Toode>();
        try (Scanner sc = new Scanner(fail, "UTF-8")) {
            int järjekorraNr = 1;
            while (sc.hasNextLine()) {
                String[] rida = sc.nextLine().split("-");
                if (kasOnAllahindlus()) {
                    Toode toode = new Toode(Double.parseDouble(rida[0]), rida[1], allahindluseProtsent());
                    kõikTooted.put(järjekorraNr, toode);
                    järjekorraNr++;
                } else {
                    Toode toode = new Toode(Double.parseDouble(rida[0]), rida[1]);
                    kõikTooted.put(järjekorraNr, toode);
                    järjekorraNr++;
                }
            }
            sc.close();
        }
        return kõikTooted;
    }
    static boolean kasOnAllahindlus() {
        double arv = Math.random()*100;
        return arv <= 33;
    }
    static double allahindluseProtsent() {
        double protsent = Math.random()*100;
        return protsent;
    }
}