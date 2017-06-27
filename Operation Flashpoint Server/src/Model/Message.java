package Model;
import java.io.Serializable;

/**
 * Message to be send from Send to Listen
z
 * @author Koen Warner, 2016
 *
 */
public class Message implements Serializable {

	private String message  = "";
	private String senderName = "";

	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public Message (String senderName, String message) {
		this.senderName = senderName;
		this.message = message;
	}


}
