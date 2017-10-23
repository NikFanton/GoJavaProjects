package flowers;

public abstract class SuperFlower {
    private float price;

    public SuperFlower(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public abstract void show();
}