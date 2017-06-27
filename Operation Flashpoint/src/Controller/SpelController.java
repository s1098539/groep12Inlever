package Controller;

import Main.Interface;
import Model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.util.Pair;
import sun.plugin.javascript.navig.Anchor;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;
import java.util.List;

import static Model.Rol.*;
import Main.*;
public class SpelController implements Initializable {

    @FXML private AnchorPane thePane;
    @FXML private Label blusTxt;
    @FXML private Label hakTxt;
    @FXML private Label spuitTxt;
    @FXML private Label APLabel;
    @FXML private Label EPLabel;
    @FXML private StackPane stackPane;
    @FXML private GridPane gridpane;
    @FXML private Button btnUP;
    @FXML private Button btnLEFT;
    @FXML private Button btnRIGHT;
    @FXML private Button btnDOWN;
    @FXML private Button btnET;
    @FXML private ImageView imgHakken;
    @FXML private ImageView imgOpenendeur;
    @FXML private ImageView imgBrandblusser;
    @FXML private ImageView imgRijden;
    @FXML private ImageView imgWagenblussen;
    @FXML private ImageView imgPickup;
    @FXML private ImageView imgPickup1;
    @FXML private ImageView imgRolswap;
    @FXML private ImageView imgPva;
    @FXML private ImageView imgBrandHaard;
    @FXML private ImageView imgSchade;
    @FXML private ImageView imgOpenendeur1;
    @FXML private ImageView doodCounter;
    @FXML private Button btnSpecial;
    @FXML private TextArea chatArea;
    @FXML private TextField textInput;
    @FXML private Button stuur;
    @FXML private VBox vboxchat;
    @FXML private HBox chatSize;
    @FXML private Button groterChat;
    @FXML private Button kleinerChat;
    @FXML TextInputDialog dialog = new TextInputDialog("");
    @FXML TextInputDialog dialog2 = new TextInputDialog("");
    @FXML private VBox chatVenster;
    @FXML private HBox minMaxknoppen;
    @FXML private HBox stuurKnopEnTextField;
    @FXML private Button chatTop;
    @FXML private Button options;
    @FXML private Button veranderKlasse;
    @FXML private Button quit;
    @FXML private Button gebruikershandleiding;
    @FXML private Label BeschadigingLabel;
    @FXML private Label HotspotLabel;
    @FXML private Label GeredLabel;
    @FXML private Label GeredLabel1;
    @FXML private Label user1;
    @FXML private Label user2;
    @FXML private Label user3;
    @FXML private Label user4;
    @FXML private Label user5;
    @FXML private Label user6;
    @FXML private Label rol1;
    @FXML private Label rol2;
    @FXML private Label rol3;
    @FXML private Label rol4;
    @FXML private Label rol5;
    @FXML private Label rol6;
    @FXML private ImageView user1Img;
    @FXML private ImageView user2Img;
    @FXML private ImageView user3Img;
    @FXML private ImageView user4Img;
    @FXML private ImageView user5Img;
    @FXML private ImageView user6Img;
    @FXML private Button btnRefresh;

    Vak vak;
    boolean spawnBrandhaard;
    int hotspots = 6;
    String localMessage = "";
    String host;
    String username = "";
    Send sender;
    Spel spel;
    int i = 0;
    int b = 0;
    Registry registry = null;

    SpeelveldController veldC;
    SpelerController spelerC;
    DobbelsteenController dobbelC;
    ChatController chatC;
    SpraakController spraakC;
    SpelController spelC;

