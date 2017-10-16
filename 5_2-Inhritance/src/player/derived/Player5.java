package player.derived;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import player.base.MultiMP3Player;

public class Player5 extends MultiMP3Player {

    public Player5(float price) {
        super(price);
    }

    @Override
    public void playSong() {
        System.out.println("\tPlaying: " + getSongByIndex(0));
    }

    @Override
    public void playAllSongs() {
        System.out.println("\t--------------------------");
        for (int i = getPlaylist().length - 1; i >= 0 ; i--) {
            System.out.println("\tPlaying: " + getSongByIndex(i));
        }
        System.out.println("\t--------------------------");
    }

    @Override
    public void show(Pane root, double x, double y) {
        super.show(root, x, y);
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
