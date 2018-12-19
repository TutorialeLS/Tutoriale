package pl.javastart.notepad;
 
import java.net.URL;
import java.util.ResourceBundle;
 
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
 
public class TextController implements Initializable {
 
    @FXML
    private Button button;
 
    @FXML
    private TextArea textArea;
 
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        button.setOnAction(x -> textArea.clear());
    }
}