package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.connector.Connector;
import fr.dralagen.alma.hadl.port.ProvidedPort;
import fr.dralagen.alma.hadl.port.RequiredPort;

import java.util.*;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public abstract class Component implements Observer {

    private Map<String, RequiredPort> requiredPort;
    private Map<String, ProvidedPort> providedPort;

    private List<Connector> connectorList;

    public Component() {
        requiredPort = new HashMap<>();
        providedPort = new HashMap<>();

        connectorList = new ArrayList<>();
    }

    public void addConnector(Connector connector) {
        connectorList.add(connector);
    }

    public void addRequiredPort(String name, RequiredPort port) {
        requiredPort.put(name, port);
        port.addObserver(this);
    }

    public void addProvidedPort(String name, ProvidedPort port) {
        providedPort.put(name, port);
        port.addObserver(this);
    }

    @Override
    public abstract void update(Observable o, Object arg);

    public ProvidedPort getProvidedPort(String name){
        return providedPort.get(name);
    }

    public RequiredPort getRequiredPort(String name){
        return requiredPort.get(name);
    }
}
