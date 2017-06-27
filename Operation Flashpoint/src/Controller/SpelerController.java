package Controller;

import Model.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static Model.Kleur.*;
import static Model.Richting.*;
import static Model.Rol.*;


public class SpelerController {

    Speler speler;


    public void setHuidigeSpeler() {
        speler = spelC.spel.getHuidigeSpeler();
    }



    Vak vak;

    // Toggles waar door de richting toetsen voor andere functies kunnen worden gebruikt.
    boolean openendeur = false;
    boolean brandblusser = false;
    boolean hakken = false;
    boolean rijden = false;
    boolean commandeer = false;

    public SpelerController() {
    }

    SpeelveldController veldC;
    DobbelsteenController dobbelC;
    ChatController chatC;
    SpelController spelC;

    // verbind deze controller met 3 andere
    public void setControllers(SpeelveldController veldC, SpelController spelC, DobbelsteenController dobbelC, ChatController chatC) {
        this.veldC = veldC;
        this.spelC = spelC;
        this.dobbelC = dobbelC;
        this.chatC = chatC;
    }

    public void noord(){
        if(commandeer) {
            commandeerActie(BOVEN);
        }
        else if(!openendeur && !brandblusser && !hakken && !rijden) {
            System.out.println("Beweeg: Noord");
            beweegActie(BOVEN);

        }
        else if(openendeur) {
            System.out.println("DeurOS: Noord");
            deurActie(BOVEN);
        }
        else if(brandblusser) {
            System.out.println("Blussen: Noord");
            blussenActie(BOVEN);
            veldC.ImageSetterAround(speler.getX(),speler.getY());
        }
        else if(hakken) {
            System.out.println("Hakken: Noord");
            hakActie(BOVEN);
            veldC.ImageSetterAround(speler.getX(),speler.getY());
        }
        else if(rijden){
            System.out.println("rijden");
            rijden(BOVEN);
        }
        spelC.updatePunten();
    }

    public void west(){
        if(commandeer) {
          commandeerActie(LINKS);
        }
         else if(!openendeur && !brandblusser && !hakken && !rijden) {
            System.out.println("Beweeg: West");
            beweegActie(LINKS);
        }
        else if(openendeur) {
            System.out.println("DeurOS: West");
            deurActie(LINKS);
        }
        else if(brandblusser) {
            System.out.println("Blussen: West");
            blussenActie(LINKS);
            veldC.ImageSetterAround(speler.getX(),speler.getY());
        }
        else if(hakken) {
            System.out.println("Hakken: West");
            hakActie(LINKS);
            veldC.ImageSetterAround(speler.getX(),speler.getY());
        }
        else if(rijden){
            System.out.println("rijden");
            rijden(LINKS);
        }
        spelC.updatePunten();
    }

    public void zuid(){
        if(commandeer) {
            commandeerActie(ONDER);
        }
         else if(!openendeur && !brandblusser && !hakken && !rijden) {
            System.out.println("Beweeg: Zuid");
            beweegActie(ONDER);
        }
        else if(openendeur) {
            System.out.println("DeurOS: Zuid");
            deurActie(ONDER);
        }
        else if(brandblusser) {
            System.out.println("Blussen: Zuid");
            blussenActie(ONDER);
            veldC.ImageSetterAround(speler.getX(),speler.getY());
        }
        else if(hakken) {
            System.out.println("Hakken: Zuid");
            hakActie(ONDER);
            veldC.ImageSetterAround(speler.getX(),speler.getY());
        }
        else if(rijden){
            System.out.println("rijden");
            rijden(ONDER);
        }
        spelC.updatePunten();
    }

