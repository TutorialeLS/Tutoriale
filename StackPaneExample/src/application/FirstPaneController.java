package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class FirstPaneController implements Initializable{
	
	@FXML
	private Button next;
	
	public Button getNext() {
		return next;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
}
