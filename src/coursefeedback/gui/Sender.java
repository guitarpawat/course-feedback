package coursefeedback.gui;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pawat Nakpiphatkul
 */
public class Sender extends Observable {
    
    private static Sender instance;
    
    private Sender() {}
    
    public void sent(Object obj,String msg) {
        send(new SendPackage(obj, msg));
    }
    
    public void send(SendPackage obj) {
        try {
            Thread.sleep(320L);
        } catch (InterruptedException ex) {}
        finally {
            setChanged();
            notifyObservers(obj);
        }
    }
    
    public static Sender getInstance() {
        if(instance == null) instance = new Sender();
        return instance;
    }
}

class SendPackage {
    
    private String message;
    private Object object;
    
    public SendPackage(Object obj,String msg) {
        message = msg;
        object = obj;
    }
    
    public String getMessage() {
        return message;
    }
    
    public Object getObject() {
        return object;
    }
}