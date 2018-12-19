package pl.javastart.media.app;
 
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
 
public class MainController implements Initializable {
     
	@FXML
	
	private ToggleButton toggleButton;
	
	
    @FXML
    private MediaView mediaView;
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Media media = new Media("http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv");
        MediaPlayer player = new MediaPlayer(media);
        player.setAutoPlay(true);
        mediaView.setMediaPlayer(player);
        toggleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(player.getStatus() == Status.READY || player.getStatus() == Status.PAUSED) {
                	player.play(); 
                	toggleButton.setText("Pause");
                } else {
                	player.pause(); 
                	toggleButton.setText("Play");
                }
            }
        });
    }
 
}