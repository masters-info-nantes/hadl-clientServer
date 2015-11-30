package fr.dralagen.alma.hadl.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public abstract class Configuration extends Component {

    protected Map<String, Component> component;

    public Configuration() {
        component = new HashMap<>();
    }

    public void addComponent(String name, Component component) {
        this.component.put(name, component);
    }
}
