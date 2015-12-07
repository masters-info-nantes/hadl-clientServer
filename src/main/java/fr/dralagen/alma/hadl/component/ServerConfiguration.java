package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.attachment.Attachment;
import fr.dralagen.alma.hadl.connector.ClearanceRequest;
import fr.dralagen.alma.hadl.connector.SQLQuery;
import fr.dralagen.alma.hadl.connector.SecurityQuery;
import fr.dralagen.alma.hadl.port.ProvidedPort;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Observable;

/**
 * Created on 11/16/15.
 *
 * @author dralagen
 */
public class ServerConfiguration extends Configuration {

    private static Logger log = LogManager.getLogger(ServerConfiguration.class);

    public ServerConfiguration() {

        log.debug("Add component : ConnectionManager");
        ConnectionManager connectionManager = new ConnectionManager();
        addComponent("ConnectionManager", connectionManager);

        log.debug("Add component : SecurityManager");
        SecurityManager securityManager = new SecurityManager();
        addComponent("SecurityManager", securityManager);

        log.debug("Add component : DataBase");
        DataBase dataBase = new DataBase();
        addComponent("DataBase", dataBase);

        log.debug("Add connector : ClearanceRequest");
        ClearanceRequest clearanceRequest = new ClearanceRequest();
        addConnector(clearanceRequest);

        log.debug("Add connector : SQLQuery");
        SQLQuery sqlQuery = new SQLQuery();
        addConnector(sqlQuery);

        log.debug("Add connector : SecurityQuery");
        SecurityQuery securityQuery = new SecurityQuery();
        addConnector(securityQuery);

        new Attachment(clearanceRequest.getCalled(), connectionManager.getSecurityCheck());
        new Attachment(clearanceRequest.getCaller(), securityManager.getSecurityAuthentication());

        new Attachment(sqlQuery.getCalled(), connectionManager.getDBQuery());
        new Attachment(sqlQuery.getCaller(), dataBase.getQueryD());

        new Attachment(securityQuery.getCalled(), securityManager.getCheckQuery());
        new Attachment(securityQuery.getCaller(), dataBase.getSecurityManagement());

    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public ProvidedPort getExternalSocket() {
        return ((ConnectionManager) component.get("ConnectionManager")).getExternalSocket();
    }
}
