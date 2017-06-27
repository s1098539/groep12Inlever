package Controller;


import Model.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

import static Model.Status.*;

public class SpeelveldController {

    SpeelveldImages veldI;
    SpeelveldData veldD;
    SpelController spelC;
    SpelerController spelerC;
    DobbelsteenController dobbelC;
    ChatController chatC;

    public SpeelveldController() {

    }

    // verbind deze controller met 3 andere
    public void setControllers(SpelController spelC, SpelerController spelerC, DobbelsteenController dobbelC, ChatController chatC) {
        this.spelC = spelC;
        this.spelerC = spelerC;
        this.dobbelC = dobbelC;
        this.chatC = chatC;
    }

    // dit is het eerste wat deze controller doet, dit stond eerst in de constructor maar dit gaf problemen
    //          aangezien de controller bij het aanmaken nog niet was verbonden met de andere controllers
    public void run() throws Exception {
        FactoryVakken fv = new FactoryVakken();
        fv.createVakken();
        veldD = new SpeelveldData();
        veldD.setVakken(fv.getVakken());

        veldI = new SpeelveldImages();
        veldI.setGridPane(new GridPane());
        veldI.getGridPane().setPrefWidth(700);
        veldI.getGridPane().setPrefHeight(640);
        flowpanesAndImageViewsFactory();
        flowpanesAndImageViewsPlaatser();
        setMap();
        spelC.run();
        for(int i = 0; i<3; i++) {
            spelC.addPersoon();
        }
        ImageSetterALL();
    }

    // maakt alle flowpanes en imageviews aan
    private void flowpanesAndImageViewsFactory() {
        for(int y = 0; y<8; y++) {
            for (int x = 0; x < 10; x++) {
                veldI.getFlowPanes()[x][y]=new FlowPane();
                for(int z = 0; z < 9 ; z++) {
                    veldI.getImageViews()[x][y][z] = new ImageView();
                }
            }
        }
    }
    public void nieuweSpelersToevoegen(){
        for(Speler speler: spelC.spel.getSpelers()){
            addSpeler(speler.getKleur(), speler.getX(), speler.getY());
        }


    }
    //zet in elke gridpane spot(op het veld) een flowpane, en in elke flowpane 9 image views
    private void flowpanesAndImageViewsPlaatser() {
        for(int y = 0; y<8; y++) {
            for(int x = 0; x<10; x++) {
                veldI.getGridPane().add(veldI.getFlowPanes()[x][y],x,y);
                for (int z = 0; z<9; z++) {
                    veldI.getFlowPanes()[x][y].getChildren().add(z,veldI.getImageViews()[x][y][z]);
                }
            }
        }
    }

    // update de volledige view van het speelveld
    public void ImageSetterALL() {
        for(int y = 0; y<8; y++) {
            for (int x = 0; x < 10; x++) {
                ImageSetter(x,y);
            }
        }
    }

    // update het vak dat is gegeven en alles dat hier tegen aan ligt
    public void ImageSetterAround(int x, int y) {
        ImageSetter(x,y);
        if(x<9)ImageSetter(x+1,y);
        if(x>0)ImageSetter(x-1,y);
        if(y<7)ImageSetter(x,y+1);
        if(y>0)ImageSetter(x,y-1);
    }

    public void carViewFactory() {
        veldI.getCarViews()[0] = new ImageView();
        veldI.getCarViews()[1] = new ImageView();
    }

    public void carSetter() {
        switch (veldD.getAmbulance()) {
            case BOVEN: veldI.getCarViews()[0].setImage(veldI.getAmbuBoven());
                break;
            case ONDER: veldI.getCarViews()[0].setImage(veldI.getAmbuOnder());
                break;
            case LINKS: veldI.getCarViews()[0].setImage(veldI.getAmbuLinks());
                break;
            case RECHTS: veldI.getCarViews()[0].setImage(veldI.getAmbuRechts());
                break;
        }

        switch (veldD.getBrandweerwagen()) {
            case BOVEN: veldI.getCarViews()[1].setImage(veldI.getBrandweerBoven());
                break;
            case RECHTS: veldI.getCarViews()[1].setImage(veldI.getBrandweerRechts());
                break;
            case LINKS: veldI.getCarViews()[1].setImage(veldI.getBrandweerLinks());
                break;
            case ONDER: veldI.getCarViews()[1].setImage(veldI.getBrandweerOnder());
                break;
        }
    }

