package Gui;

import GameOnOff.GameOFF;
import java.io.File;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import video.audioPlay;

public class GameMode extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final Button vsCompBtn;
    protected final Button multiplayerBtn;
    protected final Button backBtn;
    protected final Button exit;
    protected final ImageView imageView2;
    protected final ImageView imageView3;
    protected final Glow glow;
    protected final ImageView imageView4;
    protected final Glow glow0;
    protected final ImageView imageView5;

    public GameMode() {

        imageView = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        imageView2 = new ImageView();
        imageView3 = new ImageView();
        vsCompBtn = new Button();
        multiplayerBtn = new Button();
        backBtn = new Button();
        exit = new Button();
        glow = new Glow();
        imageView4 = new ImageView();
        glow0 = new Glow();
        imageView5 = new ImageView();
        audioPlay audio = new audioPlay();
        
        setId("AnchorPane");
        setPrefHeight(450.8);
        setPrefWidth(589.4);
        getStyleClass().add("backgroundbox");
        getStylesheets().add("Gui/style.css");

        AnchorPane.setBottomAnchor(imageView, 0.20001220703125);
        AnchorPane.setLeftAnchor(imageView, 0.0);
        AnchorPane.setRightAnchor(imageView, 294.6999877929687);
        AnchorPane.setTopAnchor(imageView, 0.0);
        imageView.setFitHeight(450.8);
        imageView.setFitWidth(294.7);
        imageView.setOpacity(0.5);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("img/back-left.png").toExternalForm()));

        AnchorPane.setBottomAnchor(imageView0, 0.20001220703125);
        AnchorPane.setLeftAnchor(imageView0, 295.0);
        AnchorPane.setRightAnchor(imageView0, 0.29998779296875);
        AnchorPane.setTopAnchor(imageView0, 0.0);
        imageView0.setFitHeight(450.8);
        imageView0.setFitWidth(294.7);
        imageView0.setLayoutX(295.0);
        imageView0.setOpacity(0.5);
        imageView0.setPickOnBounds(true);
        imageView0.setImage(new Image(getClass().getResource("img/back-right.png").toExternalForm()));

        imageView1.setFitHeight(139.0);
        imageView1.setFitWidth(129.0);
        imageView1.setLayoutX(231.0);
        imageView1.setLayoutY(63.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("img/tic-tac-toe33.png").toExternalForm()));

        vsCompBtn.setLayoutX(203.0);
        vsCompBtn.setLayoutY(226.0);
        vsCompBtn.setMnemonicParsing(false);
        vsCompBtn.setPrefHeight(30.0);
        vsCompBtn.setPrefWidth(183.0);
        vsCompBtn.setFont(new Font("Aparajita Bold", 20.0));
        vsCompBtn.setText("vs Computer");

        multiplayerBtn.setLayoutX(203.0);
        multiplayerBtn.setLayoutY(282.0);
        multiplayerBtn.setMnemonicParsing(false);
        multiplayerBtn.setPrefHeight(30.0);
        multiplayerBtn.setPrefWidth(183.0);
        multiplayerBtn.setFont(new Font("Aparajita Bold", 20.0));
        multiplayerBtn.setText("MultiPlayer");

        backBtn.setLayoutX(204.0);
        backBtn.setLayoutY(339.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(30.0);
        backBtn.setPrefWidth(183.0);
        backBtn.setFont(new Font("Aparajita Bold", 20.0));
        backBtn.setText("Back");

        exit.setLayoutX(203.0);
        exit.setLayoutY(392.0);
        exit.setMnemonicParsing(false);
        exit.setPrefHeight(30.0);
        exit.setPrefWidth(183.0);
        exit.setFont(new Font("Aparajita Bold", 20.0));
        exit.setText("Exit");

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            audio.play();
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("exit");
            alert.setContentText("Are you sure you want to exit ?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                System.exit(0);}
            }
        });

        imageView2.setFitHeight(38.0);
        imageView2.setFitWidth(37.0);
        imageView2.setLayoutX(141.0);
        imageView2.setLayoutY(336.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setRotate(180.0);
        imageView2.setImage(new Image(getClass().getResource("img/login.png").toExternalForm()));

        imageView3.setFitHeight(37.0);
        imageView3.setFitWidth(61.0);
        imageView3.setLayoutX(131.0);
        imageView3.setLayoutY(279.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("img/multi.png").toExternalForm()));

        imageView3.setEffect(glow);

        imageView4.setFitHeight(39.0);
        imageView4.setFitWidth(37.0);
        imageView4.setLayoutX(141.0);
        imageView4.setLayoutY(223.0);
        imageView4.setPickOnBounds(true);
        imageView4.setPreserveRatio(true);
        imageView4.setImage(new Image(getClass().getResource("img/single.png").toExternalForm()));

        imageView4.setEffect(glow0);

        imageView5.setFitHeight(37.0);
        imageView5.setFitWidth(37.0);
        imageView5.setLayoutX(141.0);
        imageView5.setLayoutY(389.0);
        imageView5.setPickOnBounds(true);
        imageView5.setPreserveRatio(true);
        imageView5.setImage(new Image(getClass().getResource("img/exit.png").toExternalForm()));

        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(imageView1);
        getChildren().add(vsCompBtn);
        getChildren().add(multiplayerBtn);
        getChildren().add(backBtn);
        getChildren().add(exit);
        getChildren().add(imageView2);
        getChildren().add(imageView3);
        getChildren().add(imageView4);
        getChildren().add(imageView5);


        vsCompBtn.setOnAction((ActionEvent e) -> {     
            audio.play();
            vsCompBtn.getParent().getScene().setRoot(new Levels());
        });
        
        multiplayerBtn.setOnAction((ActionEvent e) -> {
            audio.play();
            multiplayerBtn.getParent().getScene().setRoot(new GameOFF(false, 1));           
        });
       
        backBtn.setOnAction((ActionEvent e) -> {
            audio.play();
            backBtn.getParent().getScene().setRoot(new Base());           
        });
}

}
    
