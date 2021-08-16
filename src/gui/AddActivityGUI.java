package gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import scout.Activity;
import scout.Scout;

public class AddActivityGUI extends javax.swing.JFrame {

    private Scout scout;
    private int index;

    public AddActivityGUI(Scout scout) {
        initComponents();
        this.scout = scout;
        activityLabel.setVisible(false);
        activityTextField.setVisible(false);
        activitySpinner.setVisible(false);
        addButton.setVisible(false);
        bonusLabel.setVisible(false);
        bonusTextField.setVisible(false);
        bonusActivitySpinner.setVisible(false);
        bonusButton.setVisible(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addActivityLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        activityLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        activityTextField = new javax.swing.JTextField();
        bonusLabel = new javax.swing.JLabel();
        bonusTextField = new javax.swing.JTextField();
        bonusButton = new javax.swing.JButton();
        activitySpinner = new javax.swing.JSpinner();
        bonusActivitySpinner = new javax.swing.JSpinner();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addActivityLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        addActivityLabel.setText("Add Activity");
        getContentPane().add(addActivityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 110, -1));

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 51, 102));
        nameLabel.setText("Equipier Name");
        getContentPane().add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 92, -1, -1));
        getContentPane().add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 140, -1));

        loginButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 110, 60));

        activityLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        activityLabel.setForeground(new java.awt.Color(255, 51, 102));
        activityLabel.setText("Activity");
        getContentPane().add(activityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 175, -1, -1));

        addButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addButton.setText("Add Activity");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 110, 60));

        backButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 110, -1));
        getContentPane().add(activityTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 173, 140, -1));

        bonusLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bonusLabel.setForeground(new java.awt.Color(255, 51, 102));
        bonusLabel.setText("Bonus Activity");
        getContentPane().add(bonusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 257, -1, -1));
        getContentPane().add(bonusTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 255, 140, -1));

        bonusButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bonusButton.setText("Add Bonus");
        bonusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bonusButtonActionPerformed(evt);
            }
        });
        getContentPane().add(bonusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 110, 60));
        getContentPane().add(activitySpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 173, 60, -1));
        getContentPane().add(bonusActivitySpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 255, 60, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Photos/ScoutBePrepared.gif"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        WelcomeGUI welcomeGUI = new WelcomeGUI(scout);
        welcomeGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        boolean flag = false;
        for (int i = 0; i < scout.getEquipiers().size(); i++) {
            if (scout.getEquipiers().get(i).getName().toLowerCase().contains(nameTextField.getText()) && !nameTextField.getText().equals("") && !nameTextField.getText().equals(" ")) {
                index = i;
                flag = true;
                break;
            }
        }
        if (flag == false) {
            JOptionPane.showMessageDialog(null, "Equipier not found !!");
        } else {
            JOptionPane.showMessageDialog(null, "Correct !");
            activityLabel.setVisible(true);
            activityTextField.setVisible(true);
            activitySpinner.setVisible(true);
            addButton.setVisible(true);
            bonusLabel.setVisible(true);
            bonusTextField.setVisible(true);
            bonusActivitySpinner.setVisible(true);
            bonusButton.setVisible(true);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        boolean flag = false;
        if (activityTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please write the activity to be added");
            flag = true;
        }
        if (flag == false) {
            Activity activity = new Activity(activityTextField.getText(), (Integer)activitySpinner.getValue());
            scout.getEquipiers().get(index).addActivity(activity);
            try {
                scout.saveData();
            } catch (ParserConfigurationException | TransformerException ex) {
                Logger.getLogger(AddActivityGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            activityTextField.setText("");
            activitySpinner.setValue(0);
            JOptionPane.showMessageDialog(null, "Activity has been added");
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void bonusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bonusButtonActionPerformed
        boolean flag = false;
        if (bonusTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please write the bonus activity to be added");
            flag = true;
        }
        if (flag == false) {
            Activity activity = new Activity(bonusTextField.getText(), (Integer)bonusActivitySpinner.getValue());
            activity.setActivityName(activity.getActivityName() + " (Bonus)");
            scout.getEquipiers().get(index).addActivity(activity);
            scout.getEquipiers().get(index).addToBonus(activity.getPoints());
            try {
                scout.saveData();
            } catch (ParserConfigurationException | TransformerException ex) {
                Logger.getLogger(AddActivityGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            bonusTextField.setText("");
            bonusActivitySpinner.setValue(0);
            JOptionPane.showMessageDialog(null, "Bonus activity has been added");
        }
    }//GEN-LAST:event_bonusButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activityLabel;
    private javax.swing.JSpinner activitySpinner;
    private javax.swing.JTextField activityTextField;
    private javax.swing.JLabel addActivityLabel;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel background;
    private javax.swing.JSpinner bonusActivitySpinner;
    private javax.swing.JButton bonusButton;
    private javax.swing.JLabel bonusLabel;
    private javax.swing.JTextField bonusTextField;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    // End of variables declaration//GEN-END:variables
}
