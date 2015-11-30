package fr.dralagen.alma.hadl.binding;

import fr.dralagen.alma.hadl.port.Port;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public abstract class Binding {

    private static final Logger log = LogManager.getLogger(Binding.class);

    protected Port port;

    public Binding() {
    }

    protected void setPort(Port p) {
        port = p;
    }

    public Object bind(Object arg) {
        log.info("Binding port : " + arg);
        Object response = port.receive(arg);
        log.info("Binding response : " + response);
        return response;
    }
}
