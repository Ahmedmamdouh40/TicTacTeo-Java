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
import video.videoPlay;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GameON extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;
    protected final Button button4;
    protected final Button button5;
    protected final Button button6;
    protected final Button button7;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Button button8;
    
    Vector<Button> boxes;
    String mySymbol;
    String oponentSymbol;
    String playerWon;
    boolean yourTurn = false;
    public boolean gameEnded = false;
    int move = -1;
    static Map<Integer, String> movesPlayed;
    Socket socket;
    DataOutputStream dos;
    String mode;
    ServerSocket server;

    public GameON(String mySymbol, Socket socket, ServerSocket server) {
        
        this.server = server;
        this.mode = mode;
        this.socket = socket;
        boxes = new Vector<>();
        movesPlayed = new HashMap<>();
        
        this.mySymbol = mySymbol;
        if(mySymbol.equals("X")) {
            oponentSymbol = "O";
            yourTurn = true;
        } else {
            oponentSymbol = "X";
        }
        
        try {
            dos = new DataOutputStream(socket.getOutputStream());
        } catch(IOException ex) {ex.printStackTrace();}

        imageView = new ImageView();
        imageView0 = new ImageView();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        button6 = new Button();
        button7 = new Button();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        button8 = new Button();

        setId("AnchorPane");
        setPrefHeight(450.8);
        setPrefWidth(589.4);
        getStyleClass().add("backgroundbox");
        //getStylesheets().add("/game/style.css");

        AnchorPane.setBottomAnchor(imageView, 0.20001220703125);
        AnchorPane.setLeftAnchor(imageView, 0.0);
        AnchorPane.setRightAnchor(imageView, 295.29998779296875);
        AnchorPane.setTopAnchor(imageView, 0.0);
        imageView.setFitHeight(450.8);
        imageView.setFitWidth(294.7);
        imageView.setOpacity(0.7);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("img/back-left.png").toExternalForm()));

        AnchorPane.setBottomAnchor(imageView0, 0.20001220703125);
        AnchorPane.setLeftAnchor(imageView0, 295.0);
        AnchorPane.setRightAnchor(imageView0, 0.29998779296875);
        AnchorPane.setTopAnchor(imageView0, 0.0);
        imageView0.setFitHeight(450.8);
        imageView0.setFitWidth(294.7);
        imageView0.setLayoutX(295.0);
        imageView0.setOpacity(0.7);
        imageView0.setPickOnBounds(true);
        imageView0.setImage(new Image(getClass().getResource("img/back-right.png").toExternalForm()));

        gridPane.setLayoutX(83.0);
        gridPane.setLayoutY(44.0);
        gridPane.setPrefHeight(353.0);
        gridPane.setPrefWidth(423.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        button.setMnemonicParsing(false);
        button.setPrefHeight(111.0);
        button.setPrefWidth(136.0);
        button.getStyleClass().add("bluebtn");

        GridPane.setColumnIndex(button0, 1);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(111.0);
        button0.setPrefWidth(136.0);
        button0.getStyleClass().add("whitebtn");

        GridPane.setColumnIndex(button1, 2);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(111.0);
        button1.setPrefWidth(136.0);
        button1.getStyleClass().add("bluebtn");
        //button1.getStylesheets().add("/game/style.css");

        GridPane.setRowIndex(button2, 1);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(111.0);
        button2.setPrefWidth(136.0);
        button2.getStyleClass().add("whitebtn");

        GridPane.setRowIndex(button3, 2);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(111.0);
        button3.setPrefWidth(136.0);
        button3.getStyleClass().add("bluebtn");

        GridPane.setColumnIndex(button4, 1);
        GridPane.setRowIndex(button4, 1);
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(111.0);
        button4.setPrefWidth(136.0);
        button4.getStyleClass().add("bluebtn");
        //button4.getStylesheets().add("/game/style.css");

        GridPane.setColumnIndex(button5, 2);
        GridPane.setRowIndex(button5, 1);
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(111.0);
        button5.setPrefWidth(136.0);
        button5.getStyleClass().add("whitebtn");

        GridPane.setColumnIndex(button6, 1);
        GridPane.setRowIndex(button6, 2);
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(111.0);
        button6.setPrefWidth(136.0);
        button6.getStyleClass().add("whitebtn");

        GridPane.setColumnIndex(button7, 2);
        GridPane.setRowIndex(button7, 2);
        button7.setMnemonicParsing(false);
        button7.setPrefHeight(111.0);
        button7.setPrefWidth(136.0);
        button7.getStyleClass().add("bluebtn");
        
        boxes.add(button);
        boxes.add(button0);
        boxes.add(button1);
        boxes.add(button2);
        boxes.add(button4);
        boxes.add(button5);
        boxes.add(button3);              
        boxes.add(button6);
        boxes.add(button7);

        label.setLayoutX(91.0);
        label.setLayoutY(411.0);
        label.setPrefHeight(26.0);
        label.setPrefWidth(67.0);
        label.setText("Name :");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("System Bold", 17.0));

        label1.setLayoutX(373.0);
        label1.setLayoutY(411.0);
        label1.setPrefHeight(26.0);
        label1.setPrefWidth(67.0);
        label1.setText("Score :");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("System Bold", 17.0));

        button8.setLayoutX(535.0);
        button8.setLayoutY(14.0);
        button8.setMnemonicParsing(false);
        button8.setPrefHeight(29.0);
        button8.setPrefWidth(41.0);
        button8.getStyleClass().add("exit");
        //button8.getStylesheets().add("/game/style.css");
        button8.setText("x");
        button8.setFont(new Font("Calibri Bold", 5.0));
        button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        getChildren().add(imageView);
        getChildren().add(imageView0);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(button);
        gridPane.getChildren().add(button0);
        gridPane.getChildren().add(button1);
        gridPane.getChildren().add(button2);
        gridPane.getChildren().add(button3);
        gridPane.getChildren().add(button4);
        gridPane.getChildren().add(button5);
        gridPane.getChildren().add(button6);
        gridPane.getChildren().add(button7);
        getChildren().add(gridPane);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
