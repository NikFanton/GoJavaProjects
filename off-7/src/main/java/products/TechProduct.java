package products;

public class TechProduct extends BaseProduct {
    private String description;
    private int guaranteeDuration;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGuaranteeDuration() {
        return guaranteeDuration;
    }

    public void setGuaranteeDuration(int guaranteeDuration) {
        this.guaranteeDuration = guaranteeDuration;
    }

    public TechProduct(String name, double price, String description, int guaranteeDuration) {
        super(name, price);
        this.description = description;
        this.guaranteeDuration = guaranteeDuration;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\tDescription: " + description
                + "\n\tGuarantee duration: " + guaranteeDuration
                + "\n-----------------------\n";
    }
}
