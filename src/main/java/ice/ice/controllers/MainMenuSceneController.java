package ice.ice.controllers;

import ice.ice.Platform;
import ice.ice.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainMenuSceneController {
    public void initialize() {
        updatePlantedTrees();
        updateSmiley();
        updateProgressBar();
    }

    private void updateProgressBar(){
        co2CounterLabel.setText(String.format("%.0f", User.fixedCo2PrYear/365 + Platform.getInstance().getCurrentUser().getDailyCo2Usage()) + " / " + String.format("%.0f", User.averageCo2EmissionPrYear/365));
        double co2Daily = User.fixedCo2PrYear/365 + Platform.getInstance().getCurrentUser().getDailyCo2Usage();
        double progressCo2Bar = co2Daily / (User.averageCo2EmissionPrYear/365);
        co2ProgressBar.setProgress(progressCo2Bar);
    }

    private void updatePlantedTrees(){
        plantedTreesLabel.setText("Planted trees: " + Platform.getInstance().getCurrentUser().getPlantedTrees());
    }

    private void updateSmiley(){Image embarrassedSmiley = new Image("file:src/main/resources/images/smiley/embarrassed.png");
        Image worriedSmiley = new Image("file:src/main/resources/images/smiley/worried.png");
        Image angrySmiley = new Image("file:src/main/resources/images/smiley/angry.png");
        if (User.fixedCo2PrYear/365 + Platform.getInstance().getCurrentUser().getDailyCo2Usage() < User.co2Goal2030){
            smileyImage.setImage(embarrassedSmiley);
        } else if (User.fixedCo2PrYear/365 + Platform.getInstance().getCurrentUser().getDailyCo2Usage() < User.fixedCo2PrYear) {
            smileyImage.setImage(worriedSmiley);
        } else if (User.fixedCo2PrYear/365 + Platform.getInstance().getCurrentUser().getDailyCo2Usage() > User.fixedCo2PrYear) {
            smileyImage.setImage(angrySmiley);
        }
    }

    @FXML
    private ProgressBar co2ProgressBar;

    @FXML
    private ImageView smileyImage;

    @FXML
    private Label co2CounterLabel;

    @FXML
    private Label plantedTreesLabel;

    @FXML
    public void handleTransportButton(ActionEvent event) {
        Scene scene = ControllersUtil.loadScene("addTransportScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }

    @FXML
    public void handleTreeButton(ActionEvent event){
        Scene scene = ControllersUtil.loadScene("plantTreeScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }

    @FXML
    void handleSettings(ActionEvent event) {
        Scene scene = ControllersUtil.loadScene("settingsScene.fxml");
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        ControllersUtil.setShowScene(stage, scene);
    }
}
