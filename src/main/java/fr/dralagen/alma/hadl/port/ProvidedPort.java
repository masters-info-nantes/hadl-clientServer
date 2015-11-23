package fr.dralagen.alma.hadl.port;

import java.util.Observable;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class ProvidedPort extends Observable implements Port {
    private String response;

    public Object receive(Object arg) {
        setChanged();
        notifyObservers(arg);

        return response;
    }

    public void setResponse(String res) {
        response = res;
    }
}
