package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.binding.ServerConfigurationBinding;
import fr.dralagen.alma.hadl.component.Component;
import fr.dralagen.alma.hadl.port.ReceiveRequest;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class Server extends Component {

    private ReceiveRequest request;

    private ServerConfigurationBinding binding;

    public Server() {
        request = new ReceiveRequest();
        binding = new ServerConfigurationBinding();
    }

    public ReceiveRequest getRequest() {
        return request;
    }

    public ServerConfigurationBinding getBinding() {
        return binding;
    }
}