    // gaat de eigenschappen af van een bepaald vak en laad het goede plaatje in de image View
    public void ImageSetter(int x, int y) {
        // Hotspot
        if(veldD.getVakken()[x][y].isHotspot()) {
            veldI.getImageViews()[x][y][0].setImage(veldI.getHotspot());
        } else {
            veldI.getImageViews()[x][y][0].setImage(veldI.getEmpty());
        }

        // Obstakel boven
        switch (veldD.getVakken()[x][y].getBoven()) {
            case MUUR: veldI.getImageViews()[x][y][1].setImage(veldI.getMuurOnder());
                break;
            case MUUR1: veldI.getImageViews()[x][y][1].setImage(veldI.getMuur1kapotOnder());
                break;
            case MUUR2: veldI.getImageViews()[x][y][1].setImage(veldI.getMuur2kapotOnder());
                break;
            case DEURO: veldI.getImageViews()[x][y][1].setImage(veldI.getOpenDeurOnder());
                break;
            case DEURD: veldI.getImageViews()[x][y][1].setImage(veldI.getDichteDeurOnder());
                break;
            case LEEG: veldI.getImageViews()[x][y][1].setImage(veldI.getEmpty());
                break;
        }

        // Persoon
        if(veldD.getVakken()[x][y].getPersonen().isEmpty()) {
            veldI.getImageViews()[x][y][2].setImage(veldI.getEmpty());
        } else if(veldD.getVakken()[x][y].getPersonen().get(0).isGeheeld()) {
            veldI.getImageViews()[x][y][2].setImage(veldI.getMedkit());
        }
        else {
            if (!veldD.getVakken()[x][y].getPersonen().get(0).isOmgedraaid()) {
                veldI.getImageViews()[x][y][2].setImage(veldI.getPersoon());
            } else {
                switch(veldD.getVakken()[x][y].getPersonen().get(0)) {
                    case OMA: veldI.getImageViews()[x][y][2].setImage(veldI.getOma());
                        break;
                    case VIS: veldI.getImageViews()[x][y][2].setImage(veldI.getVis());
                        break;
                    case EGEL: veldI.getImageViews()[x][y][2].setImage(veldI.getEgel());
                        break;
                    case HOND: veldI.getImageViews()[x][y][2].setImage(veldI.getHond());
                        break;
                    case SNEK: veldI.getImageViews()[x][y][2].setImage(veldI.getSnek());
                        break;
                    case LATIFAH: veldI.getImageViews()[x][y][2].setImage(veldI.getLatifah());
                        break;
                    case ROODHAAR: veldI.getImageViews()[x][y][2].setImage(veldI.getRoodhaar());
                        break;
                    case GROENHAAR: veldI.getImageViews()[x][y][2].setImage(veldI.getGroenhaar());
                        break;
                    case OBAMANIGUA: veldI.getImageViews()[x][y][2].setImage(veldI.getObamanigua());
                        break;
                    case HIPSTERSNOR: veldI.getImageViews()[x][y][2].setImage(veldI.getHipstersnor());
                        break;
                    default: veldI.getImageViews()[x][y][2].setImage(veldI.getEmpty());
                }
            }
        }

        // Obstakel links
        switch (veldD.getVakken()[x][y].getLinks()) {
            case MUUR: veldI.getImageViews()[x][y][3].setImage(veldI.getMuurRechts());
                break;
            case MUUR1: veldI.getImageViews()[x][y][3].setImage(veldI.getMuur1kapotRechts());
                break;
            case MUUR2: veldI.getImageViews()[x][y][3].setImage(veldI.getMuur2kapotRechts());
                break;
            case DEURO: veldI.getImageViews()[x][y][3].setImage(veldI.getOpenDeurRechts());
                break;
            case DEURD: veldI.getImageViews()[x][y][3].setImage(veldI.getDichteDeurRechts());
                break;
            case LEEG: veldI.getImageViews()[x][y][3].setImage(veldI.getEmpty());
                break;
        }

        // Spelers
        veldI.getImageViews()[x][y][4].setImage(veldI.getEmpty()); {
            for (int i = 5; i >-1; i--) {
                if (veldD.getVakken()[x][y].getKleuren()[i] != null) {
                    switch (veldD.getVakken()[x][y].getKleuren()[i]) {
                        case BLAUW:
                            veldI.getImageViews()[x][y][4].setImage(veldI.getBrandweerBlauw());
                            i -= 5;
                            break;
                        case GEEL:
                            veldI.getImageViews()[x][y][4].setImage(veldI.getBrandweerGeel());
                            i -= 5;
                            break;
                        case GROEN:
                            veldI.getImageViews()[x][y][4].setImage(veldI.getBrandweerGroen());
                            i -= 5;
                            break;
                        case ORANJE:
                            veldI.getImageViews()[x][y][4].setImage(veldI.getBrandweerOranje());
                            i -= 5;
                            break;
                        case ROOD:
                            veldI.getImageViews()[x][y][4].setImage(veldI.getBrandweerRood());
                            i -= 5;
                            break;
                        case ZWART:
                            veldI.getImageViews()[x][y][4].setImage(veldI.getBrandweerZwart());
                            i -= 5;
                            break;
                    }
                }
            }
        }

        // Obstakel rechts
        switch (veldD.getVakken()[x][y].getRechts()) {
            case MUUR: veldI.getImageViews()[x][y][5].setImage(veldI.getMuurLinks());
                break;
            case MUUR1: veldI.getImageViews()[x][y][5].setImage(veldI.getMuur1kapotLinks());
                break;
            case MUUR2: veldI.getImageViews()[x][y][5].setImage(veldI.getMuur2kapotLinks());
                break;
            case DEURO: veldI.getImageViews()[x][y][5].setImage(veldI.getOpenDeurLinks());
                break;
            case DEURD: veldI.getImageViews()[x][y][5].setImage(veldI.getDichteDeurLinks());
                break;
            case LEEG: veldI.getImageViews()[x][y][5].setImage(veldI.getEmpty());
                break;
        }

        // Vuur plaats
        if(veldD.getVakken()[x][y].isVuur()) {
            veldI.getImageViews()[x][y][6].setImage(veldI.getVlam());
        } else if(veldD.getVakken()[x][y].isRook()) {
            veldI.getImageViews()[x][y][6].setImage(veldI.getRook());
        } else {
            veldI.getImageViews()[x][y][6].setImage(veldI.getEmpty());
        }

        // Obstakel onder
        switch (veldD.getVakken()[x][y].getOnder()) {
            case MUUR: veldI.getImageViews()[x][y][7].setImage(veldI.getMuurBoven());
                break;
            case MUUR1: veldI.getImageViews()[x][y][7].setImage(veldI.getMuur1kapotBoven());
                break;
            case MUUR2: veldI.getImageViews()[x][y][7].setImage(veldI.getMuur2kapotBoven());
                break;
            case DEURO: veldI.getImageViews()[x][y][7].setImage(veldI.getOpenDeurBoven());
                break;
            case DEURD: veldI.getImageViews()[x][y][7].setImage(veldI.getDichteDeurBoven());
                break;
            case LEEG: veldI.getImageViews()[x][y][7].setImage(veldI.getEmpty());
                break;
        }

        // Stoffen
        if(veldD.getVakken()[x][y].isStoffen()) {
            veldI.getImageViews()[x][y][8].setImage(veldI.getGevaarlijkeStof());
        } else {
            veldI.getImageViews()[x][y][8].setImage(veldI.getEmpty());
        }

    }

