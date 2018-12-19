package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainPaneController implements Initializable {

	@FXML
	private FirstPaneController firstPaneController;

	@FXML
	private StackPane mainStack;

	@FXML
	private VBox second;

	@FXML
	private Button back;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		VBox first = (VBox) mainStack.getChildren().get(0);
		first.toFront();
		second.toBack();
		
		firstPaneController.getNext().setOnAction(x -> second.toFront());
		back.setOnAction(x -> first.toFront());
	}

}
