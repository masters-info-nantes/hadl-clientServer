package fr.dralagen.alma.hadl.binding;

import fr.dralagen.alma.hadl.port.ExternalSocket;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class ServerBinding extends Binding {
    ExternalSocket connectionManagerRequest;

    public ServerBinding() {
        super();

        setPort(connectionManagerRequest);
    }
}
