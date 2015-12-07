package fr.dralagen.alma.hadl.attachment;

import fr.dralagen.alma.hadl.port.Port;
import fr.dralagen.alma.hadl.role.CallerRole;
import fr.dralagen.alma.hadl.role.Role;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by nicolas on 11/30/15.
 */
public class Attachment implements Observer {

    private static final Logger log = LogManager.getLogger(Attachment.class);

    private Role role;
    private Port port;

    public Attachment(Role role, Port port) {
        this.role = role;
        this.port = port;
        if (role instanceof CallerRole) {
            this.role.addObserver(this);
        } else {
            this.port.addObserver(this);
        }
    }

    //Check for send or receive request
    @Override
    public void update(Observable o, Object arg) {
        if (o == port) {
            log.info(this.getClass().getSimpleName() + ": Transmit Request Port to Role : " + arg);
            Object response = role.receive(arg);
            log.info(this.getClass().getSimpleName() + ": Transmit Response Role to Port : " + response);
            port.setResponse(response);
        } else if (o == role) {
            log.info(this.getClass().getSimpleName() + ": Transmit Request Port to Role : " + arg);
            Object response = port.receive(arg);
            log.info(this.getClass().getSimpleName() + ": Transmit Response Role to Port : " + response);
            role.setResponse(response);
        }
    }
}
