package ice.ice.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CarCreateSceneController {
    public void initialize(){
        fuelTypeChoiceBox.getItems().addAll("Gasoline", "Diesel", "Electrical");
        fuelTypeChoiceBox.setValue("Choose fuel type");
    }

    @FXML
    private Label invalidInput;

    @FXML
    private ChoiceBox<String> fuelTypeChoiceBox;

    @FXML
    private TextField licensePlateTextField;

    @FXML
    private TextField kmPrLiterTextField;

    public String getLicensePlateTextField() {
        return licensePlateTextField.getText();
    }

    public String getKmPrLiterTextField() {
        return kmPrLiterTextField.getText();
    }

    @FXML
    void handleCreate(ActionEvent event) {
        String licensePlate = getLicensePlateTextField();
        String kmPrLiter = getKmPrLiterTextField();

        if (licensePlate.isEmpty() && kmPrLiter.isEmpty()){
            invalidInput.setText("Please enter a license plate or manually add car");
        } else if (!licensePlate.isEmpty() && !kmPrLiter.isEmpty()){
            invalidInput.setText("Please only add license plate or manually add car");
        } else if (!licensePlate.isEmpty() && kmPrLiter.isEmpty()) {
            if (!licensePlate.isEmpty()){
                //TODO Check the if statement up against an API
                Scene scene = ControllersUtil.loadScene("mainMenuScene.fxml");
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                ControllersUtil.setShowScene(stage, scene);
            } else {
                invalidInput.setText("License plate not found. Please enter manual information");
                if (!kmPrLiter.matches("\\d+")) {
                    invalidInput.setText("Please only enter numbers");
                } else if (fuelTypeChoiceBox.getItems().isEmpty()) {
                    invalidInput.setText("Please select a fuel type");
                } else {
                    Scene scene = ControllersUtil.loadScene("mainMenuScene.fxml");
                    Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                    ControllersUtil.setShowScene(stage, scene);
                }
            }
        }
    }

    @FXML
    void handleGoBackButton(ActionEvent event) {
        Scene scene = ControllersUtil.loadScene("addressScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }

}
