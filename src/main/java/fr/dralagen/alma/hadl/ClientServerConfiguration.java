package fr.dralagen.alma.hadl;

/**
 * Created on 11/16/15.
 *
 * @author dralagen
 */
public class ClientServerConfiguration implements Configuration {

    private RPC rpc;
    private Client client;
    private Server server;

    public ClientServerConfiguration(Client client, Server server) {
        this.client = client;
        this.server = server;

        rpc = new RPC(client.getRequest(), server.getRequest());

    }

    public static void main(String[] args) {

        Client client = new Client();
        ClientServerConfiguration clientServer = new ClientServerConfiguration(client, new Server());
    }
}
