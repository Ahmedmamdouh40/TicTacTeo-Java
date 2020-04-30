//package Gui;
//
//import Gui.*;
//import GameOnOff.*;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Optional;
//import java.util.concurrent.TimeUnit;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.scene.control.Button;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.AnchorPane;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ButtonType;
//import javafx.scene.text.Text;
//import video.audioPlay;
//import video.videoPlay;
//
//public class Base extends AnchorPane {
//
//    protected final ImageView imageView;
//    protected final ImageView imageView0;
//    protected final ImageView imageView1;
//    protected final Button localBtn;
//    protected final Button onlineBtn;
//    protected final Button exit;
//    protected final Button About;
//    BufferedReader reader;
//    Text text = new Text();
//
//    public Base() {
//
//        imageView = new ImageView();
//        imageView0 = new ImageView();
//        imageView1 = new ImageView();
//        localBtn = new Button();
//        onlineBtn = new Button();
//        exit = new Button();
//        About = new Button();
//        audioPlay audio = new audioPlay();
//        
//        setId("AnchorPane");
//        setPrefHeight(450.8);
//        setPrefWidth(589.4);
//        getStyleClass().add("backgroundbox");
//        getStylesheets().add("Gui/style.css");
//
//        imageView.setFitHeight(450.8);
//        imageView.setFitWidth(294.7);
//        imageView.setOpacity(0.5);
//        imageView.setPickOnBounds(true);
//        imageView.setImage(new Image(getClass().getResource("img/back-left.png").toExternalForm()));
//
//        imageView0.setFitHeight(450.8);
//        imageView0.setFitWidth(294.7);
//        imageView0.setLayoutX(295.0);
//        imageView0.setOpacity(0.5);
//        imageView0.setPickOnBounds(true);
//        imageView0.setImage(new Image(getClass().getResource("img/back-right.png").toExternalForm()));
//
//        imageView1.setFitHeight(141.0);
//        imageView1.setFitWidth(135.0);
//        imageView1.setLayoutX(235.0);
//        imageView1.setLayoutY(67.0);
//        imageView1.setPickOnBounds(true);
//        imageView1.setPreserveRatio(true);
//        imageView1.setImage(new Image(getClass().getResource("img/tic-tac-toe33.png").toExternalForm()));
//
//        localBtn.setLayoutX(199.0);
//        localBtn.setLayoutY(240.0);
//        localBtn.setMnemonicParsing(false);
//        localBtn.setPrefHeight(38.0);
//        localBtn.setPrefWidth(207.0);
//        localBtn.setText("Local");
//
//        onlineBtn.setLayoutX(199.0);
//        onlineBtn.setLayoutY(310.0);
//        onlineBtn.setMnemonicParsing(false);
//        onlineBtn.setPrefHeight(38.0);
//        onlineBtn.setPrefWidth(207.0);
//        onlineBtn.setText("Online");
//        
//        About.setLayoutX(10.0);
//        About.setLayoutY(10.0);
//        About.setMnemonicParsing(false);
//        About.setPrefHeight(35.0);
//        About.setPrefWidth(100.0);
//        About.setText("About");
//        
//        exit.setLayoutX(199.0);
//        exit.setLayoutY(380.0);
//        exit.setMnemonicParsing(false);
//        exit.setPrefHeight(38.0);
//        exit.setPrefWidth(207.0);
//        exit.setText("Exit");
//        exit.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//            audio.play();
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setTitle("Confirmation Dialog");
//            alert.setHeaderText("exit");
//            alert.setContentText("Are you sure you want to exit ?");
//
//            Optional<ButtonType> result = alert.showAndWait();
//            if (result.get() == ButtonType.OK){
//                System.exit(0);}
//            }
//        });
//
//        getChildren().add(imageView);
//        getChildren().add(imageView0);
//        getChildren().add(imageView1);
//        getChildren().add(localBtn);
//        getChildren().add(onlineBtn);
//        getChildren().add(exit);
//        getChildren().add(About);
//                
//        onlineBtn.setOnAction((ActionEvent e) -> {
//            audio.play();
//            onlineBtn.getParent().getScene().setRoot(new reg(true));
//
//        });
//
//        localBtn.setOnAction((ActionEvent e) -> {
//            audio.play();
//            localBtn.getParent().getScene().setRoot(new reg(false));
//        });
//        
//        About.setOnAction((ActionEvent e) -> {
//            audio.play();
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("About");
//            alert.setHeaderText("Information Alert");
//            try {
//                String line;
//                StringBuilder stringBuffer = new StringBuilder();
//                BufferedReader reader = new BufferedReader(new FileReader(new File("file.txt")));
//                while ((line = reader.readLine()) != null){
//                    stringBuffer.append(line + '\n');
//                }
//                alert.setContentText(stringBuffer.toString());
//                alert.show();
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//        });
//
//    }
//}

package Gui;

import java.io.File;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import Gui.*;
import GameOnOff.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import video.audioPlay;
import video.videoPlay;

public class Base extends AnchorPane {

    protected final Pane pane;
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final ImageView imageView2;
    protected final ImageView imageView3;
    protected final Button onlineBtn;
    protected final Button localBtn;
    protected final Button About;
    protected final ImageView imageView5;
    protected final Pane pane0;

