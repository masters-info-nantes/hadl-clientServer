package fr.dralagen.alma.hadl;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class Server extends Component {

    ReceiveRequest request;

    ServerConfigurationBinding binding;

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
