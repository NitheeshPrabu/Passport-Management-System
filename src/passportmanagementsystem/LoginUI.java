/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passportmanagementsystem;

import javax.swing.JOptionPane;

/**
 *
 * @author nithe
 */
public class LoginUI extends javax.swing.JFrame {

    protected boolean validUsername, validPassword;
    protected String username, password;
    private Login l;
    
    /**
     * Creates new form NewJFrame
     */
    public LoginUI() {
        initComponents();
        validUsername = validPassword = false;
        l = new Login();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameTxtField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordTxtField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        registerNewLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setMinimumSize(new java.awt.Dimension(0, 10));
        setName("LoginJFrame"); // NOI18N
        setResizable(false);

        usernameTxtField.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        usernameTxtField.setToolTipText("Enter username");
        usernameTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameTxtFieldFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel2.setText("Password:");

        passwordTxtField.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        passwordTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordTxtFieldFocusLost(evt);
            }
        });

        loginButton.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        loginButton.setText("Login");
        loginButton.setEnabled(false);
        loginButton.setMinimumSize(new java.awt.Dimension(75, 54));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setText("Passport Management System");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel1.setText("Username:");

        registerNewLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        registerNewLabel.setForeground(new java.awt.Color(0, 51, 255));
        registerNewLabel.setText("New user? Register here");
        registerNewLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerNewLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerNewLabelMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel5.setText("User Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordTxtField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(usernameTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(registerNewLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(jLabel5)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(31, 31, 31)
                .addComponent(jLabel5)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(usernameTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(passwordTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(registerNewLabel)
                .addGap(26, 26, 26)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getUsername() {
        return usernameTxtField.getText().trim();
    }
    
    public String getPass() {
        return new String(passwordTxtField.getPassword());
    }
    
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        username = getUsername();
        password = getPass();
        String role = l.login(username,password);
        if(role.equals("user")) {
            Applicant applicant = new Applicant();
            applicant.openApplicationUI();
        } else if(role.equals("admin")) {
            SystemAdmin admin = new SystemAdmin();
            admin.openStatusUI();
        }
        this.setVisible(false);
    }//GEN-LAST:event_loginButtonActionPerformed

    private void registerNewLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerNewLabelMouseClicked
        new RegisterUI().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_registerNewLabelMouseClicked

    private void usernameTxtFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameTxtFieldFocusLost
        String username = getUsername();
        if(username.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Please enter username");
            validUsername = false;
        } else {
            validUsername = true;
        }
        loginButton.setEnabled(validUsername && validPassword);
    }//GEN-LAST:event_usernameTxtFieldFocusLost

    private void passwordTxtFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordTxtFieldFocusLost
        String password = getPass();
        if(password.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Please enter password");
            validPassword = false;
        } else {
            validPassword = true;
        }
        loginButton.setEnabled(validUsername && validPassword);
    }//GEN-LAST:event_passwordTxtFieldFocusLost

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
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordTxtField;
    private javax.swing.JLabel registerNewLabel;
    private javax.swing.JTextField usernameTxtField;
    // End of variables declaration//GEN-END:variables
}