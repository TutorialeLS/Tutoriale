package pl.javastart.app.volume;
 
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
 
public class VolumeController implements Initializable {
 
    @FXML
    private Slider volumeSlider;
 
    @FXML
    private Label volumeLevelLabel;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        volumeLevelLabel.textProperty().bind(
                volumeSlider.valueProperty().asString());
        volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                double volume = (Double) newValue;
                 
                if (volume > 75) {
                    System.out.println("Za głośno!");
                } else if (volume < 10) {
                    System.out.println("Nic nie słychać");
                }
                 
            }
        });
    }
}