    // geeft terug of een vak een bepaalde eigenschap heeft of niet.
    private boolean checkVakEigenschappen(int x, int y, Fiche fiche) {
        switch(fiche) {
            case STOFFEN: return veldD.getVakken()[x][y].isStoffen();
            case HOTSPOT: return veldD.getVakken()[x][y].isHotspot();
            case VUUR: return veldD.getVakken()[x][y].isVuur();
            case ROOK: return veldD.getVakken()[x][y].isRook();
            case NIKS: return veldD.getVakken()[x][y].isNiks();
            case PERSOON: if(veldD.getVakken()[x][y].getPersonen().isEmpty()) {return false;}
                return true;
            default:
                System.out.println("Unexpected Fiche input: " + fiche + " SpeelveldController.checkVakEigenschappen");
                return false;
        }

    }

    // geeft terug welke obstakels een vak heeft in een gegeven richting
    private Status checkVakObstakel(int x, int y, Richting richting) {
        switch(richting) {
            case BOVEN: return veldD.getVakken()[x][y].getBoven();
            case LINKS: return veldD.getVakken()[x][y].getLinks();
            case ONDER: return veldD.getVakken()[x][y].getOnder();
            case RECHTS: return veldD.getVakken()[x][y].getRechts();
            default:
                System.out.println("Unexpected Richting input: " + richting + " SpeelveldController.checkVakObstakel");
                return null;
        }
    }

