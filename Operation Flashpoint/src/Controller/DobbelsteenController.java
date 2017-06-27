package Controller;

import Model.Dobbelsteen;

/**
 * Created by Joep Oonk on 14-6-2017.
 */
public class DobbelsteenController {

    Dobbelsteen d6;
    Dobbelsteen d8;
    SpeelveldController veldC;
    SpelerController spelerC;
    ChatController chatC;
    SpelController spelC;

    // Lion, verbind deze controller met 3 andere
    public void setControllers(SpeelveldController veldC, SpelController spelC, SpelerController spelerC, ChatController chatC) {
        this.veldC = veldC;
        this.spelC = spelC;
        this.spelerC = spelerC;
        this.chatC = chatC;
    }

    public Dobbelsteen getD6() {
        return d6;
    }

    public Dobbelsteen getD8() {
        return d8;
    }

    public DobbelsteenController() {
        d6 = new Dobbelsteen(6);
        d8 = new Dobbelsteen(8);
    }
}
