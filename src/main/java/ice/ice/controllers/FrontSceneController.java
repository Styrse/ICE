package ice.ice.controllers;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FrontSceneController {
    @FXML
    void handleCreateAccount(ActionEvent event) {
        Scene scene = ControllersUtil.loadScene("createUserScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }

    @FXML
    void handleLogin(ActionEvent event) {
        Scene scene = ControllersUtil.loadScene("loginScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }
}