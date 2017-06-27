package Model;

import java.io.Serializable;

/**
 * Created by Lenovo on 6/22/2017.
 */
public class Parse implements Serializable {
    public String message;
    private SpeelveldData veldD;

    public Parse(String message, SpeelveldData veldD) {
        this.message = message;
        this.veldD = veldD;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SpeelveldData getVeldD() {
        return veldD;
    }

    public void setVeldD(SpeelveldData veldD) {
        veldD = veldD;
    }
}
