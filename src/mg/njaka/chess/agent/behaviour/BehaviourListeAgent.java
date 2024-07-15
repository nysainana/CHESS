
package mg.njaka.chess.agent.behaviour;

import jade.core.AID;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import javax.swing.table.DefaultTableModel;
import mg.njaka.chess.M;
import mg.njaka.chess.agent.PlayerAgent;

public class BehaviourListeAgent extends TickerBehaviour{
    
    private boolean pause = false;
    
    public BehaviourListeAgent(PlayerAgent a, long period) {
        super(a, period);
    }

    @Override
    protected void onTick() {
        try {
            
            if(!pause){
                PlayerAgent pa = (PlayerAgent) getAgent();

                int index = -1;
                AID aid = null;
                try {
                    index = pa.getGui().getTable().getSelectedRow();
                    aid = pa.getListeAdve().get(index);
                } catch (Exception e) {

                }

                DefaultTableModel tbm = (DefaultTableModel) pa.getGui().getTable().getModel();
                tbm.setRowCount(0);

                pa.getListeAdve().clear();
                searcByState(pa, tbm, M.var.STATE_ACTIVE);
                searcByState(pa, tbm, M.var.STATE_EN_ATENTE);
                searcByState(pa, tbm, M.var.STATE_EN_JEU);

                try {
                    if(aid != null){
                        index = pa.getListeAdve().indexOf(aid);
                        pa.getGui().getTable().setRowSelectionInterval(index, index);
                    }
                } catch (Exception e) {

                }

                System.out.println("Nombre " + pa.getListeAdve().size());
            }
            
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    private void searcByState(PlayerAgent pa, DefaultTableModel tbm, String state){
        try {
            DFAgentDescription dfd = new DFAgentDescription();
            ServiceDescription sd = new ServiceDescription();

            sd.setType(state);
            dfd.addServices(sd);
            DFAgentDescription[] result = DFService.search(pa, dfd);
            
            for (int i = 0; i < result.length; i++){
                if(!result[i].getName().equals(pa.getAID())){
                    tbm.addRow(new Object[]{
                        result[i].getName().getLocalName(),
                        result[i].getName().getAddressesArray()[0],
                        state
                    });
                    pa.getListeAdve().add(result[i].getName());
                }
            }
        } catch (FIPAException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void pause(){
        pause = true;
    }
    
    public void start(){
        pause = false;
    }

    public boolean isPause() {
        return pause;
    }
    
}
