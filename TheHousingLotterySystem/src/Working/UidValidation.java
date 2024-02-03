/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Working;

/**
 *
 * @author Himanshu
 */
import java.sql.*;
import javax.swing.*;
public class UidValidation extends javax.swing.JFrame {

    /**
     * Creates new form UidValidation
     */
    public UidValidation() {
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

        jLabel2 = new javax.swing.JLabel();
        uniqueid = new javax.swing.JTextField();
        proceed = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(500, 200));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("UID NO  :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, 58));

        uniqueid.setBackground(new java.awt.Color(204, 255, 204));
        uniqueid.setFont(new java.awt.Font("Imprint MT Shadow", 0, 24)); // NOI18N
        getContentPane().add(uniqueid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 350, 50));

        proceed.setBackground(new java.awt.Color(0, 204, 102));
        proceed.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        proceed.setForeground(new java.awt.Color(255, 255, 255));
        proceed.setText("PROCEED");
        proceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedActionPerformed(evt);
            }
        });
        getContentPane().add(proceed, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 151, 45));

        jPanel1.setBackground(new java.awt.Color(0, 153, 82));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("UID VALIDATION");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 70));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Working/formbg.jpg"))); // NOI18N
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 550, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void proceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedActionPerformed
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/genInfo", "root", "");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/maindb", "root", "");
            String unique  = uniqueid.getText();
           
            Statement stm = con.createStatement();
            Statement stmm = conn.createStatement();
            
           String sql = "SELECT reguid FROM registereduid WHERE reguid=?";
            PreparedStatement pstmtt = conn.prepareStatement(sql);
            pstmtt.setString(1, unique);
            ResultSet rss = pstmtt.executeQuery();
            if(rss.next())
            {
                JOptionPane.showMessageDialog(this, "You can register only once. ");
                this.dispose();
            }
            else {
            
             sql = "SELECT UID FROM generalInformation WHERE UID=?";
           
           PreparedStatement pstmt = con.prepareStatement(sql);
   	 pstmt.setString(1, unique);
   	 ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                this.dispose();
                BasicForm b = new BasicForm();
                b.unique = uniqueid.getText();
                Form2 ff = new Form2();
                ff.ruid = uniqueid.getText();
                b.show();
            
              

            }else {
                JOptionPane.showMessageDialog(this, "Username or password  incorrect...");
                uniqueid.setText("");
               dispose(); 
            } 
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_proceedActionPerformed

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
            java.util.logging.Logger.getLogger(UidValidation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UidValidation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UidValidation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UidValidation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UidValidation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton proceed;
    private javax.swing.JTextField uniqueid;
    // End of variables declaration//GEN-END:variables
}