package ice.ice.controllers;

import ice.ice.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class PlantSceneController {
    private double averageTreeOffset = 24.62;

    @FXML
    private Label invalidInput;

    @FXML
    private TextField selfPlantedTreesTextField;

    @FXML
    private TextField payToPlantTreesTextField;

    public TextField getPayToPlantTreeTextField() {
        return payToPlantTreesTextField;
    }

    public TextField getSelfPlantedTreesTextField() {
        return selfPlantedTreesTextField;
    }

    @FXML
    void handlePlantButton(ActionEvent event) {
        String selfPlantTrees = selfPlantedTreesTextField.getText().trim();
        String payToPlantTrees = payToPlantTreesTextField.getText().trim();

        if (!selfPlantTrees.isEmpty() && !payToPlantTrees.isEmpty()){
            invalidInput.setText("Fields cannot be empty");
        } else if (selfPlantTrees.matches("\\d+") || payToPlantTrees.matches("\\d+")) {
                int selfPlantTreesInt = 0;
                int payToPlantTreesInt = 0;
                if (selfPlantTrees.isEmpty()){
                    payToPlantTreesInt = Integer.parseInt(payToPlantTrees);
                } else if (payToPlantTrees.isEmpty()) {
                    selfPlantTreesInt = Integer.parseInt(selfPlantTrees);
                }

                if (selfPlantTreesInt < 0 || payToPlantTreesInt < 0){
                    invalidInput.setText("Please enter a positive number");
                } else {
                    Platform.getInstance().getCurrentUser().addPlantedTrees(selfPlantTreesInt + payToPlantTreesInt);
                    Platform.getInstance().getCurrentUser().adjustCo2(- (selfPlantTreesInt + payToPlantTreesInt) * averageTreeOffset);

                    Scene scene = ControllersUtil.loadScene("mainMenuScene.fxml");
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    ControllersUtil.setShowScene(stage, scene);
                }
            } else {
            invalidInput.setText("Please only enter numbers");
        }
    }

    @FXML
    void handleTeamTreesHyperlink(ActionEvent event) {
        try {
            Desktop.getDesktop().browse(new URI("https://teamtrees.org/"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleMainMenu(ActionEvent event) {
        Scene scene = ControllersUtil.loadScene("mainMenuScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }
}
