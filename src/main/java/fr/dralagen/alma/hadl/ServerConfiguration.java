package fr.dralagen.alma.hadl;

/**
 * Created on 11/16/15.
 *
 * @author dralagen
 */
public class ServerConfiguration implements Configuration {

    ConnectionManager connectionManager;
    SecurityManager securityManager;
    DataBase dataBase;

    ServerBinding binding;
}
