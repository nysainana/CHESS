
package mg.njaka.chess.agent.behaviour;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import javax.swing.JOptionPane;
import mg.njaka.chess.M;
import mg.njaka.chess.agent.PlayerAgent;


public class BehaviourMessage extends CyclicBehaviour {

    private PlayerAgent agent;
    
    @Override
    public void action() {
        agent = (PlayerAgent) getAgent();
        
        ACLMessage message = agent.receive();
        
        if(message != null){
            
            String ontology = message.getOntology();
            String content = message.getContent();
            int type = message.getPerformative();
            AID sender = message.getSender();
            
            if(ontology.equals(M.var.DEPLACEMENT)){
                try {
                    agent.getGui().getPanelGame().
                            getMainGame().setAction(content);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(agent.getGui(),e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(ontology.equals(M.var.ANNULER_JEU)){
                agent.getGui().stopGame(content, true);
            }
            else if(ontology.equals(M.var.INVITATION)){
                if(type == ACLMessage.REQUEST){
                    try{
                        agent.setState(M.var.STATE_EN_ATENTE);
                        int color = Integer.valueOf(content);

                        String ms = sender.getLocalName() + " vous invite à jouer en tant que " 
                                + (color == M.var.BLANC ? "noir" : "blanc" );


                        int res = JOptionPane.showConfirmDialog(agent.getGui(), ms,
                                "Invitation", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);

                        if(res == JOptionPane.YES_OPTION){
                            ACLMessage m = message.createReply();
                            m.setContent(String.valueOf(color));
                            m.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                            agent.send(m);
                            agent.getGui().startNewGame(
                                    color == M.var.BLANC ? M.var.NOIR : M.var.BLANC,
                                    message.getSender());
                        }
                        else{
                            ACLMessage m = message.createReply();
                            m.setPerformative(ACLMessage.REJECT_PROPOSAL);
                            agent.send(m);
                            agent.setState(M.var.STATE_ACTIVE);
                        }
                    }catch(Exception e){
                        agent.setState(M.var.STATE_ACTIVE);
                    }
                }
                else if(type == ACLMessage.ACCEPT_PROPOSAL){
                    try {
                        int color = Integer.valueOf(content);
                        agent.getGui().startNewGame(color, message.getSender());
                    } catch (Exception e) {
                        agent.setState(M.var.STATE_ACTIVE);
                    }
                }
                else if(type == ACLMessage.REJECT_PROPOSAL){
                    JOptionPane.showMessageDialog(agent.getGui(),
                            "Votre invitation est réjeter par " + sender.getLocalName(),
                                "Reponse d'invitation", JOptionPane.INFORMATION_MESSAGE);
                    agent.setState(M.var.STATE_ACTIVE);
                }
            }
        }
        else{
            block();
        }
        
    }
    
}
