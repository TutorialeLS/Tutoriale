package pl.javastart.browser.app;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application implements Initializable {

	@FXML
	private WebView webView;

	@FXML

	private Button buttonPrev;
	
	@FXML

	private Button buttonNext;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent parent = (Parent) FXMLLoader.load(getClass().getResource("/pl/javastart/browser/app/BrowserPane.fxml"));
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.setTitle("MisiaBrowser");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		WebEngine engine = webView.getEngine();
		engine.load("http://google.pl");
		buttonPrev.setOnAction(x ->engine.executeScript("history.back();"));
		buttonNext.setOnAction(x ->engine.executeScript("history.forward();"));
	}

}