package fr.dralagen.alma.hadl.port;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Observable;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class ProvidedPort extends Port {

    private static final Logger log = LogManager.getLogger(ProvidedPort.class);

    private Object response;

    public Object receive(Object arg) {
        log.info("Receive : " + arg);
        setChanged();
        notifyObservers(arg);

        return response;
    }

    public void setResponse(Object res) {
        log.info("Response : " + res);
        response = res;
    }
}
