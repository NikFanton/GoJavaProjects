package player.derived;

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
}
