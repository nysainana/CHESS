
package mg.njaka.chess.ui;

import javax.swing.JOptionPane;
import mg.njaka.chess.agent.PlayerContainer;


public class DialogLogin extends javax.swing.JFrame {

//    CommandeVocal cv;
    
    public DialogLogin() {
        super();
//        cv = new CommandeVocal(null);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Connexion au serveur");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldNom = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        labelSH = new javax.swing.JLabel();
        fieldServer = new javax.swing.JTextField();
        buttnonOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Pseudo");

        labelSH.setText("Serveur host");

        buttnonOk.setText("Connecter");
        buttnonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttnonOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(buttnonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelSH)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldNom, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(fieldServer))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSH))
                .addGap(18, 18, 18)
                .addComponent(buttnonOk)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttnonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttnonOkActionPerformed
        String nom = fieldNom.getText();
        String serverName = fieldServer.getText();

        if(!nom.isEmpty()){
            if(!serverName.isEmpty()){
                try {
                    PlayerContainer playerContainer = new PlayerContainer(serverName);
                    playerContainer.createNewAgent(nom);
                    dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog( this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog( this, "Le nom de l'hote vide", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog( this, "Pseudo vide", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        
        /*
        if(!cv.isAlive())
            cv.start();
        else
            cv.stop();
        */
        
        //LecteurTexte lecteur = new LecteurTexte("bonjour !!");
        //lecteur.playAll();
    }//GEN-LAST:event_buttnonOkActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        quiter();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttnonOk;
    private javax.swing.JTextField fieldNom;
    private javax.swing.JTextField fieldServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelSH;
    // End of variables declaration//GEN-END:variables

    private void quiter(){
        int result = JOptionPane.showConfirmDialog(this, "Etes vous sur de vouloir quiter?", 
                "Quiter", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if( result == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }

}
