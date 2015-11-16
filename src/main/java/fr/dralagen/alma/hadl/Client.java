package fr.dralagen.alma.hadl;

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
}
