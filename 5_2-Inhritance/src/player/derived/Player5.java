package player.derived;

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
}
