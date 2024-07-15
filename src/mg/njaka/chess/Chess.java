
package mg.njaka.chess;

import javafx.application.Application;
import javafx.stage.Stage;
import javax.swing.UnsupportedLookAndFeelException;
import mg.njaka.chess.ui.DialogLogin;


public class Chess extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
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
            new FrameChoix().setVisible(true);
        });

    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
