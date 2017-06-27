package Model;

import Controller.SpelerController;

import java.io.Serializable;

/**
 * Created by Sam van Schaik
 */
public class Speler implements Serializable {
    private static final long serialVersionUID = 1L;

    //Speler informatie
    String naam;
    Kleur kleur;
    String ip;

    //Positie
    int x;
    int y;

    //Punten
    int actiepunten;
    int extrapunten;

    Rol rol = Rol.MANNETJESPUTTER;

    boolean slechtziendmodus = false;

    Boolean stof = false;
    Persoon persoon = null;



    public Speler(String naam, Kleur kleur, int x, int y) {
        this.naam = naam;
        this.kleur = kleur;
//        this.x = x;
//        this.y = y;
    }

    //Getters
    public String getNaam() {
        return naam;
    }

    public Kleur getKleur() {
        return kleur;
    }

    public String getIp() {
        return ip;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getActiepunten() {
        return actiepunten;
    }

    public int getExtrapunten() {
        return extrapunten;
    }

    public Rol getRol() {
        return rol;
    }

    public boolean isSlechtziendmodus() {
        return slechtziendmodus;
    }

    //Setters
    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setKleur(Kleur kleur) {
        this.kleur = kleur;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setActiepunten(int actiepunten) {
        this.actiepunten = actiepunten;
    }

    public void setExtraPunten(int extrapunten) {
        this.extrapunten = extrapunten;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void setSlechtziendmodus(boolean slechtziendmodus) {
        this.slechtziendmodus = slechtziendmodus;
    }

    public Boolean isStof() {
        return stof;
    }

    public void setStof(Boolean stof) {
        this.stof = stof;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }


}
