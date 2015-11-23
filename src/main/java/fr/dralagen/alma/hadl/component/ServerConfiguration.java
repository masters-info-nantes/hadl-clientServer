package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.binding.ServerBinding;

/**
 * Created on 11/16/15.
 *
 * @author dralagen
 */
public class ServerConfiguration implements Configuration {

    private ConnectionManager connectionManager;
    private SecurityManager securityManager;
    private DataBase dataBase;

    private ServerBinding binding;
}
