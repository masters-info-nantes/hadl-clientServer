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
        return getProvidedPort("ExternalSocket");
    }

    public RequiredPort getSecurityCheck() {
        return getRequiredPort("SecurityCheck");
    }

    public RequiredPort getDBQuery() {
        return getRequiredPort("DBQuery");
    }

    @Override
    public void update(Observable o, Object arg) {
        ProvidedPort externalSocket = getExternalSocket();

        if (o == externalSocket) {
            log.info(this.getClass().getSimpleName() + ": Receive ExternalSocket");
            SecurityCheck security = (SecurityCheck) getRequiredPort("SecurityCheck");
            boolean access = (boolean) security.sendRequest(arg);
            log.info(this.getClass().getSimpleName() + ": Receive Security check : " + access);
            if (access) {
                DBQuery query = (DBQuery) getRequiredPort("DBQuery");
                Object response = query.sendRequest(arg);
                log.info(this.getClass().getSimpleName() + ": Return response : " + response);
                externalSocket.setResponse(response);
            } else {
                log.info(this.getClass().getSimpleName() + ": Return error : Access denied");
                externalSocket.setResponse("Access denied");
            }
        }

    }
}