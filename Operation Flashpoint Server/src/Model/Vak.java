package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Joep Oonk on 14-6-2017.
 */
public class Vak implements Serializable{
    private static final long serialVersionUID = 1L;


    boolean hotspot = false;
    boolean vuur = false;
    boolean rook = false;
    boolean stoffen = false;
    boolean niks = true;
    Kleur[] kleuren = new Kleur[6];
    ArrayList<Persoon> personen = new ArrayList<>();
    public Status boven = Status.LEEG;
    public Status rechts = Status.LEEG;
    public Status onder = Status.LEEG;
    public Status links = Status.LEEG;

    public Status getObstakelRichting (Richting richting){
        switch(richting){
            case BOVEN: return boven;
            case RECHTS: return rechts;
            case ONDER: return onder;
            case LINKS: return links;
            default: return null;
        }
    }

    public boolean isHotspot() {
        return hotspot;

    }

    public void setHotspot(boolean hotspot) {
        this.hotspot = hotspot;
    }

    public boolean isVuur() {
        return vuur;
    }

    public void setVuur(boolean vuur) {
        this.vuur = vuur;
    }

    public boolean isRook() {
        return rook;
    }

    public void setRook(boolean rook) {
        this.rook = rook;
    }

    public boolean isStoffen() {
        return stoffen;
    }

    public void setStoffen(boolean stoffen) {
        this.stoffen = stoffen;
    }

    public boolean isNiks() {
        return niks;
    }

    public void setNiks(boolean niks) {
        this.niks = niks;
    }

    public Kleur[] getKleuren() {
        return kleuren;
    }

    public void setKleuren(Kleur[] kleuren) {
        this.kleuren = kleuren;
    }

    public ArrayList<Persoon> getPersonen() {
        return personen;
    }

    public void setPersonen(Persoon persoon) {
        this.personen.add(persoon);
    }

    public Status getBoven() {
        return boven;
    }

    public void setBoven(Status boven) {
        this.boven = boven;
    }

    public Status getRechts() {
        return rechts;
    }


    public void setRechts(Status rechts) {
        this.rechts = rechts;
    }

    public Status getOnder() {
        return onder;
    }

    public void setOnder(Status onder) {
        this.onder = onder;
    }

    public Status getLinks() {
        return links;
    }

    public void setLinks(Status links) {
        this.links = links;
    }
}
