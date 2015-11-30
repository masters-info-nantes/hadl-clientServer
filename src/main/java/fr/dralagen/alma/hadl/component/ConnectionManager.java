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
        log.debug("Add port : SecurityCheck");
        SecurityCheck securityCheck = new SecurityCheck();
        addRequiredPort("SecurityCheck", securityCheck);

        log.debug("Add port : DBQuery");
        DBQuery dbQuery = new DBQuery();
        addRequiredPort("DBQuery", dbQuery);

        log.debug("Add port : ExternalSocket");
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
            log.info("Receive ExternalSocket");
            SecurityCheck security = (SecurityCheck) requiredPort.get("SecurityCheck");
            boolean access = (boolean) security.sendRequest(arg);
            if (access) {
                DBQuery query = (DBQuery) requiredPort.get("DBQuery");
                externalSocket.setResponse(query.sendRequest(arg));
            } else {
                externalSocket.setResponse("Access denied");
            }
        }

    }
}