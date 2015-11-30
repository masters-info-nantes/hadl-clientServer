package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.port.ProvidedPort;
import fr.dralagen.alma.hadl.port.QueryD;
import fr.dralagen.alma.hadl.port.SecurityManagement;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Observable;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class DataBase extends AtomicComponent {

    private static final Logger log = LogManager.getLogger(DataBase.class);

    public DataBase() {

        log.debug("Add Port : QueryD");
        QueryD queryD = new QueryD();
        addProvidedPort("QueryD", queryD);

        log.debug("Add Port : SecurityManagement");
        SecurityManagement securityManagement = new SecurityManagement();
        addProvidedPort("SecurityManagement", securityManagement);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public ProvidedPort getQueryD() {
        return providedPort.get("QueryD");
    }

    public ProvidedPort getSecurityManagement() {
        return providedPort.get("SecurityManagement");
    }
}
