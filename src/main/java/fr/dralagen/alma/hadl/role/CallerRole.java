package fr.dralagen.alma.hadl.role;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by nicolas on 11/30/15.
 */
public class CallerRole extends Role {

    private static final Logger log = LogManager.getLogger(CallerRole.class);

    public Object receive(Object arg) {
        log.info(this.getClass().getSimpleName() + ": Receive : " + arg);
        setChanged();
        notifyObservers(arg);

        log.info(this.getClass().getSimpleName() + ": Response : " + response);
        return response;
    }

}
