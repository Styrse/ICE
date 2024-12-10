package ice.ice.controllers;

import ice.ice.GUI;
import ice.ice.Platform;
import ice.ice.User;
import ice.ice.UserMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginSceneController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    public String getUsernameField() {
        return String.valueOf(usernameField);
    }

    public String getPasswordField() {
        return String.valueOf(passwordField);
    }

    @FXML
    void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        User user = UserMapper.login(username, password);
        Platform.getInstance().setCurrentUser(user);

        if (user != null) {
            FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("mainMenuScene.fxml"));
            try {
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
                //TODO Notify IT
            }
        } else {
            //TODO Wrong username or password
        }
    }


    @FXML
    void handleMainMenuButton(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("frontScene.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
            //TODO Notify IT
        }
    }
}
