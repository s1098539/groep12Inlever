package Main;

import Controller.SpelController;
import Model.*;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {
    public Kleur addSpeler(String naam) throws RemoteException;

    public Speler GetSpeler(Kleur kleur) throws RemoteException;

    public Spel updateGetSpel() throws RemoteException;

    //public void notifyObservers(Spel spel) throws RemoteException;

    public void notifyObserversMessage(Message message) throws RemoteException;

    public void registerObserver(ChatListenInterface listener) throws RemoteException;

    public void registerObserverSpel(Interface listener) throws RemoteException;


    public void unregisterObserver(ChatListenInterface listener) throws RemoteException;

    public void unregisterObserver(Interface gameListener) throws RemoteException;

    //public void update(Spel spel) throws RemoteException;

    // public void updateMessage(Message message) throws RemoteException;

    public void sendMessageObject(String user, String message) throws RemoteException;

    //public void update (Message message) throws RemoteException;

    public void setSpelData(Spel spel, SpeelveldData veldD) throws RemoteException;

    public void setFirstTimeSpel(Spel spel) throws RemoteException;

    public void setFirstTimeData(SpeelveldData veldD) throws RemoteException;

    public SpeelveldData updateGetData() throws RemoteException;

    public void notifyObserversSpel(Spel spelServer, SpeelveldData veldServer) throws RemoteException;

}