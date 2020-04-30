package GameOnOff;

import DataBase.*;
import AI.Strategy;
import video.*;
import Gui.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import DataBase.dbObj;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class GameOFF extends AnchorPane {

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
    protected final Button newgame;
    audioPlay audio=new audioPlay();
    

    protected final Button btn[] = new Button[9];

    private boolean end = false;
    private boolean playerturn = true;
    protected boolean singleMode;
    private final String X = "X";
    private final String O = "O";
    int count = 0;
    int[] pos=new int[10];
    int level;
    String state;

    public GameOFF(boolean mode, int level) {

        singleMode = mode;
        this.level = level;

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
        newgame=new Button();
        btn[0] = button;
        btn[1] = button0;
        btn[2] = button1;
        btn[3] = button2;
        btn[4] = button4;
        btn[5] = button5;
        btn[6] = button3;
        btn[7] = button6;
        btn[8] = button7;
        

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

        label0.setLayoutX(172.0);
        label0.setLayoutY(411.0);
        label0.setPrefHeight(26.0);
        label0.setPrefWidth(189.0);
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("System Bold", 17.0));

        label2.setLayoutX(433.0);
        label2.setLayoutY(411.0);
        label2.setPrefHeight(26.0);
        label2.setPrefWidth(81.0);
        label2.setTextFill(javafx.scene.paint.Color.WHITE);
        label2.setFont(new Font("System Bold", 17.0));
        
        newgame.setLayoutX(91.0);
        newgame.setLayoutY(411.0);
        newgame.setMnemonicParsing(false);
        newgame.setPrefHeight(29.0);
        newgame.setPrefWidth(100.0);
        newgame.getStyleClass().add("exit");
        newgame.setText("New Game");
        newgame.setFont(new Font("Calibri Bold", 5.0));

        button8.setLayoutX(535.0);
        button8.setLayoutY(14.0);
        button8.setMnemonicParsing(false);
        button8.setPrefHeight(29.0);
        button8.setPrefWidth(41.0);
        button8.getStyleClass().add("exit");
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
        getChildren().add(label0);
        getChildren().add(label2);
        getChildren().add(newgame);
        
        newgame.setOnAction((ActionEvent e) -> {
            audio.play();
            newgame.getParent().getScene().setRoot(new Base());
        });

        for (int i = 0; i < 9; i++) {
            btn[i].addEventHandler(ActionEvent.ACTION, e -> {
                    actionPerformed(e);
            });
        }
    }

    protected void mouseclicked(javafx.scene.input.MouseEvent mouseEvent) {
        EventHandler<ActionEvent> eventHandler = (ActionEvent e) -> {
            actionPerformed(e);
        };
    }

    protected void actionPerformed(ActionEvent e) {
       Strategy str = new Strategy(level);  
      // parm = 1 #Easy Level
      // parm = 2 #Normal Level
      // parm = 3 #Hard Level
        sql turn=new sql();      

        if (count <= 9 && end == false) {
            if (playerturn) {
                for (int i = 0; i < 9; i++) {
                    if (e.getSource() == btn[i]) {
                        if (btn[i].getText().equals("")) {
                            btn[i].setText(X);
                            str.setPlayer(i);
                            playerturn = false;
                            pos[count]=i+1;
                            System.out.println("pos X" +pos[count]);
                            count++;
                            System.out.println("btn" + i);
                            checkgame();
                        }
                    }
                }
            }
            if (!playerturn && !singleMode) {
                for (int i = 0; i < 9; i++) {
                    if (e.getSource() == btn[i]) {
                        if (btn[i].getText().equals("")) {
                            btn[i].setText(O);
                            playerturn = true;
                            pos[count]=i+1;
                            System.out.println("pos O" +pos[count]);
                            count++;
                            System.out.println("btn" + i);
                            checkgame();
                        }
                    }
                }
            }
            if (singleMode && !playerturn && count != 9 && !end) {
                int r = str.move(O);
                System.out.println(r);
                pos[count]=r+1;
                count++;
                btn[r].setText(O);
                str.setComp(r);
                playerturn = true;
                checkgame();
            }
        }
        
        if (count == 9 || end == true) {
            dbObj obj = new dbObj();
            turn.record2(pos[0], pos[1], pos[2], pos[3], pos[4], pos[5], pos[6], pos[7], pos[8]);
            reset();
            if(singleMode){
            button1.getParent().getScene().setRoot(new videoPlay(state));
        }
        }
    }

    private void checkgame() {

        String[] p;
        String sp = X;
        int i, j, k;
        String winner = null;
        sql db=new sql();
        p = new String[9];

        for (i = 0; i < 9; i++) {
            p[i] = btn[i].getText();
        }

        for (int x = 0; x < 2; x++) {
            for (j = k = 0; j < 9; j += 3, k++) {
                if ((sp.equals(p[j]) && sp.equals(p[j + 1]) && sp.equals(p[j + 2])) // Check The Rows 
                        || (sp.equals(p[k]) && sp.equals(p[k + 3]) && sp.equals(p[k + 6])) // Check The Columns
                        ) {
                    if (X.equals(sp)) {
                        if(!singleMode){
                            openDialog("Player " + sp + " won");}
                            state = "winning.mp4";  
                            winner="Player1";
                    }
                    if (O.equals(sp)) {
                        if(!singleMode){
                            openDialog("Player " + sp + " won");}
                            state = "losing.mp4"; 
                            winner="Player2";
                    }
                    end = true;
                    stop();}
                }
            if ((sp.equals(p[0]) && sp.equals(p[4]) && sp.equals(p[8])) // Check Diagnoal (\)
                    || (sp.equals(p[6]) && sp.equals(p[4]) && sp.equals(p[2])) // Check Diagonal (/)
                    ) {
                if (X.equals(sp)) {
                    if(!singleMode){
                        openDialog("Player " + sp + " won");}
                        state = "winning.mp4";                     
                        winner="Player1";
                }
                if (O.equals(sp)) {
                    if(!singleMode){
                        openDialog("Player " + sp + " won");}
                        state = "losing.mp4";
                        winner="Player2";
                }
                end = true;
                stop();}
            sp = O;
        }

        if (count == 9 && end == false) {
            if(!singleMode){
                openDialog("It's a Tie");}
                state = "tie.mp4";
                winner="Tie";
        }
        if(winner!=null){
        db.update(winner);
        }
    }

    private void reset(){
        Strategy str = new Strategy(0);
        
        str.resetStr();
        count = 0;
        for(int i = 0 ; i < 9 ; i++){
            btn[i].setText("");}
        playerturn = true;
        end = false;
    }

    private void stop() {
        System.out.println("Thank you for playing");
        //System.exit(0);
    }
    
    void openDialog(String content) {
        Dialog <String> dialog = new Dialog();
        dialog.setResizable(false);
        
        StackPane pane = new StackPane();
        Text text = new Text(content);
        pane.getChildren().add(text);
        
        dialog.getDialogPane().setContent(pane);
        
        ButtonType quitBtn = new ButtonType("Quit");
        
        ButtonType resetBtn =  new ButtonType("Main Menu");
        
        dialog.getDialogPane().getButtonTypes().addAll(quitBtn, resetBtn);
        
        dialog.setResultConverter(new Callback<ButtonType, String>() {
            @Override
            public String call(ButtonType b) {
                if (b == resetBtn) {
                    return "reset";
                }
                return "quit";
            }
        });

        Optional<String> result = dialog.showAndWait();

        if (result.isPresent()) {
            if (result.get().equals("reset"))
                button.getParent().getScene().setRoot(new Base());
            else
                System.exit(0);
        }
    }
}
