package player.derived;

import player.base.SingleMP3Player;

public class Player2 extends SingleMP3Player {

    public Player2(float price) {
        super(price);
    }

    @Override
    public void playSong() {
        System.out.println("\terror");
    }
}
