/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package prefinals_exercise3.dialogs.item;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import prefinals_exercise3.SQLConfig;

public class EditItemDialog extends javax.swing.JDialog {
    private int id;
    private int quantity;

    public EditItemDialog(java.awt.Frame parent, boolean modal, int id, String itemName, String description, String category, double unitPrice, int quantityOnHand, int reorderLevel) {
        super(parent, modal);
        initComponents();
        this.id = id;
        itemNameField.setText(itemName);
        descriptionField.setText(description);
        loadCategories(category);
        unitPriceField.setText(String.format("%.2f", unitPrice));
        this.quantity = quantityOnHand;
        reorderLevelField.setText(String.valueOf(reorderLevel));
    }
    
    private void loadCategories(String selectedCategory) {
        try (Connection con = getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT category_name FROM Categories")) {

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            while (rs.next()) {
                model.addElement(rs.getString("category_name"));
            }
            cmbCategory.setModel(model);
            cmbCategory.setSelectedItem(selectedCategory);
        } catch (SQLException | ClassNotFoundException e) {
            showError(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        Container = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        itemNameField = new javax.swing.JTextField();
        cancelButton1 = new javax.swing.JButton();
        saveChangesButton = new javax.swing.JButton();
        offsetR = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();
        cmbCategory = new javax.swing.JComboBox<>();
        unitPriceField = new javax.swing.JTextField();
        reorderLevelField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(410, 810));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container.setBackground(new java.awt.Color(255, 255, 255));
        Container.setMaximumSize(new java.awt.Dimension(410, 810));
        Container.setMinimumSize(new java.awt.Dimension(410, 810));
        Container.setPreferredSize(new java.awt.Dimension(410, 810));
        Container.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ITEM");
        jLabel4.setMaximumSize(new java.awt.Dimension(410, 48));
        jLabel4.setMinimumSize(new java.awt.Dimension(410, 48));
        jLabel4.setPreferredSize(new java.awt.Dimension(410, 48));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 50, 0);
        Container.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Item Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 0);
        Container.add(jLabel5, gridBagConstraints);

        itemNameField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        itemNameField.setForeground(new java.awt.Color(51, 51, 51));
        itemNameField.setMaximumSize(new java.awt.Dimension(320, 32));
        itemNameField.setMinimumSize(new java.awt.Dimension(320, 32));
        itemNameField.setPreferredSize(new java.awt.Dimension(320, 32));
        itemNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNameFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        Container.add(itemNameField, gridBagConstraints);

        cancelButton1.setBackground(new java.awt.Color(230, 230, 230));
        cancelButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancelButton1.setForeground(new java.awt.Color(51, 51, 51));
        cancelButton1.setText("Cancel");
        cancelButton1.setBorderPainted(false);
        cancelButton1.setMaximumSize(new java.awt.Dimension(160, 32));
        cancelButton1.setMinimumSize(new java.awt.Dimension(160, 32));
        cancelButton1.setPreferredSize(new java.awt.Dimension(160, 32));
        cancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(80, 42, 80, 5);
        Container.add(cancelButton1, gridBagConstraints);

        saveChangesButton.setBackground(new java.awt.Color(0, 153, 153));
        saveChangesButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        saveChangesButton.setForeground(new java.awt.Color(255, 255, 255));
        saveChangesButton.setText("Save Changes");
        saveChangesButton.setBorderPainted(false);
        saveChangesButton.setMaximumSize(new java.awt.Dimension(160, 32));
        saveChangesButton.setMinimumSize(new java.awt.Dimension(160, 32));
        saveChangesButton.setPreferredSize(new java.awt.Dimension(160, 32));
        saveChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(80, 5, 80, 42);
        Container.add(saveChangesButton, gridBagConstraints);

        javax.swing.GroupLayout offsetRLayout = new javax.swing.GroupLayout(offsetR);
        offsetR.setLayout(offsetRLayout);
        offsetRLayout.setHorizontalGroup(
            offsetRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        offsetRLayout.setVerticalGroup(
            offsetRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        Container.add(offsetR, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Category:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 50, 0, 0);
        Container.add(jLabel6, gridBagConstraints);

        jScrollPane1.setMaximumSize(new java.awt.Dimension(320, 86));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(320, 86));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(320, 86));

