/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Gui.*;
import GameOnOff.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import video.Intro;

/**
 *
 * @author Nouran
 */
public class TicTacToe_Project extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        Base te = new Base();
        Intro In=new Intro();

        Scene scene = new Scene(In, 589.4, 450.8);

        scene.getStylesheets().add(getClass().getResource("style.css").toString());
        
        primaryStage.getIcons().add(new Image(TicTacToe_Project.class.getResourceAsStream( "img/icon.jpg")));
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
