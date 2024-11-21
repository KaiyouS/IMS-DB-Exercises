/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package prefinals_exercise3.dialogs.transaction;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JOptionPane; 
import jdk.jfr.Description;
import prefinals_exercise3.SQLConfig;
import prefinals_exercise3.dialogs.item.*;

public class ViewTransactionDialog extends javax.swing.JDialog {
    private int id;

    public ViewTransactionDialog(java.awt.Frame parent, boolean modal, int id) {
        super(parent, modal);
        this.id = id;
        initComponents();
        loadDataAndDisplay();
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
        jLabel1 = new javax.swing.JLabel();
        resultLabel = new javax.swing.JLabel();
        doneButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(410, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container.setBackground(new java.awt.Color(255, 255, 255));
        Container.setMaximumSize(new java.awt.Dimension(410, 600));
        Container.setMinimumSize(new java.awt.Dimension(410, 600));
        Container.setPreferredSize(new java.awt.Dimension(410, 600));
        Container.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANSACTION");
        jLabel1.setMaximumSize(new java.awt.Dimension(410, 48));
        jLabel1.setMinimumSize(new java.awt.Dimension(410, 48));
        jLabel1.setPreferredSize(new java.awt.Dimension(410, 48));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(50, 0, 50, 0);
        Container.add(jLabel1, gridBagConstraints);

        resultLabel.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        resultLabel.setForeground(new java.awt.Color(51, 51, 51));
        resultLabel.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        Container.add(resultLabel, gridBagConstraints);

        doneButton.setBackground(new java.awt.Color(0, 153, 153));
        doneButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        doneButton.setForeground(new java.awt.Color(255, 255, 255));
        doneButton.setText("Done");
        doneButton.setBorderPainted(false);
        doneButton.setMaximumSize(new java.awt.Dimension(160, 32));
        doneButton.setMinimumSize(new java.awt.Dimension(160, 32));
        doneButton.setPreferredSize(new java.awt.Dimension(160, 32));
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(80, 42, 80, 42);
        Container.add(doneButton, gridBagConstraints);

        getContentPane().add(Container, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        dispose();
    }//GEN-LAST:event_doneButtonActionPerformed

    public void loadDataAndDisplay() {
        // Query to get transaction details
        String query = "SELECT t.transaction_id, i.item_name, t.transaction_date, t.quantity, t.transaction_type, t.notes " +
                       "FROM Transactions t " +
                       "LEFT JOIN Items i ON t.item_id = i.item_id " +
                       "WHERE t.transaction_id = ?";
        
        Map<String, String> dataMap = getDataFromDatabase(query, id);
        
        String alignedData = printAlignedList(dataMap);
        
        resultLabel.setFont(new Font("Courier New", Font.PLAIN, 14));
        resultLabel.setText("<html>" + alignedData.replace("\n", "<br>") + "</html>");
    }

    public Map<String, String> getDataFromDatabase(String query, int id) {
        Map<String, String> result = new LinkedHashMap<>();
        
        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                result.put("Transaction ID", String.valueOf(rs.getInt("transaction_id")));
                result.put("Item Name", rs.getString("item_name"));
                result.put("Transaction Date", rs.getString("transaction_date"));
                result.put("Quantity", String.valueOf(rs.getInt("quantity")));
                result.put("Transaction Type", rs.getString("transaction_type"));
                result.put("Notes", rs.getString("notes"));
            }
            
        } catch (Exception e) {
            showError(e);
        }
        
        return result;
    }

    public String printAlignedList(Map<String, String> items) {
        int maxKeyLength = 0;
        for (String key : items.keySet()) {
            if (key.length() > maxKeyLength) {
                maxKeyLength = key.length();
            }
        }

        StringBuilder alignedText = new StringBuilder();
        for (Map.Entry<String, String> entry : items.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.equals("Notes")) {
                StringBuilder wrappedNotes = new StringBuilder();
                int index = 0;
                int length = 35;
                while (index < value.length()) {
                    int endIndex = Math.min(index + length, value.length());
                    wrappedNotes.append(value, index, endIndex).append("\n    "); // Indent after newline
                    index += length;
                }

                // Format the notes with wrapping
                String formatted = String.format("%n%-" + (maxKeyLength + 2) + "s:%n    %s%n%n", key, wrappedNotes.toString().trim());
                formatted = formatted.replace(" ", "&nbsp;");
                alignedText.append(formatted);
                continue;
            }
            String formatted = String.format("%-" + (maxKeyLength + 2) + "s: %s%n", key, value);
            formatted = formatted.replace(" ", "&nbsp;");
            alignedText.append(formatted);
            
        }
        return alignedText.toString();
    }    
    
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
            java.util.logging.Logger.getLogger(ViewTransactionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTransactionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTransactionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTransactionDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewTransactionDialog dialog = new ViewTransactionDialog(new javax.swing.JFrame(), true, 1);
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
    private javax.swing.JButton doneButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel resultLabel;
    // End of variables declaration//GEN-END:variables
}