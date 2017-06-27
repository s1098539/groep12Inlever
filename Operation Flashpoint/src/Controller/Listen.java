package Controller;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import Model.Message;

//listen to messages from server

public class Listen extends UnicastRemoteObject implements ListenInterface {

	private static final long serialVersionUID = 1L;

	public Listen(String serverAddress) throws RemoteException {
		super();
		System.out.println("Listen: Chat listener v2.0 starting up...");
		ServerInterface server = null;

		try {
			System.out.println("Listen: looking up Server in RMI Registry...");
			server = (ServerInterface) Naming.lookup("//" + serverAddress + "/ChatService");
		} catch (NotBoundException nbe){
			System.out.println(nbe);
		} catch (MalformedURLException mfue){
			System.out.println(mfue);
		}

		System.out.println("Listen: register ourself with server (for notification of new messages).");
		server.registerObserver(this);

	}

/**
 *
 * args[0] is servername or ip address
 *
 */
	public static void main(String[] args) throws Exception {

	}
	/**
	 * Get notified by server when new message arrives at server
	 */

	public void update(Message message) throws RemoteException {

		System.out.println(message.getSenderName() + ": " + message.getMessage());

	}
}