package fr.dralagen.alma.hadl.connector;

import fr.dralagen.alma.hadl.port.DBQuery;
import fr.dralagen.alma.hadl.port.ProvidedPort;
import fr.dralagen.alma.hadl.port.QueryD;
import fr.dralagen.alma.hadl.port.RequiredPort;

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
