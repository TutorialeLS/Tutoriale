package pl.javastart.fx.controller;
 
import java.net.URL;
import java.util.ResourceBundle;
 
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
 
public class MainController implements Initializable {
     
    @FXML
    private ContentPaneController contentPaneController;
     
    @FXML
    private ControlPaneController controlPaneController;
     
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Button lowerCase = controlPaneController.getLowerCaseButton();
        Button upperCase = controlPaneController.getUpperCaseButton();
        TextArea textArea = contentPaneController.getMainTextArea();
         
        lowerCase.setOnAction(x -> textArea.setText(textArea.getText().toLowerCase()));
        upperCase.setOnAction(x -> textArea.setText(textArea.getText().toUpperCase()));
    }
}