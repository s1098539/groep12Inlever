package Model;

public class Spraak {

    public Spraak() {
    }
    //Calvin, De methodes die dit model aanroepen vind u in de spraakcontroller klasse

    //Hier zijn de Guide User Interface ondersteunde geluiden te vinden.
    //Dit model bevat de paden naar de audio bestanden.
    // De view kan getallen(ook wel counters) uitlezen door middel van de onderstaande geluiden.
    // De view kan ook actieknoppen uilezen, bijvoorbeeld: bewegen, oppakken en blussen.


    // Counters op de view
    private String schade0 = "./src/Resources/Audio/0schade.wav";
    private String schade1 = "./src/Resources/Audio/1schade.wav";
    private String schade2 = "./src/Resources/Audio/2schade.wav";
    private String schade3 = "./src/Resources/Audio/3schade.wav";
    private String schade4 = "./src/Resources/Audio/4schade.wav";
    private String schade5 = "./src/Resources/Audio/5schade.wav";
    private String schade6 = "./src/Resources/Audio/6schade.wav";
    private String schade7 = "./src/Resources/Audio/7schade.wav";
    private String schade8 = "./src/Resources/Audio/8schade.wav";
    private String schade9 = "./src/Resources/Audio/9schade.wav";
    private String schade10 = "./src/Resources/Audio/10schade.wav";
    private String schade11 = "./src/Resources/Audio/11schade.wav";
    private String schade12 = "./src/Resources/Audio/12schade.wav";
    private String schade13 = "./src/Resources/Audio/13schade.wav";
    private String schade14 = "./src/Resources/Audio/14schade.wav";
    private String schade15 = "./src/Resources/Audio/15schade.wav";
    private String schade16 = "./src/Resources/Audio/16schade.wav";
    private String schade17 = "./src/Resources/Audio/17schade.wav";
    private String schade18 = "./src/Resources/Audio/18schade.wav";
    private String schade19 = "./src/Resources/Audio/19schade.wav";
    private String schade20 = "./src/Resources/Audio/20schade.wav";
    private String schade21 = "./src/Resources/Audio/21schade.wav";
    private String schade22 = "./src/Resources/Audio/22schade.wav";
    private String schade23 = "./src/Resources/Audio/23schade.wav";
    private String schade24 = "./src/Resources/Audio/24schade.wav";
    private String eindig1 = "./src/Resources/Audio/EindigtZetKnop.wav";
    private String eindig2 = "./src/Resources/Audio/EindigZetAPOvergebleven.wav";
    private String eindig3 = "./src/Resources/Audio/EindigZetVolgendeSpelerKrijgtBeurt.wav";
    private String ap0 = "./src/Resources/Audio/0AP.wav";
    private String ap1 = "./src/Resources/Audio/1AP.wav";
    private String ap2 = "./src/Resources/Audio/2AP.wav";
    private String ap3 = "./src/Resources/Audio/3AP.wav";
    private String ap4 = "./src/Resources/Audio/4AP.wav";
    private String ap5 = "./src/Resources/Audio/5AP.wav";
    private String ap6 = "./src/Resources/Audio/6AP.wav";
    private String ap7 = "./src/Resources/Audio/7AP.wav";
    private String ap8 = "./src/Resources/Audio/8AP.wav";
    private String ap9 = "./src/Resources/Audio/9AP.wav";
    private String ep0 = "./src/Resources/Audio/0EP.wav";
    private String ep1 = "./src/Resources/Audio/1EP.wav";
    private String ep2 = "./src/Resources/Audio/2EP.wav";
    private String ep3 = "./src/Resources/Audio/3EP.wav";
    private String pva0 = "./src/Resources/Audio/0pva.wav";
    private String pva1 = "./src/Resources/Audio/1pva.wav";
    private String pva2 = "./src/Resources/Audio/2pva.wav";
    private String pva3 = "./src/Resources/Audio/3pva.wav";
    private String pva4 = "./src/Resources/Audio/4pva.wav";
    private String pva5 = "./src/Resources/Audio/5pva.wav";
    private String pva6 = "./src/Resources/Audio/6pva.wav";
    private String pva7 = "./src/Resources/Audio/7pva.wav";
    private String vermist0 = "./src/Resources/Audio/0vermist.wav";
    private String vermist1 = "./src/Resources/Audio/1vermist.wav";
    private String vermist2 = "./src/Resources/Audio/2vermist.wav";
    private String vermist3 = "./src/Resources/Audio/3vermist.wav";
    private String brandhaarden1 = "./src/Resources/Audio/1Haard.wav";
    private String brandhaarden2 = "./src/Resources/Audio/2haard.wav";
    private String brandhaarden3 = "./src/Resources/Audio/3haard.wav";
    private String brandhaarden4 = "./src/Resources/Audio/4haard.wav";
    private String brandhaarden5 = "./src/Resources/Audio/5haard.wav";
    private String brandhaarden6 = "./src/Resources/Audio/6haard.wav";

