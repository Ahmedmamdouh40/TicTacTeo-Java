/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author AbdelHamid
 */
public class audioPlay {
                 Media sound = new Media(new File("src/video/audio.mp3").toURI().toString());
                 MediaPlayer mediaPlayer = new MediaPlayer(sound);

    public void play(){mediaPlayer.play();
                     try {
                         TimeUnit.MILLISECONDS.sleep(80);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(audioPlay.class.getName()).log(Level.SEVERE, null, ex);
                     }
}
}
