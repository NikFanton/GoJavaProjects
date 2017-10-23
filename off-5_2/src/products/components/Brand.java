package products.components;

public class Brand {
    private int yearOfFoundation;
    private String name;
    private int numberOfEmployees;
    private int numberOfCountries;

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfCountries() {
        return numberOfCountries;
    }

    public void setNumberOfCountries(int numberOfCountries) {
        this.numberOfCountries = numberOfCountries;
    }

    public Brand(int yearOfFoundation, String name, int numberOfEmployees, int numberOfCountries) {
        this.yearOfFoundation = yearOfFoundation;
        this.name = name;
        this.numberOfEmployees = numberOfEmployees;
        this.numberOfCountries = numberOfCountries;
    }
}
