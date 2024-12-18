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

    @FXML
    public void handleTransportButton(ActionEvent event) {
        Scene scene = ControllersUtil.loadScene("co2MainScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }

    @FXML
    public void handleTreeButton(ActionEvent event){
        Scene scene = ControllersUtil.loadScene("plantTreeScene.fxml");
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
