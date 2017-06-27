package Controller;

// imports van de modellen Rol en Spraak
import Model.Rol;
import Model.Spraak;
import Model.SpeelveldData;

//imports die nodig zijn om audiobestanden af te spelen.
import Model.Vak;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

// imports die nodig zijn om audiobestanden aan te roepen
import java.io.FileInputStream;
import java.io.InputStream;

public class SpraakController {
    //Er worden objecten(instanties)
    // aangemaakt van de Controllers die van belang zijn voor spraakafhandeling
    SpelController spelC;
    SpelerController spelerC;

    public void setControllers(SpelController spelC, SpelerController spelerC) {
        // Hiermee wordt de link aangemaakt tussen andere controllers zodat
        // er functies van deze controller in kunnen worden aangeroepen.
        this.spelC = spelC;
        this.spelerC = spelerC;
    }

    public SpraakController() {

        //Dit is de constructor
        // Er worden geen parameters meegegeven.

    }

    // Er wordt een object aangemaakt van het model Spraak zodat
    // Deze benaderd kan worden door deze Controller
    Spraak audio = new Spraak();
    SpeelveldData speelveld = new SpeelveldData();
    Vak vak = new Vak();
    private boolean play=false;

    private void audioPlayer(String s) throws Exception {
        // In deze functie wordt een inputStream aangemaakt die de parameter String s
        // gebruikt om een audiobestand op te sporen
        InputStream in = new FileInputStream(s);

        // Dit audiobestand word ingeladen in de audiostream
        AudioStream audioStream = new AudioStream(in);

        // vervolgens word de ingeladen audio afgespeeld.
        AudioPlayer.player.start(audioStream);
    }

    // Er bevinden zich vanaf hier methodes die elk als doel hebben
    // een aspect van het audio af te spelen

    // Alle functies zijn synchronized met als doel
    // Dat de wait functie gebruikt kan worden in plaats van de sleepfunctie

    // Leest uit hoeveel schade er toegebracht is in het gebouw.
    public void playSchade(int schade) throws Exception {
        if (schade >= 0 && schade <= 24) {
        switch (schade) {
            case 0: audioPlayer(audio.getSchade0());
            break;
            case 1: audioPlayer(audio.getSchade1());
            break;
            case 2: audioPlayer(audio.getSchade2());
            break;
            case 3: audioPlayer(audio.getSchade3());
            break;
            case 4: audioPlayer(audio.getSchade4());
            break;
            case 5: audioPlayer(audio.getSchade5());
            break;
            case 6: audioPlayer(audio.getSchade6());
            break;
            case 7: audioPlayer(audio.getSchade7());
            break;
            case 8: audioPlayer(audio.getSchade8());
            break;
            case 9: audioPlayer(audio.getSchade9());
            break;
            case 10: audioPlayer(audio.getSchade10());
            break;
            case 11: audioPlayer(audio.getSchade11());
            break;
            case 12: audioPlayer(audio.getSchade12());
            break;
            case 13: audioPlayer(audio.getSchade13());
            break;
            case 14: audioPlayer(audio.getSchade14());
            break;
            case 15: audioPlayer(audio.getSchade15());
            break;
            case 16: audioPlayer(audio.getSchade16());
            break;
            case 17: audioPlayer(audio.getSchade17());
            break;
            case 18: audioPlayer(audio.getSchade18());
            break;
            case 19: audioPlayer(audio.getSchade19());
            break;
            case 20: audioPlayer(audio.getSchade20());
            break;
            case 21: audioPlayer(audio.getSchade21());
            break;
            case 22: audioPlayer(audio.getSchade22());
            break;
            case 23: audioPlayer(audio.getSchade23());
            break;
            case 24: audioPlayer(audio.getSchade24());
            break;
            }
        }
    }

    // Leest mogelijkheden van de deur knop uit
    public synchronized void playDeurActies() throws Exception{
        int waitTime=4500;
        audioPlayer(audio.getDeur());
        wait(waitTime);
    }

    // Leest de eindig zet knop audio uit
    public synchronized void playEindigZet() throws Exception{
        int waitTime = 3000;
        audioPlayer(audio.getEindig1());
        wait(waitTime);
        audioPlayer(audio.getEindig2());
        wait(waitTime);
        audioPlayer(audio.getEindig3());
        wait(waitTime);
    }

