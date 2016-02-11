/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publickeyinfrastructure;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author somil
 */
public class NoCertificate extends javax.swing.JFrame {

    /**
     * Creates new form NoCertificate
     */
    boolean CAHostName=false;
    public NoCertificate() {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jProxyLabel5 = new javax.swing.JLabel();
        jCAIPLabel = new javax.swing.JLabel();
        jUserName = new javax.swing.JLabel();
        jMyUNameField = new javax.swing.JTextField();
        jUserName1 = new javax.swing.JLabel();
        jCANameField = new javax.swing.JTextField();
        jUserName2 = new javax.swing.JLabel();
        jSerialNo = new javax.swing.JTextField();
        jApplyButton = new javax.swing.JButton();
        jGenerateKey = new javax.swing.JButton();
        jCAIPLabel1 = new javax.swing.JLabel();
        jCAIPfield1 = new javax.swing.JTextField();
        jUserName3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(208, 159, 251));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setToolTipText("CertificateNotPresent");

        jTextArea1.setBackground(new java.awt.Color(177, 130, 238));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(15, 15, 19));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("You do not possess the certificate issued by a trusted Certifying Authority. \nFirst get yourself registered at a valid Certifying Authority. Then enter the following details to obtain certificate and start the transactions. \nCarefully note down the generated public key and remember the password to be submitted at the registration desk.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setOpaque(false);
        jScrollPane1.setViewportView(jTextArea1);

        jProxyLabel5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jProxyLabel5.setForeground(new java.awt.Color(161, 17, 0));
        jProxyLabel5.setText("IPv6 not supported");
        jProxyLabel5.setFocusable(false);
        jProxyLabel5.setRequestFocusEnabled(false);

        jCAIPLabel.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jCAIPLabel.setForeground(new java.awt.Color(24, 0, 161));
        jCAIPLabel.setText("Certifying Authority Address/Hostname:");
        jCAIPLabel.setFocusable(false);
        jCAIPLabel.setRequestFocusEnabled(false);

        jUserName.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jUserName.setForeground(new java.awt.Color(57, 0, 251));
        jUserName.setText("Our UserName(as registered with Certifying Authority) ");
        jUserName.setFocusable(false);
        jUserName.setRequestFocusEnabled(false);

        jMyUNameField.setFont(new java.awt.Font("TlwgTypewriter", 0, 15)); // NOI18N

        jUserName1.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jUserName1.setForeground(new java.awt.Color(21, 0, 251));
        jUserName1.setText("Certificate Serial No.(as issued by CA)");
        jUserName1.setFocusable(false);
        jUserName1.setRequestFocusEnabled(false);

        jCANameField.setFont(new java.awt.Font("TlwgTypewriter", 0, 15)); // NOI18N

        jUserName2.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jUserName2.setForeground(new java.awt.Color(21, 0, 251));
        jUserName2.setText("Name of the Certified Authority(as issued in certificates)");
        jUserName2.setFocusable(false);
        jUserName2.setRequestFocusEnabled(false);

        jSerialNo.setFont(new java.awt.Font("TlwgTypewriter", 0, 15)); // NOI18N

        jApplyButton.setBackground(new java.awt.Color(185, 164, 216));
        jApplyButton.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jApplyButton.setText("Obtain Certificate and Start");
        jApplyButton.setActionCommand("jDownloadButton");
        jApplyButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jApplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jApplyButtonActionPerformed(evt);
            }
        });

        jGenerateKey.setBackground(new java.awt.Color(185, 164, 216));
        jGenerateKey.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jGenerateKey.setText("Generate Public Key");
        jGenerateKey.setActionCommand("jDownloadButton");
        jGenerateKey.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jGenerateKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGenerateKeyActionPerformed(evt);
            }
        });

        jCAIPLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jCAIPLabel1.setForeground(new java.awt.Color(161, 16, 0));
        jCAIPLabel1.setText("YOUR ADVERTISING PUBLIC KEY");
        jCAIPLabel1.setFocusable(false);
        jCAIPLabel1.setRequestFocusEnabled(false);

        jCAIPfield1.setFont(new java.awt.Font("TlwgTypewriter", 0, 15)); // NOI18N
        jCAIPfield1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jCAIPfield1FocusLost(evt);
            }
        });

        jUserName3.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jUserName3.setForeground(new java.awt.Color(21, 0, 251));
        jUserName3.setText("Password - The one you entered at the registration");
        jUserName3.setFocusable(false);
        jUserName3.setRequestFocusEnabled(false);

        jPasswordField1.setDragEnabled(true);
        jPasswordField1.setEchoChar(~);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jUserName2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jUserName1))
                                    .addComponent(jUserName3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSerialNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                    .addComponent(jCANameField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPasswordField1)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jCAIPLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jProxyLabel5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jUserName)
                                        .addGap(3, 3, 3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jCAIPLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jMyUNameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                    .addComponent(jCAIPfield1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))))
                        .addGap(91, 91, 91))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jApplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jGenerateKey, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jGenerateKey, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCAIPLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCAIPLabel)
                    .addComponent(jProxyLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCAIPfield1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMyUNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUserName2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCANameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jSerialNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jUserName3, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jPasswordField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jApplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jApplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jApplyButtonActionPerformed
        if(jMyUNameField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Registered Name not mentioned", "Error",
                JOptionPane.ERROR_MESSAGE);
            jMyUNameField.requestFocus();return;
        }
        if(jSerialNo.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Serial Number Essential for verification", "Error",
                JOptionPane.ERROR_MESSAGE);
         jSerialNo.requestFocus(); return;
        }
        if( jCAIPfield.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Certifying Authority Address required in for certificate", "Error",
                JOptionPane.ERROR_MESSAGE);
            jCAIPfield.requestFocus(); return;
        }
       if(jCANameField.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Certified Authority Name not mentioned", "Error",
                JOptionPane.ERROR_MESSAGE);
            jCANameField.requestFocus();return;
        
        }
        
    }//GEN-LAST:event_jApplyButtonActionPerformed

    private void jGenerateKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGenerateKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jGenerateKeyActionPerformed

    private void jCAIPfield1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jCAIPfield1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jCAIPfield1FocusLost

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
            java.util.logging.Logger.getLogger(NoCertificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NoCertificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NoCertificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NoCertificate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NoCertificate().setVisible(true);
            }
        });
    }
     private static class LoadCertificate extends Thread {

        NoCertificate board;
        public LoadCertificate(NoCertificate d) {
            board=d;
        }

        @Override
        public void run() {
            board.jApplyButton.setFocusable(false);
            board.jApplyButton.setText("Requesting Certificate...");
         fsdfsdfs   
        }
        
    }
      void DisplayMessage(String str, String title,int choice)
{
  if(choice==0)
  JOptionPane.showMessageDialog(this,
                    str, title,
                    JOptionPane.ERROR_MESSAGE);
  else 
      JOptionPane.showMessageDialog(this,
                    str, title,
                    JOptionPane.INFORMATION_MESSAGE);
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jApplyButton;
    private javax.swing.JLabel jCAIPLabel;
    private javax.swing.JLabel jCAIPLabel1;
    private javax.swing.JTextField jCAIPfield1;
    private javax.swing.JTextField jCANameField;
    private javax.swing.JButton jGenerateKey;
    private javax.swing.JTextField jMyUNameField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel jProxyLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSerialNo;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel jUserName;
    private javax.swing.JLabel jUserName1;
    private javax.swing.JLabel jUserName2;
    private javax.swing.JLabel jUserName3;
    // End of variables declaration//GEN-END:variables
}