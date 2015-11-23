package fr.dralagen.alma.hadl.port;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class ReceiveRequest extends ProvidedPort {
    public Object receive(Object arg) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println((String)arg);
        return arg;
    }
}
