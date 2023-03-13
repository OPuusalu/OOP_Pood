import java.util.HashMap;

public class test {

    public static void main(String[] args) {

        HashMap<Integer, Toode> tooted = new HashMap<>();

        Toode toode = new Toode(1.99, "Lusikas");
        Toode toode1 = new Toode(1.35, "Säästu lusikas");

        tooted.put(0, toode);
        tooted.put(1, toode1);


       Ostukorv ostukorv = new Ostukorv(tooted);

        System.out.println(ostukorv.ostukorviMaksumus());

        System.out.println(ostukorv);

    }

}
