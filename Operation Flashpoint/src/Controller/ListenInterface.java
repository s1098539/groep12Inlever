package Controller;
import java.rmi.*;
import Model.Message;

/**
 * Interface for ChatClient
*/

public interface ListenInterface extends Remote {

	// Registry ChatClient with server, to be able to receive message from the server
	void update(Message message)  throws RemoteException;
}
