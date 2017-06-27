package Controller;


import Model.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

import static Model.Status.*;

public class SpeelveldController {
    private static final long serialVersionUID = 1L; //Necessary for RMI Marshalling

    SpeelveldData veldD;

    public SpeelveldData getVeldD() {
        return veldD;
    }

    public void setVeldD(SpeelveldData veldD) {
        this.veldD = veldD;
    }
}