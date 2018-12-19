package pl.javastart.fxmvc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane loginAnchorPane;

    @FXML
    private TextField usernameTextField;

    @FXML
    private Button loginButton;

    @FXML
    private Label usernameLabel;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.println(usernameLabel.getText());
        usernameTextField.setText("Wpisz swoje imię");
    }

}
