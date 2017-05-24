package coursefeedback.gui;

/**
 * Class for pack to sent by Sender.
 * @author Pawat Nakpiphatkul
 */
public class SendPackage {

    private String message;
    private Object object;

    /**
     * Constructor for initialize SendPackage.
     * @param obj is an object to pack.
     * @param msg is a message to pack.
     */
    public SendPackage(Object obj, String msg) {
        message = msg;
        object = obj;
    }

    /**
     * Get the message in the pack.
     * @return the message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Get the object in the pack.
     * @return the object.
     */
    public Object getObject() {
        return object;
    }
}

