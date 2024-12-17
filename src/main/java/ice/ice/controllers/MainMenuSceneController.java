package ice.ice.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuSceneController {

    @FXML
    private Button co2Button;

    @FXML
    private Button settingsButton;

    @FXML
    void handleCo2(ActionEvent event) {

    }

    public void handleCo2Menu(ActionEvent event)   {
        Scene scene = ControllersUtil.loadScene("Co2MainScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }

    @FXML
    void handleSettings(ActionEvent event) {
        Scene scene = ControllersUtil.loadScene("settingsScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }
}
