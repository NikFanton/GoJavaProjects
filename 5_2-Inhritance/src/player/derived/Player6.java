package player.derived;

import player.base.MultiMP3Player;

import java.util.Random;

public class Player6 extends MultiMP3Player {

    public Player6(float price) {
        super(price);
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
}