    // Leest de hakinformatie uit
    public synchronized void playHakken() throws Exception{
        int waitTime = 3000;
        audioPlayer(audio.getHakken2());
        wait(waitTime);
        audioPlayer(audio.getHakken1());
        wait(waitTime);
    }

    // Leest de oppakinformatie uit
    public synchronized void playOppakken() throws Exception{
        int waitTime=4000;
        audioPlayer(audio.getOppakken());
        wait(waitTime);
    }

    // Leest de blusinformatie uit
    public synchronized void playBlussen(Rol rol) throws Exception{
        int waitTime=3000;
        int waitTime2=5000;
        audioPlayer(audio.getVuurNaarRook());
        wait(waitTime);
        audioPlayer(audio.getRookBlussen());
        wait(waitTime);

        if(rol==Rol.DOKTER){
            audioPlayer(audio.getDokterBlussen());
            wait(waitTime);
        }

        if(rol==rol.REDDINGSSPECIALIST){
            audioPlayer(audio.getReddingsSpecialistBlussen());
            wait(waitTime);
        }
    }

    // speelt de informatie over voertuigen besturen uit
    public synchronized void playRijden() throws Exception{
        int waitTime=3000;
        int waitTime2=5500;
        audioPlayer(audio.getRijden1());
        wait(waitTime);
        audioPlayer(audio.getRijden2());
        wait(waitTime2);
    }

    // speelt de informatie van bewegen uit
    public synchronized void playBewegen(Rol rol) throws Exception{
        int waitTime=2500;
        int waitTime2=7500;
        int waitTime3=9000;
        int waitTime4=3500;
        speelveld.getVakken();

        audioPlayer(audio.getBewegen1());
        wait(waitTime);
        audioPlayer(audio.getBewegen2());
        wait(waitTime2);

        if (rol.equals(Rol.REDDINGSSPECIALIST)) {
            audioPlayer(audio.getBewegenReddingsSpecialist());
            wait(waitTime2);
        }

        if(rol.equals(Rol.DOKTER)) {
            audioPlayer(audio.getDokterBehandeld());
            wait(waitTime3);
        }

        audioPlayer(audio.getVuurBewegen());
        wait(waitTime4);
    }

    // leest de informatie van de klassepecifieke handlinge uit

    public synchronized void playSpecial (Rol rol) throws Exception{
        int waitTime=4000;
        audioPlayer(audio.getKlasse());
        wait(waitTime);

        if(rol.equals(Rol.DOKTER)){
            audioPlayer(audio.getDokterSpecialist());
        }

        if(rol.equals(Rol.REDDINGSSPECIALIST)){
            audioPlayer(audio.getReddingsspecialistSpecialist());
        }

        if(rol.equals(Rol.VERKENNER)){
            audioPlayer(audio.getVerkennerSpecialist());
        }

        if(rol.equals(Rol.MANNETJESPUTTER)){
            audioPlayer(audio.getMannetjesputterSpecialist());
        }

        if(rol.equals(Rol.COMMANDANT)){
            audioPlayer(audio.getKapiteinSpecialist());
        }

        if(rol.equals(Rol.BRANDSPUITBEDIENER)){
            audioPlayer(audio.getBrandspuitbedienerSpecialist());
        }

        if(rol.equals(Rol.SPECSTOFFEN)){
            audioPlayer(audio.getGevaarlijkestoffenSpecialist());
        }

        if(rol.equals(Rol.GASPAKDRAGER)){
            audioPlayer(audio.getGaspakdragerSpecialist());
        }

        wait(waitTime);
    }

    // leest de informatie over het wisselen van de rol uit
    public synchronized void playRolWissel() throws Exception{
        int waitTime=4000;
        audioPlayer(audio.getRolWissel());
        wait(waitTime);
    }

    // leest de informatie over het blussen met de brandweerwagenbrandspuit uit
    public synchronized void playWagenBlussen(Rol rol) throws Exception {
        int waitTime = 4300;
        int waitTime2 = 8000;
        if(!rol.equals(Rol.BRANDSPUITBEDIENER))
            audioPlayer(audio.getBrandspuit1());
        wait(waitTime);
        System.out.println(rol);

        if (rol.equals(Rol.BRANDSPUITBEDIENER)){
            audioPlayer(audio.getBrandspuit2());
            wait(waitTime);
            audioPlayer(audio.getBrandspuit3());
            wait(waitTime2);
        }
    }

