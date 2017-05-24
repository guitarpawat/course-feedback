package coursefeedback.gui;

import java.util.Observable;

/**
 * Class for sending object to another class.
 * @author Pawat Nakpiphatkul
 */
public class Sender extends Observable {

    private static Sender instance;

    private Sender() {
    }

    /**
     * Sent a package by notifying observer.
     * @param obj is an object to send.
     * @param msg is an message to send.
     */
    public void send(Object obj, String msg) {
        Sender.this.send(new SendPackage(obj, msg));
    }

    /**
     * Sent a package by notifying observer.
     * @param obj is an sent package.
     */
    public void send(SendPackage obj) {
        try {
            Thread.sleep(320L);
        } catch (InterruptedException ex) {
        } finally {
            setChanged();
            notifyObservers(obj);
        }
    }

    /**
     * Get the instance of this class.
     * @return the instance.
     */
    public static Sender getInstance() {
        if (instance == null) {
            instance = new Sender();
        }
        return instance;
    }
}