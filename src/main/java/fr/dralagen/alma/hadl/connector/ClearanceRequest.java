package fr.dralagen.alma.hadl.connector;

import fr.dralagen.alma.hadl.port.ProvidedPort;
import fr.dralagen.alma.hadl.port.RequiredPort;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class ClearanceRequest extends Connector {

    public ClearanceRequest(RequiredPort from, ProvidedPort to) {
        super(from, to);
    }
}
