package coursefeedback.gui;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 *
 * @author Pawat Nakpiphatkul
 */
public class Sender extends Observable {
    
    private static Sender instance;
    
    private Sender() {}
    
    public void sent(Object obj) {
        setChanged();
        notifyObservers(obj);
    }
    
    public static Sender getInstance() {
        if(instance == null) instance = new Sender();
        return instance;
    }
}
