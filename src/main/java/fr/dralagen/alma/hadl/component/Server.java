package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.binding.ServerConfigurationBinding;
import fr.dralagen.alma.hadl.port.ProvidedPort;
import fr.dralagen.alma.hadl.port.ReceiveRequest;

import java.util.Observable;
import java.util.Observer;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class Server extends Component implements Observer {

    private ServerConfigurationBinding binding;

    public Server() {
        ProvidedPort request = new ReceiveRequest();
        addProvidedPort("receiveRequest", request);
        binding = new ServerConfigurationBinding();
    }

    public ProvidedPort getRequest() {
        return providedPort.get("receiveRequest");
    }

    public ServerConfigurationBinding getBinding() {
        return binding;
    }


    public void update(Observable o, Object arg) {
        ProvidedPort request = providedPort.get("receiveRequest");

        if (o == request) {
            request.setResponse("koin");
        }
    }
}
