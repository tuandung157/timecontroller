/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatprogramserver;

import ProgramLab.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author theph
 */
public class ChatProgramServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ConcurrentSkipListSet<Police> csSet = new ConcurrentSkipListSet<>();

        String fileName = System.getProperty("user.home") + "\\" + "polices.csv";

        try {
            CsvFile.loadCsvFile(fileName, csSet);
        }catch (IOException ex) {
            Logger.getLogger(ChatProgramServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ChatProgramServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Date Loaded In!");
        
        
        try {
            ServerSocket sersock = new ServerSocket(3000);
            System.out.println("Server  ready for chatting");
            Socket sock = sersock.accept();
            // reading from keyboard (keyRead object)
            BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
            // sending to client (pwrite object)
            OutputStream ostream = sock.getOutputStream();
            //PrintWriter pwrite = new PrintWriter(ostream, true);
            ObjectOutputStream objStream = new ObjectOutputStream(ostream);
            // receiving from server ( receiveRead  object)
            InputStream istream = sock.getInputStream();
            BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
            String receiveMessage, sendMessage;
            while (true) {
                if ((receiveMessage = receiveRead.readLine()) != null) {
                    System.out.println(receiveMessage);
                }
                //sendMessage = keyRead.readLine();
                objStream.writeObject(csSet);
                System.out.println("Obj sent");
                objStream.flush();
                //pwrite.println(sendMessage);
                //pwrite.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatProgramServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