    // De audiobestanden van de kosten van alle acties kunt u hier vinden.
    private String bewegen1 = "./src/Resources/Audio/Bewegen1AP.wav";
    private String bewegen2 = "./src/Resources/Audio/BewegenPvaGS2AP.wav";
    private String bewegenReddingsSpecialist = "./src/Resources/Audio/BewegenReddingsspecialist3EP.wav";
    private String brandspuit1 = "./src/Resources/Audio/BrandspuitBedienen4AP.wav";
    private String brandspuit2 = "./src/Resources/Audio/BrandspuitbedienerKost2AP.wav";
    private String brandspuit3 = "./src/Resources/Audio/BrandspuitbedienerReroll.wav";
    private String deur = "./src/Resources/Audio/DeurOpenenSluiten1AP.wav";
    private String rolWissel = "./src/Resources/Audio/RolWisselen2AP.wav";
    private String dokterBehandeld = "./src/Resources/Audio/DokterBehandelenBewegenGeenExtraAP.wav";
    private String dokterBlussen = "./src/Resources/Audio/DokterBlussenBetaaltDubbelAP.wav";
    private String reddingsSpecialistBlussen = "./src/Resources/Audio/ReddingsspecialistBlussenBetaaltDubbelAP.wav";
    private String hakken1 = "./src/Resources/Audio/Hakken1APReddingsspecialist.wav";
    private String hakken2 = "./src/Resources/Audio/Hakken2AP.wav";
    private String klasse = "./src/Resources/Audio/KlasseSpecial.wav";
    private String oppakken = "./src/Resources/Audio/OppakkenKostGeenAP.wav";
    private String rijden1 = "./src/Resources/Audio/RijdenKost2AP.wav";
    private String rijden2  = "./src/Resources/Audio/RijdenMeerijdenKostGeenAP.wav";
    private String rookBlussen = "./src/Resources/Audio/RookBlussen1AP.wav";
    private String vuurNaarRook = "./src/Resources/Audio/VuurNaarRook1AP.wav";
    private String vuurBewegen = "./src/Resources/Audio/VuurBewegen2AP.wav";

    // De audiobestanden van de unieke mogelijkheden van de verschillende specialisten stan hier.

    private String dokterSpecialist = "./src/Resources/Audio/DokterKlasse.wav";
    private String brandspuitbedienerSpecialist = "./src/Resources/Audio/BrandspuitbedienerKlasse.wav";
    private String kapiteinSpecialist = "./src/Resources/Audio/KapiteinKlasse.wav";
    private String verkennerSpecialist  = "./src/Resources/Audio/VerkennerKlasse.wav";
    private String mannetjesputterSpecialist= "./src/Resources/Audio/MannetjesputterKlasse.wav";
    private String gevaarlijkestoffenSpecialist = "./src/Resources/Audio/GevaarlijkeStoffenKlasse.wav";
    private String gaspakdragerSpecialist = "./src/Resources/Audio/GaspakdragerKlasse.wav";
    private String reddingsspecialistSpecialist = "./src/Resources/Audio/ReddingsspecialistKlasse.wav";

    // Hier staan de audiobestanden van de relevante spelregels van onze versie van het spel.
    // Deze dienen als ondersteuning van slechtziende die de regels niet kunnen lezen.

    private String aangrenzendeVakken = "./src/Resources/Audio/AangrenzendeVakken.wav";
    private String actieOndernemen = "./src/Resources/Audio/ActieOndernemen.wav";
    private String bewegenSpel1 = "./src/Resources/Audio/BewegenSpel1.wav";
    private String bewegenSpel2 = "./src/Resources/Audio/BewegenSpel2.wav";
    private String bewegenSpel3 = "./src/Resources/Audio/BewegenSpel3.wav";
    private String deurRegels = "./src/Resources/Audio/DeurOpenenSluiten1AP.wav";
    private String doelSpel = "./src/Resources/Audio/DoelVanHetSpel.wav";
    private String doven  = "./src/Resources/Audio/Doven.wav";
    private String spelEinde = "./src/Resources/Audio/HetSpeleinde.wav";
    private String houwen = "./src/Resources/Audio/Houwen.wav";
    private String omvergeblazenBrandweermannen = "./src/Resources/Audio/OmvergeblazenBrandweermannen.wav";
    private String ontploffingen1 = "./src/Resources/Audio/Ontploffingen1.wav";
    private String ontploffingen2  = "./src/Resources/Audio/Ontploffingen2.wav";
    private String gevolgSchokgolf = "./src/Resources/Audio/OntploffingenGevolgSchokgolf.wav";
    private String overslaandeBrand = "./src/Resources/Audio/OverslaandeBrand.wav";

