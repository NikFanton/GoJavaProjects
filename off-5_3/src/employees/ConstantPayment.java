package employees;

public class ConstantPayment extends SuperEmployee {

    public float monthlyPayment;

    public float getMonthlyPayment() {
        return monthlyPayment;
    }

    public ConstantPayment(String name, String surname, float monthlyPayment) {
        super(name, surname);
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public void show() {
        System.out.println("-----------------------------------");
        System.out.println("Name:            " + name);
        System.out.println("Surname:         " + surname);
        System.out.println("Monthly Payment: " + monthlyPayment);
        System.out.println("-----------------------------------");
    }

    @Override
    public float calcSalary() {
        return monthlyPayment;
    }
}
