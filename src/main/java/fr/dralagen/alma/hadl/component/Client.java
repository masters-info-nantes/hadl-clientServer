package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.port.SendRequest;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class Client extends AtomicComponent {

    private SendRequest request;

    public Client() {
        this.request = new SendRequest();
    }

    public SendRequest getRequest() {
        return request;
    }

    public String executeRequest(String req) {
        return request.sendRequest(req);
    }
}
