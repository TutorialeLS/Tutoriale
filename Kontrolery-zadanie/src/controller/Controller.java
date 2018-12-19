package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {

    @FXML
    private VBox loginVBoxPane;

    @FXML
    private Label labelOneText;

    @FXML
    private Button buttonOne;

    @FXML
    private Label labelTwoText;

    @FXML
    private Button buttonTwo;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 labelOneText.setText("Misiolina");
	        labelTwoText.setText("Tak");
	        buttonOne.setText("Misiolina i dzieci");
	        buttonTwo.setText("Takx2");
		
	}

}
