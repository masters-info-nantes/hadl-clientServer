package fr.dralagen.alma.hadl.connector;

import fr.dralagen.alma.hadl.port.ProvidedPort;
import fr.dralagen.alma.hadl.port.RequiredPort;

import java.util.Observable;
import java.util.Observer;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class Connector implements Observer {
    private final RequiredPort from;
    private ProvidedPort to;

    public Connector(RequiredPort from, ProvidedPort to) {
        this.to = to;
        this.from = from;

        this.from.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        if (o == from) {
            String response = (String) to.receive(arg);
            from.receive(response);
            System.out.println(response);
        }
    }

    public void glue(Object arg) {

    }

}
