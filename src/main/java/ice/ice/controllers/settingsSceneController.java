package ice.ice.controllers;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class settingsSceneController {

    @FXML
    private Button logoutButton;
    @FXML
    private AnchorPane scenePane;

    Stage stage;

    public void logout(ActionEvent event)   {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to logout!");
        alert.setContentText("Do you want to save your inputted data before exiting?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("You succesfully logged out");
            stage.close();
        }
    }

    public void handleMainMenu(ActionEvent event)   {
        Scene scene = ControllersUtil.loadScene("mainMenuScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }
}
