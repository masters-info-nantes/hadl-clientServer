package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.port.ProvidedPort;
import fr.dralagen.alma.hadl.port.QueryD;
import fr.dralagen.alma.hadl.port.SecurityManagement;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class DataBase extends AtomicComponent {

    public DataBase() {
        QueryD queryD = new QueryD();
        addProvidedPort("QueryD", queryD);

        SecurityManagement securityManagement = new SecurityManagement();
        addProvidedPort("SecurityManagement", securityManagement);
    }

    public ProvidedPort getQueryD() {
        return providedPort.get("QueryD");
    }

    public ProvidedPort getSecurityManagement() {
        return providedPort.get("SecurityManagement");
    }
}