//        getChildren().add(button8);
        
        if(!yourTurn) {
            new ReadThread(socket, this);
        }
                
        for(Button text: boxes) {
            text.setOnMouseClicked(event -> {
                if(yourTurn && !gameEnded){
                    if(!movesPlayed.containsKey(boxes.indexOf(text))){
                        text.setText(mySymbol);
                        move = boxes.indexOf(text);
                        movesPlayed.putIfAbsent(Integer.valueOf(boxes.indexOf(text)), String.valueOf(mySymbol));
                        
                        try{
                            dos.writeInt(move);
                        } catch(IOException ex) {
                            openDialog("Other player closed the game");
                            try{
                                dos.close();
                                socket.close();
                                if(server != null)
                                    server.close();
                                System.exit(0);
                            } catch(IOException e) {e.printStackTrace();}
                        }
                        new CheckGame(this);
                        
                        if(gameEnded) {
                            System.out.println(playerWon);
                            if(playerWon.equals(mySymbol)) {
                                button.getParent().getScene().setRoot(new videoPlay("winning.mp4"));
                            } else if(playerWon.equals(oponentSymbol)){
                                // lost
                                button.getParent().getScene().setRoot(new videoPlay("losing.mp4"));
                            }
                            else {
                                // tie
                                button.getParent().getScene().setRoot(new videoPlay("tie.mp4"));
                            }
                            
                            try{
                                dos.close();
                                socket.close();
                                if(server != null)
                                    server.close();
                            } catch(IOException ioX) {System.out.println("Server is closed");}
//                            if(!playerWon.equals("None")){
//                                openDialog("Player " + playerWon + " won");
//                            }
//                            else{
//                                openDialog("It's a Tieeee");   
//                            }
//                            Platform.exit();
                        }
                        
                        changeTurn();
                    }                   
                }
            });
        }
    }
    
    void changeTurn() {
        move = -1;
        
        if(yourTurn) {
            yourTurn = false;
            new ReadThread(socket, this);
        } else {yourTurn = true;}
    }
    
    void renderScreen(int playedMove) {

        movesPlayed.put(playedMove, oponentSymbol);
        
        boxes.elementAt(playedMove).setText(oponentSymbol);
        
        new CheckGame(this);
        
        if(gameEnded) {
            System.out.println(playerWon);
            if(playerWon.equals(mySymbol)) {
                button.getParent().getScene().setRoot(new videoPlay("winning.mp4"));
            } else if(playerWon.equals(oponentSymbol)){
                // lost
                button.getParent().getScene().setRoot(new videoPlay("losing.mp4"));
            }
            else {
                // tie
                button.getParent().getScene().setRoot(new videoPlay("tie.mp4"));
            }
            
            try{
                dos.close();
                socket.close();
                if(server != null)
                    server.close();
            } catch(IOException ioX) {System.out.println("Server is closed");}
        }
        
        changeTurn();
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

