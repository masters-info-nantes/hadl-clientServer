package fr.dralagen.alma.hadl.port;

import fr.dralagen.alma.hadl.connector.Connector;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class SQLQuery extends Connector {

    private DBQuery dbQuery;
    private QueryD queryD;

    public SQLQuery(RequiredPort from, ProvidedPort to) {
        super(from, to);
    }
}
