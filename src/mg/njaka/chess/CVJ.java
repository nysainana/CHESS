
package mg.njaka.chess;

import java.util.logging.Level;
import java.util.logging.Logger;
import t2s.son.LecteurTexte;

public class CVJ {
    
    public static void main(String[] args) {
        
        try {
            LecteurTexte lecteur = new LecteurTexte("Bonjour");
            lecteur.playAll();
            lecteur.setTexte("Ca va?");
            lecteur.playAll();
        } catch (Exception ex) {
            Logger.getLogger(CVJ.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
    
}
