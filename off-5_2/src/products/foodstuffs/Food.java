package products.foodstuffs;

import products.SuperProduct;
import products.components.ShelfLife;

public class Food extends SuperProduct {
    private ShelfLife shelfLife;

    public ShelfLife getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(ShelfLife shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Food(int id, int name, int quantity, float price, ShelfLife shelfLife) {
        super(id, name, quantity, price);
        this.shelfLife = shelfLife;
    }
}
