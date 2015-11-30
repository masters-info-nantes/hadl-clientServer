package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.port.CheckQuery;
import fr.dralagen.alma.hadl.port.ProvidedPort;
import fr.dralagen.alma.hadl.port.RequiredPort;
import fr.dralagen.alma.hadl.port.SecurityAuthentication;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class SecurityManager extends AtomicComponent {

    public SecurityManager() {
        SecurityAuthentication auth = new SecurityAuthentication();
        addProvidedPort("SecurityAuth", auth);

        CheckQuery checkQuery = new CheckQuery();
        addRequiredPort("CheckQuery", checkQuery);
    }

    public ProvidedPort getSecurityAuth() {
        return providedPort.get("SecurityAuth");
    }

    public RequiredPort getCheckQuery() {
        return requiredPort.get("CheckQuery");
    }
}
