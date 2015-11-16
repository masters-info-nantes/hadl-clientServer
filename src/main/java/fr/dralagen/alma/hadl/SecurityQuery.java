package fr.dralagen.alma.hadl;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class SecurityQuery extends Connector {
    SecurityManagement securityManagement;
    CheckQuery checkQuery;

    public SecurityQuery(RequiredPort from, ProvidedPort to) {
        super(from, to);
    }
}
