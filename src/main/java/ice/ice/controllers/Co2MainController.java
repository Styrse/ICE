package ice.ice.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Co2MainController {
    public void initialize() {
        vehicleTypeChoice.getItems().addAll("Train", "Bus", "Car");
        vehicleTypeChoice.setValue("Choose transportation type");
    }

    @FXML
    private Label invalidInput;

    @FXML
    private TextField travelTimeMinTextField;

    @FXML
    private ChoiceBox<String> vehicleTypeChoice;

    @FXML
    private Button goBackButton;

    public void handleMainMenu(ActionEvent event) {
        Scene scene = ControllersUtil.loadScene("mainMenuScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }

    @FXML
    void handleContinueButton(ActionEvent event) {
        String travelTimeMin = travelTimeMinTextField.getText().trim();
        String vehicleType = vehicleTypeChoice.getValue();

        if (travelTimeMin.isEmpty()) {
            invalidInput.setText("Travel time cannot empty");
        } else if (vehicleType.equals("Train") || vehicleType.equals("Bus") || vehicleType.equals("Car")) {
            if (!travelTimeMin.matches("\\d+")) {
                invalidInput.setText("Please only enter a whole number");
            } else {
                int travelTimeMinInt = Integer.parseInt(travelTimeMin);

                Scene scene = ControllersUtil.loadScene("mainMenuScene.fxml");
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                ControllersUtil.setShowScene(stage, scene);
            }
        } else {
            invalidInput.setText("Please choose a type of transportation");
        }
    }
}
