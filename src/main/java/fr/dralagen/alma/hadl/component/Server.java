package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.binding.ServerConfigurationBinding;
import fr.dralagen.alma.hadl.port.ReceiveRequest;

import java.util.Observable;
import java.util.Observer;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class Server extends Component implements Observer {

    private ReceiveRequest request;

    private ServerConfigurationBinding binding;

    public Server() {
        request = new ReceiveRequest();
        request.addObserver(this);
        binding = new ServerConfigurationBinding();
    }

    public ReceiveRequest getRequest() {
        return request;
    }

    public ServerConfigurationBinding getBinding() {
        return binding;
    }


    public void update(Observable o, Object arg) {

        if (o == request) {
            request.setResponse("koin");
        }
    }
}
