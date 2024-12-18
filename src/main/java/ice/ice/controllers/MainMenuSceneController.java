package ice.ice.controllers;

import ice.ice.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainMenuSceneController {
    public void initialize() {
        plantedTreesLabel.setText("Planted trees: " + Platform.getInstance().getCurrentUser().getPlantedTrees());
    }

    @FXML
    private Button co2Button;

    @FXML
    private Button settingsButton;

    @FXML
    private Label plantedTreesLabel;

    @FXML
    public void handleTransportButton(ActionEvent event) {
        Scene scene = ControllersUtil.loadScene("addTransportScene.fxml");
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
