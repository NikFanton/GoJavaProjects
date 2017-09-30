package carfunctional;

public class CarDoor {

    private boolean isDoorOpen;
    private boolean isWindowOpen;

    public CarDoor(){
        this.isDoorOpen = false;
        this.isWindowOpen = false;
    }

    public CarDoor(boolean isDoorOpen, boolean isWindowOpen) {
        this.isDoorOpen = isDoorOpen;
        this.isWindowOpen = isWindowOpen;
    }

    public void openTheDoor() {
        isDoorOpen = true;
    }

    public void closeTheDoor() {
        isDoorOpen = false;
    }

    public void changeDoorState() {
        isDoorOpen = !isDoorOpen;
    }

    public void openTheWindow() {
        isWindowOpen = true;
    }

    public void closeTheWindow() {
        isWindowOpen = false;
    }

    public void changeWindowState() {
        isWindowOpen = !isWindowOpen;
    }

    public void showInfo() {
        System.out.println( "The door is " + ((isDoorOpen) ? "open" : "closed"));
        System.out.println( "The window is " + ((isWindowOpen) ? "open" : "closed"));
    }

    public static void main(String[] args) {
        CarDoor carDoor = new CarDoor(true, false);
        carDoor.closeTheDoor();
        carDoor.openTheWindow();
        carDoor.showInfo();
    }
}
