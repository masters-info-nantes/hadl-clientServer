package fr.dralagen.alma.hadl.component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 10/5/15.
 *
 * @author dralagen
 */
public abstract class Configuration extends Component{

    protected List<Component> componentList;

    public Configuration() {
        componentList = new ArrayList<Component>();
    }

    public void addComponent(Component c) {
        componentList.add(c);
    }
}
