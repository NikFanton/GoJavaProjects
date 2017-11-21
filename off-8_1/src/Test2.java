import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class Test2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setHeight(600);
        primaryStage.setWidth(600);
        primaryStage.setTitle("File Viewer");
        Pane root = new Pane();

        String path = "files/cache/crowd-cheering.mp3";
        MediaPlayer player = new MediaPlayer(new Media(new File(path).toURI().toString()));
        player.play();

//        root.getChildren().add(player);

        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
