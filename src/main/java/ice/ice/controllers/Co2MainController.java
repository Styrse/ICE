package ice.ice.controllers;

import ice.ice.Transport;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Co2MainController {
    //Transport transport;

    @FXML
    private ChoiceBox<String> vehicleTypeChoice;

    @FXML
    private Button goBackButton;

    public void initializeVehicleType() {
        vehicleTypeChoice.getItems().addAll("Train Diesel", "Train Electric", "Bus", "Plain");
    }

    public void handleMainMenu(ActionEvent event)   {
        Scene scene = ControllersUtil.loadScene("mainMenuScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }
}
