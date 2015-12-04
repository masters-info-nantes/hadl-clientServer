package fr.dralagen.alma.hadl.connector;

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

    private Role[] roles;
    private Role firstRole;
    private Role secondRole;

    public Connector() {
        this.firstRole = new Role();
        this.secondRole = new Role();

        this.firstRole.addObserver(this);
        this.secondRole.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        log.info("Transmit From to To : " + arg);
        Object response = firstRole.receive(arg);
        log.info("Transmit To to From : " + response);
        secondRole.receive(response);
    }

    public void glue(Object arg) {

    }

    public Role getFirstRole() {
        return firstRole;
    }

    public Role getSecondRole(){
        return secondRole;
    }
}
