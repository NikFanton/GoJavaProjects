package products.components.specifications;

import products.components.memory.RAM;

public class SuperTechSpecification {
    private RAM ram;
    private Processor processor;

    public SuperTechSpecification(RAM ram, Processor processor) {
        this.ram = ram;
        this.processor = processor;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }
}
