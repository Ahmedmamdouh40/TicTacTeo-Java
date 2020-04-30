package DataBase;

import java.util.Vector;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import Gui.reg;
import video.audioPlay;

public class viewer extends AnchorPane {
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final Button[] btn = new Button[100];
    protected final Button button;
    protected final Button button0;
    protected final Button back;
    protected final ScrollPane scroller;
    audioPlay audio = new audioPlay();

    VBox content;
    dbObj obj = new dbObj();
    sql s = new sql();
    sql s1=new sql();
    sql s2=new sql();
    PosObj ps=new PosObj();
    replay re=new replay();
    Vector<String> r = new Vector<>();
    Vector<String> date = new Vector<>();
    int k=0;
    String ss;
    
    public viewer() {
        imageView = new ImageView();
        imageView0 = new ImageView();
        
        button = new Button();
        button0 = new Button();
        back = new Button();
        String flag;
        flag = "True";
        content = new VBox(5);
        scroller = new ScrollPane();
        scroller.setContent(content);
        scroller.setLayoutX(100);
        scroller.setLayoutY(10);
        scroller.setFitToWidth(true);
        scroller.setLayoutX(142.0);
        scroller.setPrefHeight(400.0);
        scroller.setPrefWidth(397.0);

        content.setPrefHeight(404.0);
        content.setPrefWidth(399.0);
        
        scroller.setContent(content);
        scroller.setStyle("-fx-background: transparent;\n -fx-background-color: transparent");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        
        back.setMnemonicParsing(false);
        back.setLayoutX(10);
        back.setLayoutY(10);
        back.setOnMouseClicked(this::mouseClicked);
        back.setPrefHeight(30.0);
        back.setPrefWidth(70.0);
        back.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        back.setFont(new Font(16.0));
        back.setText("Back");
        
        
        setId("AnchorPane");
        setPrefHeight(450.8);
        setPrefWidth(589.4);
        getStyleClass().add("backgroundbox");

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

        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(back);
        getChildren().add(scroller);
        
        r = (Vector)s.view().clone();
        
        date = (Vector)s1.viewDate().clone();
        for (int j = 0; j < r.size(); j++) {
            btn[j] = new Button();
            btn[j].setLayoutX(110.0);
            btn[j].setLayoutY(20.0 + (40.0 * j));
            btn[j].setMnemonicParsing(false);
            btn[j].setOnMouseClicked(this::mouseClicked);
            btn[j].setPrefHeight(60.0);
            btn[j].setPrefWidth(250.0);
            ss=r.get(j) + " " + date.get(j);
            btn[j].setText(ss);
            content.getChildren().add(btn[j]);
        }
        
        for(k=0;k<r.size();k++){
        btn[k].setOnAction((ActionEvent e) -> {
            actionPerformed(e);
        });
        }
        back.setOnAction((ActionEvent e) -> {
            audio.play();
            back.getParent().getScene().setRoot(new reg(true));
        });
        
    }

    protected void mouseClicked(javafx.scene.input.MouseEvent mouseEvent) {
        EventHandler<ActionEvent> eventHandler = (ActionEvent e) -> {
            actionPerformed(e);
        };
    }
    private void actionPerformed(ActionEvent e) {
        for(int j=0;j<r.size();j++){
        if (e.getSource() == btn[j]){
            String game_Name=r.get(j);
            ps.setName(game_Name);
            ps.setFlag(1);
            System.out.println(ps.getFlag());
            btn[j].getParent().getScene().setRoot(new replay());
        }}
    }
}
