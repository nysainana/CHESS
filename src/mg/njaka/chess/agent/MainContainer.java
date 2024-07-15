
package mg.njaka.chess.agent;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.ControllerException;


public class MainContainer {

    private AgentContainer mainContainer;
    
    public MainContainer() {
        try {
            Runtime runtime = Runtime.instance();
            Properties properties = new ExtendedProperties();
            properties.setProperty(Profile.GUI, "true");
            ProfileImpl profileImpl = new ProfileImpl(properties);
            mainContainer = runtime.createMainContainer(profileImpl);
        } catch (Exception e) {
            System.err.println("Err MainContainner => " + e.getMessage());
        }
    }
    
    public void start(){
        try {
            mainContainer.start();
        } catch (ControllerException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
