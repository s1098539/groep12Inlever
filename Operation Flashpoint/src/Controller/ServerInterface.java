package Controller;
import Model.Message;
import java.rmi.*;

//server interface

public interface ServerInterface extends Remote {

    // send an message object to all other clients
    void notifyObservers(Message message) throws RemoteException;
    // registerObserver a listener (listener client)
    void registerObserver(ListenInterface listen) throws RemoteException;
	// unregisterObserver a listener  (listener client)
	void unregisterObserver(ListenInterface listen) throws RemoteException;
	// receive message from a client
	void receiveMessage(Message msg) throws RemoteException;
}
