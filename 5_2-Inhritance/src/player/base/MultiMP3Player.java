package player.base;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public abstract class MultiMP3Player extends MP3Player {

    private Button btn;
    private String[] playlist = new String[] {"Without Me", "Believer", "Hallie's Song"};

    protected Button getBtnPlayAll() {
        return btn;
    }

    protected String[] getPlaylist() {
        return playlist;
    }

    protected String getSongByIndex(int i) {
        return playlist[i];
    }

    public MultiMP3Player(float price) {
        super(price);
    }

    public abstract void playAllSongs();

    @Override
    public void show(Pane root, double x, double y) {
        super.show(root, x, y);
        btn = new Button("Play All");
        btn.setTranslateX(x + getBtnPlayAll().getMinWidth());
        btn.setTranslateY(y + 35);
        btn.setMinWidth(100);
        root.getChildren().add(btn);
    }
}
