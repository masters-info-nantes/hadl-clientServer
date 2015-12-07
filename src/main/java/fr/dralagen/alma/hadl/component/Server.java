package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.binding.ServerConfigurationBinding;
import fr.dralagen.alma.hadl.port.ProvidedPort;
import fr.dralagen.alma.hadl.port.ReceiveRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Observable;
import java.util.Observer;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class Server extends Component implements Observer {

    private static final Logger log = LogManager.getLogger(Server.class);

    private ServerConfigurationBinding binding;

    public Server() {
        ProvidedPort request = new ReceiveRequest();
        log.debug("Add port : receiveRequest");
        addProvidedPort("receiveRequest", request);

        binding = new ServerConfigurationBinding();
    }

    public ProvidedPort getRequest() {
        return getProvidedPort("receiveRequest");
    }

    public ServerConfigurationBinding getBinding() {
        return binding;
    }


    public void update(Observable o, Object arg) {
        ProvidedPort request = getProvidedPort("receiveRequest");

        if (o == request) {
            log.info(this.getClass().getSimpleName() + ": Receive request : " + arg);
            request.setResponse(binding.bind(arg));
        }
    }
}
