package flowers;

public class Rose extends SuperFlower {
    public Rose() {
        super(100f);
    }

    @Override
    public void show() {
        System.out.print("Rose ");
    }
}
