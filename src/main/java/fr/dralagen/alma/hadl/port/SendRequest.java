package fr.dralagen.alma.hadl.port;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class SendRequest extends RequiredPort {
    private String response;

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
