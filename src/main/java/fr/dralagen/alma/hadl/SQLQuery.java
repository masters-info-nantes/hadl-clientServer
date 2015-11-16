package fr.dralagen.alma.hadl;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class SQLQuery extends Connector {
    DBQuery dbQuery;
    QueryD queryD;

    public SQLQuery(RequiredPort from, ProvidedPort to) {
        super(from, to);
    }
}
