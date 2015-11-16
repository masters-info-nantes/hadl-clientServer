package fr.dralagen.alma.hadl;

import java.util.Observable;
import java.util.Observer;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class Connector implements Observer {
    private ProvidedPort to;
    private final RequiredPort from;

    public Connector(RequiredPort from, ProvidedPort to) {
        this.to = to;
        this.from = from;

        this.from.addObserver(this);
    }

    public void update(Observable o, Object arg) {
            if ( o == from ) {
                String response = (String) to.receive(arg);
                from.receive(response);
                System.out.println(response);
            }
    }
}
