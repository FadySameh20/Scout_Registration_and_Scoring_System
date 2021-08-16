package gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import scout.Scout;

public class WelcomeGUI extends javax.swing.JFrame {
    
    private Scout scout;
    
    public WelcomeGUI() {
        initComponents();
        scout = Scout.getInstance();
        this.setLocationRelativeTo(null);
        try {
            scout.loadData();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(RegisterGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public WelcomeGUI(Scout scout) {
        initComponents();
        this.scout = scout;
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bePreparedLabel = new javax.swing.JLabel();
        seeDataButton = new javax.swing.JButton();
        scoutLabel = new javax.swing.JLabel();
        registerLabel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bePreparedLabel.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        bePreparedLabel.setText("Scout");
        getContentPane().add(bePreparedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 70, 80, -1));

        seeDataButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        seeDataButton.setText("Show Data");
        seeDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeDataButtonActionPerformed(evt);
            }
        });
        getContentPane().add(seeDataButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 100, 50));

        scoutLabel.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        scoutLabel.setText("Groupe Wadi El Nil");
        getContentPane().add(scoutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 200, -1));

        registerLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        registerLabel.setText("Register");
        registerLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerLabelActionPerformed(evt);
            }
        });
        getContentPane().add(registerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 90, 50));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Add Equipier's Activity");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, 50));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Photos/bePreparedLogo.gif"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seeDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeDataButtonActionPerformed
        DataGUI dataGUI = new DataGUI(scout);
        dataGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_seeDataButtonActionPerformed

    private void registerLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerLabelActionPerformed
        RegisterGUI registerGUI = new RegisterGUI(scout);
        registerGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_registerLabelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AddActivityGUI addActivityGUI = new AddActivityGUI(scout);
        addActivityGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WelcomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WelcomeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel bePreparedLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton registerLabel;
    private javax.swing.JLabel scoutLabel;
    private javax.swing.JButton seeDataButton;
    // End of variables declaration//GEN-END:variables
}
