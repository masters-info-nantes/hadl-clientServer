package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.port.CheckQuery;
import fr.dralagen.alma.hadl.port.SecurityAuthentication;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public class SecurityManager extends AtomicComponent {

    private SecurityAuthentication authentication;
    private CheckQuery checkQuery;

}
