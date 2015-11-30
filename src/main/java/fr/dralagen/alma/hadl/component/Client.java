package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.port.RequiredPort;
import fr.dralagen.alma.hadl.port.SendRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Observable;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class Client extends AtomicComponent {

    private static final Logger log = LogManager.getLogger(Client.class);

    public Client() {
        log.debug("Add port : SendRequest");
        addRequiredPort("sendRequest", new SendRequest());
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public RequiredPort getRequest() {
        return requiredPort.get("sendRequest");
    }

    public String executeRequest(String req) {
        log.info("Execute request : " + req);
        return (String) requiredPort.get("sendRequest").sendRequest(req);
    }
}