    // Eenvoudige samenvoeging van alle audiobestanden tot één bestand zodat deze met gemak
    // volledig beluisterd kan worden.
    // Audiobestand bevat de bovenstaande audio spelregelaudio.
    // Hiermee is de mogelijkheid om specifieke stukken af te spelen, en het geheel.
    // Dit moet echter nog geïmplementeerd worden.

    private String spelRegels = "./src/Resources/Audio/Spelregels.wav";

    // Vanaf hier staan de getters.
    // In dit bestand zal u geen setters vinden, omdat deze niet nodig zijn.
    // In een ergere situatie kan het gebeuren dat de audiopaden worden aangepast en hier mee
    // deze functionaliteit wegvalt.
    // Hierom zijn alleen getters van belang.
    // Je wil alleen aan het systeem melden waar deze heen de audio kan vinden.

    // Getters van de SchadeCounter
    // Hier kan je de audio getten wat uitleest hoeveel schadeblokjes op het speelveld staan

    public String getSchade0() {
        return schade0;
    }

    public String getSchade1() {
        return schade1;
    }

    public String getSchade2() {
        return schade2;
    }

    public String getSchade3() {
        return schade3;
    }

    public String getSchade4() {
        return schade4;
    }

    public String getSchade5() {
        return schade5;
    }

    public String getSchade6() {
        return schade6;
    }

    public String getSchade7() {
        return schade7;
    }

    public String getSchade8() {
        return schade8;
    }

    public String getSchade9() {
        return schade9;
    }

    public String getSchade10() {
        return schade10;
    }

    public String getSchade11() {
        return schade11;
    }

    public String getSchade12() {
        return schade12;
    }

    public String getSchade13() {
        return schade13;
    }

    public String getSchade14() {
        return schade14;
    }

    public String getSchade15() {
        return schade15;
    }

    public String getSchade16() {
        return schade16;
    }

    public String getSchade17() {
        return schade17;
    }

    public String getSchade18() {
        return schade18;
    }

    public String getSchade19() {
        return schade19;
    }

    public String getSchade20() {
        return schade20;
    }

    public String getSchade21() {
        return schade21;
    }

    public String getSchade22() {
        return schade22;
    }

    public String getSchade23() {
        return schade23;
    }

    public String getSchade24() {
        return schade24;
    }

    // Getters van de Eindig zet knop
    // Hier kan je de audio getten wat uitleest wat de eindig zet knop onder andere doet.

    public String getEindig1() {
        return eindig1;
    }

    public String getEindig2() {
        return eindig2;
    }

    public String getEindig3() {
        return eindig3;
    }

    // Getters van de Actiepunten Counter
    // Hier kan je de audio getten wat uitleest hoeveel actiepunten je speler

    public String getAp0() { return ap0; }

    public String getAp1() {
        return ap1;
    }

    public String getAp2() {
        return ap2;
    }

    public String getAp3() {
        return ap3;
    }

    public String getAp4() {
        return ap4;
    }

    public String getAp5() {
        return ap5;
    }

    public String getAp6() {
        return ap6;
    }

    public String getAp7() {
        return ap7;
    }

    public String getAp8() {
        return ap8;
    }

    public String getAp9() {
        return ap9;
    }

    // Getters van de Extrapunten
    // Hier kan je de audio getten wat uitleest hoeveel extrapunten een speler bezit

    public String getEp0() {
        return ep0;
    }

    public String getEp1() {
        return ep1;
    }

    public String getEp2() {
        return ep2;
    }

    public String getEp3() {
        return ep3;
    }

    // Getters van de geredde personen van aandacht Counter
    // Hier kan je de audio getten wat uitleest hoeveel personen van aandacht gered zijn.

    public String getPva0() {
        return pva0;
    }

    public String getPva1() {
        return pva1;
    }

    public String getPva2() {
        return pva2;
    }

    public String getPva3() {
        return pva3;
    }

    public String getPva4() {
        return pva4;
    }

    public String getPva5() {
        return pva5;
    }

    public String getPva6() {
        return pva6;
    }

