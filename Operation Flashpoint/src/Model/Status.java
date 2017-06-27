package Model;

/**
 * Created by lion on 14-06-17.
 */
public enum Status {
    MUUR(false), MUUR1(false), MUUR2(true), DEURO(true), DEURD(false), LEEG(true);
    private final boolean begaanbaar;

    public boolean isBegaanbaar() {
        return begaanbaar;
    }


    //
    Status(boolean begaanbaar) {
        this.begaanbaar = begaanbaar;
    }
}
