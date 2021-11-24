/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.sdclient2;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import utils.Utils;

/**
 *
 * @author thi_s
 */
public class Login extends javax.swing.JFrame {

Socket connection;
    ObjectOutputStream saida;

    public Login(Socket connection) { 
        this.connection = connection;
        initComponents();
        start();
    }

    private void start(){
        this.pack();
        this.setVisible(true); 
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTGiAm = new javax.swing.ButtonGroup();
        jPReceptor = new javax.swing.JPanel();
        jLLogin = new javax.swing.JLabel();
        jTFLogin = new javax.swing.JTextField();
        jLPassword = new javax.swing.JLabel();
        jPFPassword = new javax.swing.JPasswordField();
        jBLogin = new javax.swing.JButton();
        jBCreateReceptor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPReceptor.setBorder(javax.swing.BorderFactory.createTitledBorder("Bem Vindo"));

        jLLogin.setText("Login:");

        jTFLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFLoginActionPerformed(evt);
            }
        });

        jLPassword.setText("Password:");

        jBLogin.setText("Login");
        jBLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLoginActionPerformed(evt);
            }
        });

        jBCreateReceptor.setText("Ainda não tenho uma conta");
        jBCreateReceptor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCreateReceptorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPReceptorLayout = new javax.swing.GroupLayout(jPReceptor);
        jPReceptor.setLayout(jPReceptorLayout);
        jPReceptorLayout.setHorizontalGroup(
            jPReceptorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPReceptorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPReceptorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBCreateReceptor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addGroup(jPReceptorLayout.createSequentialGroup()
                        .addGroup(jPReceptorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLLogin)
                            .addComponent(jLPassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPReceptorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPFPassword)
                            .addComponent(jTFLogin))))
                .addContainerGap())
        );
        jPReceptorLayout.setVerticalGroup(
            jPReceptorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPReceptorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPReceptorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPReceptorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPassword)
                    .addComponent(jPFPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jBLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBCreateReceptor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPReceptor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCreateReceptorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCreateReceptorActionPerformed
        new ReceptorsCreate(connection).setVisible(true);//que quer abrir
        dispose();
    }//GEN-LAST:event_jBCreateReceptorActionPerformed

    private void jBLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLoginActionPerformed
    try {
        JSONObject login = new JSONObject();
        JSONObject loginMessage = new JSONObject();
        
        loginMessage.put("username", jTFLogin.getText());
        loginMessage.put("password", jPFPassword.getText());
        login.put("protocol", 100);
        login.put("message", loginMessage);
        Utils.sendMessage(connection, login.toString());
        String messageJson = Utils.receiveMessage(connection);
        JSONObject jsonO = new JSONObject(messageJson);
        Integer protocol = (Integer) jsonO.opt("protocol");
        System.out.println("mensagem de resposta --->>>" + messageJson);
            if(protocol == 101){
                System.out.println("Login ok");
                new LandingPage(connection);
                dispose();
            }else if(protocol == 102){
                JSONObject jsonMessageO = new JSONObject(jsonO.opt("message"));
                System.err.println(jsonMessageO.opt("reason")); 
            }
                
    } catch (JSONException ex) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jBLoginActionPerformed

    private void jTFLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFLoginActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BTGiAm;
    private javax.swing.JButton jBCreateReceptor;
    private javax.swing.JButton jBLogin;
    private javax.swing.JLabel jLLogin;
    private javax.swing.JLabel jLPassword;
    private javax.swing.JPasswordField jPFPassword;
    private javax.swing.JPanel jPReceptor;
    private javax.swing.JTextField jTFLogin;
    // End of variables declaration//GEN-END:variables
}
