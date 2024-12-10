package ice.ice.controllers;

import ice.ice.Platform;
import ice.ice.User;
import ice.ice.UserMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginSceneController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = UserMapper.login(username, password);
        Platform.getInstance().setCurrentUser(user);

        if (user != null) {
            Scene scene = ControllersUtil.loadScene("mainMenuScene.fxml");
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            ControllersUtil.setShowScene(stage, scene);
        } else {
            //TODO Wrong username or password
        }
    }

    @FXML
    void handleMainMenuButton(ActionEvent event) {
        Scene scene = ControllersUtil.loadScene("frontScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }
}
