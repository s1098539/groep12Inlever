package Model;

/**
 * Created by lion on 14-06-17.
 */
public enum Persoon {
    HOND(false, false), EGEL(false, false), GROENHAAR(false, false), HIPSTERSNOR(false, false), LATIFAH(false, false),
    OBAMANIGUA(false, false), OMA(false, false), ROODHAAR(false, false), SNEK(false, false),
    VIS(false, false), NOPE1(false, false), NOPE2(false, false), NOPE3(false, false), NOPE4(false, false), NOPE5(false, false);
    private boolean gered;
    private boolean omgedraaid;
    private boolean geheeld = false;

    public boolean isGeheeld() {
        return geheeld;
    }

    public void setGeheeld() {
        this.geheeld = true;
    }

    Persoon(boolean omgedraaid, boolean gered) {
        this.gered = gered;
        this.omgedraaid = omgedraaid;
    }
    Persoon(boolean omgedraaid){this.omgedraaid = omgedraaid;}

    public boolean isGered() {
        return gered;
    }

    public void setGered(boolean gered) {
        this.gered = gered;
    }

    public boolean isOmgedraaid() {
        return omgedraaid;
    }

    public void setOmgedraaid(boolean omgedraaid) {
        this.omgedraaid = omgedraaid;
    }
}
