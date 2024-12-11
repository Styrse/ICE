package ice.ice.controllers;

import ice.ice.UserMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class CreateUserSceneController {
    public void initialize() {
        genderChoiceBox.getItems().addAll("Male", "Female", "Non-binary", "Transgender", "Other", "Prefer not to say");
        genderChoiceBox.setValue("Choose gender");
    }

    @FXML
    private Label invalidInput;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private TextField nameTextField;

    @FXML
    private ChoiceBox<String> genderChoiceBox;

    @FXML
    private DatePicker birthdayPicker;

    @FXML
    void handleCreate(ActionEvent event) {
        String username = usernameTextField.getText();
        String password = passwordPasswordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String name = nameTextField.getText();
        String gender = genderChoiceBox.getValue();
        String birthday = birthdayPicker.getId();

        if (UserMapper.checkDuplicateUsername(username)) {
            invalidInput.setText(username + " has already been taken");
        } else if (!password.equals(confirmPassword)) {
            invalidInput.setText("Password doesn't match");
            //TODO Strong password
        } else if (name.isEmpty()) {
            invalidInput.setText("Name field cannot be empty");
        } else if (gender.isEmpty()) {
            invalidInput.setText("Choose a gender");
        } else if (password.equals(confirmPassword)) {
            if (password.length() < 7){
                invalidInput.setText("Password must be longer than 6 characters");
            } else if (!password.matches("\\d.*")) {
                invalidInput.setText("Password must contain a number");
            } else if (!password.matches(".*[A-Z].*")) {
                invalidInput.setText("Password must contain a capital letter");
            } else if (!password.matches(".*[a-z].*")) {
                invalidInput.setText("Password must contain a small letter");
            } else if (!password.matches(".*[^a-zA-Z0-9\\s].*")) {
                invalidInput.setText("Password must contain a special character");
            } else {
                Scene scene = ControllersUtil.loadScene("addressScene.fxml");
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                ControllersUtil.setShowScene(stage, scene);
            }
        }
        //TODO birthday to be realistic before creating new instance of User and continuing to next scene
    }

    @FXML
    void handleMainMenuButton(ActionEvent event) {
        Scene scene = ControllersUtil.loadScene("frontScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }
}
