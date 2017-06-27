package Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class SpeelveldImages {

    public SpeelveldImages() {
    }

    private GridPane gridPane;
    private FlowPane[][]flowPanes = new FlowPane[10][8];
    private ImageView[][][]imageViews = new ImageView[10][8][9];
    private ImageView[]carViews = new ImageView[2];

    private Image BrandweerBlauw50pxActive = new Image("Resources/GFX/Brandweerblauwselect.png");
    private Image BrandweerGeel50pxActive = new Image("Resources/GFX/Brandweergeelselect.png");
    private Image BrandweerGroen50pxActive = new Image("Resources/GFX/Brandweergroenselect.png");
    private Image BrandweerOranje50pxActive = new Image("Resources/GFX/Brandweeroranjeselect.png");
    private Image BrandweerRood50pxActive = new Image("Resources/GFX/Brandweerroodselect.png");
    private Image BrandweerZwart50pxActive = new Image("Resources/GFX/Brandweerzwartselect.png");
    private Image brandBlusserSelect = new Image("Resources/GFX/Brandblusserselect.png");
    private Image hakkenSelect = new Image("Resources/GFX/Hakkenselect.png");
    private Image openenDeurSelect = new Image("Resources/GFX/Openendeurselect.png");
    private Image pickIpSelect = new Image("Resources/GFX/Pickupselect.png");
    private Image rijdenSelect = new Image("Resources/GFX/Rijdenselect.png");
    private Image brandweerBlauw50px = new Image("Resources/GFX/Brandweerblauw50px.png");
    private Image brandweerGeel50px = new Image("Resources/GFX/Brandweergeel50px.png");
    private Image brandweerGroen50px = new Image("Resources/GFX/Brandweergroen50px.png");
    private Image brandweerOranje50px = new Image("Resources/GFX/Brandweeroranje50px.png");
    private Image brandweerRood50px = new Image("Resources/GFX/Brandweerrood50px.png");
    private Image brandweerZwart50px = new Image("Resources/GFX/Brandweerzwart50px.png");
    private Image pickup = new Image("Resources/GFX/Pickup.png");
    private Image openenDeur = new Image("Resources/GFX/Openendeur.png");
    private Image hakken = new Image("Resources/GFX/Hakken.png");
    private Image brandBlusser = new Image("Resources/GFX/Brandblusser.png");
    private Image rijden = new Image("Resources/GFX/Rijden.png");
    private Image vraagteken = new Image("Resources/GFX/Vraagteken.png",50,50,false,true);
    private Image empty = new Image("Resources/GFX/Empty.png",20,20,false,true);
    private Image hotspot = new Image("Resources/GFX/Hotspot.png",20,20,false,true);
    private Image persoon = new Image("Resources/GFX/Vraagteken.png",20,20,false,true);
    private Image vlam = new Image("Resources/GFX/Vlam.png");
    private Image rook = new Image("Resources/GFX/Rook.png");
    private Image gevaarlijkeStof = new Image("Resources/GFX/GevaarlijkeStof.png");
    private Image dichteDeurLinks = new Image("Resources/GFX/DichteDeurLinks.png");
    private Image dichteDeurOnder = new Image("Resources/GFX/DichteDeurOnder.png");
    private Image dichteDeurBoven = new Image("Resources/GFX/DichteDeurBoven.png");
    private Image dichteDeurRechts = new Image("Resources/GFX/DichteDeurRechts.png");
    private Image openDeurLinks = new Image("Resources/GFX/OpenDeurLinks.png");
    private Image openDeurOnder = new Image("Resources/GFX/OpenDeurOnder.png");
    private Image openDeurBoven = new Image("Resources/GFX/OpenDeurBoven.png");
    private Image openDeurRechts = new Image("Resources/GFX/OpenDeurRechts.png");
    private Image muurBoven = new Image("Resources/GFX/MuurBoven.png");
    private Image muurLinks = new Image("Resources/GFX/MuurLinks.png");
    private Image muurOnder = new Image("Resources/GFX/MuurOnder.png");
    private Image muurRechts = new Image("Resources/GFX/MuurRechts.png");
    private Image muur1kapotBoven = new Image("Resources/GFX/Muur1kapotBoven.png");
    private Image muur1kapotLinks = new Image("Resources/GFX/Muur1kapotLinks.png");
    private Image muur1kapotOnder = new Image("Resources/GFX/Muur1kapotOnder.png");
    private Image muur1kapotRechts = new Image("Resources/GFX/Muur1kapotRechts.png");
    private Image muur2kapotBoven = new Image("Resources/GFX/Muur2kapotBoven.png");
    private Image muur2kapotLinks = new Image("Resources/GFX/Muur2kapotLinks.png");
    private Image muur2kapotOnder = new Image("Resources/GFX/Muur2kapotOnder.png");
    private Image muur2kapotRechts = new Image("Resources/GFX/Muur2kapotRechts.png");
    private Image brandweerBlauw = new Image("Resources/GFX/Brandweerblauw.png",20,20,false,true);
    private Image brandweerGeel = new Image("Resources/GFX/Brandweergeel.png",20,20,false,true);
    private Image brandweerGroen = new Image("Resources/GFX/Brandweergroen.png",20,20,false,true);
    private Image brandweerOranje = new Image("Resources/GFX/Brandweeroranje.png",20,20,false,true);
    private Image brandweerRood = new Image("Resources/GFX/Brandweerrood.png",20,20,false,true);
    private Image brandweerZwart = new Image("Resources/GFX/Brandweerzwart.png",20,20,false,true);
    private Image oma = new Image("Resources/GFX/Oma.png",20,20,false,true);
    private Image vis = new Image("Resources/GFX/Vis.png",20,20,false,true);
    private Image egel = new Image("Resources/GFX/Egel.png",20,20,false,true);
    private Image hond = new Image("Resources/GFX/(zee)Hond.png",20,20,false,true);
    private Image snek = new Image("Resources/GFX/Snek.png",20,20,false,true);
    private Image latifah = new Image("Resources/GFX/Latifah.png",20,20,false,true);
    private Image roodhaar = new Image("Resources/GFX/Roodhaar.png",20,20,false,true);
    private Image groenhaar = new Image("Resources/GFX/Groenhaar.png",20,20,false,true);
    private Image obamanigua = new Image("Resources/GFX/Obamanigua.png",20,20,false,true);
    private Image hipstersnor = new Image("Resources/GFX/Hipstersnor.png",20,20,false,true);
    private Image medkit = new Image("Resources/GFX/Medkit.png",20,20,false,true);
    private Image ambuBoven = new Image("Resources/GFX/ambulanceLayerboven.png");
    private Image ambuLinks = new Image("Resources/GFX/ambulanceLayerlinks.png");
    private Image ambuOnder = new Image("Resources/GFX/ambulanceLayeronder.png");
    private Image ambuRechts = new Image("Resources/GFX/ambulanceLayerrechts.png");
    private Image brandweerBoven = new Image("Resources/GFX/brandweerlayerboven.png");
    private Image brandweerLinks = new Image("Resources/GFX/brandweerlayerlinks.png");
    private Image brandweerOnder = new Image("Resources/GFX/brandweerlayeronder.png");
    private Image brandweerRechts = new Image("Resources/GFX/brandweerlayerrechts.png");

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public FlowPane[][] getFlowPanes() {
        return flowPanes;
    }

    public ImageView[][][] getImageViews() {
        return imageViews;
    }

    public ImageView[] getCarViews() {
        return carViews;
    }

    public Image getEmpty() {
        return empty;
    }

    public Image getHotspot() {
        return hotspot;
    }

    public Image getPersoon() {
        return persoon;
    }

    public Image getVlam() {
        return vlam;
    }

    public Image getRook() {
        return rook;
    }

    public Image getGevaarlijkeStof() {
        return gevaarlijkeStof;
    }

    public Image getDichteDeurLinks() {
        return dichteDeurLinks;
    }

    public Image getDichteDeurOnder() {
        return dichteDeurOnder;
    }

    public Image getDichteDeurBoven() {
        return dichteDeurBoven;
    }

    public Image getDichteDeurRechts() {
        return dichteDeurRechts;
    }

    public Image getOpenDeurLinks() {
        return openDeurLinks;
    }

    public Image getOpenDeurOnder() {
        return openDeurOnder;
    }

    public Image getOpenDeurBoven() {
        return openDeurBoven;
    }

    public Image getOpenDeurRechts() {
        return openDeurRechts;
    }

    public Image getMuurBoven() {
        return muurBoven;
    }

    public Image getMuurLinks() {
        return muurLinks;
    }

    public Image getMuurOnder() {
        return muurOnder;
    }

    public Image getMuurRechts() {
        return muurRechts;
    }

    public Image getMuur1kapotBoven() {
        return muur1kapotBoven;
    }

    public Image getMuur1kapotLinks() {
        return muur1kapotLinks;
    }

    public Image getMuur1kapotOnder() {
        return muur1kapotOnder;
    }

    public Image getMuur1kapotRechts() {
        return muur1kapotRechts;
    }

    public Image getMuur2kapotBoven() {
        return muur2kapotBoven;
    }

    public Image getMuur2kapotLinks() {
        return muur2kapotLinks;
    }

    public Image getMuur2kapotOnder() {
        return muur2kapotOnder;
    }

    public Image getMuur2kapotRechts() {
        return muur2kapotRechts;
    }

    public Image getBrandweerBlauw() {
        return brandweerBlauw;
    }

    public Image getBrandweerGeel() {
        return brandweerGeel;
    }

    public Image getBrandweerGroen() {
        return brandweerGroen;
    }

    public Image getBrandweerOranje() {
        return brandweerOranje;
    }

    public Image getBrandweerRood() {
        return brandweerRood;
    }

    public Image getBrandweerZwart() {
        return brandweerZwart;
    }

    public Image getOma() {
        return oma;
    }

    public Image getVis() {
        return vis;
    }

    public Image getEgel() {
        return egel;
    }

    public Image getHond() {
        return hond;
    }

    public Image getSnek() {
        return snek;
    }

    public Image getLatifah() {
        return latifah;
    }

    public Image getRoodhaar() {
        return roodhaar;
    }

    public Image getGroenhaar() {
        return groenhaar;
    }

    public Image getObamanigua() {
        return obamanigua;
    }

    public Image getHipstersnor() {
        return hipstersnor;
    }

    public Image getMedkit() {
        return medkit;
    }

    public Image getAmbuBoven() {
        return ambuBoven;
    }

    public Image getAmbuLinks() {
        return ambuLinks;
    }

    public Image getAmbuOnder() {
        return ambuOnder;
    }

    public Image getAmbuRechts() {
        return ambuRechts;
    }

    public Image getBrandweerBoven() {
        return brandweerBoven;
    }

    public Image getBrandweerLinks() {
        return brandweerLinks;
    }

    public Image getBrandweerOnder() {
        return brandweerOnder;
    }

    public Image getBrandweerRechts() {
        return brandweerRechts;
    }

    public Image getVraagteken() {
        return vraagteken;
    }

    public Image getOpenenDeur() {
        return openenDeur;
    }

    public Image getHakken() {
        return hakken;
    }

    public Image getBrandBlusser() {
        return brandBlusser;
    }

    public Image getRijden() {
        return rijden;
    }

    public Image getPickup() {
        return pickup;
    }

    public Image getBrandweerBlauw50px() {
        return brandweerBlauw50px;
    }

    public Image getBrandweerGeel50px() {
        return brandweerGeel50px;
    }

    public Image getBrandweerGroen50px() {
        return brandweerGroen50px;
    }

    public Image getBrandweerOranje50px() {
        return brandweerOranje50px;
    }

    public Image getBrandweerRood50px() {
        return brandweerRood50px;
    }

    public Image getBrandweerZwart50px() {
        return brandweerZwart50px;
    }

    public Image getBrandBlusserSelect() {
        return brandBlusserSelect;
    }

    public Image getHakkenSelect() {
        return hakkenSelect;
    }

    public Image getOpenenDeurSelect() {
        return openenDeurSelect;
    }

    public Image getPickIpSelect() {
        return pickIpSelect;
    }

    public Image getRijdenSelect() {
        return rijdenSelect;
    }

    public Image getBrandweerBlauw50pxActive() {
        return BrandweerBlauw50pxActive;
    }

    public Image getBrandweerGeel50pxActive() {
        return BrandweerGeel50pxActive;
    }

    public Image getBrandweerGroen50pxActive() {
        return BrandweerGroen50pxActive;
    }

    public Image getBrandweerOranje50pxActive() {
        return BrandweerOranje50pxActive;
    }

    public Image getBrandweerRood50pxActive() {
        return BrandweerRood50pxActive;
    }

    public Image getBrandweerZwart50pxActive() {
        return BrandweerZwart50pxActive;
    }
}