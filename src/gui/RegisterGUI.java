package gui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import scout.Equipier;
import scout.Scout;

public class RegisterGUI extends javax.swing.JFrame {

    private Scout scout;

    public RegisterGUI(Scout scout) {
        initComponents();
        this.scout = scout;
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        equipeLabel = new javax.swing.JLabel();
        dateOfBirthLabel = new javax.swing.JLabel();
        mobileLabel = new javax.swing.JLabel();
        equipeTextField = new javax.swing.JTextField();
        dateOfBirthTextField = new javax.swing.JTextField();
        mobileTextField = new javax.swing.JTextField();
        registerButton = new javax.swing.JButton();
        nationalIdTextField = new javax.swing.JTextField();
        nationalIdLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registerLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        registerLabel.setForeground(new java.awt.Color(255, 255, 0));
        registerLabel.setText("Registration");
        getContentPane().add(registerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 55, 110, 30));

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nameLabel.setText("Name");
        getContentPane().add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 93, -1, -1));

        equipeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        equipeLabel.setText("Equipe");
        getContentPane().add(equipeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 20));

        dateOfBirthLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dateOfBirthLabel.setText("Date of Birth");
        getContentPane().add(dateOfBirthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 180, 80, -1));

        mobileLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mobileLabel.setText("Mobile");
        getContentPane().add(mobileLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));
        getContentPane().add(equipeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 180, 30));
        getContentPane().add(dateOfBirthTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 180, 30));
        getContentPane().add(mobileTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 180, 30));

        registerButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 100, 40));
        getContentPane().add(nationalIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 180, 30));

        nationalIdLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nationalIdLabel.setText("National ID");
        getContentPane().add(nationalIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));
        getContentPane().add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 87, 180, 30));

        backButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 100, 40));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Photos/WadiElNilLogo.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 480, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean checkLettersOnly(String str){
        str = str.toLowerCase();
        char[] charArray = str.toCharArray();
        for(char c : charArray){
            if(!(c >= 'a' && c <= 'z')){
                if(c == ' '){
                    continue;
                }
                return false;
            }
        }
        return true;
    }
    
    private boolean checkNumbersOnly(String str){
        str = str.toLowerCase();
        char[] charArray = str.toCharArray();
        for(char c : charArray){
            if(!(c >= '0' && c <= '9')){
                return false;
            }
        }
        return true;
    }
    
    private boolean validateDateOfBirth(String str){
        str = str.toLowerCase();
        char[] charArray = str.toCharArray();
        for(char c : charArray){
            if(!(c >= '0' && c <= '9')){
                if(c == '/'){
                    continue;
                }
                return false;
            }
        }
        return true;
    }
    
    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed

        boolean flag = false;
        String name = nameTextField.getText();
        for (Equipier equipier : scout.getEquipiers()) {
            if (name.equals(equipier.getName())) {
                flag = true;
            }
        }
        if (flag == true) {
            JOptionPane.showMessageDialog(null, "Equipier already exists !!");
        } else if (nameTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter at least the name");
            return;
        } else if(!checkLettersOnly(nameTextField.getText())){
            JOptionPane.showMessageDialog(null, "Name must contain alphabets only !!");
            return;
        } else if(!checkLettersOnly(equipeTextField.getText())){
            JOptionPane.showMessageDialog(null, "Equipe must contain alphabets only !!");
            return;
        }else if(!validateDateOfBirth(dateOfBirthTextField.getText())){
            JOptionPane.showMessageDialog(null, "Invalid date of birth or invalid format !!");
            return;
        }else if(!checkNumbersOnly(mobileTextField.getText())){
            JOptionPane.showMessageDialog(null, "Mobile must contain numbers only !!");
            return;
        }else if(!checkNumbersOnly(nationalIdTextField.getText())){
            JOptionPane.showMessageDialog(null, "National ID must contain numbers only !!");
            return;
        }else {
            Equipier equipier = new Equipier();
            equipier.setName(nameTextField.getText());
            equipier.setEquipe(equipeTextField.getText());
            equipier.setDateOfBirth(dateOfBirthTextField.getText());
            equipier.setMobile(mobileTextField.getText());
            equipier.setNationalId(nationalIdTextField.getText());

            scout.getEquipiers().add(equipier);

            try {
                scout.saveData();
            } catch (ParserConfigurationException | TransformerException ex) {
                Logger.getLogger(RegisterGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Equipier has been added");
        }
        nameTextField.setText("");
        equipeTextField.setText("");
        dateOfBirthTextField.setText("");
        mobileTextField.setText("");
        nationalIdTextField.setText("");
    }//GEN-LAST:event_registerButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        WelcomeGUI welcomeGUI = new WelcomeGUI(scout);
        welcomeGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel background;
    private javax.swing.JLabel dateOfBirthLabel;
    private javax.swing.JTextField dateOfBirthTextField;
    private javax.swing.JLabel equipeLabel;
    private javax.swing.JTextField equipeTextField;
    private javax.swing.JLabel mobileLabel;
    private javax.swing.JTextField mobileTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel nationalIdLabel;
    private javax.swing.JTextField nationalIdTextField;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel registerLabel;
    // End of variables declaration//GEN-END:variables
}
