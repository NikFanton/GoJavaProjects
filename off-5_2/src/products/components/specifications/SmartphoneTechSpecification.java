package products.components.specifications;

import products.components.memory.RAM;

public class SmartphoneTechSpecification extends SuperTechSpecification {
    private String operatingSystem;
    private float screenDiagonal;
    private float batteryLifeTime;

    public SmartphoneTechSpecification(RAM ram, Processor processor, String operatingSystem, float screenDiagonal, float batteryLifeTime) {
        super(ram, processor);
        this.operatingSystem = operatingSystem;
        this.screenDiagonal = screenDiagonal;
        this.batteryLifeTime = batteryLifeTime;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public float getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(float screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }

    public float getBatteryLifeTime() {
        return batteryLifeTime;
    }

    public void setBatteryLifeTime(float batteryLifeTime) {
        this.batteryLifeTime = batteryLifeTime;
    }
}
