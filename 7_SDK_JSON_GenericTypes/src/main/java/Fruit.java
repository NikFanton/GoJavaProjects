import java.util.Date;

public class Fruit {
    private TypeOfFruit typeOfFruit;
    private int shelfTime;
    private Date deliveryDate;
    private float price;

    public TypeOfFruit getTypeOfFruit() {
        return typeOfFruit;
    }

    public void setTypeOfFruit(TypeOfFruit typeOfFruit) {
        this.typeOfFruit = typeOfFruit;
    }

    public int getShelfTime() {
        return shelfTime;
    }

    public void setShelfTime(int shelfTime) {
        this.shelfTime = shelfTime;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Fruit(TypeOfFruit typeOfFruit, int shelfTime, Date deliveryDate, float price) {
        this.typeOfFruit = typeOfFruit;
        this.shelfTime = shelfTime;
        this.deliveryDate = deliveryDate;
        this.price = price;
    }

    @Override
    public String toString() {
        return ("\n\tDeliveryDate: " + deliveryDate.getDate() + "/" + deliveryDate.getMonth() + "/" + deliveryDate.getYear()
                + "\n\tPrice:        " + price
                + "\n\tShelfTime:    " + shelfTime
                + "\n\tType:         " + typeOfFruit
                + "\n\t--------------------------");
    }
}
