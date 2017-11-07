package products;

public class AnimalProduct extends BaseProduct {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AnimalProduct(String name, double price, int age) {
        super(name, price);
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\tAge: " + age
                + "\n-----------------------\n";
    }
}
