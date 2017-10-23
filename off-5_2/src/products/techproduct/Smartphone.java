package products.techproduct;

import products.components.specifications.SmartphoneTechSpecification;

public class Smartphone extends TechProduct {

    private SmartphoneTechSpecification smartphoneTechSpecification;

    public SmartphoneTechSpecification getSmartphoneTechSpecification() {
        return smartphoneTechSpecification;
    }

    public void setSmartphoneTechSpecification(SmartphoneTechSpecification smartphoneTechSpecification) {
        this.smartphoneTechSpecification = smartphoneTechSpecification;
    }

    public Smartphone(int id, int name, int quantity, float price, SmartphoneTechSpecification smartphoneTechSpecification) {
        super(id, name, quantity, price);
        this.smartphoneTechSpecification = smartphoneTechSpecification;
    }
}
