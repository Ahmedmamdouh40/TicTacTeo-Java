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
import Gui.Base;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import video.audioPlay;

public class CreatePage extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final Button createBtn;
    protected final Button joinBtn;
    protected final Button backBtn;
    audioPlay audio = new audioPlay();
    
    public CreatePage() {

        imageView = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        createBtn = new Button();
        joinBtn = new Button();
        backBtn = new Button();

        setId("AnchorPane");
        setPrefHeight(450.8);
        setPrefWidth(589.4);
        getStyleClass().add("backgroundbox");
        getStylesheets().add("Gui/style.css");

        AnchorPane.setBottomAnchor(imageView, 0.20001220703125);
        AnchorPane.setLeftAnchor(imageView, 0.0);
        AnchorPane.setTopAnchor(imageView, 0.0);
        imageView.setFitHeight(450.8);
        imageView.setFitWidth(294.7);
        imageView.setOpacity(0.5);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("img/back-left.png").toExternalForm()));

        AnchorPane.setBottomAnchor(imageView0, -3.79998779296875);
        AnchorPane.setLeftAnchor(imageView0, 295.0);
        AnchorPane.setRightAnchor(imageView0, -0.30001220703127274);
        AnchorPane.setTopAnchor(imageView0, 4.0);
        imageView0.setFitHeight(450.8);
        imageView0.setFitWidth(294.7);
        imageView0.setLayoutX(295.0);
        imageView0.setLayoutY(4.0);
        imageView0.setOpacity(0.5);
        imageView0.setPickOnBounds(true);
        imageView0.setImage(new Image(getClass().getResource("img/back-right.png").toExternalForm()));

        imageView1.setFitHeight(139.0);
        imageView1.setFitWidth(136.0);
        imageView1.setLayoutX(227.0);
        imageView1.setLayoutY(61.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("img/tic-tac-toe33.png").toExternalForm()));

        createBtn.setLayoutX(202.0);
        createBtn.setLayoutY(229.0);
        createBtn.setMnemonicParsing(false);
        createBtn.setPrefHeight(34.0);
        createBtn.setPrefWidth(187.0);
        createBtn.setText("Create");

        joinBtn.setLayoutX(202.0);
        joinBtn.setLayoutY(297.0);
        joinBtn.setMnemonicParsing(false);
        joinBtn.setPrefHeight(34.0);
        joinBtn.setPrefWidth(187.0);
        joinBtn.setText("Join");

        backBtn.setLayoutX(201.0);
        backBtn.setLayoutY(363.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(34.0);
        backBtn.setPrefWidth(187.0);
        backBtn.setText("Back");

        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(imageView1);
        getChildren().add(createBtn);
        getChildren().add(joinBtn);
        getChildren().add(backBtn);
        
        createBtn.setOnAction((ActionEvent e) -> {        
            // Page with IP address of the server
            audio.play();
            createBtn.getParent().getScene().setRoot(new ServerPage());
        });
        
        joinBtn.setOnAction((ActionEvent e) -> {
            
            // Page with text field to enter the IP of server
            audio.play();
            joinBtn.getParent().getScene().setRoot(new ClientPage());           
        });
        
        backBtn.setOnAction((ActionEvent e) -> {
            audio.play();
            backBtn.getParent().getScene().setRoot(new Base());           
        });

    }
}

