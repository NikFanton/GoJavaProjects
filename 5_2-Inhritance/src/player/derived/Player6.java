package player.derived;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import player.base.MultiMP3Player;

import java.util.Random;

public class Player6 extends MultiMP3Player {

    private Button btnShuffle;
    public Player6(float price) {
        super(price);
    }

    public Button getBtnShuffle() {
        return btnShuffle;
    }

    @Override
    public void playSong() {
        System.out.println("\tPlaying: " + getSongByIndex(0));
    }

    @Override
    public void playAllSongs() {
        System.out.println("\t--------------------------");
        for (int i = 0; i < getPlaylist().length; i++) {
            System.out.println("\tPlaying: " + getSongByIndex(i));
        }
        System.out.println("\t--------------------------");
    }

    public void shuffle() {
        Random random = new Random();
        String temp;
        int randomIndex;
        int length = getPlaylist().length - 1;
        for (int i = 0; i <= length; i++) {
            randomIndex = random.nextInt(length);
            temp = getPlaylist()[i];
            getPlaylist()[i] = getPlaylist()[randomIndex];
            getPlaylist()[randomIndex] = temp;
        }
    }

    @Override
    public void show(Pane root, double x, double y) {
        super.show(root, x, y);

        btnShuffle = new Button("Shuffle");
        btnShuffle.setTranslateX(x);
        btnShuffle.setTranslateY(y + 70);
        btnShuffle.setMinWidth(100);
        root.getChildren().add(btnShuffle);
        btnShuffle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                shuffle();
                getLbl().setText("");
            }
        });

        getBtnPlayAll().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                getLbl().setText("");
                for (int i = getPlaylist().length - 1; i >= 0 ; i--) {
                    getLbl().setText(getLbl().getText() + "Playing: " + getSongByIndex(i) + "\n");
                }
            }
        });
        getBtn().setOnMouseClicked(event -> getLbl().setText("Playing: " + getSongByIndex(0)));
    }
}
