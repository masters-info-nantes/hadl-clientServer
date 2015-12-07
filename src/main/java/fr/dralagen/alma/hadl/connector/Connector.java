package fr.dralagen.alma.hadl.connector;

import fr.dralagen.alma.hadl.role.CallerRole;
import fr.dralagen.alma.hadl.role.CalledRole;
import fr.dralagen.alma.hadl.role.Role;
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

    private CalledRole called;
    private CallerRole caller;

    public Connector() {
        this.called = new CalledRole();
        this.caller = new CallerRole();

        this.called.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        if (o == called) {
            glue(arg);
        }
    }

    public void glue(Object arg) {
        log.info(this.getClass().getSimpleName() + ": Transmit Request Called to Caller : " + arg);
        Object response = caller.receive(arg);
        log.info(this.getClass().getSimpleName() + ": Transmit Response Caller to called : " + response);
        called.setResponse(response);
    }

    public Role getCalled() {
        return called;
    }

    public Role getCaller(){
        return caller;
    }
}
