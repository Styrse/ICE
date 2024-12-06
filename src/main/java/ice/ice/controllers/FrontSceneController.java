package ice.ice.controllers;

import ice.ice.GUI;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FrontSceneController {
    @FXML
    void handleCreateAccount(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("createUserScene.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), GUI.width, GUI.height);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
            //TODO Notify IT
        }
    }

    @FXML
    void handleLogin(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("loginScene.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 414, 896);
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}