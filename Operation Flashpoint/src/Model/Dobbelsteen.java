package Model;
import java.util.Random;

public class Dobbelsteen {

    private int waarde;
    private int aantalOgen;


    public Dobbelsteen(int aantalOgen) {
        this.aantalOgen = aantalOgen;
    }

    public void gooi() {
        Random random = new Random();
        waarde = random.nextInt(aantalOgen)+1;
    }

    public void flip() {
        waarde = aantalOgen+1-waarde;
    }

    public int getWaarde() {
        return waarde;
    }
}