        descriptionField.setColumns(20);
        descriptionField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        descriptionField.setLineWrap(true);
        descriptionField.setRows(5);
        descriptionField.setTabSize(20);
        descriptionField.setWrapStyleWord(true);
        jScrollPane1.setViewportView(descriptionField);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        Container.add(jScrollPane1, gridBagConstraints);

        cmbCategory.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbCategory.setMaximumSize(new java.awt.Dimension(320, 32));
        cmbCategory.setMinimumSize(new java.awt.Dimension(320, 32));
        cmbCategory.setPreferredSize(new java.awt.Dimension(320, 32));
        cmbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoryActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        Container.add(cmbCategory, gridBagConstraints);

        unitPriceField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        unitPriceField.setForeground(new java.awt.Color(51, 51, 51));
        unitPriceField.setMaximumSize(new java.awt.Dimension(320, 32));
        unitPriceField.setMinimumSize(new java.awt.Dimension(320, 32));
        unitPriceField.setPreferredSize(new java.awt.Dimension(320, 32));
        unitPriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitPriceFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        Container.add(unitPriceField, gridBagConstraints);

        reorderLevelField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        reorderLevelField.setForeground(new java.awt.Color(51, 51, 51));
        reorderLevelField.setMaximumSize(new java.awt.Dimension(320, 32));
        reorderLevelField.setMinimumSize(new java.awt.Dimension(320, 32));
        reorderLevelField.setPreferredSize(new java.awt.Dimension(320, 32));
        reorderLevelField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reorderLevelFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        Container.add(reorderLevelField, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Description:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 50, 0, 0);
        Container.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("Unit Price:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 50, 0, 0);
        Container.add(jLabel8, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 153));
        jLabel10.setText("Reorder Level:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 50, 0, 0);
        Container.add(jLabel10, gridBagConstraints);

        getContentPane().add(Container, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 840));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemNameFieldActionPerformed

    private void cancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButton1ActionPerformed

    private void saveChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesButtonActionPerformed
        String itemName = itemNameField.getText().trim();
        String description = descriptionField.getText().trim();
        String category = (String) cmbCategory.getSelectedItem();
        String unitPriceStr = unitPriceField.getText().trim();
        String reorderLevelStr = reorderLevelField.getText().trim();

        if (itemName.isEmpty() || description.isEmpty() || category == null || unitPriceStr.isEmpty() || reorderLevelStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill out all the necessary fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double unitPrice = Double.parseDouble(unitPriceStr);
            int reorderLevel = Integer.parseInt(reorderLevelStr);

            try (Connection con = getConnection();
                 PreparedStatement pstmt = con.prepareStatement("UPDATE Items SET item_name = ?, description = ?, category_id = (SELECT category_id FROM Categories WHERE category_name = ?), unit_price = ?, quantity_on_hand = ?, reorder_level = ? WHERE item_id = ?")) {
                pstmt.setString(1, itemName);
                pstmt.setString(2, description);
                pstmt.setString(3, category);
                pstmt.setDouble(4, unitPrice);
                pstmt.setInt(5, this.quantity);
                pstmt.setInt(6, reorderLevel);
                pstmt.setInt(7, this.id);
                pstmt.executeUpdate();
                dispose();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for unit price and reorder level.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException | ClassNotFoundException e) {
            showError(e);
        }
    }//GEN-LAST:event_saveChangesButtonActionPerformed

    private void cmbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoryActionPerformed

    private void unitPriceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitPriceFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitPriceFieldActionPerformed

    private void reorderLevelFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reorderLevelFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reorderLevelFieldActionPerformed

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        SQLConfig sql = new SQLConfig();
        String DB_URL = sql.getDbUrl();
        String DB_USER = sql.getDbUser();
        String DB_PASSWORD = sql.getDbPassword();
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    private void showError(Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditItemDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditItemDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditItemDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditItemDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditItemDialog dialog = new EditItemDialog(new javax.swing.JFrame(), true, 1, "v0", "v1", "v2", 0.0, 1, 1);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JButton cancelButton1;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JTextArea descriptionField;
    private javax.swing.JTextField itemNameField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel offsetR;
    private javax.swing.JTextField reorderLevelField;
    private javax.swing.JButton saveChangesButton;
    private javax.swing.JTextField unitPriceField;
    // End of variables declaration//GEN-END:variables
}