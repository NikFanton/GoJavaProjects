package products.components.specifications;

public class Processor {
    public int numberOfCores;
    public double coreClockFrequency;

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public double getCoreClockFrequency() {
        return coreClockFrequency;
    }

    public void setCoreClockFrequency(double coreClockFrequency) {
        this.coreClockFrequency = coreClockFrequency;
    }
}
