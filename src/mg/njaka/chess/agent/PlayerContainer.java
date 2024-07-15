
package mg.njaka.chess.agent;

import jade.core.Runtime;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
import java.net.InetAddress;


public class PlayerContainer {
    
    private AgentContainer agentContainer;
    
    public PlayerContainer(String host) {
        try {
            InetAddress IP = InetAddress.getLocalHost(); 
            Runtime runtime = Runtime.instance();
            ProfileImpl profileImpl = new ProfileImpl(false);
            profileImpl.setParameter(ProfileImpl.MAIN_HOST, host != null ? host : "localhost");
            profileImpl.setParameter(ProfileImpl.CONTAINER_NAME, IP.toString());
            agentContainer = runtime.createAgentContainer(profileImpl);
        } catch (Exception e) {
            System.err.println("Err PlayerContainner => " + e.getMessage());
        }
    }
    
    public void start(){
        try {
            agentContainer.start();
        } catch (ControllerException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void createNewAgent(String nickname){
        try {
            AgentController agentController = agentContainer.createNewAgent(
                    nickname, PlayerAgent.class.getName(), new Object[]{});
            agentController.start();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }      
    }
    
}
