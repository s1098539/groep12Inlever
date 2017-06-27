package Controller;

import javafx.scene.control.TextField;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import Main.*;

//delete knoppen hier en maak er methodes van, dan kan je de methodes gebruiken met de knoppen in spelcontroller

/**
 * Created by Joep Oonk on 14-6-2017.
 */


public class ChatController {
    SpeelveldController veldC;
    SpelerController spelerC;
    DobbelsteenController dobbelC;
    SpelController spelC;
    ChatController chatC;
    Registry registry = null;


    // Lion, verbind deze controller met 3 andere
    public void setControllers(SpelController spelC, SpeelveldController veldC, SpelerController spelerC, DobbelsteenController dobbelC, ChatController chatC) {
        this.veldC = veldC;
        this.spelC = spelC;
        this.spelerC = spelerC;
        this.dobbelC = dobbelC;
        this.chatC = chatC;

    }


    //chat groter maken
   public void groterChat() {
       spelC.getChatArea().setPrefHeight(500);
       spelC.getChatArea().setScrollTop(Double.MAX_VALUE);
    }

    //Chat kleiner maken
    public void kleinerChat() {
        spelC.getChatArea().setPrefHeight(50);
        spelC.getChatArea().setScrollTop(Double.MAX_VALUE);
    }

    public void stuurBericht(){
        spelC.setLocalMessage(spelC.getTextInput().getText());

        try {
            registry = LocateRegistry.getRegistry("localhost");
            Interface clientStub = (Interface) registry.lookup("Main.Interface");
            clientStub.sendMessageObject(spelC.getUsername(), spelC.getLocalMessage());

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

        spelC.getTextInput().setText("");
    }
}



