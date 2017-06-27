package Model;

import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Created by Joep Oonk on 14-6-2017.
 */
//dit zal ook wel nodig zijn
public class Lobby {
    private String ip;
    private Kleur[] kleur;
    int welkespeler=0;
    Kleur SpelerKleur;
    ArrayList<Speler> ready = new ArrayList<>();


    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public Kleur getKleur(){
        SpelerKleur = kleur[welkespeler];
        welkespeler++;
        return SpelerKleur;
    }

    public Lobby (){
        kleur = new Kleur[6];
        for(int i=0; i<kleur.length; i++){
            for (Kleur k: Kleur.values()){
                kleur[i] = k;
            }
        }
    }
    public void setReady(Speler speler){
        ready.add(speler);
    }
    public int getAantalReady(){
        return ready.size();
    }
}
