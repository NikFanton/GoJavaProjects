package products.techproduct;

import products.components.specifications.ComputerTechSpecification;

public class Computer extends TechProduct {
    ComputerTechSpecification computerTechSpecification;

    public ComputerTechSpecification getComputerTechSpecification() {
        return computerTechSpecification;
    }

    public void setComputerTechSpecification(ComputerTechSpecification computerTechSpecification) {
        this.computerTechSpecification = computerTechSpecification;
    }

    public Computer(int id, int name, int quantity, float price, ComputerTechSpecification computerTechSpecification) {
        super(id, name, quantity, price);
        this.computerTechSpecification = computerTechSpecification;
    }
}
