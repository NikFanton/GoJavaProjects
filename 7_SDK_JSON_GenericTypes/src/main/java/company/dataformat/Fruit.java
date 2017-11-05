package company.dataformat;

import company.dataformat.TypeOfFruit;

import java.util.Date;

public class Fruit {
    private TypeOfFruit typeOfFruit;
    private int shelfTime;
    private Date deliveryDate;
    private float price;
    private int count;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Fruit(TypeOfFruit typeOfFruit, int shelfTime, Date deliveryDate, float price, int count) {
        this.typeOfFruit = typeOfFruit;
        this.shelfTime = shelfTime;
        this.deliveryDate = deliveryDate;
        this.price = price;
        this.count = count;
    }

    @Override
    public String toString() {
        return ("\n\t\t\tDeliveryDate: " + deliveryDate.getDate() + "/" + deliveryDate.getMonth() + "/" + deliveryDate.getYear()
                + "\n\t\t\tPrice:        " + price
                + "\n\t\t\tShelfTime:    " + shelfTime
                + "\n\t\t\tType:         " + typeOfFruit
                + "\n\t\t\tCount:        " + count
                + "\n\t\t\t--------------------------");
    }
}
