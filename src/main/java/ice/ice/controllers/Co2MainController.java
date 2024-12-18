package ice.ice.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Co2MainController {
    public void initialize() {
        vehicleTypeChoice.getItems().addAll("Train", "Bus", "Car");
        vehicleTypeChoice.setValue("Choose transportation type");
    }

    @FXML
    private ChoiceBox<String> vehicleTypeChoice;

    @FXML
    private Button goBackButton;

    public void handleMainMenu(ActionEvent event)   {
        Scene scene = ControllersUtil.loadScene("mainMenuScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }

    @FXML
    void handleContinueButton(ActionEvent event) {

    }
}
