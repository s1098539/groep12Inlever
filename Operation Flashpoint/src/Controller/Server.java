package Controller;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*;
import java.util.ArrayList;
import Model.Message;
/**
 * Receives message objects from send clients and sends the message object to all registered
 * listen clients
z
 * Here the server object is the remote object itself (UnicastRemoteObject)
 *
 * Usage:
 * 	java -cp bin Server
 * 	vanuit project directory RMIChat
 *
 * @author Koen Warner, 2016
 *
 */
public class Server extends UnicastRemoteObject implements ServerInterface {

	private static final long serialVersionUID = 1L;
	// A list of registered listener clients
	private ArrayList<ListenInterface> chatListeners = new ArrayList<ListenInterface>();
	// Port where RMI Registry listens
	private int port = 1099;


	public Server() throws RemoteException {

		System.out.println("Server: Server v2.0 starting up...");

		try {
			// Connect to RMI Registry
			LocateRegistry.createRegistry(port);
			System.out.println("Server: connected to RMI registry.");
			// Register this server object in the RMI Registry
			Naming.rebind("ChatService", this);
			System.out.println("Server: server registered as \'ChatService\' in RMI registry.");
		} catch (MalformedURLException mfue) {
			System.out.println(mfue);
		} catch (RemoteException re){
			System.out.println(re);
		}
	}

	/**
	 *	Start up server
	 */
	public static void main(String args[]) throws Exception {
		Server Chat = new Server();
		System.out.println("Server: Server running.");
	}

	/**
	 *	Receive message from Send object and resent to all registered Listen objects
	 */
	public synchronized void notifyObservers(Message message) throws RemoteException {
	    for (ListenInterface client : chatListeners) {
	    	client.update(message);

	    }
	}

	/**
	 *	Register a Listen object as an observer
	 */
	public synchronized void registerObserver(ListenInterface listener) throws RemoteException {
		this.chatListeners.add(listener);
	}


	/**
	 *	Unregister a Listen object as an observer
	 */
	public synchronized void unregisterObserver(ListenInterface listener) throws RemoteException {
		System.out.println("Server: removinglistener");
		this.chatListeners.remove(listener);
		System.out.println("Server: listener removed");
	}

	/**
	 *	Receive message from send client and notify all listeners
	 */
	public synchronized void receiveMessage(Message msg){

		try {
			this.notifyObservers(msg);

		} catch (RemoteException re) {

		}

	}
}
