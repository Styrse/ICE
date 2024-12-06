package ice.ice.controllers;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

public class FrontSceneController {
    @FXML
    void handleCreateAccount(ActionEvent event) {
        System.out.println("New user");
    }

    @FXML
    void handleLogin(ActionEvent event) {
        System.out.println("Login");
    }
}