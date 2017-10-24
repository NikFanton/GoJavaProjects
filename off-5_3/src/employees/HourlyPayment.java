package employees;

public class HourlyPayment extends SuperEmployee {

    private float hourlyPayment;
    private float workingHoursPerDay;
    private float workingDaysPerMonth;

    public float getHourlyPayment() {
        return hourlyPayment;
    }

    public float getWorkingHoursPerDay() {
        return workingHoursPerDay;
    }

    public float getWorkingDaysPerMonth() {
        return workingDaysPerMonth;
    }

    public HourlyPayment(String name, String surname, float hourlyPayment, float workingHoursPerDay, float workingDaysPerMonth) {
        super(name, surname);
        this.hourlyPayment = hourlyPayment;
        this.workingHoursPerDay = workingHoursPerDay;
        this.workingDaysPerMonth = workingDaysPerMonth;
    }

    @Override
    public void show() {
        System.out.println("-----------------------------------");
        System.out.println("Name:                   " + name);
        System.out.println("Surname:                " + surname);
        System.out.println("Hourly Payment:         " + hourlyPayment);
        System.out.println("Working Hours Per Day:  " + workingHoursPerDay);
        System.out.println("Working Days Per Month: " + workingDaysPerMonth);
        System.out.println("Monthly Payment:        " + calcSalary());
        System.out.println("-----------------------------------");
    }

    @Override
    public float calcSalary() {
        return workingDaysPerMonth * workingHoursPerDay * hourlyPayment;
    }
}
