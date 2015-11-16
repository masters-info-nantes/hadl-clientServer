package fr.dralagen.alma.hadl;

import java.util.Observable;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public abstract class RequiredPort extends Observable implements Port  {

    public Object receive(Object arg) {
        return null;
    }

}
