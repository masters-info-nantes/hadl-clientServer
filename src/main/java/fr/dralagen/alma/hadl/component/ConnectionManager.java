package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.port.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Observable;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class ConnectionManager extends AtomicComponent {

    private static final Logger log = LogManager.getLogger(ConnectionManager.class);

    public ConnectionManager() {
        log.debug("Add Port : SecurityCheck");
        SecurityCheck securityCheck = new SecurityCheck();
        addRequiredPort("SecurityCheck", securityCheck);

        log.debug("Add Port : DBQuery");
        DBQuery dbQuery = new DBQuery();
        addRequiredPort("DBQuery", dbQuery);

        log.debug("Add Port : ExternalSocket");
        ExternalSocket externalSocket = new ExternalSocket();
        addProvidedPort("ExternalSocket", externalSocket);
    }

    public ProvidedPort getExternalSocket() {
        return providedPort.get("ExternalSocket");
    }

    public RequiredPort getSecurityCheck() {
        return requiredPort.get("SecurityCheck");
    }

    public RequiredPort getDBQuery() {
        return requiredPort.get("DBQuery");
    }

    @Override
    public void update(Observable o, Object arg) {
        ProvidedPort externalSocket = getExternalSocket();

        if (o == externalSocket) {
            RequiredPort requiredPort = (RequiredPort) o;
            log.info("Receive ExternalSocket");
            requiredPort.receive(externalSocket.receive(arg));
        }

    }
}