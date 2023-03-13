import java.util.StringJoiner;

public class Toode{
    double hind;
    String nimi;

    public Toode(double hind, String nimi) {
        this.hind = hind;
        this.nimi = nimi;
    }

    public double getHind() {
        return hind;
    }

    @Override
    public String toString() {
        return " " + nimi + " " + hind;
    }
}
