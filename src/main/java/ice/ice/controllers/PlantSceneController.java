package ice.ice.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlantSceneController {

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

    }

}
