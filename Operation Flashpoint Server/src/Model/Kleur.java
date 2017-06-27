package Model;

public enum Kleur {
    BLAUW("Blauw"),GEEL("Geel"),GROEN("Groen"),ORANJE("Oranje"),ROOD("Rood"),ZWART("Zwart");
    private final String string;

    Kleur(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
