import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class Test extends Application{
    MediaPlayer mediaPlayer;
    private Label time;
    Duration duration;
    Button fullScreenButton;
    Button btnPlay;
    Scene scene;
    Media media;
    double width;
    double height;
    MediaView mediaView;

    public Scene setScene(double width, double height) {
        this.height = height;
        this.width = width;
//Add your own path of the vidio that you want to play
        String path = "D:\\Projects\\GoJavaProjects\\off-8_1\\files\\cache\\wave.mp3";

        mediaPlayer = new MediaPlayer(new Media(new File(path).toURI().toString()));
//AutoPlay set to false
        mediaPlayer.setAutoPlay(false);
        mediaView = new MediaView(mediaPlayer);

// DropShadow effect
        DropShadow dropshadow = new DropShadow();
        dropshadow.setOffsetY(5.0);
        dropshadow.setOffsetX(5.0);
        dropshadow.setColor(Color.WHITE);

        mediaView.setEffect(dropshadow);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(mediaView);
        btnPlay = new Button("Play");
        btnPlay.setOnAction((event -> {
            mediaPlayer.play();
        }));
        borderPane.setBottom(btnPlay);

        borderPane.setStyle("-fx-background-color: Black");
        scene = new Scene(borderPane, 600, 600);
        scene.setFill(Color.BLACK);
        return scene;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        scene = setScene(this.width, this.height);

        primaryStage.setTitle("Media Player!");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
