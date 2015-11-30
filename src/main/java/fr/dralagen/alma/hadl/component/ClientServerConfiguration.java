package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.connector.RPC;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Observable;

/**
 * Created on 11/16/15.
 *
 * @author dralagen
 */
public class ClientServerConfiguration extends Configuration {

    private static final Logger log = LogManager.getLogger(ClientServerConfiguration.class);

    public static void main(String[] args) {

        Client client = new Client();
        Server server = new Server();

        ClientServerConfiguration clientServer = new ClientServerConfiguration();
        log.debug("Add component : client");
        clientServer.addComponent("Client", client);
        log.debug("Add component : server");
        clientServer.addComponent("Server", server);

        log.debug("Add connector : RPC");
        clientServer.addConnector(new RPC(client.getRequest(), server.getRequest()));

        System.out.println("main : " + client.executeRequest("koin"));
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
