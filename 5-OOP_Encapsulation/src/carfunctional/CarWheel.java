package carfunctional;

public class CarWheel {

    private float busCondition;

    public CarWheel() {
        this.busCondition = 1;
    }

    public CarWheel(float percent) {
        if (percent >= 0 && percent <= 100) {
            this.busCondition = percent/100;
        } else {
            this.busCondition = 1;
        }
    }

    public float getBusCondition() {
        return busCondition;
    }

    public void changeBus() {
        busCondition = 1;
    }

    public boolean eraseBus(float percent) {
        if (percent >= 0 && percent <= 100) {
            if (percent/100 > busCondition) {
                busCondition = 0;
            } else {
                this.busCondition -= percent / 100;
            }
            return true;
        }
        return false;
    }

    public void showInfo() {
        System.out.println("Bus erased on " + (100 - busCondition*100) + "%");
    }

    public static void main(String[] args) {
        CarWheel carWheel = new CarWheel();
        carWheel.eraseBus(13);
        carWheel.showInfo();
        carWheel.changeBus();
        carWheel.showInfo();
        carWheel.eraseBus(20);
        carWheel.eraseBus(90);
        carWheel.showInfo();
    }
}
