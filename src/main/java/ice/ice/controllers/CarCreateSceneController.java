package ice.ice.controllers;

import ice.ice.Car;
import ice.ice.FuelType;
import ice.ice.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CarCreateSceneController {
    public void initialize(){
        fuelTypeChoiceBox.getItems().addAll(FuelType.GASOLINE.getType(), FuelType.DIESEL.getType(),FuelType.ELECTRIC.getType());
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

    public ChoiceBox<String> getFuelTypeChoiceBox() {
        return fuelTypeChoiceBox;
    }

    @FXML
    void handleCreate(ActionEvent event) {
        String licensePlate = getLicensePlateTextField();
        String kmPrLiter = getKmPrLiterTextField();
        String fuelType = String.valueOf(getFuelTypeChoiceBox());

        if (licensePlate.isEmpty() && kmPrLiter.isEmpty()){
            invalidInput.setText("Please enter a license plate or manually add car");
        } else if (!licensePlate.isEmpty() && !kmPrLiter.isEmpty()){
            invalidInput.setText("Please only add license plate or manually add car");
        } else if (!licensePlate.isEmpty() && kmPrLiter.isEmpty()) {
            if (!licensePlate.isEmpty()){
                //srry Styrbjørn efter implementeringen af den nye car class måtte vi bruge den hardcoded value som er i constructoren i car klassen
                Platform.getInstance().getCurrentUser().setMyCar(new Car(Platform.getInstance().getCurrentUser(),
                        licensePlate,
                        "Skoda",
                        FuelType.GASOLINE,
                        13.57,
                        200));
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
                    //srry Styrbjørn efter implementeringen af den nye car class måtte vi
                    // bruge den hardcoded value i setMyCar.
                    Platform.getInstance().getCurrentUser().setMyCar(new Car(Platform.getInstance().getCurrentUser(), "Insert License Plate", "Insert Car Brand", FuelType.ELECTRIC, 12, 100));
                    Scene scene = ControllersUtil.loadScene("mainMenuScene.fxml");
                    Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                    ControllersUtil.setShowScene(stage, scene);
                }
            }
        }
    }

    @FXML
    void handleGoBackButton(ActionEvent event) {
        Scene scene = ControllersUtil.loadScene("transportScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }
}
