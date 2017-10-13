package player.base;

public abstract class MultiMP3Player extends MP3Player {

    private String[] playlist = new String[] {"Without Me", "Believer", "Hallie's Song"};

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

}
