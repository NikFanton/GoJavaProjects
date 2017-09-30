package carfunctional;

public class Car {
    private final int date;
    private int engineType;
    private float maxSpeed;
    private float timeTo100KmPerHour;
    private int maxNumberOfPassengers;
    private int currentNumberOfPassengers;
    private float currentSpeed;
    private CarDoor[] doors = new CarDoor[4];
    private CarWheel[] wheels = new CarWheel[4];

    public Car(int date) {
        this.date = date;
    }

    public Car(int date, int engineType, float maxSpeed, float timeTo100KmPerHour, int maxNumberOfPassengers,
               int currentNumberOfPassengers, float currentSpeed) {
        this.date = date;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.timeTo100KmPerHour = timeTo100KmPerHour;
        this.maxNumberOfPassengers = maxNumberOfPassengers;
        this.currentNumberOfPassengers = currentNumberOfPassengers;
        this.currentSpeed = currentSpeed;

        for (int i = 0; i < doors.length; i++) {
            doors[i] = new CarDoor();
            wheels[i] = new CarWheel();
        }
    }

    public void setCurrentSpeed(float currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public boolean addPassenger() {
        if (currentNumberOfPassengers < maxNumberOfPassengers) {
            currentNumberOfPassengers++;
            return true;
        }
        return false;
    }

    public boolean landPassenger() {
        if (currentNumberOfPassengers > 0) {
            currentNumberOfPassengers--;
            return true;
        }
        return false;
    }

    public void landAllPassengers() {
        currentNumberOfPassengers = 0;
    }

    public CarDoor getDoorAt(int i) {
        return doors[i];
    }

    public CarWheel getWheelAt(int i) {
        return wheels[i];
    }

    public void removeAllWheels() {
        wheels = new CarWheel[0];
    }

    public void addWheels(int x) {
        int temp = wheels.length;
        wheels = new CarWheel[temp+x];
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = new CarWheel();
        }
    }

    public float calculateMaxSpeed() {
        if (wheels.length >= 4 && currentNumberOfPassengers > 0) {
            float min = wheels[0].getBusCondition();
            for (int i = 1; i < wheels.length; i++) {
                if (wheels[i].getBusCondition() < min) {
                    min = wheels[i].getBusCondition();
                }
            }
            return maxSpeed * min;
        } else {
            return 0;
        }
    }

    public void showInfo() {
        System.out.println("Date:             " + date);
        System.out.println("Engine type:      " + engineType);
        System.out.println("Max speed:        " + maxSpeed);
        System.out.println("Time to 100 km/h: " + timeTo100KmPerHour);
        System.out.println("Current speed:    " + currentSpeed);
        System.out.println("Max number of passengers:     " + maxNumberOfPassengers);
        System.out.println("Current number of passengers: " + currentNumberOfPassengers);
        float calculatedMaxSpeed = calculateMaxSpeed();
        if (calculatedMaxSpeed > 0) { System.out.println("Calculated max speed:         " + calculatedMaxSpeed); }
    }

    public static void main(String[] args) {
        Car car = new Car(2007, 2, 300, 2, 6, 1, 60);
        car.removeAllWheels();
        car.addWheels(5);
        car.getWheelAt(0).eraseBus(50);
        car.landAllPassengers();
        car.addPassenger();
        car.showInfo();
    }
}
