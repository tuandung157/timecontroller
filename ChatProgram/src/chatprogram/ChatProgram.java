/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatprogram;

import ProgramLab.Police;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author theph
 */
public class ChatProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Runnable receiving_thread=null;
        Socket sock = null;
        try {
            sock = new Socket("127.0.0.1", 3000);
            // reading from keyboard (keyRead object)
            BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
            // sending to client (pwrite object)
            OutputStream ostream = sock.getOutputStream();
            PrintWriter pwrite = new PrintWriter(ostream, true);
            // receiving from server ( receiveRead  object)
            InputStream istream = sock.getInputStream();
            
            ObjectInputStream ois = new ObjectInputStream(istream);
            //BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
            System.out.println("Start the chitchat, type and press Enter key");
            String sendMessage;
            //receiving_thread = (Runnable) new Runnable() {
            //    @Override
            //    public void run() {
                    while(true){
                        try {
                            pwrite.println("sent message");       // sending to server
                pwrite.flush();     
                            ConcurrentSkipListSet<Police> receiveMessage;
                            if ((receiveMessage = (ConcurrentSkipListSet<Police>) ois.readObject()) != null) //receive from server
                            {
                                System.out.println(receiveMessage.size());
                                for (Police police : receiveMessage) {
                                    System.out.println(police.toString()); // displaying at DOS prompt
                                }
                                
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(ChatProgram.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(ChatProgram.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                //}
            //};
            /*while (true) {
                sendMessage = keyRead.readLine();  // keyboard reading
                pwrite.println(sendMessage);       // sending to server
                pwrite.flush();     
            }*/
        } catch (IOException ex) {
            Logger.getLogger(ChatProgram.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(sock!=null&& sock.isConnected()) try {
                sock.close();
            } catch (IOException ex) {
                Logger.getLogger(ChatProgram.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
