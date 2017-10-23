package products.foodstuffs;

import products.components.ShelfLife;

public class Vegetables extends Food {
    private String variety;

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public Vegetables(int id, int name, int quantity, float price, ShelfLife shelfLife, String variety) {
        super(id, name, quantity, price, shelfLife);
        this.variety = variety;
    }
}
