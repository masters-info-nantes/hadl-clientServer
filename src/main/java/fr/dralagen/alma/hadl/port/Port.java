package fr.dralagen.alma.hadl.port;

import java.util.Observable;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public abstract class Port extends Observable {
    public abstract Object receive(Object arg);

    public abstract void setResponse(Object response);
}
