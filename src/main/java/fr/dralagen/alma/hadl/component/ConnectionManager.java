package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.port.*;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class ConnectionManager extends AtomicComponent {

    public ConnectionManager() {
        addRequiredPort("SecurityCheck", new SecurityCheck());
        addRequiredPort("DBQuery", new DBQuery());

        addProvidedPort("ExternalSocket", new ExternalSocket());
    }

    public ProvidedPort getSocket() {
        return providedPort.get("ExternalSocket");
    }

    public RequiredPort getSecuriyCheck() {
        return requiredPort.get("SecurityCheck");
    }

    public RequiredPort getDBQuery() {
        return requiredPort.get("DBQuery");
    }
}
