package fr.dralagen.alma.hadl;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class ClearanceRequest extends Connector {
    SecurityCheck securityCheck;
    SecurityAuthentication authentication;

    public ClearanceRequest(RequiredPort from, ProvidedPort to) {
        super(from, to);
    }
}
