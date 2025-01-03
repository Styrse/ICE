package ice.ice;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GUI extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Platform p1 = new Platform("Ecospire");
        p1.setup();

        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("frontScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.getIcons().add(new Image(getClass().getResource("/images/logo.png").toExternalForm()));
        stage.setResizable(false);
        stage.setTitle(p1.getPlatformName());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
