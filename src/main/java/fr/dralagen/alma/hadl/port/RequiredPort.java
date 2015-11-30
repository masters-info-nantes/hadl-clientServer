package fr.dralagen.alma.hadl.port;

import java.util.Observable;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public abstract class RequiredPort extends Observable implements Port {

    String response;

    public String sendRequest(String req) {
        setChanged();
        notifyObservers(req);

        return response;
    }

    public Object receive(Object arg) {
        response = (String) arg;
        return response;
    }

}
