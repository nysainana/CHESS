
package mg.njaka.chess;

import javax.swing.JOptionPane;


public class M {
    
    public final static Var var = new Var();
    public final static UI ui = new UI();
    
    
    public static class Var{
        public final int NOIR = 1;
        public final int BLANC = -1;
    
        public final String DEPLACEMENT = "deplacement";
        public final String ANNULER_JEU = "annuler_jeu";
        public final String INVITATION = "invitation";
        
        public static final int EVT_DEPLACEMENT = 10;
        public static final int EVT_ANNULER_JEU = 11;
        public static final int EVT_INVITATION = 12;
        
        public final String STATE_ACTIVE = "Libre";
        public final String STATE_EN_JEU = "En jeu";
        public final String STATE_EN_ATENTE = "En attente";
    }
    
    public static class UI{
       
    }
 
}
