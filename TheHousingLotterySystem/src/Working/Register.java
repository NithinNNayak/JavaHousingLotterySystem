/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Working;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Himanshu
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
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
        jLabel3 = new javax.swing.JLabel();
        newuser = new javax.swing.JTextField();
        newreg = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        newpassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter Username :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 160, 41));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" Create Password :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 160, 48));

        newuser.setBackground(new java.awt.Color(204, 255, 204));
        newuser.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        getContentPane().add(newuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 290, 41));

        newreg.setBackground(new java.awt.Color(0, 204, 102));
        newreg.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        newreg.setForeground(new java.awt.Color(255, 255, 255));
        newreg.setText("REGISTER");
        newreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newregActionPerformed(evt);
            }
        });
        getContentPane().add(newreg, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, -1, 50));

        jPanel1.setBackground(new java.awt.Color(0, 153, 82));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTER");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 60));

        newpassword.setBackground(new java.awt.Color(204, 255, 204));
        newpassword.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(newpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 290, 40));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Working/formbg.jpg"))); // NOI18N
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 650, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newregActionPerformed
       try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/maindb", "root", "");
            String usname  = newuser.getText();
            String pasw = newpassword.getText();
            Statement stm = con.createStatement();
           String sql = "INSERT INTO logindetails (username, passkey) VALUES (?, ?)";
           PreparedStatement pstmt = con.prepareStatement(sql);
    pstmt.setString(1, usname);
    pstmt.setString(2, pasw);
    int rowsAffected = pstmt.executeUpdate();
            if(rowsAffected > 0) {
                dispose();
                JOptionPane.showMessageDialog(this, "User Registered Successfully");
                dispose();
                 loginpage logg = new loginpage();
                 logg.show();

            }else {
                JOptionPane.showMessageDialog(this, "Do not leave the field empty.");
                dispose();
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_newregActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newpassword;
    private javax.swing.JButton newreg;
    private javax.swing.JTextField newuser;
    // End of variables declaration//GEN-END:variables
}
