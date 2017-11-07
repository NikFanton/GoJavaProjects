package products;

import java.util.ArrayList;

public class Store<Type> {
    private String name;
    private String address;
    public ArrayList<Type> products = new ArrayList<Type>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Store(String name, String address, ArrayList<Type> products) {
        this.name = name;
        this.address = address;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Store {"
                + "\n\tName: " + name
                + "\n\tAddress: " + address
                + "\n\tProducts {" + products + "}" + "}";
    }
}
