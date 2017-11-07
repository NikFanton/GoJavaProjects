package products;

public class FruitProduct extends BaseProduct {
    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public FruitProduct(String name, double price, double weight) {
        super(name, price);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\tWeight: " + weight
                + "\n-----------------------\n";
    }
}
