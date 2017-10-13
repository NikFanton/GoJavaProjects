package player.base;

import player.base.MP3Player;

public abstract class SingleMP3Player extends MP3Player {

    private String song = "Believer";

    protected String getSong() {
        return song;
    }

    public SingleMP3Player(float price) {
        super(price);
    }


}
