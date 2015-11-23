package fr.dralagen.alma.hadl.component;

import fr.dralagen.alma.hadl.connector.Connector;
import fr.dralagen.alma.hadl.port.ProvidedPort;
import fr.dralagen.alma.hadl.port.RequiredPort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public abstract class Component{

    protected List<RequiredPort> requiredPortList;
    protected List<ProvidedPort> providedPortList;

    protected List<Connector> connectorList;

    public Component() {
        requiredPortList = new ArrayList<RequiredPort>();
        providedPortList = new ArrayList<ProvidedPort>();

        connectorList = new ArrayList<Connector>();
    }

    public void addConnector(Connector connector) {
        connectorList.add(connector);
    }

    public void addRequiredPort(RequiredPort port) {
        requiredPortList.add(port);
    }

    public void addProvidedPort(ProvidedPort port) {
        providedPortList.add(port);
    }
}
