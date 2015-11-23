package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.connector.RPC;

/**
 * Created on 11/16/15.
 *
 * @author dralagen
 */
public class ClientServerConfiguration extends Configuration {

    public static void main(String[] args) {

        Client client = new Client();
        Server server = new Server();

        ClientServerConfiguration clientServer = new ClientServerConfiguration();
        clientServer.addComponent(client);
        clientServer.addComponent(server);
        clientServer.addConnector(new RPC(client.getRequest(), server.getRequest()));

        System.out.println("main : " + client.executeRequest("koin"));
    }
}
