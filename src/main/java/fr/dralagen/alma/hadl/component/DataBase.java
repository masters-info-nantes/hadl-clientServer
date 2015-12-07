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

        log.debug("Add port : QueryD");
        QueryD queryD = new QueryD();
        addProvidedPort("QueryD", queryD);

        log.debug("Add port : SecurityManagement");
        SecurityManagement securityManagement = new SecurityManagement();
        addProvidedPort("SecurityManagement", securityManagement);
    }

    @Override
    public void update(Observable o, Object arg) {
        QueryD query = (QueryD) getProvidedPort("QueryD");
        SecurityManagement security = (SecurityManagement) getProvidedPort("SecurityManagement");
        if (o == query) {
            log.info(this.getClass().getSimpleName() + ": Execute query");
            query.setResponse("Hello " + arg + "!");
        } else if (o == security) {
            log.info(this.getClass().getSimpleName() + ": Check security query");
            if ("Bonjour".equals(arg)) {
                security.setResponse(false);
            } else {
                security.setResponse(true);
            }
        }
    }

    public ProvidedPort getQueryD() {
        return getProvidedPort("QueryD");
    }

    public ProvidedPort getSecurityManagement() {
        return getProvidedPort("SecurityManagement");
    }
}
