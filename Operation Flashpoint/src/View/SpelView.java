package View;

import Controller.SpelController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class SpelView {
Scene scene;

    // Zet SpelView.fxml in een scene en stelt spelC in als controller
    public SpelView(SpelController spelC) {
        Parent root = null;
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("SpelView.fxml")
        );
        loader.setController(spelC);
        try {
            root = (Parent) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scene = new Scene(root, 1200, 700);
    }

    public Scene getScene() {
        return scene;
    }
}
