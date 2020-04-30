/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import Gui.*;
import GameOnOff.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import video.audioPlay;

public class Levels extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final ImageView imageView2;
    protected final ImageView imageView3;
    protected final ImageView imageView4;
    protected final Button easyBtn;
    protected final Button mediumBtn;
    protected final Button hardBtn;
    protected final Button backBtn;
    audioPlay audio = new audioPlay();

    public Levels() {

        imageView = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        imageView4 = new ImageView();
        imageView2 = new ImageView();
        imageView3 = new ImageView();
        easyBtn = new Button();
        mediumBtn = new Button();
        hardBtn = new Button();
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

        easyBtn.setLayoutX(202.0);
        easyBtn.setLayoutY(220.0);
        easyBtn.setMnemonicParsing(false);
        easyBtn.setPrefHeight(32.0);
        easyBtn.setPrefWidth(213.0);
        easyBtn.setFont(new Font("Aparajita Bold", 20.0));
        easyBtn.setText("Easy");
        
        imageView2.setLayoutX(150.0);
        imageView2.setLayoutY(215.0);
        imageView2.setFitHeight(38);
        imageView2.setFitWidth(38);
        imageView2.setPickOnBounds(true);
        imageView2.setImage(new Image(getClass().getResource("img/easy.png").toExternalForm()));

        mediumBtn.setLayoutX(202.0);
        mediumBtn.setLayoutY(280.0);
        mediumBtn.setMnemonicParsing(false);
        mediumBtn.setPrefHeight(32.0);
        mediumBtn.setPrefWidth(213.0);
        mediumBtn.setFont(new Font("Aparajita Bold", 20.0));
        mediumBtn.setText("Medium");
            
        imageView3.setLayoutX(150.0);
        imageView3.setLayoutY(278.0);
        imageView3.setFitHeight(38);
        imageView3.setFitWidth(38);
        imageView3.setPickOnBounds(true);
        imageView3.setImage(new Image(getClass().getResource("img/medium.png").toExternalForm()));

        hardBtn.setLayoutX(202.0);
        hardBtn.setLayoutY(340.0);
        hardBtn.setMnemonicParsing(false);
        hardBtn.setPrefHeight(32.0);
        hardBtn.setPrefWidth(213.0);
        hardBtn.setFont(new Font("Aparajita Bold", 20.0));
        hardBtn.setText("Hard");
        
        imageView4.setLayoutX(150.0);
        imageView4.setLayoutY(338.0);
        imageView4.setFitHeight(38);
        imageView4.setFitWidth(38);
        imageView4.setPickOnBounds(true);
        imageView4.setImage(new Image(getClass().getResource("img/hard.png").toExternalForm()));
        
        backBtn.setLayoutX(202.0);
        backBtn.setLayoutY(400.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(32.0);
        backBtn.setPrefWidth(213.0);
        backBtn.setFont(new Font("Aparajita Bold", 20.0));
        backBtn.setText("Back");

        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(imageView1);
        getChildren().add(imageView2);
        getChildren().add(imageView3);
        getChildren().add(imageView4);
        getChildren().add(easyBtn);
        getChildren().add(mediumBtn);
        getChildren().add(hardBtn);
        getChildren().add(backBtn);
        
        easyBtn.setOnAction((ActionEvent e) -> {        
             audio.play();
            easyBtn.getParent().getScene().setRoot(new GameOFF(true, 1));
        });
        
        mediumBtn.setOnAction((ActionEvent e) -> {
            audio.play();
            mediumBtn.getParent().getScene().setRoot(new GameOFF(true, 2));           
        });
        
        hardBtn.setOnAction((ActionEvent e) -> {
            audio.play();
            hardBtn.getParent().getScene().setRoot(new GameOFF(true, 3));           
        });
        
        backBtn.setOnAction((ActionEvent e) -> {
            audio.play();
            backBtn.getParent().getScene().setRoot(new GameMode());           
        });

    }
}
