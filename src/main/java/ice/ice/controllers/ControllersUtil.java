package ice.ice.controllers;

import ice.ice.GUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllersUtil {

    public static Scene loadScene(String path){
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource(path));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return scene;
    }

    public static void setShowScene(Stage stage, Scene scene){
        stage.setScene(scene);
        stage.show();
    }
}
