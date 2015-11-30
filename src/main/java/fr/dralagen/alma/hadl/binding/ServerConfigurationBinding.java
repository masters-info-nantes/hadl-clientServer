package fr.dralagen.alma.hadl.binding;

import fr.dralagen.alma.hadl.component.ServerConfiguration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created on 11/16/15.
 *
 * @author dralagen
 */
public class ServerConfigurationBinding extends Binding {

    private static final Logger log = LogManager.getLogger(ServerConfigurationBinding.class);

    private ServerConfiguration server;

    public ServerConfigurationBinding() {
        super();

        log.debug("Create server configuration");
        server = new ServerConfiguration();

        setPort(server.getExternalSocket());
    }

}
