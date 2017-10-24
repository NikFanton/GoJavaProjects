package employees;

public abstract class SuperEmployee {
    protected String name;
    protected String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public SuperEmployee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public abstract void show();

    public abstract float calcSalary();
}
