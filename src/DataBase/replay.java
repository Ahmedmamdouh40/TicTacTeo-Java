package DataBase;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import video.audioPlay;

public class replay extends BorderPane {

    Thread t;
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final AnchorPane anchorPane;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;
    protected final Button button4;
    protected final Button button5;
    protected final Button button6;
    protected final Button button7;
    protected final Button play;
    protected final Button back;
    audioPlay audio = new audioPlay();

    Button[] btn = new Button[100];
    boolean playerturn = true;
    int count = 0;
    static final int[] pos = new int[10];
    static int pp = 0;
    int k = 0;
    int x = 0;
    int g = 0;
    sql s = new sql();
    PosObj ps = new PosObj();
    boolean stopFlag = true;

    public replay() {
        imageView = new ImageView();
        imageView0 = new ImageView();
        anchorPane = new AnchorPane();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        button6 = new Button();
        button7 = new Button();
        play = new Button();
        back = new Button();
        btn[0] = button;
        btn[1] = button0;
        btn[2] = button1;
        btn[3] = button2;
        btn[4] = button4;
        btn[5] = button5;
        btn[6] = button3;
        btn[7] = button6;
        btn[8] = button7;
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(360.0);
        setPrefWidth(420.0);

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
        
//        button.setMnemonicParsing(false);
//        button.setPrefHeight(111.0);
//        button.setPrefWidth(136.0);
        button.getStyleClass().add("bluebtn");

//        button0.setMnemonicParsing(false);
//        button0.setPrefHeight(111.0);
//        button0.setPrefWidth(136.0);
        button0.getStyleClass().add("whitebtn");

//        button1.setMnemonicParsing(false);
//        button1.setPrefHeight(111.0);
//        button1.setPrefWidth(136.0);
        button1.getStyleClass().add("bluebtn");
        //button1.getStylesheets().add("/game/style.css");

//        button2.setMnemonicParsing(false);
//        button2.setPrefHeight(111.0);
//        button2.setPrefWidth(136.0);
        button2.getStyleClass().add("whitebtn");

//        button3.setMnemonicParsing(false);
//        button3.setPrefHeight(111.0);
//        button3.setPrefWidth(136.0);
        button3.getStyleClass().add("bluebtn");

//        button4.setMnemonicParsing(false);
//        button4.setPrefHeight(111.0);
//        button4.setPrefWidth(136.0);
        button4.getStyleClass().add("bluebtn");

//        button5.setMnemonicParsing(false);
//        button5.setPrefHeight(111.0);
//        button5.setPrefWidth(136.0);
        button5.getStyleClass().add("whitebtn");

//        button6.setMnemonicParsing(false);
//        button6.setPrefHeight(111.0);
//        button6.setPrefWidth(136.0);
        button6.getStyleClass().add("whitebtn");

//        button7.setMnemonicParsing(false);
//        button7.setPrefHeight(111.0);
//        button7.setPrefWidth(136.0);
        button7.getStyleClass().add("bluebtn");

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(360.0);
        anchorPane.setPrefWidth(579.0);
        button.setLayoutX(30.0);
        button.setLayoutY(30.0);
        button0.setLayoutX(170.0);
        button0.setLayoutY(30.0);
        button1.setLayoutX(310.0);
        button1.setLayoutY(30.0);
        button2.setLayoutX(30.0);
        button2.setLayoutY(150.0);
        button4.setLayoutX(170.0);
        button4.setLayoutY(150.0);
        button5.setLayoutX(310.0);
        button5.setLayoutY(150.0);
        button3.setLayoutX(30.0);
        button3.setLayoutY(270.0);
        button6.setLayoutX(170.0);
        button6.setLayoutY(270.0);
        button7.setLayoutX(310.0);
        button7.setLayoutY(270.0);
        back.setLayoutX(20);
        back.setLayoutY(400);
        play.setLayoutX(350);
        play.setLayoutY(400);
        setTop(anchorPane);

        play.setMnemonicParsing(false);
        play.setOnMouseClicked(this::mouseclicked);
        play.setPrefHeight(30.0);
        play.setPrefWidth(70.0);
        play.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        play.setFont(new Font(16.0));
        play.setText("Replay");

        back.setMnemonicParsing(false);
        back.setOnMouseClicked(this::mouseclicked);
        back.setPrefHeight(30.0);
        back.setPrefWidth(70.0);
        back.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        back.setFont(new Font(16.0));
        back.setText("Back");

        for (int j = 0; j < 9; j++) {
            btn[j].setMnemonicParsing(false);
            btn[j].setPrefHeight(120.0);
            btn[j].setPrefWidth(140.0);
            btn[j].setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
            btn[j].setFont(new Font(51.0));
        }
        play.setOnAction((ActionEvent e)->{
            audio.play();
            if (ps.getFlag() == 1) {
            PosObj po = s.viewRecord();
            if (po != null) {
                pos[0] = po.pos1;
                pos[1] = po.pos2;
                pos[2] = po.pos3;
                pos[3] = po.pos4;
                pos[4] = po.pos5;
                pos[5] = po.pos6;
                pos[6] = po.pos7;
                pos[7] = po.pos8;
                pos[8] = po.pos9;
            }}
        Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            actionPerformed(e);
                        } catch (Exception ex) {
                            System.out.println("cant run method");
                        }
                    }
                };

                Thread backgroundThread = new Thread(task);
                backgroundThread.setDaemon(true);
                backgroundThread.start();
        });
        back.setOnAction((ActionEvent e) -> {
            audio.play();
            back.getParent().getScene().setRoot(new viewer());
        });
        anchorPane.getChildren().add(imageView);
        anchorPane.getChildren().add(imageView0);
        anchorPane.getChildren().add(button);
        anchorPane.getChildren().add(button0);
        anchorPane.getChildren().add(button1);
        anchorPane.getChildren().add(button2);
        anchorPane.getChildren().add(button3);
        anchorPane.getChildren().add(button4);
        anchorPane.getChildren().add(button5);
        anchorPane.getChildren().add(button6);
        anchorPane.getChildren().add(button7);
        anchorPane.getChildren().add(play);
        anchorPane.getChildren().add(back);
    }

    protected void mouseclicked(javafx.scene.input.MouseEvent mouseEvent) {
        EventHandler<ActionEvent> eventHandler = (ActionEvent e) -> {
            actionPerformed(e);
        };
    }

    private void actionPerformed(ActionEvent e) {
        for(g=0;g<9;g++){
            play();
        }
            }
    protected void play(){
        
            for (x = 0; x < 9 && pos[x]!=0; x++) {
               try{ for(k=0;k<9;k++){    
                if (playerturn) {      
                       pp = pos[x];
                      
                        Platform.runLater(new Runnable(){
                            @Override
                            public void run() {
                            if (btn[pp - 1].getText().equals("")) {
                            btn[pp - 1].setText("X");
                            System.out.println("X" + x + pp);
                            playerturn = false;

                        }
                            }
                    });
                    }else {
                     pp=pos[x];
                        Platform.runLater(new Runnable(){
                            @Override
                            public void run() {
                            if (btn[pp - 1].getText().equals("")) {
                            btn[pp - 1].setText("O");
                            System.out.println("O" + x + pp);
                            playerturn = true;

                        }
                            }
                    });
                        break;
                    }
                }
                Thread.sleep(3000);
               }catch(Exception ex){
                   ex.printStackTrace();
               }
            }
    }
    
}
