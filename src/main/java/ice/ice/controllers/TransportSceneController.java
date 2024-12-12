package ice.ice.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class TransportSceneController {
    @FXML
    private RadioButton bikeWalkRadioButton;

    @FXML
    private RadioButton busRadioButton;

    @FXML
    private RadioButton trainRadioButton;

    @FXML
    private RadioButton carRadioButton;

    @FXML
    private ToggleGroup transportToggleGroup;

    @FXML
    private Label invalidInput;

    @FXML
    private TextField kmPrTripTextField;

    @FXML
    private TextField recurringTripsTextField;

    @FXML
    void handleCreate(ActionEvent event) {
        String recurringTrips = recurringTripsTextField.getText().trim();
        String kmPrTrip = kmPrTripTextField.getText().trim();

        //TODO Simplify
        if (recurringTrips.isEmpty() || kmPrTrip.isEmpty()){
            invalidInput.setText("Fields cannot be empty");
        } else {
            if (kmPrTrip.contains(",")){
                for (int i = 0; i < kmPrTrip.length(); i++){
                    if (kmPrTrip.charAt(i) == ','){
                        kmPrTrip = kmPrTrip.replace(',', '.');
                        System.out.println(kmPrTrip);
                    }
                }
            } else if (!recurringTrips.matches("\\d+") || !kmPrTrip.matches("\\d+\\.?\\d*")){
                invalidInput.setText("Please only enter numbers");
            } else {
                int recurringTripsInt = Integer.parseInt(recurringTrips);
                float kmPrTripInt = Float.parseFloat(kmPrTrip);

                if (recurringTripsInt < 0 || kmPrTripInt < 0){
                    invalidInput.setText("Please enter a positive number");
                } else {
                    if (transportToggleGroup.getSelectedToggle() == null){
                        invalidInput.setText("Please select a type of transportation");
                    } else {
                        if (carRadioButton.isSelected()){
                            Scene scene = ControllersUtil.loadScene("carCreationScene.fxml");
                            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                            ControllersUtil.setShowScene(stage, scene);
                        } else {
                            Scene scene = ControllersUtil.loadScene("mainMenuScene.fxml");
                            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                            ControllersUtil.setShowScene(stage, scene);
                        }
                    }
                }
            }
        }
    }

    public void checkIfNumber(String check){
        if (!check.equals("^[0-9]")){
            invalidInput.setText("Please only enter numbers");
        } else {

        }
    }

    @FXML
    void handleGoBackButton(ActionEvent event) {
        Scene scene = ControllersUtil.loadScene("addressScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);

    }
}
