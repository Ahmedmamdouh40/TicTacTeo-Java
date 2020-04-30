/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

/**
 *
 * @author Nouran
 */
import GameOnOff.GameON;
import Gui.CreatePage;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.WindowEvent;
import video.audioPlay;

public class ServerPage extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final Label label;
    protected final Button backBtn;
    protected final ImageView imageView1;
    audioPlay audio = new audioPlay();
    
    protected final String playSymbol = "X";
    
    ServerSocket server;
    GameON mainServerPage;
    Socket s;

    public ServerPage() {

        imageView = new ImageView();
        imageView0 = new ImageView();
        label = new Label();
        backBtn = new Button();
        imageView1 = new ImageView();

        setId("AnchorPane");
        setPrefHeight(450.8);
        setPrefWidth(589.4);
        getStyleClass().add("backgroundbox");
        getStylesheets().add("Gui/style.css");

        AnchorPane.setBottomAnchor(imageView, 0.0);
        AnchorPane.setLeftAnchor(imageView, 301.0);
        AnchorPane.setRightAnchor(imageView, 0.39999999999997726);
        AnchorPane.setTopAnchor(imageView, 0.0);
        imageView.setFitHeight(453.0);
        imageView.setFitWidth(288.0);
        imageView.setLayoutX(301.0);
        imageView.setOpacity(0.5);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("img/back-right.png").toExternalForm()));

        imageView0.setFitHeight(453.0);
        imageView0.setFitWidth(288.0);
        imageView0.setOpacity(0.45);
        imageView0.setPickOnBounds(true);
        imageView0.setImage(new Image(getClass().getResource("img/back-left.png").toExternalForm()));

        label.setLayoutX(86.0);
        label.setLayoutY(211.0);
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Cambria Bold", 19.0));
        
        backBtn.setLayoutX(201.0);
        backBtn.setLayoutY(363.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(34.0);
        backBtn.setPrefWidth(187.0);
        backBtn.setText("Back");

        imageView1.setFitHeight(133.0);
        imageView1.setFitWidth(137.0);
        imageView1.setLayoutX(222.0);
        imageView1.setLayoutY(58.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("img/tic-tac-toe33.png").toExternalForm()));

        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(label);
        getChildren().add(backBtn);
        getChildren().add(imageView1);
        
        backBtn.setOnAction((ActionEvent e) -> {
            audio.play();
            backBtn.getParent().getScene().setRoot(new CreatePage());  
            try{
                if(server != null)
                    server.close();
            } catch(IOException ioX) {System.out.println("Server closed");}
        });
        
        try{
            server = new ServerSocket(5000);
            
            // Get the connected IP address not the static one
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("google.com", 80));
            
            String ip = socket.getLocalAddress().getHostAddress();
            label.setText("This is your IP Address \n " + ip + "\n Give it to the other player");
            this.new ClientListener(); // Listen to the other player
            socket.close();
            
        } catch (Exception e) {
            label.setText("Connection unavailable or another player \nhas created a game on this machine");
        }

    }
    
    class ClientListener extends Thread {
       
       public ClientListener() {   
                start();}        


        public void run() {
            try {
                Platform.runLater(new Runnable() {
                    public void run() {
                        backBtn.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
                            public void handle(WindowEvent we) {
                                try{
                                    if(server != null){
                                        server.close();
                                        System.out.println("Server closing from closing button");
//                                        Platform.exit();
                                    }
                                    System.exit(0);
                                } catch(IOException ioX) {System.out.println("Server closing error");}
                            }
                        });
                    }
                });
                 s = server.accept();
                 System.out.println("connected");
                 mainServerPage = new GameON(playSymbol, s, server);
                 
                 Platform.runLater(new Runnable() {
                     public void run() {
                         label.getParent().getScene().setRoot(mainServerPage);
                     }
                 });
                 
                 while(true) { // close connections when game is ended
                     if(mainServerPage.gameEnded) {
                         try {
                             s.close();
                             server.close();
                             System.out.println("Server closing");
                         } catch(IOException ex) {ex.printStackTrace();}
                         finally {
                             break;
                         }
                     }
                 }
            } 
            catch(SocketException ex) {
                try {
                    server.close();
                    System.out.println("Server from thread closed in socket exception");
                } catch(IOException socketEx) {socketEx.printStackTrace();}
            }
            catch(IOException ex) {
                System.out.println("Server from thread closed");
            }
        }   
    }
}
