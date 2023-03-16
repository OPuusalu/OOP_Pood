import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {

        HashMap<Integer, Toode> tootedMüügil = loebFailist("tooted.txt");
        Ostukorv ostukorv = new Ostukorv();
        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.println(prindiTooted(tootedMüügil));
            System.out.println("0 - Kui olete lõpetanud");
            System.out.println("Kirjutage toote number, mida soovite lisada ostukorvi.");

            int valik = -1;
            boolean onSisestatudNumber = false;

            while (!onSisestatudNumber) {
                try {
                    valik = scanner.nextInt();
                    onSisestatudNumber = true;
                } catch (Exception e) {
                    System.out.println("Palun sisestage number.");
                    scanner.nextLine();
                }
            }

            System.out.println();

            if (valik == 0) {
                System.out.println();
                System.out.println("-------------------");
                System.out.println();
                System.out.println(ostukorv);
                System.out.printf("Teie ostukorvi maksumus on %s eurot.%n", ostukorv.ostukorviMaksumus());

                double säästetud = ostukorv.kokkuSäästetud();

                if (säästetud > 0)
                    System.out.printf("Olete säästnud oma ostudega %s eurot.", säästetud);
                break;
            }

            if (tootedMüügil.containsKey(valik)){
                Toode toode = tootedMüügil.get(valik);
                System.out.printf("Ostukorvi on lisatud toode%s%n", toode);
                ostukorv.lisaToode(toode);
            }
            else {
                System.out.println("Sellist toodet pole!");
            }
            System.out.println();
            System.out.println("-------------------");
            System.out.println();
        }
    }
    static HashMap<Integer, Toode> loebFailist (String failiNimi) throws FileNotFoundException {
        // Loeme failist andmed, määrame juhuslikult osadele allahindlused, teeme neist klassi Toode isendid ja loome neist HashMapi
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
        // Tootel on 1/3 võimalus, et on parajasti allahindlus
        double arv = Math.random()*100;
        return arv <= 33;
    }
    static double allahindluseProtsent() {
        // Allahindluse protsendi leiame suvaliselt Random abil
        double protsent = Math.random()*100;
        return protsent;
    }
    public static String prindiTooted(HashMap<Integer, Toode> kõikTooted) {

        StringBuilder tooted = new StringBuilder();

        try {
            tooted.append("Tooted poes: \n");
            for (int i = 1; i <= kõikTooted.size(); i++) {
                if (i == kõikTooted.size())
                    tooted.append(i).append(" -").append(kõikTooted.get(i).toString());
                else
                    tooted.append(i).append(" -").append(kõikTooted.get(i).toString()).append("\n");
            }
        }
        catch (Exception e) {
            System.out.println("Tooteid pole");
        }
        return tooted.toString();
    }
}