package Gui;

import Gui.*;
import GameOnOff.*;
import DataBase.sql;
import DataBase.viewer;
import java.sql.SQLException;
import java.util.Vector;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import video.audioPlay;

public class reg extends AnchorPane {
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final Button regist,records, back;
    protected final TextField textField;
    protected final Label label;
    audioPlay audio = new audioPlay();
    
    Alert a = new Alert(AlertType.NONE);
    static String g_name=null;
    Vector<String> r = new Vector<>();
    sql s=new sql();
    protected static boolean flag;
    
    public reg(boolean mode) {
        imageView = new ImageView();
        imageView0 = new ImageView();
        regist = new Button();
        records = new Button();
        back = new Button();
        textField = new TextField();
        label = new Label();
        
        setId("AnchorPane");
        setPrefHeight(450.8);
        setPrefWidth(589.4);
        getStyleClass().add("backgroundbox");
        getStylesheets().add("Gui/style.css");

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
        
        
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        regist.setLayoutX(226.0);
        regist.setLayoutY(220.0);
        regist.setMnemonicParsing(false);
        regist.setOnMouseClicked(this::mouseclicked);
        regist.setPrefHeight(32.0);
        regist.setPrefWidth(213.0);
        regist.setText("Register Game");
        regist.setFont(new Font("Aparajita Bold", 20.0));
        
        records.setLayoutX(226.0);
        records.setLayoutY(270.0);
        records.setMnemonicParsing(false);
        records.setOnMouseClicked(this::mouseclicked);
        records.setPrefHeight(32.0);
        records.setPrefWidth(213.0);
        records.setText("Records");
        records.setFont(new Font("Aparajita Bold", 20.0));
        
        back.setLayoutX(226.0);
        back.setLayoutY(320.0);
        back.setMnemonicParsing(false);
        back.setOnMouseClicked(this::mouseclicked);
        back.setPrefHeight(32.0);
        back.setPrefWidth(213.0);
        back.setText("Back");
        back.setFont(new Font("Aparajita Bold", 20.0));

        textField.setLayoutX(226.0);
        textField.setLayoutY(157.0);
        textField.setPrefHeight(32.0);
        textField.setPrefWidth(220.0);
        textField.setFont(new Font("Aparajita Bold", 17.0));
        textField.setPromptText("Game_Name");
        textField.getStyleClass().add("field");

        label.setLayoutX(100.0);
        label.setLayoutY(158.0);
        label.setPrefHeight(25.0);
        label.setPrefWidth(150.0);
        label.setText("Game_Name");
        label.setFont(new Font("Aparajita Bold", 20.0));
        label.getStyleClass().add("label");
        r = (Vector)s.view().clone();
        
        regist.setOnAction((ActionEvent e) -> {
            audio.play();
            a.setAlertType(AlertType.ERROR);
            if(setName().isEmpty()){
                a.setContentText("Please Enter Name");
                a.showAndWait();
                setName();
            }
            flag=false;
            for(int i=0;i<r.size();i++){
                if(setName().equals(r.get(i))){
                    a.setContentText("Duplicate Entry , Enter another Name!!");
                    System.out.println("duplicate");
                    a.showAndWait();
                    setName();
                    flag=true;
                    System.out.println(flag);
                }
                if(i==r.size()-1 && flag!=true){
                flag=false;
                System.out.println("msh duplicate");
                break;
            }
            }
            System.out.println(flag);
            if((!setName().isEmpty()) && flag==false){
                if(mode==true){
                    actionPerformed(e);
                    audio.play();
                    regist.getParent().getScene().setRoot(new CreatePage());
                }    
                if(mode==false){
                    actionPerformed(e);
                    System.out.println("convert page");
                    audio.play();
                    regist.getParent().getScene().setRoot(new GameMode());
                }
            }
        });
        records.setOnAction((ActionEvent e) -> {
            audio.play();
            records.getParent().getScene().setRoot(new viewer());
        });
        
        back.setOnAction((ActionEvent e) -> {
            audio.play();
            back.getParent().getScene().setRoot(new Base());
        });
        
        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(regist);
        getChildren().add(records);
        getChildren().add(back);
        getChildren().add(textField);
        getChildren().add(label);

    }

     protected void mouseclicked(javafx.scene.input.MouseEvent mouseEvent){
    EventHandler<ActionEvent> eventHandler = (ActionEvent e) -> {
            actionPerformed(e);
        };
    }
    protected void actionPerformed(ActionEvent e) {
        sql db=new sql();
        String p1="Player1";
        String p2=null;
        String win=null;
        if(!g_name.isEmpty() && flag==false){
            db.insert(g_name,p1,p2,win);}
    }
    public String setName(){
        g_name=textField.getText();
        return g_name;
    }
}

