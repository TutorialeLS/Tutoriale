package pl.javastart.youtufy.controller;
 
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import pl.javastart.youtufy.data.YoutubePlayer;
 
public class ControlPaneController implements Initializable {
 
    @FXML
    private Button nextButton;
 
    @FXML
    private Slider volumeSlider;
 
    public Slider getVolumeSlider() {
		return volumeSlider;
	}

	public void setVolumeSlider(Slider volumeSlider) {
		this.volumeSlider = volumeSlider;
	}

	public Slider getSongSlider() {
		return songSlider;
	}

	public void setSongSlider(Slider songSlider) {
		this.songSlider = songSlider;
	}

	@FXML
    private Button previousButton;
 
    public Button getNextButton() {
		return nextButton;
	}

	public void setNextButton(Button nextButton) {
		this.nextButton = nextButton;
	}

	public Button getPreviousButton() {
		return previousButton;
	}

	public void setPreviousButton(Button previousButton) {
		this.previousButton = previousButton;
	}

	@FXML
    private Slider songSlider;
 
    @FXML
    private ToggleButton playButton;
 
    public ToggleButton getPlayButton() {
		return playButton;
	}

	public void setPlayButton(ToggleButton playButton) {
		this.playButton = playButton;
	}

	@Override
    public void initialize(URL location, ResourceBundle resources) {
        // dodanie akcji przycisku dla playButton
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // jeśli przycisk nie był wciśnięty, to znaczy, że ma przejść w
                // Play
                // jeśli przycisk był wciśnięty, to po wciśnięciu przechodzi w
                // Stop
                if (playButton.isSelected()) {
                    System.out.println("Play");
                } else {
                    System.out.println("Stop");
                }
            }
        });
 
        // dodanie akcji dla previous i next
        previousButton.setOnAction(x -> System.out.println("Previous"));
 
        nextButton.setOnAction(x -> System.out.println("Next"));
    }
	protected void progressUpdate() {
	    Task<Void> progressTask = new Task<Void>() {
	        @Override
	        protected Void call() throws Exception {
	            while(!isCancelled()) {
	                if(playButton.isSelected() && YoutubePlayer.PLAYING.get()) {
	                    Platform.runLater(() -> songSlider.setValue(songSlider.getValue()+0.1));
	                }
	                Thread.sleep(100);
	            }
	            return null;
	        }
	    };
	    Thread t = new Thread(progressTask);
	    t.setDaemon(true);
	    t.start();
	}
}