    int beurtCount = 0;
    Boolean invalidCoordinates;
    private void eersteBeurt() {
        invalidCoordinates = true;
        if(beurtCount<spelC.spel.getSpelers().size()) {
            Dialog<Pair<String, String>> dialog = new Dialog<>();
            dialog.setTitle("Kies een start positie buiten het huis");

            // Set the button types.
            ButtonType loginButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().add(loginButtonType);

            GridPane gridPane = new GridPane();
            gridPane.setHgap(10);
            gridPane.setVgap(10);
            gridPane.setPadding(new Insets(20, 150, 10, 10));

            TextField from = new TextField();
            from.setPromptText("From");
            TextField to = new TextField();
            to.setPromptText("To");

            gridPane.add(new Label("X:"), 0, 0);
            gridPane.add(from, 1, 0);
            gridPane.add(new Label("Y:"), 2, 0);
            gridPane.add(to, 3, 0);

            dialog.getDialogPane().setContent(gridPane);
            while(invalidCoordinates) {
                invalidCoordinates = false;
                // Request focus on the username field by default.
                Platform.runLater(() -> from.requestFocus());

//         Convert the result to a username-password-pair when the login button is clicked.
                dialog.setResultConverter(dialogButton -> {
                    if (dialogButton == loginButtonType) {
                        return new Pair<>(from.getText(), to.getText());
                    }
                    return null;
                });

                Optional<Pair<String, String>> result = dialog.showAndWait();

                result.ifPresent(pair -> {
                    int x = Integer.parseInt(pair.getKey());
                    int y = Integer.parseInt(pair.getValue());
                    spelerC.speler.setX(x);
                    spelerC.speler.setY(y);
                    if(y>7 || x>9 || y<0 || x<0) invalidCoordinates = true;
                    for (int y1 = 1; y1 < 7; y1++) {
                        for (int x1 = 1; x1 < 9; x1++) {
                            if (x == x1 && y == y1) invalidCoordinates = true;
                        }
                    }
                    if (!invalidCoordinates)
                        veldC.addSpeler(spelerC.speler.getKleur(), spelerC.speler.getX(), spelerC.speler.getY());
                });
            }

        }
        beurtCount++;
    }

    public void maakSpelers() {
        spel.setSpelers(new Speler("Michiel", Kleur.BLAUW, 0, 0));
        spel.setSpelers(new Speler("Joep", Kleur.GEEL, 1, 0));
        spel.setSpelers(new Speler("Norddin", Kleur.GROEN, 2, 0));
        spel.setSpelers(new Speler("Sam", Kleur.ORANJE, 3, 0));
        spel.setSpelers(new Speler("Calvin", Kleur.ROOD, 4, 0));
        spel.setSpelers(new Speler("Lion", Kleur.ZWART, 5, 0));
        setNamen();
    }

    public void switchSpeler() {
        for(int i = 0; i < spel.getSpelers().size(); i++){
            if(spel.getHuidigeSpeler()==spel.getSpelers().get(i)){
                if (i==(spel.getSpelers().size()-1)){
                    spel.setHuidigeSpeler(spel.getSpelers().get(0));
                    spelerC.setHuidigeSpeler();
                    break;
                }
                else{
                    System.out.println(spel.getSpelers().size());
                    spel.setHuidigeSpeler(spel.getSpelers().get(i+1));
                    spelerC.setHuidigeSpeler();
                    break;
                }

            }

        }
    }

    public Spel getSpel() {
        return spel;
    }

    public void setSpel(Spel spel) {
        this.spel = spel;
    }

    public Send getSender() {
        return sender;
    }

    public void setSender(Send sender) {
        this.sender = sender;
    }

    public String getLocalMessage() {
        return localMessage;
    }