    public void oost(){
        if(commandeer) {
            commandeerActie(RECHTS);
        }
        else if(!openendeur && !brandblusser && !hakken && !rijden) {
            System.out.println("Beweeg: Oost");
            beweegActie(RECHTS);
        }
        else if(openendeur) {
            System.out.println("DeurOS: Oost");
            deurActie(RECHTS);
        }
        else if(brandblusser) {
            System.out.println("Blussen: Oost");
            blussenActie(RECHTS);
            veldC.ImageSetterAround(speler.getX(),speler.getY());
        }
        else if(hakken) {
            System.out.println("Hakken: Oost");
            hakActie(RECHTS);
            veldC.ImageSetterAround(speler.getX(),speler.getY());
        }
        else if(rijden){
            System.out.println("rijden");
            rijden(RECHTS);
        }
        spelC.updatePunten();
    }

    // Als in SpelC op de special knop word gedrukt gaat deze functie lopen
    // Er word gekeken welke rol een speler heeft en verwijst verolgens door naar de bijpassende specla methode.
    public void special() {
        switch(speler.getRol()) {
            case VERKENNER:     verken();
                break;
            case COMMANDANT:    commandeer();
                break;
            case DOKTER:        helen();
                break;
            case SPECSTOFFEN: onschadelijkMaken();
                break;
            default: System.out.println("Mom thinks im special :(");
        }
        spelC.updatePunten();
    }


