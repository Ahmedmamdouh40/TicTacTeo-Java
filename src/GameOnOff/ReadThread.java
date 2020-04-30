/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameOnOff;

/**
 *
 * @author Nouran
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javafx.application.Platform;

/**
 *
 * @author Nouran
 */
public class ReadThread extends Thread{
    Socket socket;
    GameON gamePage;
    DataInputStream dis;
    
    public ReadThread(Socket s, GameON page) {
        this.socket = s;
        this.gamePage = page;
        
        try {
            dis = new DataInputStream(s.getInputStream());
        } catch(IOException ex) {
            System.out.println("Socket closed");
            try{
                if(dis != null)
                    dis.close();
            } catch(IOException ioX) {ioX.printStackTrace();}
        }
        
        start();
    }
    
    public void run() {
    
        try{
            if(dis != null){
                int played = dis.readInt();

                Platform.runLater(new Runnable() { // This function has to be run using an application thread
                    public void run() {
                        gamePage.renderScreen(played);
                    }
                });  
            }
            
        } catch(IOException ex) {
            Platform.runLater(new Runnable() { // This function has to be run using an application thread
                public void run() {
                    gamePage.openDialog("Other player closed the game");
                    try{
                        dis.close();
                        socket.close();
                        if(gamePage.server != null)
                            gamePage.server.close();
                        System.out.println("Other player has closed");             
                        System.exit(0);
                    } catch(IOException e) {e.printStackTrace();}
                }
            }); 
            
//            try{
//                dis.close();
//                socket.close();
//                System.out.println("Other player has closed");
////                Platform.runLater(new Runnable() { // This function has to be run using an application thread
////                    public void run() {
////                        gamePage.gameEnded = true;
////                    }
////                });              
//                System.exit(0);
//            } catch(IOException e) {e.printStackTrace();}
        }
    }
    
}