    // Leest de counter van huidige hoeveelheid actiepunten uit
    public void playAP(int actiepunten) throws Exception{
        if(actiepunten>=0 && actiepunten<=9){
            switch(actiepunten) {
                case 0:audioPlayer(audio.getAp0());
                    break;
                case 1: audioPlayer(audio.getAp1());
                    break;
                case 2: audioPlayer(audio.getAp2());
                    break;
                case 3: audioPlayer(audio.getAp3());
                    break;
                case 4: audioPlayer(audio.getAp4());
                    break;
                case 5: audioPlayer(audio.getAp5());
                    break;
                case 6: audioPlayer(audio.getAp6());
                    break;
                case 7: audioPlayer(audio.getAp7());
                    break;
                case 8: audioPlayer(audio.getAp8());
                    break;
                case 9: audioPlayer(audio.getAp9());
                    break;
            }
        }
    }

    // leest de hoeveelheid extrapunten uit.
    public void playEP(int extrapunten) throws Exception{
        if (extrapunten>=0 && extrapunten<=3) {
            switch (extrapunten) {
                //default WAV moet nog gemaakt worden.
                case 0: audioPlayer(audio.getEp0());
                    break;
                case 1: audioPlayer(audio.getEp1());
                    break;
                case 2: audioPlayer(audio.getEp2());
                    break;
                case 3: audioPlayer(audio.getEp3());
                    break;
            }
        }
    }
    // speelt de hoeveelheid geredde personen van aandacht uit
    public void playPva(int gered) throws Exception{
            switch (gered) {
                case 0: audioPlayer(audio.getPva0());
                break;
                case 1: audioPlayer(audio.getPva1());
                break;
                case 2: audioPlayer(audio.getPva2());
                break;
                case 3: audioPlayer(audio.getPva3());
                break;
                case 4: audioPlayer(audio.getPva4());
                break;
                case 5: audioPlayer(audio.getPva5());
                break;
                case 6: audioPlayer(audio.getPva6());
                break;
                case 7: audioPlayer(audio.getPva7());
                break;
        }
    }

    // Speelt hoeveel vermiste ofwel dode personen van aandacht er zijn.
    public void playDood(int dood) throws Exception{
        switch (dood) {
            case 0: audioPlayer(audio.getVermist0());
                break;
            case 1: audioPlayer(audio.getVermist1());
                break;
            case 2: audioPlayer(audio.getVermist2());
                break;
            case 3: audioPlayer(audio.getVermist3());
        }
    }

    //speelt af hoeveel brandhaarden er op het spel aanwezig zijn.
    public void playBrandHaard(int haard) throws Exception{
        switch (haard) {
            case 1: audioPlayer(audio.getBrandhaarden1());
            break;
            case 2: audioPlayer(audio.getBrandhaarden2());
            break;
            case 3: audioPlayer(audio.getBrandhaarden3());
            break;
            case 4: audioPlayer(audio.getBrandhaarden4());
            break;
            case 5: audioPlayer(audio.getBrandhaarden5());
            break;
            case 6: audioPlayer(audio.getBrandhaarden6());
            break;
        }
    }

    // Tweede audiospeler gedeelte.
    // nadere toelichting binnen de methoden
    AudioStream audioStream;

    public void spelRegelAudioPlayer(String s) throws Exception {

        // Deze functie is een aparte audiospeler voor de spelregels
        // Deze heeft wat extra logica.
        // Deze audiospeler heeft een stop functie.
        // Wanneer de audio afspeelt, gaat play naar false en daarmee word dan
        // de audio ook gestopt. Wanneer de play op false is dan word de audio weer gestart.
        // Deze functie heeft echter nog meer aandacht nodig, omdat deze nooit werkt.
        // De reden is nog onbekend.

        InputStream in = new FileInputStream(s);

        audioStream = new AudioStream(in);

        if (play) {
            //
            AudioPlayer.player.start(audioStream);
        } else {
            AudioPlayer.player.stop(audioStream);
        }
    }

    private void handleSpelregels(){

        // Regelaar voor de stop en startmethode van de spelregelaudio.
        // Work in progress

        if(play){
            play=false;
        }

        if(!play){
            play=true;
        }
    }

    // de spelController roept deze methode aan om audio af te spelen en te stoppen.
    public void playSpelRegels(String s) throws Exception{
        handleSpelregels();
        spelRegelAudioPlayer(s);
    }

    public void playVakToestand(){
        System.out.println(speelveld.getVakken());
    }
}
