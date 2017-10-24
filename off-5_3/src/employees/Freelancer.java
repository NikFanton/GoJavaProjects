package employees;

public class Freelancer extends SuperEmployee {

    private float hourlyPayment;
    private float workingHours;

    public float getHourlyPayment() {
        return hourlyPayment;
    }

    public float getWorkingHours() {
        return workingHours;
    }

    public Freelancer(String name, String surname, float hourlyPayment, float workingHours) {
        super(name, surname);
        this.hourlyPayment = hourlyPayment;
        this.workingHours = workingHours;
    }

    @Override
    public void show() {
        System.out.println("-----------------------------------");
        System.out.println("Name:            " + name);
        System.out.println("Surname:         " + surname);
        System.out.println("Hourly Payment:  " + hourlyPayment);
        System.out.println("Working Hours:   " + workingHours);
        System.out.println("Monthly Payment: " + calcSalary());
        System.out.println("-----------------------------------");
    }

    @Override
    public float calcSalary() {
        return (hourlyPayment * workingHours);
    }
}
