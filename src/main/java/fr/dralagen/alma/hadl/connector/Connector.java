package fr.dralagen.alma.hadl.connector;

import fr.dralagen.alma.hadl.port.ProvidedPort;
import fr.dralagen.alma.hadl.port.RequiredPort;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Observable;
import java.util.Observer;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class Connector implements Observer {

    private static final Logger log = LogManager.getLogger(Connector.class);

    private final RequiredPort from;
    private final ProvidedPort to;

    public Connector(RequiredPort from, ProvidedPort to) {
        this.to = to;
        this.from = from;

        this.from.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        if (o == from) {
            log.info("Transmit From to To : " + arg);
            Object response = to.receive(arg);
            log.info("Transmit To to From : " + response);
            from.receive(response);
        }
    }

    public void glue(Object arg) {

    }

}
