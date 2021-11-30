/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thi_s
 */
public class Utils {
    public static String federativeUnit[]={"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
    
public static boolean sendMessage(Socket connection, String message) {
        try {
            DataOutputStream output = new DataOutputStream(connection.getOutputStream());
            output.flush();
            output.write((message +"\n").getBytes("UTF-8"));
            output.flush();
            System.out.println("Mensagem enviada: " + message);
            output.flush();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static String receiveMessage(Socket connection) {
        
        String response = null;

        try {
            DataInputStream input = new DataInputStream(connection.getInputStream());
            response = input.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return response;
    }
}
