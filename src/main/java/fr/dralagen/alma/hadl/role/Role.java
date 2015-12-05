package fr.dralagen.alma.hadl.role;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Observable;

/**
 * Created by nicolas on 11/30/15.
 */
public class Role extends Observable {

    private static final Logger log = LogManager.getLogger(Role.class);
    private Object response;
    private boolean used;


    public Object receive(Object arg) {
        log.info("Receive : " + arg);
        setChanged();
        notifyObservers(arg);

        return response;
    }

    public void setResponse(Object res) {
        log.info("Response : " + res);
        response = res;
    }


    public Object sendRequest(Object req) {
        log.info("Transit Port : " + req);

        setChanged();
        notifyObservers(req);

        return response;
    }

    public boolean isAlreadyUsed(){
        return used;
    }


    public void setUsed(boolean used){
        this.used = used;
    }
}
