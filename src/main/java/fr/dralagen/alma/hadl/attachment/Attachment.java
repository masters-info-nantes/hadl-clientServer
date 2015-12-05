package fr.dralagen.alma.hadl.attachment;

import fr.dralagen.alma.hadl.port.Port;
import fr.dralagen.alma.hadl.role.Role;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by nicolas on 11/30/15.
 */
public class Attachment implements Observer {

    private Role role;
    private Port port;

    public Attachment(Role role, Port port) {
        this.role = role;
        this.role.addObserver(this);
        this.port = port;
        this.port.addObserver(this);
    }

    //Check for send or receive request
    @Override
    public void update(Observable o, Object arg) {
        if (o == role) {
            role.receive(port.receive(arg));
        } else if (o == port) {
            port.receive(role.receive(arg));
        }
    }
}
