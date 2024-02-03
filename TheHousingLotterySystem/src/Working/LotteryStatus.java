/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Working;

/**
 *
 * @author Himanshu
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
public class LotteryStatus extends javax.swing.JFrame {

    /**
     * Creates new form LotteryStatus
     */
    public LotteryStatus() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        sshhooww = new javax.swing.JButton();
        BACK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        atable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 204, 0));
        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 60)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Allotment Status");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 520, 70));

        sshhooww.setBackground(new java.awt.Color(0, 153, 82));
        sshhooww.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        sshhooww.setForeground(new java.awt.Color(255, 255, 255));
        sshhooww.setText("Show");
        sshhooww.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sshhoowwActionPerformed(evt);
            }
        });
        getContentPane().add(sshhooww, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 30, 200, 60));

        BACK.setBackground(new java.awt.Color(255, 0, 0));
        BACK.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        BACK.setForeground(new java.awt.Color(255, 255, 255));
        BACK.setText("BACK");
        BACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BACKActionPerformed(evt);
            }
        });
        getContentPane().add(BACK, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 200, 60));

        atable.setAutoCreateRowSorter(true);
        atable.setBackground(new java.awt.Color(204, 255, 204));
        atable.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        atable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        atable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lottery Number", "UID", "Name", "House ID", "House Type", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(atable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 1390, 600));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Working/formbg.jpg"))); // NOI18N
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1650, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sshhoowwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sshhoowwActionPerformed
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/maindb", "root", "");
            String sql = "SELECT Lotno, Finuid, Finname, did, ttype, dadd FROM ResultOutcome";
            PreparedStatement psmt = con.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            DefaultTableModel modell = new DefaultTableModel();

            // Get column names
            int columnCount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                modell.addColumn(rs.getMetaData().getColumnName(i));
            }

            // Populate the table with data
            while (rs.next()) {
                String alotno = rs.getString("Lotno");
                String afinuid = rs.getString("Finuid");
                String afinname = rs.getString("Finname");
                String adid = rs.getString("did");
                String atype = rs.getString("ttype");
                String ahad = rs.getString("dadd");

                String tbldata[] = {alotno, afinuid, afinname, adid, atype, ahad};
                DefaultTableModel tblModel = (DefaultTableModel)atable.getModel();
                tblModel.addRow(tbldata);
            }
            rs.close();
            psmt.close();
            con.close();
            sshhooww.setEnabled(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_sshhoowwActionPerformed

    private void BACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BACKActionPerformed
        this.dispose();
    }//GEN-LAST:event_BACKActionPerformed

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
            java.util.logging.Logger.getLogger(LotteryStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LotteryStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LotteryStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LotteryStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LotteryStatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BACK;
    private javax.swing.JTable atable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sshhooww;
    // End of variables declaration//GEN-END:variables
}
