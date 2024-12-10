package ice.ice.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class CreateUserSceneController {

    @FXML
    private ChoiceBox<?> countryChoiceBox;

    @FXML
    private ChoiceBox<?> genderChoiceBox;

    @FXML
    void handleAddress(ActionEvent event) {

    }

    @FXML
    void handleBirthday(ActionEvent event) {

    }

    @FXML
    void handleCreate(ActionEvent event) {

    }

    @FXML
    void handleName(ActionEvent event) {

    }

    @FXML
    void handlePassword(ActionEvent event) {

    }

    @FXML
    void handleUsername(ActionEvent event) {

    }

    @FXML
    void handleMainMenuButton(ActionEvent event) {
        Scene scene = ControllersUtil.loadScene("frontScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }
}
