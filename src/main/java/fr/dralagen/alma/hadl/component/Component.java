package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.connector.Connector;
import fr.dralagen.alma.hadl.port.ProvidedPort;
import fr.dralagen.alma.hadl.port.RequiredPort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public abstract class Component {

    protected Map<String, RequiredPort> requiredPort;
    protected Map<String, ProvidedPort> providedPort;

    protected List<Connector> connectorList;

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
    }

    public void addProvidedPort(String name, ProvidedPort port) {
        providedPort.put(name, port);
    }
}
