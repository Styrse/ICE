package ice.ice.controllers;

import ice.ice.UserMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddressSceneController {
    public void initialize() {

        countryChoiceBox.getItems().addAll("Denmark", "Sweden", "Italy");
        countryChoiceBox.setValue("Choose country");
    }

    @FXML
    private TextField streetTextField;

    @FXML
    private TextField houseNumberTextField;

    @FXML
    private TextField postcodeTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private ChoiceBox<String> countryChoiceBox;

    @FXML
    private Label invalidInput;

    @FXML
    void handleCreate(ActionEvent event) {
        String street = streetTextField.getText();
        String houseNumber = houseNumberTextField.getText();
        String postcode = postcodeTextField.getText();
        String city = cityTextField.getText();
        String country = String.valueOf(countryChoiceBox.getSelectionModel().getSelectedItem());

        if(street.isEmpty() || houseNumber.isEmpty() || postcode.isEmpty() || city.isEmpty() || country.isEmpty()){
            invalidInput.setText("Fields cannot be empty");
        }
    }

    @FXML
    void handleMainMenuButton(ActionEvent event) {
        Scene scene = ControllersUtil.loadScene("frontScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }
}