    // kijkt of een speler zich op een bepaald vak bevind en geeft al die speler kleuren terug in een arraylist
    private ArrayList<Kleur> checkVakSpeler(int x, int y) {
        ArrayList<Kleur> kleuren= new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            if(veldD.getVakken()[x][y].getKleuren()[i] != null) {
                kleuren.add(veldD.getVakken()[x][y].getKleuren()[i]);
            }
        }
        return kleuren;
    }

    // geeft true als de gekozen richting geen hinderend obstakel bevat.
    private boolean checkDoorgaanbaar(int x, int y, Richting richting) {
        switch(richting) {
            case BOVEN:
                return veldD.getVakken()[x][y].getBoven().isBegaanbaar();
            case LINKS:
                return veldD.getVakken()[x][y].getLinks().isBegaanbaar();
            case ONDER:
                return veldD.getVakken()[x][y].getOnder().isBegaanbaar();
            case RECHTS:
                return veldD.getVakken()[x][y].getRechts().isBegaanbaar();
            default:
                System.out.println("Unexpected Richting input: " + richting + " SpeelveldController.checkDoorgaanbaar");
                return false;
        }
    }

    //Lion/Joep, Zet alle muren en deuren op de goeie plek om het spel te beginnen
    public void setMap(){
        int x;
        int y;
        for(int brandhaarden=0; brandhaarden<3; brandhaarden++) {
            dobbelC.getD8().gooi();
            dobbelC.getD6().gooi();
            x = dobbelC.getD8().getWaarde();
            y = dobbelC.getD6().getWaarde();
            veldD.getVakken()[x][y].setHotspot(true);
        }
        for(int gs=0; gs<3; gs++) {
            dobbelC.getD8().gooi();
            dobbelC.getD6().gooi();
            x = dobbelC.getD8().getWaarde();
            y = dobbelC.getD6().getWaarde();
            veldD.getVakken()[x][y].setStoffen(true);
        }




        //buitenmuren horizontaal
        for(x = 1; x <9; x++) {
            veldD.getVakken()[x][0].setOnder(MUUR);
            veldD.getVakken()[x][1].setBoven(MUUR);
            veldD.getVakken()[x][6].setOnder(MUUR);
            veldD.getVakken()[x][7].setBoven(MUUR);

        }
        //buitenmuren verticaal
        for (y = 1; y < 7; y++) {
            veldD.getVakken()[0][y].setRechts(MUUR);
            veldD.getVakken()[1][y].setLinks(MUUR);
            veldD.getVakken()[8][y].setRechts(MUUR);
            veldD.getVakken()[9][y].setLinks(MUUR);

        }
        //scheidingswand woonkamer
        veldD.getVakken()[1][2].setOnder(MUUR);
        veldD.getVakken()[1][3].setBoven(MUUR);
        veldD.getVakken()[2][2].setOnder(MUUR);
        veldD.getVakken()[2][3].setBoven(MUUR);

        //muur tussen woonkamer en slaapkamer + keuken
        for (int j = 1; j<7;j++){
            veldD.getVakken()[j][4].setOnder(MUUR);
            veldD.getVakken()[j][5].setBoven(MUUR);
            veldD.getVakken()[j][4].setOnder(MUUR);
            veldD.getVakken()[j][5].setBoven(MUUR);
        }
        //muur tussen woonkamer en badkamer + bergruimte
        for (int k = 1; k<4;k++){
            veldD.getVakken()[3][k].setRechts(MUUR);
            veldD.getVakken()[4][k].setLinks(MUUR);
            veldD.getVakken()[3][k].setRechts(MUUR);
            veldD.getVakken()[4][k].setLinks(MUUR);
        }
        //muur tussen bergruimte en badkamer
        veldD.getVakken()[4][1].setOnder(MUUR);
        veldD.getVakken()[4][2].setBoven(MUUR);
        veldD.getVakken()[5][1].setOnder(MUUR);
        veldD.getVakken()[5][2].setBoven(MUUR);

        //overige horizontale muren
        veldD.getVakken()[4][3].setOnder(MUUR);
        veldD.getVakken()[4][4].setBoven(MUUR);
        veldD.getVakken()[7][3].setOnder(MUUR);
        veldD.getVakken()[7][4].setBoven(MUUR);
        veldD.getVakken()[8][3].setOnder(MUUR);
        veldD.getVakken()[8][4].setBoven(MUUR);

        //verticale muur tussen slaapkamer en keuken
        veldD.getVakken()[3][5].setRechts(MUUR);
        veldD.getVakken()[4][5].setLinks(MUUR);
        veldD.getVakken()[3][6].setRechts(MUUR);
        veldD.getVakken()[4][6].setLinks(MUUR);

        //verticale muur tussen slaapkamers
        veldD.getVakken()[6][5].setRechts(MUUR);
        veldD.getVakken()[7][5].setLinks(MUUR);
        veldD.getVakken()[6][6].setRechts(MUUR);
        veldD.getVakken()[7][6].setLinks(MUUR);

        //overige muur
        veldD.getVakken()[5][2].setRechts(MUUR);
        veldD.getVakken()[6][2].setLinks(MUUR);

        //verticale deuren
        veldD.getVakken()[5][1].setRechts(DEURD);
        veldD.getVakken()[6][1].setLinks(DEURD);
        veldD.getVakken()[5][3].setRechts(DEURD);
        veldD.getVakken()[6][3].setLinks(DEURD);
        veldD.getVakken()[6][4].setRechts(DEURD);
        veldD.getVakken()[7][4].setLinks(DEURD);

        //horizontale deuren
        veldD.getVakken()[5][4].setBoven(DEURD);
        veldD.getVakken()[5][3].setOnder(DEURD);
        veldD.getVakken()[6][4].setBoven(DEURD);
        veldD.getVakken()[6][3].setOnder(DEURD);
        veldD.getVakken()[6][5].setBoven(DEURD);
        veldD.getVakken()[6][4].setOnder(DEURD);
        veldD.getVakken()[3][5].setBoven(DEURD);
        veldD.getVakken()[3][4].setOnder(DEURD);

        //buitenmuren waar deuren horen leeg maken
        veldD.getVakken()[0][3].setRechts(LEEG);
        veldD.getVakken()[1][3].setLinks(LEEG);

        veldD.getVakken()[3][7].setBoven(LEEG);
        veldD.getVakken()[3][6].setOnder(LEEG);

        for(int explosies=0; explosies<3; explosies++) {
            dobbelC.getD8().gooi();
            dobbelC.getD6().gooi();
            x = dobbelC.getD8().getWaarde();
            y = dobbelC.getD6().getWaarde();
            spelC.checkExplosie(x,y);
        }
    }

    public void doeDeur(int x, int y, Richting richting) {
        Vak vak = veldD.getVakken()[x][y];
        switch(richting) {
            case BOVEN:
                if (y>0) {
                    switch(vak.getBoven()) {
                        case DEURD: vak.setBoven(DEURO);
                            veldD.getVakken()[x][y-1].setOnder(DEURO);
                            break;
                        case DEURO: vak.setBoven(DEURD);
                            veldD.getVakken()[x][y-1].setOnder(DEURD);
                            break;
                        default:
                            System.out.println("Unexpected obstakel (SpeelveldController.doeDeur.Boven)");
                    }
                    ImageSetter(x, y);
                    ImageSetter(x, y-1);
                }
                break;
            case RECHTS:
                if (x<9) {
                    switch(vak.getRechts()) {
                        case DEURD: vak.setRechts(DEURO);
                            veldD.getVakken()[x+1][y].setLinks(DEURO);
                            break;
                        case DEURO: vak.setRechts(DEURD);
                            veldD.getVakken()[x+1][y].setLinks(DEURD);
                            break;
                        default:
                            System.out.println("Unexpected obstakel (SpeelveldController.doeDeur.Rechts)");
                    }
                    ImageSetter(x, y);
                    ImageSetter(x+1, y);
                }
                break;
            case LINKS:
                if (x>0) {
                    switch(vak.getLinks()) {
                        case DEURD: vak.setLinks(DEURO);
                            veldD.getVakken()[x-1][y].setRechts(DEURO);
                            break;
                        case DEURO: vak.setLinks(DEURD);
                            veldD.getVakken()[x-1][y].setRechts(DEURD);
                            break;
                        default:
                            System.out.println("Unexpected obstakel (SpeelveldController.doeDeur.Links)");
                    }
                    ImageSetter(x, y);
                    ImageSetter(x-1, y);
                }
                break;
            case ONDER:
                if (y<7) {
                    switch(vak.getOnder()) {
                        case DEURD: vak.setOnder(DEURO);
                            veldD.getVakken()[x][y+1].setBoven(DEURO);
                            break;
                        case DEURO: vak.setOnder(DEURD);
                            veldD.getVakken()[x][y+1].setBoven(DEURD);
                            break;
                        default:
                            System.out.println("Unexpected obstakel (SpeelveldController.doeDeur.Onder)");
                    }
                    ImageSetter(x, y);
                    ImageSetter(x, y+1);
                }
                break;
            default:
                System.out.println("Unexpected Richting: " + richting + "SpeelveldController.doeDeur.default");
        }
    }


    // handeld obstakels voor explosies en hakken
    public boolean doeBeschadiging(int x, int y, Richting richting) {
        Vak vak = veldD.getVakken()[x][y];
        switch (richting) {
            case BOVEN:
                if (y > 0) {
                    switch (vak.getBoven()) {
                        case MUUR:
                            vak.setBoven(MUUR1);
                            veldD.getVakken()[x][y - 1].setOnder(MUUR1);
                            spelC.addBeschadigingCount();
                            return true;
                        case MUUR1:
                            vak.setBoven(MUUR2);
                            veldD.getVakken()[x][y - 1].setOnder(MUUR2);
                            spelC.addBeschadigingCount();
                            return true;
                        case DEURD:
                            vak.setBoven(LEEG);
                            veldD.getVakken()[x][y - 1].setOnder(LEEG);
                            return true;
                        default:
                            System.out.println("Unexpected obstakel (SpeelveldController.doeBeschadiging.Boven)");
                            return false;
                    }
                }
                return false;
            case RECHTS:
                if (x < 9) {
                    switch (vak.getRechts()) {
                        case MUUR:
                            vak.setRechts(MUUR1);
                            veldD.getVakken()[x + 1][y].setLinks(MUUR1);
                            spelC.addBeschadigingCount();
                            return true;
                        case MUUR1:
                            vak.setRechts(MUUR2);
                            veldD.getVakken()[x + 1][y].setLinks(MUUR2);
                            spelC.addBeschadigingCount();
                            return true;
                        case DEURD:
                            vak.setRechts(LEEG);
                            veldD.getVakken()[x + 1][y].setLinks(LEEG);
                            return true;
                        default:
                            System.out.println("Unexpected obstakel (SpeelveldController.doeBeschadiging.Rechts)");
                            return false;
                    }
                }
                return false;
            case LINKS:
                if (x > 0) {
                    switch (vak.getLinks()) {
                        case MUUR:
                            vak.setLinks(MUUR1);
                            veldD.getVakken()[x - 1][y].setRechts(MUUR1);
                            spelC.addBeschadigingCount();
                            return true;
                        case MUUR1:
                            vak.setLinks(MUUR2);
                            veldD.getVakken()[x - 1][y].setRechts(MUUR2);
                            spelC.addBeschadigingCount();
                            return true;
                        case DEURD:
                            vak.setLinks(LEEG);
                            veldD.getVakken()[x - 1][y].setRechts(LEEG);
                            return true;
                        default:
                            System.out.println("Unexpected obstakel (SpeelveldController.doeBeschadiging.Links)");
                            return false;
                    }
                }
                return false;
            case ONDER:
                if (y < 7) {
                    switch (vak.getOnder()) {
                        case MUUR:
                            vak.setOnder(MUUR1);
                            veldD.getVakken()[x][y + 1].setBoven(MUUR1);
                            spelC.addBeschadigingCount();
                            return true;
                        case MUUR1:
                            vak.setOnder(MUUR2);
                            veldD.getVakken()[x][y + 1].setBoven(MUUR2);
                            spelC.addBeschadigingCount();
                            return true;
                        case DEURD:
                            vak.setOnder(LEEG);
                            veldD.getVakken()[x][y + 1].setBoven(LEEG);
                            return true;
                        default:
                            System.out.println("Unexpected obstakel (SpeelveldController.doeBeschadiging.Onder)");
                            return false;
                    }
                }
                return false;
            default:
                System.out.println("Unexpected Richting: " + richting + "SpeelveldController.doeBeschadiging.default");
                return false;
        }
    }



    public int[] volgPijl(int x, int y){

        if(y==1 && x < 9 && x > 0){
            y = 2;
        }
        else if(y==6 && x < 9 && x > 0){
            y = 5;
        }
        if(x==1 && y < 6 && y > 1){
            x = 2;
        }
        if(x==8 && y < 6 && y > 1){
            x = 7;
        }
        else if (y==2 || y==5){
            if (x == 3){
                x--;
            }
            else if (x==6){
                x++;
            }
            else if (y == 2 && (x==4 || x == 5)){
                y++;
            }
            else if (y == 5 && (x==4 || x == 5)){
                y--;
            }
        }
        else if (x==2 || x==7){
            if (y==3){
                y--;
            }
            else if (y == 4){
                y++;
            }
            else if (x==2 && y==2){
                x++;
                y++;
            }
            else if (x==2 && y==5){
                x++;
                y--;
            }
            else if (x==5 && y==2){
                x--;
                y++;
            }
            else if (x==5 && y==5){
                x--;
                y--;
            }
        }
        else if (y==3 && x < 7 && x > 3) {
            x--;
        }
        else if (y==4 && x < 6 && x > 2) {
            x++;
        }
        else if (y==3 && x==3){
            y++;
        }
        else if (y==4 && x==6){
            y--;
        }
        return new int[]{x,y};
    }

    public void addSpeler(Kleur kleur, int x, int y) {
        for(int i = 0; i < 6; i++) {
            if (veldD.getVakken()[x][y].getKleuren()[i] == null) {
                veldD.getVakken()[x][y].getKleuren()[i] = kleur;
                i+=6;
            }
        }
    }

    public void removeSpeler(Kleur kleur, int x, int y) {
        for(int i = 0; i < 6; i++) {
            if (veldD.getVakken()[x][y].getKleuren()[i] == kleur) {
                veldD.getVakken()[x][y].getKleuren()[i] = null;
                i+=6;
            }
        }
    }




    // Getters and Setters down below
    public SpeelveldData getVeldD() {
        return veldD;
    }

    public void setVeldD(SpeelveldData veldD) {
        this.veldD = veldD;
    }

    public SpeelveldImages getVeldI() {
        return veldI;
    }
}