    public Base() {

        pane = new Pane();
        imageView = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        imageView2 = new ImageView();
        imageView3 = new ImageView();
        onlineBtn = new Button();
        localBtn = new Button();
        imageView5 = new ImageView();
        pane0 = new Pane();
        audioPlay audio = new audioPlay();
        About = new Button();
        Text text = new Text();

        setId("AnchorPane");
        setPrefHeight(450.8);
        setPrefWidth(589.4);
        getStyleClass().add("backgroundbox");
        getStylesheets().add("Gui/style2.css");

        pane.setLayoutX(-2.0);
        pane.setPrefHeight(457.0);
        pane.setPrefWidth(304.0);
        pane.getStyleClass().add("paneleft");
        pane.getStylesheets().add("Gui/style2.css");

        imageView.setFitHeight(197.0);
        imageView.setFitWidth(247.0);
        imageView.setLayoutX(20.0);
        imageView.setLayoutY(31.0);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("img/font.png").toExternalForm()));

        imageView0.setFitHeight(138.0);
        imageView0.setFitWidth(132.0);
        imageView0.setLayoutX(96.0);
        imageView0.setLayoutY(102.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("img/o.png").toExternalForm()));

        imageView1.setFitHeight(143.0);
        imageView1.setFitWidth(140.0);
        imageView1.setLayoutX(49.0);
        imageView1.setLayoutY(102.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("img/x.png").toExternalForm()));

        AnchorPane.setBottomAnchor(imageView2, 1.0);
        AnchorPane.setLeftAnchor(imageView2, 301.0);
        AnchorPane.setRightAnchor(imageView2, 0.0);
        AnchorPane.setTopAnchor(imageView2, -1.0);
        imageView2.setFitHeight(457.0);
        imageView2.setFitWidth(288.0);
        imageView2.setLayoutX(301.0);
        imageView2.setLayoutY(-1.0);
        imageView2.setOpacity(0.4);
        imageView2.setPickOnBounds(true);
        imageView2.setImage(new Image(getClass().getResource("img/back-right.png").toExternalForm()));

        imageView3.setFitHeight(150.0);
        imageView3.setFitWidth(200.0);
        imageView3.setLayoutX(364.0);
        imageView3.setLayoutY(54.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("img/tic-tac-toe33.png").toExternalForm()));

        onlineBtn.setLayoutX(339.0);
        onlineBtn.setLayoutY(250.0);
        onlineBtn.setMnemonicParsing(false);
        onlineBtn.setPrefHeight(38.0);
        onlineBtn.setPrefWidth(220.0);
        onlineBtn.setFont(new Font("Aparajita Bold", 20.0));
        onlineBtn.setText("Online Game");

        localBtn.setLayoutX(339.0);
        localBtn.setLayoutY(322.0);
        localBtn.setMnemonicParsing(false);
        localBtn.setPrefHeight(38.0);
        localBtn.setPrefWidth(220.0);
        localBtn.setFont(new Font("Aparajita Bold", 20.0));
        localBtn.setText("Local Game");
        
        About.setLayoutX(10.0);
        About.setLayoutY(10.0);
        About.setMnemonicParsing(false);
        About.setPrefHeight(35.0);
        About.setPrefWidth(100.0);
        About.setText("About");
                
        imageView5.setFitHeight(35.0);
        imageView5.setFitWidth(34.0);
        imageView5.setLayoutX(292.0);
        imageView5.setLayoutY(324.0);
        imageView5.setOpacity(0.95);
        imageView5.setPickOnBounds(true);
        imageView5.setPreserveRatio(true);
        imageView5.getStyleClass().add("img");

        pane0.setLayoutX(292.0);
        pane0.setLayoutY(323.0);
        pane0.setPrefHeight(34.0);
        pane0.setPrefWidth(34.0);
        pane0.getStyleClass().add("img");
        pane0.getStylesheets().add("Gui/style2.css");

        pane.getChildren().add(imageView);
        pane.getChildren().add(imageView0);
        pane.getChildren().add(imageView1);
        getChildren().add(pane);
        getChildren().add(imageView2);
        getChildren().add(imageView3);
        getChildren().add(imageView5);
        getChildren().add(pane0);
        getChildren().add(onlineBtn);
        getChildren().add(localBtn);
        getChildren().add(About);
    
        onlineBtn.setOnAction((ActionEvent e) -> {
            audio.play();
            onlineBtn.getParent().getScene().setRoot(new reg(true));

        });

        localBtn.setOnAction((ActionEvent e) -> {
            audio.play();
            localBtn.getParent().getScene().setRoot(new reg(false));
        });
        
        About.setOnAction((ActionEvent e) -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About");
            alert.setHeaderText("Information Alert");
            try {
                String line;
                StringBuilder stringBuffer = new StringBuilder();
                BufferedReader reader = new BufferedReader(new FileReader(new File("file.txt")));
                while ((line = reader.readLine()) != null){
                    stringBuffer.append(line + '\n');
                }
                alert.setContentText(stringBuffer.toString());
                alert.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
    }
}