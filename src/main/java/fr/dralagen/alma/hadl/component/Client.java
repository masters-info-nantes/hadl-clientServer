package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.port.RequiredPort;
import fr.dralagen.alma.hadl.port.SendRequest;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class Client extends AtomicComponent {

    public Client() {
        addRequiredPort("sendRequest", new SendRequest());
    }

    public RequiredPort getRequest() {
        return requiredPort.get("sendRequest");
    }

    public String executeRequest(String req) {
        return requiredPort.get("sendRequest").sendRequest(req);
    }
}
