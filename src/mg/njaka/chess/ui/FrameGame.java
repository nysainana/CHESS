
package mg.njaka.chess.ui;

import jade.core.AID;
import jade.gui.GuiEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import mg.njaka.chess.M;
import mg.njaka.chess.agent.PlayerAgent;
import mg.njaka.chess.interaction.CommandeVocal;
import t2s.son.LecteurTexte;


public class FrameGame extends javax.swing.JFrame {

    private PanelGame panelGame;
    private PlayerAgent playerAgent;
    private CommandeVocal commandeVocal;
    private LecteurTexte lecteur;
    
    public FrameGame(PlayerAgent playerAgent) {
        this.playerAgent = playerAgent;
        lecteur = new LecteurTexte("bonjour !!");
        lecteur.playAll();
        
        initComponents();
        setLocationRelativeTo(getParent());
        setTitle("Chess - " + playerAgent.getLocalName());
        toolBarEnJeu.setVisible(false);
        
        this.commandeVocal = new CommandeVocal(this);
        enabledMenuJeu(false);
        panelControl.setEnabled(false);
        //fieldDeplacement.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogColor = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        radioButtonBlanc = new javax.swing.JRadioButton();
        radioButtonNoir = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panelMain = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelControl = new javax.swing.JPanel();
        fieldDeplacement = new javax.swing.JTextField();
        buttonStart = new javax.swing.JButton();
        labelCommande = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panelPresentation = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        toolBarColor = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        toolBarEnJeu = new javax.swing.JToolBar();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuJeu = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        menuRText = new javax.swing.JRadioButtonMenuItem();
        menuRVocal = new javax.swing.JRadioButtonMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        dialogColor.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        dialogColor.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dialogColorWindowClosing(evt);
            }
        });

        jLabel1.setText("Choisissez votre couleur");

        buttonGroup1.add(radioButtonBlanc);
        radioButtonBlanc.setSelected(true);
        radioButtonBlanc.setText("Blanc");

        buttonGroup1.add(radioButtonNoir);
        radioButtonNoir.setText("Noir");

        jButton3.setText("Envoyer l'invitation");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogColorLayout = new javax.swing.GroupLayout(dialogColor.getContentPane());
        dialogColor.getContentPane().setLayout(dialogColorLayout);
        dialogColorLayout.setHorizontalGroup(
            dialogColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogColorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(dialogColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addGroup(dialogColorLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(dialogColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioButtonNoir)
                            .addComponent(radioButtonBlanc)))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        dialogColorLayout.setVerticalGroup(
            dialogColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogColorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioButtonBlanc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioButtonNoir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(783, 510));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelMain.setLayout(new java.awt.BorderLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 440));

        fieldDeplacement.setMaximumSize(new java.awt.Dimension(150, 2147483647));
        fieldDeplacement.setMinimumSize(new java.awt.Dimension(150, 24));
        fieldDeplacement.setPreferredSize(new java.awt.Dimension(150, 24));
        fieldDeplacement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDeplacementActionPerformed(evt);
            }
        });
        fieldDeplacement.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldDeplacementKeyReleased(evt);
            }
        });

        buttonStart.setText("Start");
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });

        labelCommande.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCommande.setText("La reconaissance vocale est désactiver");

        javax.swing.GroupLayout panelControlLayout = new javax.swing.GroupLayout(panelControl);
        panelControl.setLayout(panelControlLayout);
        panelControlLayout.setHorizontalGroup(
            panelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelControlLayout.createSequentialGroup()
                .addGroup(panelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelControlLayout.createSequentialGroup()
                        .addGroup(panelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelControlLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(fieldDeplacement, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelControlLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(buttonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(panelControlLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelCommande, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelControlLayout.setVerticalGroup(
            panelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelControlLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(fieldDeplacement, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(buttonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCommande)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(262, Short.MAX_VALUE))
        );

        panelMain.add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setLayout(new java.awt.CardLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Pseudo", "Adresse", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(204, 204, 204));
        jTable1.setRowHeight(20);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout panelPresentationLayout = new javax.swing.GroupLayout(panelPresentation);
        panelPresentation.setLayout(panelPresentationLayout);
        panelPresentationLayout.setHorizontalGroup(
            panelPresentationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPresentationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPresentationLayout.setVerticalGroup(
            panelPresentationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPresentationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(panelPresentation, "card2");

        panelMain.add(jPanel2, java.awt.BorderLayout.CENTER);

        jToolBar1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        toolBarColor.setRollover(true);

        jButton1.setText("Inviter à jouer");
        jButton1.setToolTipText("");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        toolBarColor.add(jButton1);

        jToolBar1.add(toolBarColor);

        toolBarEnJeu.setRollover(true);
        toolBarEnJeu.setPreferredSize(new java.awt.Dimension(129, 25));

        jButton2.setText("Annuler le jeu");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        toolBarEnJeu.add(jButton2);

        jToolBar1.add(toolBarEnJeu);

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Inviter...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Quiter");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        menuJeu.setText("Jeu");

        jMenu4.setText("Controle");

        menuRText.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        buttonGroup2.add(menuRText);
        menuRText.setSelected(true);
        menuRText.setText("Text");
        menuRText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRTextActionPerformed(evt);
            }
        });
        jMenu4.add(menuRText);

        menuRVocal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        buttonGroup2.add(menuRVocal);
        menuRVocal.setText("Commande vocal");
        menuRVocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRVocalActionPerformed(evt);
            }
        });
        jMenu4.add(menuRVocal);

        menuJeu.add(jMenu4);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Annuler le jeu");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuJeu.add(jMenuItem3);

        jMenuBar1.add(menuJeu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        quiter();
    }//GEN-LAST:event_formWindowClosing

    private void fieldDeplacementKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldDeplacementKeyReleased
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            onDeplace(fieldDeplacement.getText(), null);
            fieldDeplacement.setText("");
        }
    }//GEN-LAST:event_fieldDeplacementKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        prepareInvitation();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void dialogColorWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dialogColorWindowClosing
        System.out.println(dialogColor.getWidth() + "x" + dialogColor.getHeight());
    }//GEN-LAST:event_dialogColorWindowClosing

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dialogColor.dispose();
        if(radioButtonBlanc.isSelected())
            envoyerInvitation(M.var.BLANC);
        else if(radioButtonNoir.isSelected())
            envoyerInvitation(M.var.NOIR);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        int result = JOptionPane.showConfirmDialog(this, "Etes vous sur de vouloir annuler le jeu?", 
                "Annuler", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if( result == JOptionPane.YES_OPTION){
            stopGame("Stoper", false);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        quiter();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        prepareInvitation();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
        int result = JOptionPane.showConfirmDialog(this, "Etes vous sur de vouloir annuler le jeu?", 
                "Annuler", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if( result == JOptionPane.YES_OPTION){
            stopGame("Stoper", false);
        }
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menuRTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRTextActionPerformed
        startCommandeVocal(false);
    }//GEN-LAST:event_menuRTextActionPerformed

    private void menuRVocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRVocalActionPerformed
        startCommandeVocal(true);
    }//GEN-LAST:event_menuRVocalActionPerformed

    private void fieldDeplacementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDeplacementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldDeplacementActionPerformed

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        if(menuRText.isSelected()){
            startCommandeVocal(true);
        }
        else{
            startCommandeVocal(false);
        }
    }//GEN-LAST:event_buttonStartActionPerformed

    private void startCommandeVocal(boolean start){
        menuRText.setSelected(!start);
        menuRVocal.setSelected(start);
        fieldDeplacement.setEditable(!start);
        buttonStart.setEnabled(start);
        
        if(start){
            commandeVocal.start();
            buttonStart.setText("Stop");
            labelCommande.setText("Commencer à parler");
        }
        else{
            commandeVocal.stop();
            buttonStart.setText("Start");
            labelCommande.setText("La reconaissance vocale est désactiver");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton buttonStart;
    private javax.swing.JDialog dialogColor;
    private javax.swing.JTextField fieldDeplacement;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelCommande;
    private javax.swing.JMenu menuJeu;
    private javax.swing.JRadioButtonMenuItem menuRText;
    private javax.swing.JRadioButtonMenuItem menuRVocal;
    private javax.swing.JPanel panelControl;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelPresentation;
    private javax.swing.JRadioButton radioButtonBlanc;
    private javax.swing.JRadioButton radioButtonNoir;
    private javax.swing.JToolBar toolBarColor;
    private javax.swing.JToolBar toolBarEnJeu;
    // End of variables declaration//GEN-END:variables

    private void quiter(){
        int result = JOptionPane.showConfirmDialog(this, "Etes vous sur de vouloir quiter le jeu?", 
                "Quiter", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if( result == JOptionPane.YES_OPTION){
            if(panelGame != null && panelGame.getMainGame() != null){
                panelGame.getMainGame().stop();
                stopGame("Votre adversiare à déconnecter", false);
            }
            this.playerAgent.doDelete();
        }
    }

    public void setPlayerAgent(PlayerAgent playerAgent) {
        this.playerAgent = playerAgent;
    }

    public PlayerAgent getPlayerAgent() {
        return playerAgent;
    }
    
    public void startNewGame(int couleur, AID aid){
        panelGame = new PanelGame();
        jPanel2.add(panelGame, "panelGame");
        jPanel2.remove(panelPresentation);
        panelGame.initGame(couleur);
        playerAgent.setAidAdversaire(aid);
        playerAgent.setState(M.var.STATE_EN_JEU);
        toolBarEnJeu.setVisible(true);
        toolBarColor.setVisible(false);
        enabledMenuJeu(true);
    }
    
    public void stopGame(String raison, boolean receved){
        if(!receved){
            GuiEvent gev = new GuiEvent(this, M.var.EVT_ANNULER_JEU);
            Map<String, Object> param = new HashMap<>();
            param.put(M.var.ANNULER_JEU, raison);
            gev.addParameter(param);
            playerAgent.onGuiEvent(gev);
        }
        else{
            JOptionPane.showMessageDialog(this, raison, "Jeu annuler", JOptionPane.INFORMATION_MESSAGE);
        }
        
        playerAgent.setState(M.var.STATE_ACTIVE);
        jPanel2.add(panelPresentation, "card2");
        jPanel2.remove(panelGame);
        toolBarEnJeu.setVisible(false);
        toolBarColor.setVisible(true);
        enabledMenuJeu(false);
        panelGame = null;
    }

    public PanelGame getPanelGame() {
        return panelGame;
    }
    
    public void onDeplace(String dep, String commande){
        try {
            if(panelGame.getMainGame() != null){
                if(panelGame.getMainGame().isMonTour()){
                    boolean[] res = panelGame.getMainGame().setAction(dep);

                    if(!res[0] && commande!=null){
                        afficheTextCommmande("La commande "+ commande + " est inconnue", Color.RED);
                    }
                    else if(!res[1] && commande!=null){
                        afficheTextCommmande(commande + " deplacement impossible", Color.RED);
                    }

                    if(res[0] && res[1]){
                        GuiEvent gev = new GuiEvent(this, M.var.EVT_DEPLACEMENT);
                        Map<String, Object> param = new HashMap<>();
                        param.put(M.var.DEPLACEMENT, dep);
                        gev.addParameter(param);
                        playerAgent.onGuiEvent(gev);
                        afficheTextCommmande(dep, Color.BLACK);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void envoyerInvitation(int color){
        try {
            int r =jTable1.getSelectedRow();
            AID aid = playerAgent.getListeAdve().get(r);
            GuiEvent gev = new GuiEvent(this, M.var.EVT_INVITATION);
            Map<String, Object> param = new HashMap<>();
            param.put("aid", aid);
            param.put("color", color);
            gev.addParameter(param);
            playerAgent.onGuiEvent(gev);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public JTable getTable() {
        return jTable1;
    }
    
    private void prepareInvitation(){
        if(jTable1.getSelectedRow() != -1){
            dialogColor.setLocationRelativeTo(this);
            dialogColor.setPreferredSize(new Dimension(210, 160));
            dialogColor.setMinimumSize(new Dimension(210, 160));
//            dialogColor.setMaximumSize(new Dimension(210, 160));
            dialogColor.setVisible(true);
        }
    }
    
    private void enabledMenuJeu(boolean en){
        jMenuItem3.setEnabled(en);
        menuRText.setEnabled(en);
        menuRVocal.setEnabled(en);
        fieldDeplacement.setEnabled(en);
        buttonStart.setEnabled(en);
    }
    
    private void afficheTextCommmande(String txt, Color col){
        labelCommande.setText(txt);
        labelCommande.setForeground(col);
    }
}
