package products.components;

public class ShelfLife {
    private int dateOfManufacture;
    private int storageTemperature;
    private int durationOfShelfLife;

    public int getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(int dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public int getStorageTemperature() {
        return storageTemperature;
    }

    public void setStorageTemperature(int storageTemperature) {
        this.storageTemperature = storageTemperature;
    }

    public int getDurationOfShelfLife() {
        return durationOfShelfLife;
    }

    public void setDurationOfShelfLife(int durationOfShelfLife) {
        this.durationOfShelfLife = durationOfShelfLife;
    }

    public ShelfLife(int dateOfManufacture, int storageTemperature, int durationOfShelfLife) {
        this.dateOfManufacture = dateOfManufacture;
        this.storageTemperature = storageTemperature;
        this.durationOfShelfLife = durationOfShelfLife;
    }
}