    public String getPva7() {
        return pva7;
    }

    public String getVermist0() {
        return vermist0;
    }

    public String getVermist1() {
        return vermist1;
    }

    public String getVermist2() {
        return vermist2;
    }

    public String getVermist3() {
        return vermist3;
    }

    // Getters van de brandhaarden Counter
    // Hier kan je de audio getten wat uitleest hoeveel brandhaarden op het speelveld staan

    public String getBrandhaarden1() {
        return brandhaarden1;
    }

    public String getBrandhaarden2() {
        return brandhaarden2;
    }

    public String getBrandhaarden3() {
        return brandhaarden3;
    }

    public String getBrandhaarden4() {
        return brandhaarden4;
    }

    public String getBrandhaarden5() {
        return brandhaarden5;
    }

    public String getBrandhaarden6() {
        return brandhaarden6;
    }

    // Getters van de beweegknoppen
    // Hier kan je de audio getten wat de mogelijkheden van de beweegknoppen uitleest.

    public String getBewegen1() {
        return bewegen1;
    }

    public String getBewegen2() {
        return bewegen2;
    }

    public String getVuurBewegen() {
        return vuurBewegen;
    }

    public String getBewegenReddingsSpecialist() {
        return bewegenReddingsSpecialist;
    }

    // Getters van de knop brandspuit
    // Hier kan je de audio getten wat de mogelijkheden van de brandspuit uitleest.

    public String getBrandspuit1() {
        return brandspuit1;
    }

    public String getBrandspuit2() {
        return brandspuit2;
    }

    public String getBrandspuit3() {
        return brandspuit3;
    }

    // getters audio actiepunten kosten.

    public String getDeur() {
        return deur;
    }

    public String getRolWissel() {
        return rolWissel;
    }

    public String getHakken1() {
        return hakken1;
    }

    public String getHakken2() {
        return hakken2;
    }

    public String getKlasse() {
        return klasse;
    }

    public String getOppakken() {
        return oppakken;
    }

    public String getRijden1() {
        return rijden1;
    }

    public String getRijden2() {
        return rijden2;
    }

    public String getRookBlussen() {
        return rookBlussen;
    }

    public String getVuurNaarRook() {
        return vuurNaarRook;
    }

    // getters audio Klasseuitzonderingen wat het bedrag van de actiepunten beïnvoed.

    public String getDokterBehandeld() {
        return dokterBehandeld;
    }

    public String getDokterBlussen() {
        return dokterBlussen;
    }

    public String getReddingsSpecialistBlussen() {
        return reddingsSpecialistBlussen;
    }

    // Getters van de audio van de unieke en klassespecifieke handelingen

    public String getDokterSpecialist() {
        return dokterSpecialist;
    }

    public String getBrandspuitbedienerSpecialist() {
        return brandspuitbedienerSpecialist;
    }

    public String getKapiteinSpecialist() {
        return kapiteinSpecialist;
    }

    public String getVerkennerSpecialist() {
        return verkennerSpecialist;
    }

    public String getMannetjesputterSpecialist() {
        return mannetjesputterSpecialist;
    }

    public String getGevaarlijkestoffenSpecialist() {
        return gevaarlijkestoffenSpecialist;
    }

    public String getGaspakdragerSpecialist() {
        return gaspakdragerSpecialist;
    }

    public String getReddingsspecialistSpecialist() {
        return reddingsspecialistSpecialist;
    }

    // getters van de audio van de spelregels

    public String getAangrenzendeVakken() {
        return aangrenzendeVakken;
    }

    public String getActieOndernemen() {
        return actieOndernemen;
    }

    public String getBewegenSpel1() {
        return bewegenSpel1;
    }

    public String getBewegenSpel2() {
        return bewegenSpel2;
    }

    public String getBewegenSpel3() {
        return bewegenSpel3;
    }

    public String getDeurRegels() {
        return deurRegels;
    }

    public String getDoelSpel() {
        return doelSpel;
    }

    public String getDoven() {
        return doven;
    }

    public String getSpelEinde() {
        return spelEinde;
    }

    public String getHouwen() {
        return houwen;
    }

    public String getOmvergeblazenBrandweermannen() {
        return omvergeblazenBrandweermannen;
    }

    public String getOntploffingen1() {
        return ontploffingen1;
    }

    public String getOntploffingen2() {
        return ontploffingen2;
    }

    public String getGevolgSchokgolf() {
        return gevolgSchokgolf;
    }

    public String getOverslaandeBrand() {
        return overslaandeBrand;
    }

    public String getSpelRegels() {
        return spelRegels;
    }

}