    // Als een commandant op special klikt kan hij een andere speler kiezen om te bewegen
    Kleur commandKeuze;
    public void commandeer() {
        if (speler.getExtrapunten() > 0) {
            commandeer ^= true;
            if(commandeer) {
                List<String> choices = new ArrayList<>();
                Speler speler2;
                for (int i = 0; i < spelC.spel.getSpelers().size(); i++) {
                    speler2 = spelC.spel.getSpelers().get(i);
                    if (speler != speler2) choices.add(speler2.getKleur().getString());
                }

                ChoiceDialog<String> dialog = new ChoiceDialog<>("Kies een mede speler", choices);
                dialog.setTitle("Commandant special");
                dialog.setHeaderText("De commandant kan een andere speler commanderen te bewegen");
                dialog.setContentText("Kies een mede speler:");

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()) {
                    System.out.println("Your choice: " + result.get());
                    switch (result.get()) {
                        case "Blauw":
                            commandKeuze = BLAUW;
                            break;
                        case "Geel":
                            commandKeuze = GEEL;
                            break;
                        case "Groen":
                            commandKeuze = GROEN;
                            break;
                        case "Oranje":
                            commandKeuze = ORANJE;
                            break;
                        case "Rood":
                            commandKeuze = ROOD;
                            break;
                        case "Zwart":
                            commandKeuze = ZWART;
                    }
                }
            }
        }
    }

    // De daadwerkelijke beweeg actie van de commandant word hier afgehandeld.
    private void commandeerActie(Richting richting) {
        Speler spelerhuidig = speler;
        for(int i = 0; i < spelC.spel.getSpelers().size(); i++) {
            if(spelC.spel.getSpelers().get(i).getKleur() == commandKeuze) {
                speler = spelC.spel.getSpelers().get(i);
            }
        }
        if(speler.getRol() == REDDINGSSPECIALIST) speler.setExtraPunten(speler.getExtrapunten()+1);
        else speler.setActiepunten(speler.getActiepunten()+1);
        boolean bewogen = beweegActie(richting);
        if(!bewogen && speler.getRol() != REDDINGSSPECIALIST) speler.setActiepunten(speler.getActiepunten()-1);
        speler = spelerhuidig;
        if(bewogen) speler.setExtraPunten(speler.getExtrapunten()-1);
        if(speler.getExtrapunten()<1) {
            commandeer = false;
        }
    }

    public void BrandweerwagenSpuitActie() {
        System.out.println("BLUS BLUS");
        Boolean opBWagen = false;
        switch(veldC.getVeldD().getBrandweerwagen()) {
            case BOVEN: if(speler.getY()==0 && (speler.getX() == 3|| speler.getX() == 4)) {
                opBWagen = true;
            }
                break;
            case ONDER: if(speler.getY()==7 && (speler.getX() == 5|| speler.getX() == 6)) {
                opBWagen = true;
            }
                break;
            case LINKS: if(speler.getX()==0 && (speler.getY() == 4|| speler.getY() == 5))
                opBWagen = true;
                break;
            case RECHTS: if(speler.getX()==9 && (speler.getY() == 2|| speler.getY() == 3))
                opBWagen = true;
                break;
        }
        if(opBWagen) {
            Boolean eersteLoop = true;
            Boolean loop = true;
            Boolean asignX = true;
            Boolean asignY = true;
            int x = 0;
            int y = 0;
            System.out.println("Ik ga nu blussen");
            if (speler.getActiepunten() > 3 || (speler.getRol() == BRANDSPUITBEDIENER && speler.getActiepunten() > 1)) {
                speler.setActiepunten(speler.getActiepunten() - 4);
                if (speler.getRol() == BRANDSPUITBEDIENER) speler.setActiepunten(speler.getActiepunten() + 2);
                Richting kwadrant = veldC.getVeldD().getBrandweerwagen();
                while(loop) {
                    loop = false;
                    dobbelC.d6.gooi();
                    dobbelC.d8.gooi();
                    switch (kwadrant) {
                        case ONDER:
                            if (dobbelC.d6.getWaarde() < 4) {
                                dobbelC.d6.flip();
                            }
                            if (dobbelC.d8.getWaarde() < 5) {
                                dobbelC.d8.flip();
                            }

                            break;
                        case LINKS:
                            if (dobbelC.d6.getWaarde() < 4) {
                                dobbelC.d6.flip();
                            }
                            if (dobbelC.d8.getWaarde() > 4) {
                                dobbelC.d8.flip();
                            }
                            break;
                        case BOVEN:
                            if (dobbelC.d6.getWaarde() > 3) {
                                dobbelC.d6.flip();
                            }
                            if (dobbelC.d8.getWaarde() > 4) {
                                dobbelC.d8.flip();
                            }
                            break;
                        case RECHTS:
                            if (dobbelC.d6.getWaarde() > 3) {
                                dobbelC.d6.flip();
                            }
                            if (dobbelC.d8.getWaarde() < 5) {
                                dobbelC.d8.flip();
                            }
                            break;
                    }

                    if (speler.getRol() == BRANDSPUITBEDIENER && eersteLoop) {
                        eersteLoop = false;
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Opnieuw gooien");
                        alert.setHeaderText("Je hebt " + dobbelC.d8.getWaarde() + " en " + dobbelC.d6.getWaarde() + " gegooid.");
                        alert.setContentText("Wil je opnieuw gooien?");

                        ButtonType buttonTypeOne = new ButtonType("X");
                        ButtonType buttonTypeTwo = new ButtonType("Y");
                        ButtonType buttonTypeThree = new ButtonType("Allebei");
                        ButtonType buttonTypeCancel = new ButtonType("Blus", ButtonBar.ButtonData.CANCEL_CLOSE);

                        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeCancel);

                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == buttonTypeOne) {
                            asignY = false;
                            y = dobbelC.d6.getWaarde();
                            loop = true;
                        } else if (result.get() == buttonTypeTwo) {
                            asignX = false;
                            x = dobbelC.d8.getWaarde();
                            loop = true;
                        } else if (result.get() == buttonTypeThree) {
                            loop = true;
                        } else {
                            loop = false;
                        }
                    }
                }

                if(asignX) x = dobbelC.d8.getWaarde();
                if(asignY) y = dobbelC.d6.getWaarde();

                System.out.println(x);
                System.out.println(y);

                vak = veldC.getVeldD().getVakken()[x][y];

                vak.setNiks(true);
                vak.setRook(false);
                vak.setVuur(false);
                for (Richting richting : Richting.values()) {
                    if (vak.getObstakelRichting(richting).isBegaanbaar()) {
                        switch (richting) {
                            case BOVEN:
                                setNiks(x, y - 1);
                                break;
                            case RECHTS:
                                setNiks(x + 1, y);
                                break;
                            case ONDER:
                                setNiks(x, y + 1);
                                break;
                            case LINKS:
                                setNiks(x - 1, y);
                        }
                    }
                }
                veldC.ImageSetterALL();
                spelC.updatePunten();
            }
        }
    }

    private void setNiks(int x, int y) {
        veldC.getVeldD().getVakken()[x][y].setNiks(true);
        veldC.getVeldD().getVakken()[x][y].setRook(false);
        veldC.getVeldD().getVakken()[x][y].setVuur(false);
    }

    // Speciale actie van de verkenner, geeft een popup met alle niet ? personen en draait de gekeuze persoon om.
    private void verken() {
        if(speler.getActiepunten()>0) {
            ArrayList<String> keuzes = new ArrayList<>();
            ArrayList<Persoon> personen = new ArrayList<>();
            int[][] xEnY = new int[3][2];
            int count = 0;
            for (int y = 1; y < 7; y++) {
                for (int x = 1; x < 9; x++) {
                    personen = veldC.getVeldD().getVakken()[x][y].getPersonen();
                    if (!personen.isEmpty()) {
                        for (int i = 0; i < personen.size(); i++) {
                            if (!personen.get(i).isOmgedraaid()) {
                                keuzes.add("PVA: X: " + Integer.toString(x) + " Y: " + Integer.toString(y));
                                xEnY[count][0] = x;
                                xEnY[count][1] = y;
                                count++;
                            }
                        }
                    }
                }
            }

            //De choicedialog maken
            ChoiceDialog<String> dialog = new ChoiceDialog<>("Keuze", keuzes);
            dialog.setTitle("Choice Dialog");
            dialog.setHeaderText("Kies de PVA die je wilt omdraaien");
            dialog.setContentText("Persoon:");

            Optional<String> keuzePersoon = dialog.showAndWait();
            if (keuzePersoon.isPresent() && keuzePersoon.get() != "Keuze") {
                for (int i = 0; i < keuzes.size(); i++) {
                    if (keuzePersoon.get() == keuzes.get(i)) {
                        persoonOmdraaien(xEnY[i][0], xEnY[i][1]);
                        veldC.ImageSetter(xEnY[i][0], xEnY[i][1]);
                        speler.setActiepunten(speler.getActiepunten()-1);

                    }
                }
            }
        }
    }

    private void helen(){
        vak = veldC.getVeldD().getVakken()[speler.getX()][speler.getY()];
        if (!vak.getPersonen().isEmpty()){
            vak.getPersonen().get(0).setGeheeld();
        }
        veldC.ImageSetter(speler.getX(),speler.getY());
    }
    // dit is de special methode van specStoffen, indien mogelijk word een stoffen fiche verwijderd.
    private void onschadelijkMaken() {
        int x = speler.getX();
        int y = speler.getY();
        if(speler.getActiepunten()>1 && veldC.getVeldD().getVakken()[x][y].isStoffen()) {
            veldC.getVeldD().getVakken()[x][y].setStoffen(false);
            speler.setActiepunten(speler.getActiepunten()-2);
            spelC.updatePunten();
            veldC.ImageSetter(x,y);
        }
    }

    public void togglesOff() {
        openendeur = false;
        brandblusser = false;
        hakken = false;
        rijden = false;
        spelC.toggleViewUpdate();
    }

    public void btnOpenenDeur() {
        openendeur ^= true;
        brandblusser = false;
        hakken = false;
        rijden = false;
    }

    public void btnRijden() {
        openendeur = false;
        brandblusser = false;
        hakken = false;
        rijden ^= true;
    }

    public void btnBrandblusser() {
        openendeur = false;
        brandblusser ^= true;
        hakken = false;
        rijden = false;
    }

    public void btnHakken() {
        openendeur = false;
        brandblusser = false;
        hakken ^= true;
        rijden = false;
    }

    private String kiezenVoertuig(){
        ArrayList<String> keuzes = new ArrayList<>();
        keuzes.add("Brandweerwagen");
        keuzes.add("Ambulance");
        //De choicedialog maken
        ChoiceDialog<String> oppakkeus = new ChoiceDialog<>("Kies een voertuig", keuzes);
        oppakkeus.setTitle("Voertuig kiezen");
        oppakkeus.setHeaderText("Kies het voertuig dat je wilt verplaatsen");
        oppakkeus.setContentText("Voertuig");

        Optional<String> keuzeObject = oppakkeus.showAndWait();
        if (keuzeObject.isPresent() && keuzeObject.get() != "Kies een Voertuig"){
            if (keuzeObject.get() == "Ambulance"){
                return keuzeObject.get();
            }
            else {
                return keuzeObject.get();
            }
        }
        return ("als je dit ziet is er iets mis met voertuig kiezen");
    }
    public void rijden(Richting richting) {
        if(speler.getActiepunten()>1) {
            String wagen = kiezenVoertuig();
            System.out.println(wagen);
            Richting kant;
            boolean verkeerdeKant = false;
            if (wagen.equals("Ambulance")) {
                kant = veldC.veldD.getAmbulance();
                switch (kant) {
                    case BOVEN:
                        if (richting == Richting.ONDER && richting != kant) {
                            verkeerdeKant = true;
                        }
                        break;
                    case RECHTS:
                        if (richting == Richting.LINKS && richting != kant) {
                            verkeerdeKant = true;
                        }
                        break;
                    case ONDER:
                        if (richting == Richting.BOVEN && richting != kant) {
                            verkeerdeKant = true;
                        }
                        break;
                    case LINKS:
                        if (richting == Richting.RECHTS && richting != kant) {
                            verkeerdeKant = true;
                        }
                        break;
                }
                if (!verkeerdeKant) {
                    veldC.veldD.setAmbulance(richting);
                    speler.setActiepunten(speler.getActiepunten() - 2);
                    veldC.carSetter();
                }


            } else if (wagen.equals("Brandweerwagen")) {
                kant = veldC.veldD.getBrandweerwagen();
                switch (kant) {
                    case BOVEN:
                        if (richting == Richting.ONDER && richting != kant) {
                            verkeerdeKant = true;
                        }
                        break;
                    case RECHTS:
                        if (richting == Richting.LINKS && richting != kant) {
                            verkeerdeKant = true;
                        }
                        break;
                    case ONDER:
                        if (richting == Richting.BOVEN && richting != kant) {
                            verkeerdeKant = true;
                        }
                        break;
                    case LINKS:
                        if (richting == Richting.RECHTS && richting != kant) {
                            verkeerdeKant = true;
                        }
                        break;
                }

                if (!verkeerdeKant) {
                    veldC.veldD.setBrandweerwagen(richting);
                    speler.setActiepunten(speler.getActiepunten() - 2);
                    veldC.carSetter();
                }

            }
        }
    }
    private void brandweerwagenActie(){
        System.out.println("Actie: Gebruik brandweerwagen");
    }
    public void dropItem(){
        if(speler.isStof()){
            if(speler.getX()==0 || speler.getX()==9 || speler.getY()==0 || speler.getY()== 7){
                speler.setStof(false);
                vak.setStoffen(false);
            }
            else{
                speler.setStof(false);
                vak.setStoffen(true);
            }

        }
        else if (speler.getPersoon() != null){
            Richting kant = veldC.veldD.getAmbulance();
            boolean opAmbulance= false;
            switch(kant){
                case BOVEN:
                    if(speler.getY()==0 && (speler.getX()== 5 || speler.getX()== 6) ){
                    opAmbulance = true;
                    }
                    break;
                case RECHTS:
                    if(speler.getX()==9 && (speler.getY()== 4 || speler.getY()== 5) ){
                    opAmbulance = true;
                    }
                    break;
                case ONDER:
                    if(speler.getY()==7 && (speler.getX()== 3 || speler.getX()== 4) ){
                    opAmbulance = true;
                    }
                    break;
                case LINKS:
                    if(speler.getX()==0 && (speler.getY()== 2 || speler.getY()== 3) ){
                    opAmbulance = true;
                    }
                    break;
            }
            if(opAmbulance){
                speler.setPersoon(null);
                spelC.spel.addGered();
            }
            else {
                vak.setPersonen(speler.getPersoon());
                speler.setPersoon(null);
            }
            spelC.updatePunten();
        }

    }
    public void oppakkenActie(){
        vak = veldC.getVeldD().getVakken()[speler.getX()][speler.getY()];
        if(speler.isStof() || speler.getPersoon() !=null){
           dropItem();
        }

        else if(vak.isStoffen() && !vak.getPersonen().isEmpty()){
            ArrayList<String> keuzes = new ArrayList<>();
            keuzes.add("Gevaarlijke stoffen");
            keuzes.add("Persoon van aandacht");
            //De choicedialog maken
            ChoiceDialog<String> oppakkeus = new ChoiceDialog<>("Oppak object", keuzes);
            oppakkeus.setTitle("Object kiezen");
            oppakkeus.setHeaderText("Kies het object dat je wilt oppakken");
            oppakkeus.setContentText("Object:");

            Optional<String> keuzeObject = oppakkeus.showAndWait();
            if (keuzeObject.isPresent() && keuzeObject.get() != "Oppak object"){
                if (keuzeObject.get() == "Gevaarlijke stoffen"){
                    speler.setStof(true);
                    vak.setStoffen(false);
                }
                else {
                    speler.setPersoon(vak.getPersonen().get(0));
                    vak.getPersonen().remove(0);
                }
            }
        }
        else if (vak.isStoffen()){
            speler.setStof(true);
            vak.setStoffen(false);
        }
        else if (!vak.getPersonen().isEmpty()){
            speler.setPersoon(vak.getPersonen().get(0));
            vak.getPersonen().remove(0);
        }
        veldC.ImageSetter(speler.getX(),speler.getY());
    }

    private void hakActie(Richting richting) {
        if(speler.getRol()==REDDINGSSPECIALIST) {
            if(speler.getActiepunten()>0 && veldC.doeBeschadiging(speler.getX(), speler.getY(), richting)) {
                speler.setActiepunten(speler.getActiepunten()-1);
            }
        } else if(speler.getActiepunten()>1 && veldC.doeBeschadiging(speler.getX(), speler.getY(), richting)) {
                    speler.setActiepunten(speler.getActiepunten()-2);
        }
    }

    private void deurActie(Richting richting) {
        int x = speler.getX();
        int y = speler.getY();
        veldC.doeDeur(x,y,richting);
    }

    public void blussenActie(Richting richting) {
        int x = speler.getX();
        int y = speler.getY();
        vak = veldC.veldD.getVakken()[x][y];
        if (vak.getObstakelRichting(richting).isBegaanbaar() && (speler.getActiepunten()>0 ||
                (speler.getRol()== GASPAKDRAGER && speler.getExtrapunten()>0)) && ((speler.getRol()!=REDDINGSSPECIALIST
                && speler.getRol()!=DOKTER) || speler.getActiepunten()>1)){
            if(speler.getRol()==REDDINGSSPECIALIST || speler.getRol()==DOKTER) speler.setActiepunten(speler.getActiepunten()-1);
            if(speler.getRol()==GASPAKDRAGER && speler.getExtrapunten()>0) speler.setExtraPunten(speler.getExtrapunten()-1);
            else speler.setActiepunten(speler.getActiepunten()-1);

            switch (richting) {
                case BOVEN:
                    vak = veldC.veldD.getVakken()[x][y-1];
                    break;
                case RECHTS:
                    vak = veldC.veldD.getVakken()[x+1][y];
                    break;
                case ONDER:
                    vak = veldC.veldD.getVakken()[x][y+1];
                    break;
                case LINKS:
                    vak = veldC.veldD.getVakken()[x-1][y];
                    break;
            }
            if(vak.isRook()) {
                vak.setNiks(true);
                vak.setRook(false);
                vak.setVuur(false);
            }
            else if(vak.isVuur()){
                vak.setNiks(false);
                vak.setRook(true);
                vak.setVuur(false);
            }
        }
        else{
            System.out.println("hier zit een muur oid");
        }

    }

    private boolean draagt() {
        if(speler.isStof()) return true;
        if(speler.getPersoon() != null) return true;
        return false;
    }

    private void beweegActieKosten() {
        if (speler.getRol() == REDDINGSSPECIALIST && (speler.getExtrapunten() > 1 || (speler.getExtrapunten() > 0 && !draagt()))) {
            speler.setExtraPunten(speler.getExtrapunten() - 1);
            if(draagt()) speler.setExtraPunten(speler.getExtrapunten() - 1);
            if(speler.getPersoon()!=null && speler.getPersoon().isGeheeld()) speler.setExtraPunten(speler.getExtrapunten()+1);
        } else {
            speler.setActiepunten(speler.getActiepunten() - 1);
            if(draagt())speler.setActiepunten(speler.getActiepunten() - 1);
            if(speler.getPersoon()!=null && speler.getPersoon().isGeheeld()) speler.setActiepunten(speler.getActiepunten()+1);
        }
    }

    // verplaats de speler in de gewenste richting indien mogelijk.
    private boolean beweegActie(Richting richting) {
        boolean returnValue = false;
        Vak vak = veldC.veldD.getVakken()[speler.getX()][speler.getY()];
        veldC.removeSpeler(speler.getKleur(), speler.getX(), speler.getY());
        veldC.ImageSetter(speler.getX(), speler.getY());
        if ((speler.getActiepunten() > 0 && !draagt()) || (speler.getRol() == REDDINGSSPECIALIST && speler.getExtrapunten() > 0 && !draagt()) ||
                (speler.getActiepunten() > 1 && draagt()) || (speler.getRol() == REDDINGSSPECIALIST && speler.getExtrapunten() > 0 && !draagt())  ||
                (speler.getActiepunten() > 0 && speler.getPersoon() != null && speler.getPersoon().isGeheeld()) || (speler.getRol() == REDDINGSSPECIALIST && speler.getExtrapunten() > 0 && speler.getPersoon() != null && speler.getPersoon().isGeheeld())) {
            switch (richting) {
                case BOVEN:
                    if (speler.getY() > 0 && vak.boven.isBegaanbaar()) {
                        beweegActieKosten();
                        speler.setY(speler.getY() - 1);
                        System.out.println("*De speler loopt naar: " + speler.getX() + "," + speler.getY() + "*");
                        returnValue = true;
                    }
                    break;
                case RECHTS:
                    if (speler.getX() < 9 && vak.rechts.isBegaanbaar()) {
                        beweegActieKosten();
                        speler.setX(speler.getX() + 1);
                        System.out.println("*De speler loopt naar: " + speler.getX() + "," + speler.getY() + "*");
                        returnValue = true;
                    }
                    break;
                case ONDER:
                    if (speler.getY() < 7 && vak.onder.isBegaanbaar()) {
                        beweegActieKosten();
                        speler.setY(speler.getY() + 1);
                        System.out.println("*De speler loopt naar: " + speler.getX() + "," + speler.getY() + "*");
                        returnValue = true;
                    }
                    break;
                case LINKS:
                    if (speler.getX() > 0 && vak.links.isBegaanbaar()) {
                        beweegActieKosten();
                        speler.setX(speler.getX() - 1);
                        System.out.println("*De speler loopt naar: " + speler.getX() + "," + speler.getY() + "*");
                        returnValue = true;
                    }
                    break;
            }
        }
        veldC.addSpeler(speler.getKleur(), speler.getX(), speler.getY());
        persoonOmdraaien();
        veldC.ImageSetter(speler.getX(), speler.getY());
        return returnValue;
    }

    private void persoonOmdraaien(int x, int y) {
        vak = veldC.getVeldD().getVakken()[x][y];
        if(!vak.getPersonen().isEmpty()) {
            for(int i = 0; i < vak.getPersonen().size(); i++) {
                vak.getPersonen().get(0).setOmgedraaid(true);
            }
        }
        ArrayList<Persoon> personen = veldC.getVeldD().getVakken()[x][y].getPersonen();
        for(int i = 0; i < personen.size(); i++) {
            if (personen.get(i) == Persoon.NOPE1 || personen.get(i) == Persoon.NOPE2 ||
                    personen.get(i) == Persoon.NOPE3 || personen.get(i) == Persoon.NOPE4 ||
                    personen.get(i) == Persoon.NOPE5) {
                personen.remove(i);
                i--;
            }
        }
    }

    private void persoonOmdraaien() {
        int x = speler.getX();
        int y = speler.getY();
        vak = veldC.getVeldD().getVakken()[x][y];
        if(!vak.getPersonen().isEmpty()) {
            for(int i = 0; i < vak.getPersonen().size(); i++) {
                vak.getPersonen().get(0).setOmgedraaid(true);
            }
        }
        ArrayList<Persoon> personen = veldC.getVeldD().getVakken()[x][y].getPersonen();
        for(int i = 0; i < personen.size(); i++) {
            if (personen.get(i) == Persoon.NOPE1 || personen.get(i) == Persoon.NOPE2 ||
                    personen.get(i) == Persoon.NOPE3 || personen.get(i) == Persoon.NOPE4 ||
                    personen.get(i) == Persoon.NOPE5) {
                personen.remove(i);
                i--;
            }
        }
    }

    // reset AP en EP bij het eindigen van een beurt.
    public void resetPunten() {
        speler.setActiepunten(speler.getActiepunten()+4);
        if(speler.getActiepunten()>8) speler.setActiepunten(8);
        if(speler.getRol()==GASPAKDRAGER || speler.getRol() == REDDINGSSPECIALIST) speler.setActiepunten(speler.getActiepunten()-1);
        if(speler.getRol()==MANNETJESPUTTER) speler.setActiepunten(speler.getActiepunten()+1);
        if(speler.getRol()==GODMODE) speler.setActiepunten(9001);

        switch(speler.getRol()) {
            case REDDINGSSPECIALIST: speler.setExtraPunten(3);
                break;
            case GASPAKDRAGER: speler.setExtraPunten(3);
                break;
            case COMMANDANT: speler.setExtraPunten(2);
                break;
            default: speler.setExtraPunten(0);
        }
        spelC.updatePunten();
    }

    public void openHandleiding() {
        Stage stage = new Stage();
        BorderPane borderPane = new BorderPane();
        ScrollPane scrollpane = new ScrollPane();

        Image gebruikershandleiding = new Image("Resources/GFX/GebruikersHandleiding.jpg",2390,796,true,true);
        ImageView imageview = new ImageView(gebruikershandleiding);
        scrollpane.setContent(imageview);
        borderPane.setCenter(scrollpane);
        Scene scene = new Scene(borderPane, 1190, 815);
        stage.setScene(scene);
        stage.setTitle("Gebruikershandleiding");
        stage.show();
    }
    public Speler getSpeler() {
        return speler;
    }

}