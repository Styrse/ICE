package ice.ice.controllers;

import ice.ice.GUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class loginSceneController {

    @FXML
    void handleLogin(ActionEvent event) {

    }

    @FXML
    void handlePassword(ActionEvent event) {

    }

    @FXML
    void handleUsername(ActionEvent event) {

    }

    @FXML
    void handleMainMenuButton(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("frontScene.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), GUI.width, GUI.height);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
