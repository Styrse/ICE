package ice.ice.controllers;

import ice.ice.Address;
import ice.ice.Platform;
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
        String country = countryChoiceBox.getValue();

        if(street.isEmpty() || houseNumber.isEmpty() || postcode.isEmpty() || city.isEmpty() || country.isEmpty()){
            invalidInput.setText("Please fill out all the fields");
        } else {
            Platform.getInstance().getCurrentUser().setAddress(new Address(street, houseNumber, postcode, city, country));
            Scene scene = ControllersUtil.loadScene("transportScene.fxml");
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            ControllersUtil.setShowScene(stage, scene);
        }
    }

    @FXML
    void handleGoBackButton(ActionEvent event) {
        Scene scene = ControllersUtil.loadScene("createUserScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
        //TODO Maybe add deleteUser when going back to not have unused users - Look at this for all go back buttons in Controllers
    }
}
