package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Sam van Schaik
 */

public class Spel implements Serializable {
    private static final long serialVersionUID = 1L; //Necessary for RMI Marshalling


    int hotspotCounter = 0;
    int beschadigingCounter = 0;
    int geredCounter = 0;
    ArrayList<Speler> spelers = new ArrayList<>();
    Speler huidigeSpeler;

    public Speler getHuidigeSpeler() {
        return huidigeSpeler;
    }

    public void setHuidigeSpeler(Speler huidigeSpeler) {
        this.huidigeSpeler = huidigeSpeler;
    }

    public void setSpelers(Speler speler) {
        if (spelers.size()<7) {
            this.spelers.add(speler);
        }
    }
    public ArrayList<Speler> getSpelers(){
        return spelers;
    }
    int doodCounter;

    int hotspots;

    public int getDoodCounter() {
        return doodCounter;
    }

    public void setDoodCounter(int doodCounter) {
        this.doodCounter = doodCounter;
    }

    public void addDood(){
        doodCounter ++;
    }

    public void addHotspot(){
        hotspotCounter ++;
    }

    public void deductHotspot(){
        hotspotCounter --;
    }

    public int getHotspotCounter() {
        return hotspotCounter;
    }

    public void setHotspotCounter(int hotspotCounter) {
        this.hotspotCounter = hotspotCounter;
    }

    public int getBeschadigingCounter() {
        return beschadigingCounter;
    }

    public void setBeschadigingCounter(int beschadigingCounter) {
        this.beschadigingCounter = beschadigingCounter;
    }

    public int getGeredCounter() {
        return geredCounter;
    }
    public void addGered(){
        geredCounter++;
    }

    public Spel(int hotspotCounter) {
        this.hotspotCounter = hotspotCounter;
    }


}
