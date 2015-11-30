package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.port.CheckQuery;
import fr.dralagen.alma.hadl.port.ProvidedPort;
import fr.dralagen.alma.hadl.port.RequiredPort;
import fr.dralagen.alma.hadl.port.SecurityAuthentication;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Observable;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class SecurityManager extends AtomicComponent {

    private static final Logger log = LogManager.getLogger(SecurityManager.class);

    public SecurityManager() {
        log.debug("Add Port : SecurityAuthentication");
        SecurityAuthentication auth = new SecurityAuthentication();
        addProvidedPort("SecurityAuthentication", auth);

        log.debug("Add Port : CheckQuery");
        CheckQuery checkQuery = new CheckQuery();
        addRequiredPort("CheckQuery", checkQuery);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public ProvidedPort getSecurityAuthentication() {
        return providedPort.get("SecurityAuthentication");
    }

    public RequiredPort getCheckQuery() {
        return requiredPort.get("CheckQuery");
    }
}
