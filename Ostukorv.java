import java.util.HashMap;
import java.util.StringJoiner;

public class Ostukorv {

    HashMap<Integer, Toode> ostukorv;

    public Ostukorv(HashMap<Integer, Toode> ostukorv) {
        this.ostukorv = ostukorv;
    }

    public double ostukorviMaksumus(){

        double summa = 0;

        for (int i = 0; i < ostukorv.size(); i++) {
            summa += ostukorv.get(i).getHind();
        }

        return summa;

    }

    @Override
    public String toString() {
        StringBuilder tooted = new StringBuilder();

        tooted.append("Tooted ostukorvis: \n");
        for (int i = 0; i < ostukorv.size(); i++) {

            tooted.append(ostukorv.get(i).toString()).append('\n');
        }
        return tooted.toString();
    }
}
