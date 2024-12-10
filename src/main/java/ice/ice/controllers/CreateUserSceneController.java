package ice.ice.controllers;

import ice.ice.UserMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateUserSceneController {
    public void initialize(){
        genderChoiceBox.getItems().addAll("Male", "Female", "Non-binary", "Transgender", "Other", "Prefer not to say");
        genderChoiceBox.setValue("Choose gender");

        countryChoiceBox.getItems().addAll("Denmark", "Sweden", "Italy");
        countryChoiceBox.setValue("Choose country");
    }

    @FXML
    private TextField addressTextField;

    @FXML
    private DatePicker birthdayPicker;

    @FXML
    private ChoiceBox<String> countryChoiceBox;

    @FXML
    private ChoiceBox<String> genderChoiceBox;

    @FXML
    private TextField nameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private TextField usernameTextField;

    @FXML
    void handleCreate(ActionEvent event) {
        String username = usernameTextField.getText();
        String password = passwordPasswordField.getText();
        String name = nameTextField.getText();
        String gender = String.valueOf(genderChoiceBox.getSelectionModel().getSelectedItem());
        String birthday = birthdayPicker.getId();
        String address = addressTextField.getText();
        String country = String.valueOf(countryChoiceBox.getSelectionModel().getSelectedItem());

        if (UserMapper.checkDuplicateUsername(username)){

        }
    }

    @FXML
    void handleMainMenuButton(ActionEvent event) {
        Scene scene = ControllersUtil.loadScene("frontScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }
}
