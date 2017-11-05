package company.dataformat;

import company.dataformat.TypeOfFruit;

public class Client {
    private String name;
    private TypeOfFruit type;
    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeOfFruit getType() {
        return type;
    }

    public void setType(TypeOfFruit type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Client(String name, TypeOfFruit type, int count) {
        this.name = name;
        this.type = type;
        this.count = count;
    }

    @Override
    public String toString() {
        return ("\n\tName:  " + name
                + "\n\tType:  " + type
                + "\n\tCount: " + count
                + "\n\t--------------------------");
    }
}
