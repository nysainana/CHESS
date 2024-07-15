
package mg.njaka.chess.agent;

import jade.core.AID;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import mg.njaka.chess.M;
import mg.njaka.chess.agent.behaviour.BehaviourListeAgent;
import mg.njaka.chess.agent.behaviour.BehaviourMessage;
import mg.njaka.chess.ui.FrameGame;


public class PlayerAgent extends GuiAgent {

    private FrameGame gui;
    private AID aidAdversaire;
    private ObservableList<AID> listeAdve = FXCollections.observableArrayList();
    private BehaviourListeAgent behaviourListeAgent;

    @Override
    protected void setup() {
        gui = new FrameGame(this);
        
        behaviourListeAgent = new BehaviourListeAgent(this, 2000);
        addBehaviour( new BehaviourMessage());
        addBehaviour(behaviourListeAgent);
        register();
        showGui();
    }
    
    public void actualiseListeAgent(boolean actualise){
//        
//        if(actualise){
//            behaviourListeAgent = new BehaviourListeAgent(this, 2000);
//            addBehaviour(behaviourListeAgent);
//        }
//        else{
//            if(behaviourListeAgent != null){
//                behaviourListeAgent.stop();
//                removeBehaviour(behaviourListeAgent);
//                behaviourListeAgent = null;
//            }
//        }
//        
        if(actualise && behaviourListeAgent.isPause())
            behaviourListeAgent.start();
        else if(!actualise && !behaviourListeAgent.isPause())
            behaviourListeAgent.pause();
    }
    
    private void register() {
        ServiceDescription sd = new ServiceDescription();
        sd.setType(M.var.STATE_ACTIVE);
        sd.setName(getLocalName());
        
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        } catch (FIPAException fe) {
            System.err.println(fe.getMessage());
        }
    }
    
    public void setState(String state){
        ServiceDescription sd = new ServiceDescription();
        sd.setType(state);
        sd.setName(getLocalName());
        
        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        dfd.addServices(sd);
        try {
            DFService.modify(this, dfd);
            
            actualiseListeAgent(state != M.var.STATE_EN_JEU);
        } catch (FIPAException fe) {
            System.err.println(fe.getMessage());
        }
        
    }
    
    private void showGui(){
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            System.err.println("Err : " + ex.getMessage());
        }
 
        java.awt.EventQueue.invokeLater(() -> {
            gui.setVisible(true);
        });
    }
    
    @Override
    public void onGuiEvent(GuiEvent ge) {
        Map<String, Object> params = (Map<String, Object>) ge.getParameter(0);
        
        switch(ge.getType()){
            case M.Var.EVT_DEPLACEMENT:
                String dep = (String) params.get(M.var.DEPLACEMENT);
                sendShortMessage(aidAdversaire, dep, M.var.DEPLACEMENT, ACLMessage.INFORM);
                break;
            case M.Var.EVT_ANNULER_JEU:
                String annul = (String) params.get(M.var.ANNULER_JEU);
                sendShortMessage(aidAdversaire, annul, M.var.ANNULER_JEU, ACLMessage.INFORM);
                break;
            case M.Var.EVT_INVITATION:
                AID aid = (AID) params.get("aid");
                int color = (int) params.get("color");
                
                sendShortMessage(aid, 
                        String.valueOf(color), 
                        M.var.INVITATION, ACLMessage.REQUEST);
                setState(M.var.STATE_EN_ATENTE);
                break;
        }
    }
    
    public void sendShortMessage(AID aid, String msg, String ontologi, int type){
        ACLMessage message = new ACLMessage(type);
        message.addReceiver( aid);
        message.setContent(msg);
        message.setOntology(ontologi);
        send(message);
    }

    public FrameGame getGui() {
        return gui;
    }

    public void setAidAdversaire(AID aidAdversaire) {
        this.aidAdversaire = aidAdversaire;
    }

    public AID getAidAdversaire() {
        return aidAdversaire;
    }

    @Override
    public void doDelete() {
        try{
            DFService.deregister(this);
            this.gui.dispose();
            super.doDelete();
            System.exit(0);
        } catch (FIPAException fe) {
            JOptionPane.showMessageDialog(gui, fe.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public ObservableList<AID> getListeAdve() {
        return listeAdve;
    }
    
}
