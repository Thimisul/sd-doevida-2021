/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany.sdclient2;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Utils;

/**
 *
 * @author thi_s
 */
public class Chat extends javax.swing.JFrame implements Runnable {

    Socket server;

    private String receptor;
    private ArrayList<String> message_list;

    ObjectOutputStream saida;
    ObjectInputStream entrada;

    Chat(String receptor, Socket server) {
        super("Chat com " + receptor);
        this.server = server;
        this.receptor = receptor;
        initComponents();
        message_list = new ArrayList<String>();
        newStart();
    }
    
        Chat(Socket server) {
        this.server = server;
        this.receptor = receptor;
        initComponents();
        message_list = new ArrayList<String>();
        newStart();
    }

    public void newStart() {
        this.pack();
        this.setVisible(true);
        Thread threadChat = new Thread(this);
        threadChat.start();
        
    }

    public void append_message(String received) {
        message_list.add(received);
        String message = "";
        for (String str : message_list) {
            message += str;
        }
        jEPMessages.setText(message);
    }

    public void send() {
//        try {
            //saida = null;
            //saida = new ObjectOutputStream(server.getOutputStream());
            //saida.writeObject(jTFMessage.getText());
            
            Utils.sendMessage(server, jTFMessage.getText());
            
            DateFormat df = new SimpleDateFormat("hh:mm:ss");
            append_message("<b>[" + df.format(new Date()) + "] Eu: <b><i>" + jTFMessage.getText() + "</i><br>");
            jTFMessage.setText("");
//        } catch (IOException ex) {
//            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
        jTFMessage = new javax.swing.JTextField();
        jBSendMessage = new javax.swing.JButton();
        jPReceptor1 = new javax.swing.JPanel();
        jSPMessages1 = new javax.swing.JScrollPane();
        jEPMessages = new javax.swing.JEditorPane();
        jPDonations1 = new javax.swing.JPanel();
        jBrs3 = new javax.swing.JButton();
        jBrs11 = new javax.swing.JButton();
        jBrs21 = new javax.swing.JButton();
        jBrs51 = new javax.swing.JButton();
        jBrs101 = new javax.swing.JButton();
        jBrs201 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite uma mensagem: "));

        jTFMessage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFMessageKeyPressed(evt);
            }
        });

        jBSendMessage.setText("Enviar");
        jBSendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSendMessageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTFMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBSendMessage))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSendMessage))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPReceptor1.setBorder(javax.swing.BorderFactory.createTitledBorder("Receptador"));

        jEPMessages.setEditable(false);
        jEPMessages.setContentType("text/html"); // NOI18N
        jSPMessages1.setViewportView(jEPMessages);
        jEPMessages.getAccessibleContext().setAccessibleName("");

        jPDonations1.setBorder(javax.swing.BorderFactory.createTitledBorder("Doações"));

        jBrs3.setText("R$ 2,00");
        jBrs3.setMaximumSize(new java.awt.Dimension(83, 25));
        jBrs3.setMinimumSize(new java.awt.Dimension(83, 25));
        jBrs3.setPreferredSize(new java.awt.Dimension(83, 25));
        jBrs3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrs3ActionPerformed(evt);
            }
        });
        jPDonations1.add(jBrs3);

        jBrs11.setText("R$ 10,00");
        jBrs11.setMaximumSize(new java.awt.Dimension(83, 25));
        jBrs11.setMinimumSize(new java.awt.Dimension(83, 25));
        jBrs11.setPreferredSize(new java.awt.Dimension(83, 25));
        jPDonations1.add(jBrs11);

        jBrs21.setText("R$ 20,00");
        jBrs21.setMaximumSize(new java.awt.Dimension(83, 25));
        jBrs21.setMinimumSize(new java.awt.Dimension(83, 25));
        jBrs21.setPreferredSize(new java.awt.Dimension(83, 25));
        jBrs21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBrs21ActionPerformed(evt);
            }
        });
        jPDonations1.add(jBrs21);

        jBrs51.setText("R$ 50,00");
        jBrs51.setPreferredSize(new java.awt.Dimension(83, 25));
        jPDonations1.add(jBrs51);

        jBrs101.setText("R$ 100,00");
        jPDonations1.add(jBrs101);

        jBrs201.setText("R$ 200,00");
        jPDonations1.add(jBrs201);

        javax.swing.GroupLayout jPReceptor1Layout = new javax.swing.GroupLayout(jPReceptor1);
        jPReceptor1.setLayout(jPReceptor1Layout);
        jPReceptor1Layout.setHorizontalGroup(
            jPReceptor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPReceptor1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPReceptor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPDonations1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSPMessages1))
                .addContainerGap())
        );
        jPReceptor1Layout.setVerticalGroup(
            jPReceptor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPReceptor1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSPMessages1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPDonations1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPReceptor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPReceptor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSendMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSendMessageActionPerformed
        send();
    }//GEN-LAST:event_jBSendMessageActionPerformed

    private void jTFMessageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFMessageKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            send();
        }
    }//GEN-LAST:event_jTFMessageKeyPressed

    private void jBrs3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrs3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBrs3ActionPerformed

    private void jBrs21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBrs21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBrs21ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSendMessage;
    private javax.swing.JButton jBrs101;
    private javax.swing.JButton jBrs11;
    private javax.swing.JButton jBrs201;
    private javax.swing.JButton jBrs21;
    private javax.swing.JButton jBrs3;
    private javax.swing.JButton jBrs51;
    private javax.swing.JEditorPane jEPMessages;
    private javax.swing.JPanel jPDonations1;
    private javax.swing.JPanel jPReceptor1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jSPMessages1;
    private javax.swing.JTextField jTFMessage;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
         DateFormat df = new SimpleDateFormat("hh:mm:ss");
        while (true) {        
                String msgReceive = Utils.receiveMessage(server);
             try {
                 append_message("<b>[" + df.format(new Date()) + "]"+  server.getOutputStream() + " : <b><i>" + msgReceive + "</i><br>");
             } catch (IOException ex) {
                 Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }
}
