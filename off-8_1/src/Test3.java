import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;


public class Test3 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        File f = new File("d:\\Download\\Naruto Shippuuden 489 [fan-naruto.ru] [Ancord] [720p].mp4");
        Media media = new Media(f.toURI().toString());
        MediaPlayer mp = new MediaPlayer(media);
        MediaView mv = new MediaView();

        StackPane root = new StackPane();
        root.getChildren().add(mv);

        primaryStage.setScene(new Scene(root, 960, 540));
        primaryStage.setTitle("Video Player");
        primaryStage.show();
        mp.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
