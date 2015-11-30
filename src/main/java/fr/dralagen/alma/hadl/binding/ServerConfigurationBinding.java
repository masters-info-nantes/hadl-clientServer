package fr.dralagen.alma.hadl.binding;

import fr.dralagen.alma.hadl.component.ServerConfiguration;
import fr.dralagen.alma.hadl.port.ProvidedPort;

/**
 * Created on 11/16/15.
 *
 * @author dralagen
 */
public class ServerConfigurationBinding implements Binding {

    private ProvidedPort socket;

    public ServerConfigurationBinding() {
        ServerConfiguration server = new ServerConfiguration();
        socket = server.getExternalSocket();
    }

    public Object bind(Object o) {
        return socket.receive(o);
    }

}
