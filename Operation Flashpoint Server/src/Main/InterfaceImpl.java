package Main;

import Controller.SpeelveldController;
import Controller.SpelController;
import Model.*;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import Main.ChatListenInterface;

public class InterfaceImpl implements Interface, Serializable {
    //DONT GET RID OF THIS ---------------------------

    Spel spelServer;
    SpeelveldData veldServer;

    protected InterfaceImpl() throws IOException {
    }

    Map<Kleur, Speler> mMap = new HashMap<Kleur, Speler>();
    int i = 1;
    int a = 0;
    int b = 0;
    private ArrayList<ChatListenInterface> Listeners = new ArrayList<ChatListenInterface>();
    private ArrayList<Interface> gameListeners = new ArrayList<Interface>();

    @Override
    public Kleur addSpeler(String naam) throws RemoteException {
        Kleur kleur;
        switch (i) {
            case 1:
                Speler speler = new Speler(naam, Kleur.GROEN, 1, 1);
                mMap.put(Kleur.GROEN, speler);
                i++;
                kleur = Kleur.GROEN;
                break;
            case 2:
                Speler speler2 = new Speler(naam, Kleur.ZWART, 1, 2);
                mMap.put(Kleur.ZWART, speler2);
                i++;
                kleur = Kleur.ZWART;
                break;
            case 3:
                Speler speler3 = new Speler(naam, Kleur.GEEL, 1, 3);
                mMap.put(Kleur.GEEL, speler3);
                i++;
                kleur = Kleur.GEEL;
                break;
            case 4:
                Speler speler4 = new Speler(naam, Kleur.BLAUW, 1, 4);
                mMap.put(Kleur.BLAUW, speler4);
                i++;
                kleur = Kleur.BLAUW;
                break;
            case 5:
                Speler speler5 = new Speler(naam, Kleur.ORANJE, 1, 5);
                mMap.put(Kleur.ORANJE, speler5);
                i++;
                kleur = Kleur.ORANJE;
                break;
            case 6:
                Speler speler6 = new Speler(naam, Kleur.ROOD, 1, 6);
                mMap.put(Kleur.ROOD, speler6);
                i++;
                kleur = Kleur.ROOD;
                break;
            default:
                return null;
        }
        return kleur;
    }

    @Override
    public Speler GetSpeler(Kleur kleur) throws RemoteException {
        return mMap.get(kleur);
    }
    @Override
    public void setFirstTimeSpel(Spel spel) throws RemoteException {
        if (a == 0) {
            this.spelServer = spel;
            i++;
        }
    }
    @Override
    public void setFirstTimeData(SpeelveldData veldD) throws RemoteException {
        if (b == 0) {
            this.veldServer = veldD;
            b++;
        }
    }

    @Override
    public void setSpelData(Spel spel, SpeelveldData veldD) throws RemoteException {

        this.veldServer = veldD;
        this.spelServer = spel;
        this.notifyObserversSpel(spel, veldD);

    }

    @Override
    public Spel updateGetSpel() throws RemoteException {
        return this.spelServer;
    }

    @Override
    public SpeelveldData updateGetData() throws RemoteException {
        return this.veldServer;
    }

    //---------------------------------->

    //    public synchronized void notifyObservers(Spel spel) throws RemoteException {
//        for (Interface client : Listeners) {
//            client.update(spel);
//        }
//        System.out.println("Notified observers");
//    }
    @Override
    public synchronized void registerObserver(ChatListenInterface listener) throws RemoteException {
        this.Listeners.add(listener);
        System.out.println("Listener added" + listener);
    }

    @Override
    public void registerObserverSpel(Interface gameListener) throws RemoteException {
        this.gameListeners.add(gameListener);
        System.out.println("Listener added" + gameListener);
    }

    @Override
    public synchronized void unregisterObserver(Interface gameListener) throws RemoteException {
        this.gameListeners.remove(gameListener);
    }

    @Override
    public synchronized void unregisterObserver(ChatListenInterface listener) throws RemoteException {
        this.Listeners.remove(listener);
    }


//    public void update(Spel spel) throws RemoteException {
//        spelC.setSpel(spel);
//    }


//    @Override
//    public void updateMessage(Message message) throws RemoteException {
//        System.out.println(message.getSenderName() + ": " + message.getMessage());
//    }

    @Override
    public void sendMessageObject(String user, String message) throws RemoteException {
        Message messageObject = new Message(user, message);
        this.notifyObserversMessage(messageObject);
    }
    @Override
    public synchronized void notifyObserversMessage(Message message) throws RemoteException {
        for (ChatListenInterface client : Listeners) {
            client.update(message);
        }
        System.out.println("Notified observers");
    }
    @Override
    public synchronized void notifyObserversSpel(Spel spelServer, SpeelveldData veldServer) throws RemoteException {
        for (ChatListenInterface client : Listeners) {
            client.receiveGame(spelServer, veldServer);
        }
        System.out.println("Notified observers");
    }
    public static void main(String[] args) throws Exception{
        InterfaceImpl impl = new InterfaceImpl();
    }
}

