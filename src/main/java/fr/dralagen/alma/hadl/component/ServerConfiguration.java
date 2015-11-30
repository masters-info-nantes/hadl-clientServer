package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.connector.ClearanceRequest;
import fr.dralagen.alma.hadl.connector.SecurityQuery;
import fr.dralagen.alma.hadl.port.SQLQuery;

import java.util.Observable;

/**
 * Created on 11/16/15.
 *
 * @author dralagen
 */
public class ServerConfiguration extends Configuration {

    public ServerConfiguration() {

        ConnectionManager connectionManager = new ConnectionManager();
        addComponent(connectionManager);

        SecurityManager securityManager = new SecurityManager();
        addComponent(securityManager);

        DataBase dataBase = new DataBase();
        addComponent(dataBase);

        ClearanceRequest clearanceRequest = new ClearanceRequest(
                connectionManager.getSecurityCheck(),
                securityManager.getSecurityAuthentication()
        );
        addConnector(clearanceRequest);

        SQLQuery sqlQuery = new SQLQuery(
                connectionManager.getDBQuery(),
                dataBase.getQueryD()
        );
        addConnector(sqlQuery);

        SecurityQuery securityQuery = new SecurityQuery(
                securityManager.getCheckQuery(),
                dataBase.getSecurityManagement()
        );

    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
