package player.derived;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import player.base.MultiMP3Player;

public class Player4 extends MultiMP3Player {

    public Player4(float price) {
        super(price);
    }

    @Override
    public void playSong() {
        System.out.println("\tPlaying: " + getSongByIndex(getPlaylist().length-1));
    }

    @Override
    public void playAllSongs() {
        System.out.println("\t--------------------------");
        for (int i = 0; i < getPlaylist().length; i++) {
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
                for (int i = 0; i < getPlaylist().length; i++) {
                    getLbl().setText(getLbl().getText() + "Playing: " + getSongByIndex(i) + "\n");
                }
            }
        });
        getBtn().setOnMouseClicked(event -> getLbl().setText("Playing: " + getSongByIndex(getPlaylist().length-1)));
    }
}
