package fr.dralagen.alma.hadl.connector;

import fr.dralagen.alma.hadl.port.CheckQuery;
import fr.dralagen.alma.hadl.port.ProvidedPort;
import fr.dralagen.alma.hadl.port.RequiredPort;
import fr.dralagen.alma.hadl.port.SecurityManagement;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class SecurityQuery extends Connector {
    private SecurityManagement securityManagement;
    private CheckQuery checkQuery;

    public SecurityQuery(RequiredPort from, ProvidedPort to) {
        super(from, to);
    }
}
