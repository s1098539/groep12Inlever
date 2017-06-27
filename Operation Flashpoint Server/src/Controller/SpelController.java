package Controller;

import Model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.*;

import static Model.Rol.BRANDSPUITBEDIENER;
import static Model.Rol.REDDINGSSPECIALIST;

public class SpelController implements Initializable, Serializable {
    Spel spel;

    public Spel getSpel() {
        return spel;
    }

    public void setSpel(Spel spel) {
        this.spel = spel;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

