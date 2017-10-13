package player.base;

public abstract class MP3Player {
    private final float price;

    public MP3Player(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public abstract void playSong();
}
