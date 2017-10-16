package player.base;

import javafx.scene.layout.Pane;

public abstract class SingleMP3Player extends MP3Player {

    private String song = "Believer";

    protected String getSong() {
        return song;
    }

    public SingleMP3Player(float price) {
        super(price);
    }
}
