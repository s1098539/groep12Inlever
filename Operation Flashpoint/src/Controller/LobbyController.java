package Controller;
import Model.Kleur;
import Model.Lobby;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by Joep Oonk on 14-6-2017.
 */
//beetje erbij
public class LobbyController extends Application {
    Lobby model = new Lobby();
    @FXML
    private Button btnIP;
    @FXML
    private TextField IPtext;
    @FXML
    private Button btnHelpIP;
    @FXML
    private Button btnNaam;
    @FXML
    private TextField naamText;
    @FXML
    private Button btnHelpNaam;
    @FXML
    private Button btnReady;
    @FXML
    private Button btnHelpReady;
    Parent root;
    Scene scene;
    Stage stage;
    SpelerController spelerC;
    SpelController spelC;
    public LobbyController(SpelerController spelerC, SpelController spelC){
        this.spelerC = spelerC;
        this.spelC = spelC;
    }

    public LobbyController() {
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/LobbyView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Lobby");
        stage.show();
    }
    public void Launch(){
        LobbyController.launch(LobbyController.class);
    }

    @FXML
    public void setIPtext() throws IOException{
        model.setIp(IPtext.getText());
        getIP();
        Parent root = FXMLLoader.load(getClass().getResource("/View/NaamView.fxml"));
        stage = (Stage) btnIP.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void helpdialoog(){
        System.out.println("yeah boy");

    }

    public Kleur getSpelerKleur(){
        return model.getKleur();

    }

    public void getIP(){
        System.out.println(model.getIp());
    }
    @FXML
    public void naamHelp(){
        System.out.println("eindelijk");

    }
    @FXML
    public void setNaam() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/View/ReadyView.fxml"));
        stage = (Stage) btnNaam.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void setReady() throws IOException{
        model.setReady(spelC.spel.getHuidigeSpeler());
        btnReady.setText("Ready");
        System.out.println("oke");
        if(checkReady()){
            System.out.println("oke iedereen ready");
        }
    }
    @FXML
    public void readyHelp(){
        System.out.println("deze werkt ook");
    }
    private boolean checkReady(){
        if (spelC.spel.getSpelers().size() == model.getAantalReady()){
            return true;
        }
        else{
            return false;
        }
    }

}
