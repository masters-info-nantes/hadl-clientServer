package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.port.DBQuery;
import fr.dralagen.alma.hadl.port.SecurityCheck;
import fr.dralagen.alma.hadl.port.ExternalSocket;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class ConnectionManager extends AtomicComponent {

    private ExternalSocket socket;
    private SecurityCheck securiyCheck;
    private DBQuery query;

}
