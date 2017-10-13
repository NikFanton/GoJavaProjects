package player.derived;

import player.base.SingleMP3Player;

public class Player1 extends SingleMP3Player {

    public Player1(float price) {
        super(price);
    }

    @Override
    public void playSong() {
        System.out.println("\tPlaying: " + getSong());
    }
}
