package pl.javastart.fxaction.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class MainController implements Initializable {

	@FXML
	private TextArea mainTextArea;

	@FXML
	private Button lowerCaseButton;

//	 @Override
//	 public void initialize(URL location, ResourceBundle resources) {
//	 lowerCaseButton.setOnAction(x ->
//	 mainTextArea.setText(mainTextArea.getText().toLowerCase()));
//	 System.out.println("to lower Case");
//	 } 
	//------------------------------------------------------------- to samo co poniżej jako funkcja Lambda
//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
//	    lowerCaseButton.setOnAction(new EventHandler<ActionEvent>() {
//	        @Override
//	        public void handle(ActionEvent event) {
//	            System.out.println("Wygenerowano zdarzenie " + event.getEventType());
//	            String text = mainTextArea.getText();
//	            mainTextArea.setText(text.toLowerCase());
//	        }
//	    });
//	}
	// ------------------------------------------------------------------------ obsluga przez domyslne metody kontrolek
//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
//	    lowerCaseButton.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
//	        @Override
//	        public void handle(ActionEvent event) {
//	            System.out.println("Wygenerowano zdarzenie " + event.getEventType());
//	            String text = mainTextArea.getText();
//	            mainTextArea.setText(text.toLowerCase());
//	        }
//	    });
//	     
//	    lowerCaseButton.addEventFilter(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//	        @Override
//	        public void handle(MouseEvent event) {
//	            System.out.println("Uwaga, kliknięcie nadchodzi!");
//	        }
//	    });
//	}
	//--------------------------------------------------------------------------------- obsluga przez EventFilter
	 @FXML
	    private void toLowerCaseAction(ActionEvent event) {
	        System.out.println("toLowerCaseAction()"); 
	        mainTextArea.setText(mainTextArea.getText().toLowerCase());	        
	    }
//	 @FXML
//	    private void onMouseButton(MouseEvent event) {
//		 lowerCaseButton.addEventFilter(MouseEvent.MOUSE_ENTERED, x -> System.out.println("Dowolne zdarzenie myszy"));
//	    }
//	 
//	 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
    }
}
