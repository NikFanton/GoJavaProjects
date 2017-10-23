package flowers;

public class Tulip extends SuperFlower {
    public Tulip() {
        super(45f);
    }

    @Override
    public void show() {
        System.out.print("Tulip ");
    }
}
