package fr.dralagen.alma.hadl.role;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Observable;

/**
 * Created by nicolas on 11/30/15.
 */
public abstract class Role extends Observable {

    protected Object response;

    public abstract Object receive(Object arg);

    public void setResponse(Object res) {
        response = res;
    }
}
