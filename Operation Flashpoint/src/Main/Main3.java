//package Main;
//
//import Controller.DobbelsteenController;
//import Controller.SpeelveldController;
//import Controller.SpelController;
//import Controller.SpelerController;
//
///**
// * Created by Lion on 15-6-2017.
// */
//public class Main3 {
//    public static void main(String[] args) {
//        SpeelveldController veldC = new SpeelveldController();
//        SpelController spelC = new SpelController();
//        SpelerController spelerC = new SpelerController();
//        DobbelsteenController dobbelC = new DobbelsteenController();
//
//        veldC.setControllers(spelC,spelerC,dobbelC);
//        spelC.setControllers(veldC,spelerC,dobbelC);
//        spelerC.setControllers(veldC,spelC,dobbelC);
//        dobbelC.setControllers(veldC,spelC,spelerC);
//
//
//
//
//
//
//    }
//}
