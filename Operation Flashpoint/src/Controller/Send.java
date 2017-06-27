package Controller;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import Model.Message;

/**
 *
 * Send a message to the server.
*/

public class Send {

	private ServerInterface server = null;

	/**
	 * args[0] is server address or ip
	 * args[1] is user name
	 * args[1] is message to send
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("Send: Chat sender v2.0 starting up...");

		Send sender;
		String host;
		String username;
		String message;

		try {
			if ( args.length == 0 ){
				host = "127.0.0.1";
				username = "Unknown";
				message = "no message";

			} else {
				host = args[0];
				username = args[1];
				message = args[2];
			}

			System.out.println("Send: Create chat sender object");
			sender = new Send(host, username, message);
			System.out.println("Send: sender object created");

			System.out.println("Send: send message");
			sender.sendMessageObject(username, message);


		} catch (RemoteException re){
			System.out.println("An exception occured");
			re.printStackTrace();
		} catch (Exception e){
			System.out.println("An exception occured");
			e.printStackTrace();
		}
	}

	/**
	 * Constructor
	 *
	 * Create remote reference to server object.
	 */
	public Send(String host, String usernamej, String message) throws RemoteException, MalformedURLException, NotBoundException  {
		// Get reference to remote object, i.e. the server object (which will consume the message)
		this.server = (ServerInterface) Naming.lookup("//" + host +"/ChatService");
		//System.out.println("Send: looked up server in RMI Registry; \'ChatService\'");
	}

	/**
	 * Send message object to server
	 */
	
	void sendMessageObject(String user, String  message) throws RemoteException {

		Message messageObject = new Message(user,  message); // serialized object
		this.server.receiveMessage( messageObject );

	}


}
