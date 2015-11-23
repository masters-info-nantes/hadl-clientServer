package fr.dralagen.alma.hadl.connector;

import fr.dralagen.alma.hadl.port.ProvidedPort;
import fr.dralagen.alma.hadl.port.RequiredPort;
import fr.dralagen.alma.hadl.port.SecurityAuthentication;
import fr.dralagen.alma.hadl.port.SecurityCheck;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class ClearanceRequest extends Connector {
    private SecurityCheck securityCheck;
    private SecurityAuthentication authentication;

    public ClearanceRequest(RequiredPort from, ProvidedPort to) {
        super(from, to);
    }
}
