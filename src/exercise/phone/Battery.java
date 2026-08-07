package exercise.phone;

public class Battery {

    int capacity;

    public Battery(int capacity) {
        this.capacity = capacity;
    }

    public void showBattery() {
        System.out.println("배터리 용량: " + capacity);
    }
}
