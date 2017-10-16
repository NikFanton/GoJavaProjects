package real.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import player.derived.*;
import real.RealPlayer;

import java.io.File;

public class XMainWindow extends Application{

    public static void initPlayer(Pane root, RealPlayer player) {
        double posX = 10, posY = 20;
        Button btnPlay = new Button("Play");
        Button btnStop = new Button("Stop");
        Button btnPrev = new Button("Prev");
        Button btnNext = new Button("Next");
        double minWidth = 50;
        btnPlay.setMinWidth(minWidth);
        btnStop.setMinWidth(minWidth);
        btnPrev.setMinWidth(minWidth);
        btnNext.setMinWidth(minWidth);
        btnPlay.setTranslateX(posX);
        btnStop.setTranslateX(btnPlay.getTranslateX() + minWidth + 2);
        btnPrev.setTranslateX(btnStop.getTranslateX() + minWidth + 2);
        btnNext.setTranslateX(btnPrev.getTranslateX() + minWidth + 2);
        btnPlay.setTranslateY(posY);
        btnStop.setTranslateY(posY);
        btnPrev.setTranslateY(posY);
        btnNext.setTranslateY(posY);
        btnPlay.setOnMouseClicked(event -> player.playSong());
        btnStop.setOnMouseClicked(event -> player.stopSong());
        btnPrev.setOnMouseClicked(event -> player.previousSong());
        btnNext.setOnMouseClicked(event -> player.nextSong());

        Label lblPlaylist = new Label();
        lblPlaylist.setTranslateY(posY + 50);
        for (int i = 0; i < player.getTracks().size(); i++) {
            lblPlaylist.setText(lblPlaylist.getText() + "\n" + (i+1) + " - " + player.getTracks().get(i).getName());
        }
        root.getChildren().addAll(btnPlay, btnStop, btnPrev, btnNext, lblPlaylist);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("MP3-Player");
        primaryStage.setWidth(900);
        primaryStage.setHeight(500);
        Pane root = new Pane();
        RealPlayer player = new RealPlayer(new File("D:\\music"));
        initPlayer(root, player);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
