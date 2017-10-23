package products.techproduct;

import products.SuperProduct;
import products.components.specifications.SuperTechSpecification;

public class TechProduct extends SuperProduct {

    private SuperTechSpecification techSpecification;

    public SuperTechSpecification getTechSpecification() {
        return techSpecification;
    }

    public void setTechSpecification(SuperTechSpecification techSpecification) {
        this.techSpecification = techSpecification;
    }

    public TechProduct(int id, int name, int quantity, float price) {
        super(id, name, quantity, price);
    }


}
