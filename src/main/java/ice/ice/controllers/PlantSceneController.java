package ice.ice.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

        }
    }

    @FXML
    void handleTeamTreesHyperlink(ActionEvent event) {

    }

}
