package gui;

import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import scout.Scout;

public class DataGUI extends javax.swing.JFrame {

    private Scout scout;
    private DefaultTableModel table;

    public DataGUI(Scout scout) {
        initComponents();
        this.scout = scout;

        this.setLocationRelativeTo(null);
        table = (DefaultTableModel) infoTable.getModel();
        infoTable.setRowSelectionAllowed(false);
        infoTable.setFocusable(false);
        infoTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        infoTable.getColumnModel().getColumn(3).setPreferredWidth(85);
        infoTable.getColumnModel().getColumn(4).setPreferredWidth(120);
        infoTable.getColumnModel().getColumn(5).setPreferredWidth(200);
        infoTable.getColumnModel().getColumn(6).setPreferredWidth(50);
        infoTable.getColumnModel().getColumn(7).setPreferredWidth(50);
        infoTable.getColumnModel().getColumn(8).setPreferredWidth(50);
        setInfoTable();
    }

    private void setInfoTable() {
        for (int k = 0; k < scout.getEquipiers().size(); k++) {
            int m = 0;
            table.addRow(new Object[]{scout.getEquipiers().get(k).getName(), scout.getEquipiers().get(k).getEquipe(), scout.getEquipiers().get(k).getDateOfBirth(), scout.getEquipiers().get(k).getMobile(), scout.getEquipiers().get(k).getNationalId(), "", "", scout.getEquipiers().get(k).getBonus(), scout.getEquipiers().get(k).getTotal()});
            int i = table.getRowCount();
            for (; m < scout.getEquipiers().get(k).getActivities().size(); i++) {
                int j = 5;
                if (scout.getEquipiers().get(k).getActivities().get(m).getActivityName().toLowerCase().contains("attendance") && m != 0) {
                    table.addRow(new Object[]{"", "", "", "", "", "", "", "", ""});
                    i++;
                }
                table.setValueAt(scout.getEquipiers().get(k).getActivities().get(m).getActivityName(), i - 1, j++);
                table.setValueAt(scout.getEquipiers().get(k).getActivities().get(m).getPoints(), i - 1, j++);
                m++;
                table.addRow(new Object[]{"", "", "", "", "", "", "", "", ""});
            }
            table.addRow(new Object[]{"", "", "", "", "", "", "", "", ""});
            if (scout.getEquipiers().get(k).getActivities().size() == 0) {
                table.addRow(new Object[]{"", "", "", "", "", "", "", "", ""});
            }
        }
    }

    private void sortByEquipe() {
        for (int i = 0; i < scout.getEquipiers().size() - 1; i++) {
            for (int j = 0; j < scout.getEquipiers().size() - i - 1; j++) {
                if (scout.getEquipiers().get(j).getEquipe().compareToIgnoreCase(scout.getEquipiers().get(j + 1).getEquipe()) < 0) {
                    Collections.swap(scout.getEquipiers(), j, j + 1);
                }
            }
        }
        table.setRowCount(0);
        setInfoTable();
    }

    private void sortByPoints() {
        for (int i = 0; i < scout.getEquipiers().size() - 1; i++) {
            for (int j = 0; j < scout.getEquipiers().size() - i - 1; j++) {
                if (scout.getEquipiers().get(j).getTotal() < scout.getEquipiers().get(j + 1).getTotal()) {
                    Collections.swap(scout.getEquipiers(), j, j + 1);
                }
            }
        }
        table.setRowCount(0);
        setInfoTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        infoTable = new javax.swing.JTable();
        scoutInfoLabel = new javax.swing.JLabel();
        sortLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        sortButton = new javax.swing.JButton();
        sortComboBox = new javax.swing.JComboBox<>();
        euipePointsButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        infoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Equipe", "Date of Birth", "Mobile", "National ID", "Activities", "Points", "Bonus", "Total"
            }
        ));
        jScrollPane1.setViewportView(infoTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 1050, 460));

        scoutInfoLabel.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        scoutInfoLabel.setForeground(new java.awt.Color(255, 255, 0));
        scoutInfoLabel.setText("Scout Data");
        getContentPane().add(scoutInfoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 7, 120, -1));

        sortLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sortLabel.setForeground(new java.awt.Color(255, 255, 255));
        sortLabel.setText("Sort by:");
        getContentPane().add(sortLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 103, -1, -1));

        backButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 85, 100, 50));

        sortButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sortButton.setText("Sort");
        sortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sortButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 85, 100, 50));

        sortComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Equipe", "Total Points" }));
        getContentPane().add(sortComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 120, -1));

        euipePointsButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        euipePointsButton.setText("Equipe Points");
        euipePointsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                euipePointsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(euipePointsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 85, 120, 50));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/Photos/WorldScouting.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        WelcomeGUI welcomeGUI = new WelcomeGUI(scout);
        welcomeGUI.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    private void sortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortButtonActionPerformed
        if (sortComboBox.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Please choose the way of sorting");
        } else if (sortComboBox.getSelectedIndex() == 1) {
            sortByEquipe();
        } else if (sortComboBox.getSelectedIndex() == 2) {
            sortByPoints();
        }
        try {
            scout.saveData();
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(RegisterGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sortButtonActionPerformed

    private void euipePointsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_euipePointsButtonActionPerformed
        int pantherePoints = 0, leopardPoints = 0;
        for (int i = 0; i < scout.getEquipiers().size(); i++){
            if(scout.getEquipiers().get(i).getEquipe().equalsIgnoreCase("Panthere")){
                pantherePoints += scout.getEquipiers().get(i).getTotal();
            } else if(scout.getEquipiers().get(i).getEquipe().equalsIgnoreCase("Leopard")){
                leopardPoints += scout.getEquipiers().get(i).getTotal();
            }
        }
        if(pantherePoints >= leopardPoints){
            JOptionPane.showMessageDialog(null, "Panthere: " + pantherePoints + " points\n" + "Leopard: " + leopardPoints + " points");
        } else {
            JOptionPane.showMessageDialog(null, "Leopard: " + leopardPoints + " points\n" + "Panthere: " + pantherePoints + " points");
        }
        
    }//GEN-LAST:event_euipePointsButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel background;
    private javax.swing.JButton euipePointsButton;
    private javax.swing.JTable infoTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel scoutInfoLabel;
    private javax.swing.JButton sortButton;
    private javax.swing.JComboBox<String> sortComboBox;
    private javax.swing.JLabel sortLabel;
    // End of variables declaration//GEN-END:variables
}
