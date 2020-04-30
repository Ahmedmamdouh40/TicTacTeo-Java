package video;

import Gui.*;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Intro extends AnchorPane {

    protected final VBox vBox;
    protected final Button button;
    audioPlay audio = new audioPlay();

   
    //protected final String videoName;

    public Intro() {
        
        //this.videoName = name;

        vBox = new VBox();
        button = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(450.8);
        setPrefWidth(589.4);
        getStyleClass().add("video");
        getStylesheets().add("video/style.css");
        
        AnchorPane.setBottomAnchor(vBox, 94.0);
        AnchorPane.setLeftAnchor(vBox, 0.0);
        AnchorPane.setRightAnchor(vBox, 0.39999999999997726);
        AnchorPane.setTopAnchor(vBox, 0.0);
        vBox.setPrefHeight(357.0);
        vBox.setPrefWidth(589.0);

        button.setLayoutX(199.0);
        button.setLayoutY(380.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(45.0);
        button.setPrefWidth(213.0);
        button.setText("Start Game");

        getChildren().add(vBox);
        getChildren().add(button);
               
        MediaPlayer player = new MediaPlayer( new Media(getClass().getResource("beginning.mp4").toExternalForm()));
        MediaView mediaView = new MediaView(player);
        player.play();
        
        vBox.getChildren().add(mediaView);
        button.setOnAction((ActionEvent e) -> {
            player.stop();
            button.getParent().getScene().setRoot(new Base());
        });

    }
}
