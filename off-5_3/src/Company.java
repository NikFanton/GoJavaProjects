import employees.ConstantPayment;
import employees.Freelancer;
import employees.HourlyPayment;
import employees.SuperEmployee;

import java.io.*;

public class Company {
    private final static String FILE = "data.txt";
    private final static String PATH = "D:\\Projects\\GoJavaProjects\\off-5_3\\files\\" + FILE;
    private final static String SEPARATOR = ";";

    private SuperEmployee[] employees;
    private float expensesPerMonth = 0;


    public float calcExpensesPerMonth() {
        for (SuperEmployee employee : employees) {
            expensesPerMonth += employee.calcSalary();
        }
        return expensesPerMonth;
    }

    public void addEmployee(SuperEmployee employee) {
        SuperEmployee[] tmp = new SuperEmployee[employees.length + 1];
        for (int i = 0; i < employees.length; i++) {
            tmp[i] = employees[i];
        }
        tmp[employees.length] = employee;
        employees = tmp;
    }

    public void show() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getClass().equals(ConstantPayment.class)) {
                ConstantPayment constantPayment = (ConstantPayment)employees[i];
                constantPayment.show();
            } else if (employees[i].getClass().equals(HourlyPayment.class)) {
                HourlyPayment hourlyPayment = (HourlyPayment)employees[i];
                hourlyPayment.show();
            } else if (employees[i].getClass().equals(Freelancer.class)) {
                Freelancer freelancer = (Freelancer)employees[i];
                freelancer.show();
            }
        }
    }

    public void saveData() {
        try {
            FileWriter writer = new FileWriter(PATH);
            writer.write(employees.length + "\n");
            for (SuperEmployee employee: employees) {
                if (employee.getClass().equals(ConstantPayment.class)) {
                    ConstantPayment constantPayment = (ConstantPayment)employee;
                    writer.write(constantPayment.getClass().getSimpleName() + SEPARATOR);
                    writer.write(constantPayment.getName() + SEPARATOR);
                    writer.write(constantPayment.getSurname() + SEPARATOR);
                    writer.write("" + constantPayment.getMonthlyPayment());
                } else if (employee.getClass().equals(HourlyPayment.class)) {
                    HourlyPayment hourlyPayment = (HourlyPayment)employee;
                    writer.write(hourlyPayment.getClass().getSimpleName());
                    writer.write(hourlyPayment.getName() + SEPARATOR);
                    writer.write(hourlyPayment.getSurname() + SEPARATOR);
                    writer.write(hourlyPayment.getHourlyPayment() + SEPARATOR);
                    writer.write(hourlyPayment.getWorkingHoursPerDay() + SEPARATOR);
                    writer.write("" + hourlyPayment.getWorkingDaysPerMonth());
                } else if (employee.getClass().equals(Freelancer.class)) {
                    Freelancer freelancer = (Freelancer) employee;
                    writer.write(freelancer.getClass().getSimpleName() + SEPARATOR);
                    writer.write(freelancer.getName() + SEPARATOR);
                    writer.write(freelancer.getSurname() + SEPARATOR);
                    writer.write(freelancer.getHourlyPayment() + SEPARATOR);
                    writer.write("" + freelancer.getWorkingHours());
                }
                writer.write("\n");
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData() {
        FileReader reader = null;
        try {
            reader = new FileReader(PATH);
            BufferedReader bufferedReader = new BufferedReader(reader);
            int length = Integer.parseInt(bufferedReader.readLine());
            employees = new SuperEmployee[length];
            for (int i = 0; i < length; i++) {
                String line = bufferedReader.readLine();
                String[] data = line.split(SEPARATOR);
                if (data[0].equals(ConstantPayment.class.getSimpleName())) {
                    employees[i] = new ConstantPayment(data[1], data[2], Float.parseFloat(data[3]));
                } else if (data[0].equals(HourlyPayment.class.getSimpleName())) {
                    employees[i] = new HourlyPayment(
                            data[1],
                            data[2],
                            Float.parseFloat(data[3]),
                            Float.parseFloat(data[4]),
                            Float.parseFloat(data[5]));
                } else if (data[0].equals(Freelancer.class.getSimpleName())) {
                    employees[i] = new Freelancer(
                            data[1],
                            data[2],
                            Float.parseFloat(data[3]),
                            Float.parseFloat(data[4]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortEmployees() {
        int right = employees.length - 1;
        int left = 0;
        while (right >= left) {
            for (int i = left; i < right; i++) {
                if (employees[i].calcSalary() > employees[i+1].calcSalary()) {
                    SuperEmployee temp = employees[i];
                    employees[i] = employees[i+1];
                    employees[i+1] = temp;
                }
            }
            right--;

            for (int i = right; i > left; i--) {
                if (employees[i-1].calcSalary() > employees[i].calcSalary()) {
                    SuperEmployee temp = employees[i];
                    employees[i] = employees[i-1];
                    employees[i-1] = temp;
                }
            }
            left++;
        }
    }

    public void reverseSortEmployees() {
        int right = employees.length - 1;
        int left = 0;
        while (right >= left) {
            for (int i = left; i < right; i++) {
                if (employees[i].calcSalary() < employees[i+1].calcSalary()) {
                    SuperEmployee temp = employees[i];
                    employees[i] = employees[i+1];
                    employees[i+1] = temp;
                }
            }
            right--;

            for (int i = right; i > left; i--) {
                if (employees[i-1].calcSalary() < employees[i].calcSalary()) {
                    SuperEmployee temp = employees[i];
                    employees[i] = employees[i-1];
                    employees[i-1] = temp;
                }
            }
            left++;
        }
    }


    public static void main(String[] args) {
        Company goit = new Company();
        goit.loadData();
//        goit.addEmployee(new Freelancer("Perchuhi", "Darbinian", 15f, 160f));
//        goit.addEmployee(new ConstantPayment("Nikita", "Guchenko", 1000f));
        goit.show();
        goit.reverseSortEmployees();
        goit.show();
        goit.saveData();
    }
}
