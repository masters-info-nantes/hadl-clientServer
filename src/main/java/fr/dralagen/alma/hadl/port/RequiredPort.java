package fr.dralagen.alma.hadl.port;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public abstract class RequiredPort extends Port {

    private static final Logger log = LogManager.getLogger(RequiredPort.class);

    Object response;

    public Object sendRequest(Object req) {
        log.info("Transit Port : " + req);

        setChanged();
        notifyObservers(req);

        return response;
    }

    public Object receive(Object arg) {
        log.info("Response : " + arg.toString());

        response = arg;
        return response;
    }

    public void setResponse(Object res) {
        log.info("Response : " + res);
        response = res;
    }
}
