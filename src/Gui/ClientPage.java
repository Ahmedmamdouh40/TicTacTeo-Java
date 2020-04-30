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
import Gui.CreatePage;
import GameOnOff.GameON;
import GameOnOff.GameON;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import video.audioPlay;

public class ClientPage extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final Label label;
    protected final TextField textField;
    protected final Button connectBtn;
    protected final Button backBtn;
    protected final ImageView imageView1;
    
    GameON mainClientPage;
    protected final String playSymbol = "O";

    public ClientPage() {

        imageView = new ImageView();
        imageView0 = new ImageView();
        label = new Label();
        textField = new TextField();
        connectBtn = new Button();
        backBtn = new Button();
        imageView1 = new ImageView();
        audioPlay audio = new audioPlay();


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
        label.setPrefHeight(48.0);
        label.setPrefWidth(130.0);
        label.setText("Enter IP ");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Cambria Bold", 19.0));

        textField.setLayoutX(182.0);
        textField.setLayoutY(219.0);
        textField.setPrefHeight(32.0);
        textField.setPrefWidth(222.0);
        textField.setFont(new Font("Aparajita Bold", 17.0));
        textField.setPromptText("125.0.0.1");
        textField.getStyleClass().add("field");
        //textField.getStylesheets().add("style.css");
        textField.setFont(new Font("Arial Black", 13.0));

        connectBtn.setLayoutX(182.0);
        connectBtn.setLayoutY(295.0);
        connectBtn.setMnemonicParsing(false);
        connectBtn.setPrefHeight(32.0);
        connectBtn.setPrefWidth(213.0);
        connectBtn.setText("Connect");

        backBtn.setLayoutX(182.0);
        backBtn.setLayoutY(362.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setPrefHeight(32.0);
        backBtn.setPrefWidth(213.0);
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
        getChildren().add(textField);
        getChildren().add(connectBtn);
        getChildren().add(backBtn);
        getChildren().add(imageView1);
        
        connectBtn.setOnAction((ActionEvent e) -> {
            String zeroTo255 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
            String patternStr = zeroTo255 + "\\." + zeroTo255 + "\\." +
                                zeroTo255 + "\\." + zeroTo255; 

            Pattern patternReg = Pattern.compile(patternStr); // Create the pattern
            Socket s = null;
            try {
                audio.play();
                if(!textField.getText().equals("")){
                    if(patternReg.matcher(textField.getText()).matches()){ // check if it is valid ip 
                        if(InetAddress.getByName(textField.getText()).isReachable(500)){ // the ip address is reachable
                            s = new Socket(textField.getText(), 5000);

                            mainClientPage = new GameON(playSymbol, s, null);
                            connectBtn.getParent().getScene().setRoot(mainClientPage);
                        } else {
                            openDialog("Can't reach this IP address\nTry again");
                        }
                    } else {
                        openDialog("You entered a wrong IP address");
                    }
                } else {
                    openDialog("You have to enter an IP address");
                }
            } catch(IOException ex) {
                ex.printStackTrace();
                try{
                    s.close();
                } catch(IOException ioX) {ioX.printStackTrace();}
            };     
        });
        
        backBtn.setOnAction((ActionEvent e) -> {
            audio.play();
            backBtn.getParent().getScene().setRoot(new CreatePage());           
        });

    }
    
    void openDialog(String content) {
        Dialog <String> dialog = new Dialog();
        dialog.setResizable(false);
        
        StackPane pane = new StackPane();
        Text text = new Text(content);
        pane.getChildren().add(text);
        
        dialog.getDialogPane().setContent(pane);
        
        ButtonType okBtn = new ButtonType("Okay");
        
        dialog.getDialogPane().getButtonTypes().add(okBtn);
        
        dialog.showAndWait();
    }
}