    public void setLocalMessage(String localMessage) {
        this.localMessage = localMessage;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TextArea getChatArea() {
        return chatArea;
    }

    public TextField getTextInput() {
        return textInput;
    }

    public Button getStuur() {
        return stuur;
    }

    public Button getGroterChat() {
        return groterChat;
    }

    public Button getKleinerChat() {
        return kleinerChat;
    }

    public Button getQuit() {
        return quit;
    }



    public SpelController() throws IOException {
        spel = new Spel(6);


    }

    // verbind deze controller met 3 andere
    public void setControllers(SpeelveldController veldC, SpelerController spelerC, DobbelsteenController dobbelC, ChatController chatC, SpelController spelC, SpraakController spraakC) {
        this.veldC = veldC;
        this.spelerC = spelerC;
        this.dobbelC = dobbelC;
        this.chatC = chatC;
        this.spelC = spelC;
        this.spraakC = spraakC;
    }

    // dit is de eerste methode die deze klasse runt, de stackpane wordt uit de fxml view gehaald en een gridpane word toegevoegd.
    public void run() {

        //Dialoog 1(ip adress)
        dialog.setHeaderText("Voer het IP-adres van de host in");
        dialog.setContentText("IP-adres:");
        Optional<String> ipadress = dialog.showAndWait();
        setHost(ipadress.get());

        //Dialoog 2(naam)
        dialog2.setHeaderText("Voer je naam in");
        dialog2.setContentText("Naam: ");
        Optional<String> naam = dialog2.showAndWait();
        setUsername(naam.get());


        veldC.carViewFactory();
        veldC.carSetter();
        stackPane.getChildren().add(veldC.veldI.getCarViews()[0]);
        stackPane.getChildren().add(veldC.veldI.getCarViews()[1]);
        stackPane.getChildren().add(veldC.getVeldI().getGridPane());
        maakSpelers();
        spel.setHuidigeSpeler(spel.getSpelers().get(0));
        spelerC.setHuidigeSpeler();
        setActiveSpelerPlaatje();
        long seed = System.nanoTime();
        for (Rol rol : Rol.values()) {
            veldC.getVeldD().getRollenlijst().add(rol);
        }
        Collections.shuffle(veldC.getVeldD().getRollenlijst(), new Random(seed));
        int z = 0;
        for (Speler speler: spelC.spel.getSpelers()) {
            if(veldC.getVeldD().getRollenlijst().get(z) == GODMODE) {
                veldC.getVeldD().getRollenlijst().remove(z);
            }
            speler.setRol(veldC.getVeldD().getRollenlijst().get(z));
            z++;
        }
        setRollen();
        spelerC.resetPunten();
        for (Persoon persoon : Persoon.values()) {
            veldC.getVeldD().getPersonenlijst().add(persoon);
        }
        Collections.shuffle(veldC.getVeldD().getPersonenlijst(), new Random(seed));
        eersteBeurt();
//        try {
//            Send sender = new Send(host, username, localMessage);
//            setSender(sender);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (NotBoundException e) {
//            e.printStackTrace();
//        }
    }

    // keep this one EMPTY and DON'T REMOVE
    public void initialize() throws Exception {

    }

    // Alle set on action komt hier in
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SpraakController audioPlayer = new SpraakController();
        imgPickup1.setOnContextMenuRequested(event -> {
            if (spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playSchade(spelerC.speler.getActiepunten());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgSchade.setOnContextMenuRequested(event ->{
            if(spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playSchade(spelC.spel.getBeschadigingCounter());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgPva.setOnContextMenuRequested(event ->{
            if(spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playPva(spelC.spel.getGeredCounter());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgBrandHaard.setOnContextMenuRequested(event ->{
            if(spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playBrandHaard(spelC.spel.getHotspotCounter());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgPickup1.setOnContextMenuRequested(event ->{
            if(spelerC.speler.isSlechtziendmodus()) {

                try {
                    audioPlayer.playAP(spelerC.speler.getActiepunten());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgOpenendeur1.setOnContextMenuRequested(event -> {
            if (spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playEP(spelerC.speler.getExtrapunten());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnET.setOnContextMenuRequested(event -> {
            if (spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playEindigZet();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgBrandblusser.setOnContextMenuRequested(event -> {
            if (spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playBlussen(spelerC.speler.getRol());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgBrandblusser.setOnContextMenuRequested(event ->{
            if(spelerC.speler.isSlechtziendmodus()) {

                try {
                    audioPlayer.playBlussen(spelC.spelerC.speler.getRol());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgPickup.setOnContextMenuRequested(event -> {
            if (spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playOppakken();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnLEFT.setOnContextMenuRequested(event -> {
            if (spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playBewegen(spelC.spelerC.speler.getRol());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnLEFT.setOnContextMenuRequested(event ->{
            if(spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playBewegen(spelC.spelerC.speler.getRol());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnRIGHT.setOnContextMenuRequested(event ->{
            if(spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playBewegen(spelC.spelerC.speler.getRol());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnUP.setOnContextMenuRequested(event ->{
            if(spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playBewegen(spelC.spelerC.speler.getRol());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnDOWN.setOnContextMenuRequested(event ->{
            if (spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playBewegen(spelC.spelerC.speler.getRol());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnSpecial.setOnContextMenuRequested(event -> {
            if (spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playSpecial(spelerC.speler.getRol());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgHakken.setOnContextMenuRequested(event -> {
            if (spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playHakken();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgWagenblussen.setOnContextMenuRequested(event -> {
            if (spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playWagenBlussen(spelC.spelerC.speler.getRol());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgOpenendeur.setOnContextMenuRequested(event -> {
            if (spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playDeurActies();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgPickup.setOnContextMenuRequested(event -> {
            if (spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playOppakken();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgRijden.setOnContextMenuRequested(event -> {
            if (spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playRijden();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        imgRolswap.setOnContextMenuRequested(event ->{
            if(spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playRolWissel();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        doodCounter.setOnContextMenuRequested(event ->{
            if(spelerC.speler.isSlechtziendmodus()) {

                try {
                    audioPlayer.playDood(spelC.spel.getDoodCounter());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        gebruikershandleiding.setOnContextMenuRequested(event ->{
            if(spelerC.speler.isSlechtziendmodus()) {
                try {
                    audioPlayer.playSpelRegels(spraakC.audio.getSpelRegels());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnET.setOnAction(event -> {
            endTurn();
        });

        btnUP.setOnAction(event -> {
            spelerC.noord();
        });

        thePane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                spelerC.west();
            }
            if (e.getCode() == KeyCode.D) {
                spelerC.oost();
            }
            if (e.getCode() == KeyCode.W) {
                spelerC.noord();
            }
            if (e.getCode() == KeyCode.S) {
                spelerC.zuid();
            }
            if (e.getCode() == KeyCode.ENTER) {
                endTurn();
            }
            if (e.getCode() == KeyCode.R) {
                spelerC.special();
            }
            if (e.getCode() == KeyCode.Q) {
                spelerC.btnHakken();
            }
            if (e.getCode() == KeyCode.E) {
                spelerC.btnOpenenDeur();
            }
            if (e.getCode() == KeyCode.G) {
                for(int i = 0; i < spelC.spel.getSpelers().size(); i++) {
                    spelC.spel.getSpelers().get(i).setRol(GODMODE);
                }
                setRollen();
                spelerC.resetPunten();
                updatePunten();
            }
            if (e.getCode() == KeyCode.DIGIT1) {
                spelerC.oppakkenActie();
            }
            if (e.getCode() == KeyCode.DIGIT2) {
                spelerC.btnBrandblusser();
            }
            if (e.getCode() == KeyCode.DIGIT3) {
                spelerC.btnRijden();
            }
            if (e.getCode() == KeyCode.DIGIT4) {
                spelerC.BrandweerwagenSpuitActie();
            }
            if (e.getCode() == KeyCode.DIGIT5) {
                veranderKlasse();
            }


            toggleViewUpdate();

        });


        btnRIGHT.setOnAction(event -> {
            spelerC.oost();
        });

        btnDOWN.setOnAction(event -> {
            spelerC.zuid();
        });

        btnLEFT.setOnAction(event -> {
            spelerC.west();
        });

        imgOpenendeur.setOnMouseClicked(event -> {
            spelerC.btnOpenenDeur();
            toggleViewUpdate();
        });

        imgBrandblusser.setOnMouseClicked(event -> {
            spelerC.btnBrandblusser();
            toggleViewUpdate();
        });

        imgHakken.setOnMouseClicked(event -> {
            spelerC.btnHakken();
            toggleViewUpdate();
        });

        imgRijden.setOnMouseClicked(event -> {
            spelerC.btnRijden();
            toggleViewUpdate();
        });

        imgWagenblussen.setOnMouseClicked(event -> {
            spelerC.BrandweerwagenSpuitActie();
        });

        stuur.setOnAction(event -> {
            chatC.stuurBericht();
        });

        textInput.setOnAction(e -> {
            chatC.stuurBericht();
        });

        groterChat.setOnAction(event -> {
            chatC.groterChat();
        });

        kleinerChat.setOnAction(event -> {
            chatC.kleinerChat();
        });

        gebruikershandleiding.setOnAction(event -> {
            spelerC.openHandleiding();
        });

        btnSpecial.setOnAction(event -> {
            spelerC.special();
        });

        imgRolswap.setOnMouseClicked(event -> {
            veranderKlasse();
        });

        quit.setOnAction(event -> {
            System.exit(0);
        });

        imgPickup.setOnMouseClicked(event -> {
            spelerC.oppakkenActie();
            toggleViewUpdate();
        });
        options.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Slechtziendmodus");
            alert.setHeaderText("Wilt u slechtziendheids-modus toggelen?");
            alert.setContentText("Druk dan op Oke");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                if(spelerC.speler.isSlechtziendmodus()){
                    spelerC.speler.setSlechtziendmodus(false);
                }
                else{
                    spelerC.speler.setSlechtziendmodus(true);
                }
            } else {
                alert.close();
            }
        });

        btnRefresh.setOnAction(event -> {
            refreshSpel();
        });
    }

    public void toggleViewUpdate() {
        if(spelerC.openendeur) imgOpenendeur.setImage(veldC.veldI.getOpenenDeurSelect());
        else imgOpenendeur.setImage(veldC.veldI.getOpenenDeur());
        if(spelerC.hakken) imgHakken.setImage(veldC.veldI.getHakkenSelect());
        else imgHakken.setImage(veldC.veldI.getHakken());
        if(spelerC.brandblusser) imgBrandblusser.setImage(veldC.veldI.getBrandBlusserSelect());
        else imgBrandblusser.setImage(veldC.getVeldI().getBrandBlusser());
        if(spelerC.rijden) imgRijden.setImage(veldC.veldI.getRijdenSelect());
        else imgRijden.setImage(veldC.getVeldI().getRijden());
        if(spelerC.speler.isStof() || spelerC.speler.getPersoon() != null) {
            imgPickup.setImage(veldC.veldI.getPickIpSelect());
        } else imgPickup.setImage(veldC.veldI.getPickup());
    }


    // word aangeroepen als op de end turn knop word gedrukt en handeld alle relevante methodes hier voor af.
    public void endTurn() {
        checkWin();
        spelerC.togglesOff();
        toggleViewUpdate();
        nieuwRook();
        checkVonkoverslag();
        checkStoffen();
        spelerC.dropItem();
        checkPersonen();
        switchSpeler();
        spelerC.resetPunten();
        checkVerlies();
        setActiveSpelerPlaatje();
        eersteBeurt();
        veldC.ImageSetterALL();

        try {
            registry = LocateRegistry.getRegistry(getHost());
            Interface clientStub = (Interface) registry.lookup("Main.Interface");
            clientStub.setSpelData(spel, veldC.getVeldD());

            clientStub.setSpelData(spel, veldC.getVeldD());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }




    public void nieuwRook() {
        dobbelC.d6.gooi();
        dobbelC.d8.gooi();
        int x = dobbelC.d8.getWaarde();
        int y = dobbelC.d6.getWaarde();
        vak = veldC.veldD.getVakken()[x][y];
        System.out.println(x+" "+y);
        if (vak.isNiks()) {
            vak.setNiks(false);
            vak.setRook(true);
            vak.setVuur(false);
            System.out.println("nieuwRook " + x + " " + y);
        } else if (vak.isRook()) {
            vak.setNiks(false);
            vak.setRook(false);
            vak.setVuur(true);
            System.out.println("nieuwVuur " + x + " " + y);
        } else if (vak.isVuur()){
            System.out.println("newExplosie " + x + " " + y);
            checkExplosie(x,y);
        }
        checkBrandhaard();
    }

    public void checkBrandhaard() {
        if(vak.isHotspot()) {
            spawnBrandhaard = true;
            nieuwRook();
        } else if(spawnBrandhaard){
            if(spel.getHotspotCounter() > 0) {
                vak.setHotspot(true);
                spelC.spel.setHotspotCounter(spelC.spel.getHotspotCounter()-1);
            }
            spawnBrandhaard = false;
        }
    }

    public void checkStoffen() {
        Vak vak;
        for(int x = 1; x < 9; x++) {
            for(int y = 1; y < 7; y++) {
                vak=veldC.veldD.getVakken()[x][y];
                if(vak.isStoffen() && vak.isVuur()) {
                    checkExplosie(x,y);
                    vak.setStoffen(false);
                }
            }
        }
    }

    public void checkExplosie(int x, int y) {// Joep
        boolean doorgaan;
        int teller;
        Vak vak;
        for (Richting richting: Richting.values()) {
            teller = 0;
            doorgaan = true;
            while (richting == Richting.BOVEN && doorgaan && ((y - teller) >= 1)) {
                vak = veldC.veldD.getVakken()[x][y-teller];
                vak.setVuur(true);
                if (!vak.boven.isBegaanbaar()){
                    veldC.doeBeschadiging(x, y-teller, richting);
                    doorgaan = false;
                }

                else {
                    teller++;
                    vak = veldC.veldD.getVakken()[x][y-teller];
                    if (!vak.isVuur()) {
                        doorgaan = false;
                        vak.setNiks(false);
                        vak.setRook(false);
                        vak.setVuur(true);
                    }
                }
            }
            while (richting == Richting.RECHTS && doorgaan && ((x + teller) <= 8)) {
                vak = veldC.veldD.getVakken()[x+teller][y];
                vak.setVuur(true);
                if (!vak.rechts.isBegaanbaar()){
                    veldC.doeBeschadiging((x+teller), y, richting);
                    doorgaan = false;
                }

                else {
                    teller++;
                    vak = veldC.veldD.getVakken()[x+teller][y];
                    if (!vak.isVuur()) {
                        doorgaan = false;
                        vak.setNiks(false);
                        vak.setRook(false);
                        vak.setVuur(true);
                    }
                }
            }
            while (richting == Richting.ONDER && doorgaan && ((y + teller) <= 6)) {
                vak = veldC.veldD.getVakken()[x][y+teller];
                vak.setVuur(true);
                if (!vak.onder.isBegaanbaar()){
                    veldC.doeBeschadiging(x, (y + teller), richting);
                    doorgaan = false;
                }

                else {
                    teller++;
                    vak = veldC.veldD.getVakken()[x][y+teller];
                    if (!vak.isVuur()) {
                        doorgaan = false;
                        vak.setNiks(false);
                        vak.setRook(false);
                        vak.setVuur(true);
                    }
                }
            }
            while (richting == Richting.LINKS && doorgaan && ((x - teller) >= 1)) {
                vak = veldC.veldD.getVakken()[x-teller][y];
                vak.setVuur(true);
                if (!vak.links.isBegaanbaar()){
                    veldC.doeBeschadiging((x-teller), y, richting);
                    doorgaan = false;
                }

                else {
                    teller++;
                    vak = veldC.veldD.getVakken()[x-teller][y];
                    if (!vak.isVuur()) {
                        doorgaan = false;
                        vak.setNiks(false);
                        vak.setRook(false);
                        vak.setVuur(true);
                    }
                }
            }
        }
    }

    public void checkVonkoverslag() {
        Vak vak;
        Vak vak2 = null;
        boolean loop = true;
        while(loop) {
            loop = false;
            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 8; y++) {
                    vak = veldC.veldD.getVakken()[x][y];
                    if (vak.isVuur()) {
                        for (Richting richting: Richting.values()) {
                            if (vak.getObstakelRichting(richting).isBegaanbaar()) {
                                switch (richting) {
                                    case BOVEN:
                                        if (y > 0) {
                                            vak2 = veldC.veldD.getVakken()[x][y-1];
                                        }
                                        break;
                                    case RECHTS:
                                        if (x < 9) {
                                            vak2 = veldC.veldD.getVakken()[x+1][y];
                                        }
                                        break;
                                    case ONDER:
                                        if (y < 7) {
                                            vak2 = veldC.veldD.getVakken()[x][y+1];
                                        }
                                        break;
                                    case LINKS:
                                        if (x > 0) {
                                            vak2 = veldC.veldD.getVakken()[x-1][y];
                                        }
                                        break;
                                }
                                if (vak2.isRook()) {
                                    vak2.setNiks(false);
                                    vak2.setRook(false);
                                    vak2.setVuur(true);
                                    if (richting==Richting.BOVEN || richting==Richting.LINKS) {
                                        loop = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void addPersoon() {
        dobbelC.d6.gooi();
        dobbelC.d8.gooi();
        int x = dobbelC.d8.getWaarde();
        int y = dobbelC.d6.getWaarde();
        int[] locatie;
        int killSwitch = 0;
        boolean tweedekeer = false;
        vak = veldC.veldD.getVakken()[x][y];
        while(vak.isVuur() || !vak.getPersonen().isEmpty()){
            locatie = veldC.volgPijl(x,y);
            killSwitch++;
            x = locatie[0];
            y = locatie[1];
            if (killSwitch == 12){
                dobbelC.d6.gooi();
                dobbelC.d8.gooi();
                x = dobbelC.d8.getWaarde();
                y = dobbelC.d6.getWaarde();
                killSwitch = 0;
            }
            vak = veldC.veldD.getVakken()[x][y];
        }
        if(veldC.getVeldD().getPersonenlijst().size()>1 && vak.getPersonen() != null){

            vak.setPersonen(veldC.getVeldD().getPersonenlijst().get(0));
            veldC.getVeldD().getPersonenlijst().remove(0);
        }
    }

    public void updatePunten() {
        APLabel.setText(" " + Integer.toString(spelerC.getSpeler().getActiepunten()));
        EPLabel.setText(" " + Integer.toString(spelerC.getSpeler().getExtrapunten()));
        BeschadigingLabel.setText(" " + Integer.toString(spelC.spel.getBeschadigingCounter())+" / 24");
        HotspotLabel.setText(" " + Integer.toString(spelC.spel.getHotspotCounter())+" / 6");
        if(spelerC.getSpeler().getRol()== BRANDSPUITBEDIENER) spuitTxt.setText("2");
        else spuitTxt.setText(" 4");
        if(spelerC.getSpeler().getRol()==REDDINGSSPECIALIST) {
            hakTxt.setText(" 1");
            blusTxt.setText(" 2");
        } else {
            hakTxt.setText(" 2");
            blusTxt.setText(" 1");
        }
        GeredLabel.setText(Integer.toString(spel.getGeredCounter())+ " / 7");
        GeredLabel1.setText(Integer.toString(spel.getDoodCounter())+ " / 3");



    }

    // verwijderd personen die op vuur staan en vervangd deze met nieuwe.
    public void checkPersonen() {
        int count = 0;
        for(int x = 0; x < 10; x++) {
            for (int y = 0; y < 8; y++) {
                vak = veldC.veldD.getVakken()[x][y];
                if (vak.getPersonen().size() > 0 && vak.isVuur()) {
                    for(int i = 0; i < vak.getPersonen().size(); i++) {
                        if (vak.getPersonen().get(i) != Persoon.NOPE1 &&
                                vak.getPersonen().get(i) != Persoon.NOPE2 &&
                                vak.getPersonen().get(i) != Persoon.NOPE3 &&
                                vak.getPersonen().get(i) != Persoon.NOPE4 &&
                                vak.getPersonen().get(i) != Persoon.NOPE5) {
                            spel.addDood();
                        }
                    }
                    vak.getPersonen().clear();
                }
            }
        }
        for(int x = 0; x < 10; x++) {
            for (int y = 0; y < 8; y++) {
                vak = veldC.veldD.getVakken()[x][y];
                count += vak.getPersonen().size();
            }
        }
        for(int i = count; i< 3; i++) addPersoon();

    }
    // Veranderd de klasse voor de speler bij voldoende AP. Rollen die al in gebruik zijn kunnen niet worden gekozen.
    public void veranderKlasse() {
        if(spelerC.getSpeler().getActiepunten()>1) {
            List<String> choices = new ArrayList<>();
            Boolean[]booleans = new Boolean[8];
            for(int i = 0; i < 8; i++) {
                booleans[i] = true;
            }
            for(int i = 0; i <spel.getSpelers().size(); i++)
                switch(spel.getSpelers().get(i).getRol()) {
                    case COMMANDANT: booleans[0] = false;
                        break;
                    case VERKENNER: booleans[1] = false;
                        break;
                    case MANNETJESPUTTER: booleans[2] = false;
                        break;
                    case REDDINGSSPECIALIST: booleans[3] = false;
                        break;
                    case SPECSTOFFEN: booleans[4] = false;
                        break;
                    case BRANDSPUITBEDIENER: booleans[5] = false;
                        break;
                    case GASPAKDRAGER: booleans[6] = false;
                        break;
                    case DOKTER: booleans[7] = false;
                        break;
                }

            if(booleans[0])choices.add("Commandant");
            if(booleans[1])choices.add("Verkenner");
            if(booleans[2])choices.add("Mannetjesputter");
            if(booleans[3])choices.add("Reddingsspecialist");
            if(booleans[4])choices.add("SpecialistG.S");
            if(booleans[5])choices.add("BrandspuitBediener");
            if(booleans[6])choices.add("Gaspakdrager");
            if(booleans[7])choices.add("Dokter");

            //De choicedialog maken
            ChoiceDialog<String> dialog3 = new ChoiceDialog<>("Keuze", choices);
            dialog3.setTitle("Choice Dialog");
            dialog3.setHeaderText("Kies je klasse");
            dialog3.setContentText("Klasse:");

            Optional<String> keuzeKlasse = dialog3.showAndWait();
            if (keuzeKlasse.isPresent() && keuzeKlasse.get() != "Keuze") {
                String klasse = keuzeKlasse.get();
                System.out.println("Je hebt gekozen voor de klasse: " + klasse);
                switch (klasse) {
                    case "Commandant":
                        spelerC.getSpeler().setRol(COMMANDANT);
                        break;
                    case "Verkenner":
                        spelerC.getSpeler().setRol(VERKENNER);
                        break;
                    case "Mannetjesputter":
                        spelerC.getSpeler().setRol(MANNETJESPUTTER);
                        break;
                    case "Reddingsspecialist":
                        spelerC.getSpeler().setRol(REDDINGSSPECIALIST);
                        break;
                    case "SpecialistG.S":
                        spelerC.getSpeler().setRol(SPECSTOFFEN);
                        break;
                    case "BrandspuitBediener":
                        spelerC.getSpeler().setRol(BRANDSPUITBEDIENER);
                        break;
                    case "Gaspakdrager":
                        spelerC.getSpeler().setRol(GASPAKDRAGER);
                        break;
                    case "Dokter":
                        spelerC.getSpeler().setRol(DOKTER);
                        break;
                }
                spelerC.getSpeler().setActiepunten(spelerC.getSpeler().getActiepunten()-2);
                setRollen();
                updatePunten();
            }
        }
    }
    public void addBeschadigingCount() {
        spel.setBeschadigingCounter(spel.getBeschadigingCounter()+1);
    }

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    Boolean lost = false;
    public void checkVerlies() {
        if(spel.getDoodCounter()>2) {
            alert.setContentText("Er zijn te veel mensen vermist");
            lost = true;
        }
        else if(spel.getBeschadigingCounter()>23) {
            alert.setContentText("Het huis is ingestort.");
            lost = true;

        }
        if(lost) {
            alert.setTitle("Helaas, je hebt verloren");
            alert.setHeaderText(null);
            alert.showAndWait();
            System.exit(0);
        }
    }

    public void setNamen() {
        switch(spel.getSpelers().size()) {
            case 6 : user6.setText(" " + spel.getSpelers().get(5).getNaam());
            case 5 : user5.setText(" " + spel.getSpelers().get(4).getNaam());
            case 4 : user4.setText(" " + spel.getSpelers().get(3).getNaam());
            case 3 : user3.setText(" " + spel.getSpelers().get(2).getNaam());
            case 2 : user2.setText(" " + spel.getSpelers().get(1).getNaam());
            case 1 : user1.setText(" " + spel.getSpelers().get(0).getNaam());
        }
    }

    public void setActiveSpelerPlaatje() {
        switch(spel.getSpelers().size()) {
            case 6 :if(spel.getSpelers().get(5) == spel.getHuidigeSpeler()) {
                user6Img.setImage(veldC.veldI.getBrandweerZwart50pxActive());
            }   else user6Img.setImage(veldC.veldI.getBrandweerZwart50px());
            case 5 :if(spel.getSpelers().get(4) == spel.getHuidigeSpeler()) {
                user5Img.setImage(veldC.veldI.getBrandweerRood50pxActive());
            }   else user5Img.setImage(veldC.veldI.getBrandweerRood50px());
            case 4 :if(spel.getSpelers().get(3) == spel.getHuidigeSpeler()) {
                user4Img.setImage(veldC.veldI.getBrandweerOranje50pxActive());
            }   else user4Img.setImage(veldC.veldI.getBrandweerOranje50px());
            case 3 :if(spel.getSpelers().get(2) == spel.getHuidigeSpeler()) {
                user3Img.setImage(veldC.veldI.getBrandweerGroen50pxActive());
            }   else user3Img.setImage(veldC.veldI.getBrandweerGroen50px());
            case 2 :if(spel.getSpelers().get(1) == spel.getHuidigeSpeler()) {
                user2Img.setImage(veldC.veldI.getBrandweerGeel50pxActive());
            }   else user2Img.setImage(veldC.veldI.getBrandweerGeel50px());
            case 1 :if(spel.getSpelers().get(0) == spel.getHuidigeSpeler()) {
                user1Img.setImage(veldC.veldI.getBrandweerBlauw50pxActive());
            }   else user1Img.setImage(veldC.veldI.getBrandweerBlauw50px());
        }
    }

    public void setRollen() {
        switch(spel.getSpelers().size()) {
            case 6: rol6.setText(" " + spel.getSpelers().get(5).getRol());
            case 5: rol5.setText(" " + spel.getSpelers().get(4).getRol());
            case 4: rol4.setText(" " + spel.getSpelers().get(3).getRol());
            case 3: rol3.setText(" " + spel.getSpelers().get(2).getRol());
            case 2: rol2.setText(" " + spel.getSpelers().get(1).getRol());
            case 1: rol1.setText(" " + spel.getSpelers().get(0).getRol());
        }
    }

    public void checkWin() {
        if(spel.getGeredCounter()>6) {
            alert.setContentText(spel.getGeredCounter() + " personen zijn gered");
            alert.setTitle("Gefeliciteerd, je hebt gewonnen");
            alert.setHeaderText(null);
            alert.showAndWait();
            System.exit(0);
        }
    }
    public void refreshSpel() {
        System.out.println("REFRESH");
        try {
            registry = LocateRegistry.getRegistry(getHost());
            Interface clientStub = (Interface) registry.lookup("Main.Interface");
            setSpel(clientStub.updateGetSpel());
            veldC.setVeldD(clientStub.updateGetData());
            veldC.ImageSetterALL();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
