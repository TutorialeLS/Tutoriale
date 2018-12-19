package controller;
 
import java.net.URL;
import java.util.ResourceBundle;
 
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
 
public class MainController implements Initializable {
 
    @FXML
    private Button clearButton;
 
    @FXML
    private TextArea inputTextArea;
 
    @FXML
    private TextArea outputTextArea;
 
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        inputTextArea.addEventFilter(KeyEvent.KEY_RELEASED, x -> outputTextArea
                .setText(new StringBuilder(inputTextArea.getText()).reverse()
                        .toString()));
        
        outputTextArea.addEventFilter(KeyEvent.KEY_RELEASED, x -> inputTextArea
                .setText(new StringBuilder(outputTextArea.getText()).reverse()
                        .toString()));
         
//        clearButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                inputTextArea.clear();
//                outputTextArea.clear();
//            }
//        });
        clearButton.addEventFilter(MouseEvent.MOUSE_PRESSED, x-> inputTextArea.clear());
        clearButton.addEventFilter(MouseEvent.MOUSE_PRESSED, x-> outputTextArea.clear());
    }
}