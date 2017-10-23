package products;

import products.components.Brand;

public class Clothes extends SuperProduct {
    private Brand brand;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Clothes(int id, int name, int quantity, float price, Brand brand) {
        super(id, name, quantity, price);
        this.brand = brand;
    }
}
