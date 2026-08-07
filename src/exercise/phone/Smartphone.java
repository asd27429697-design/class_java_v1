package exercise.phone;

public class Smartphone {

    Battery battery;
    String model;

    public Smartphone(String model) {
        this.model = model;
        this.battery = new Battery(5000);

    }

    public void showInfo() {
        System.out.println("모델명 " + model);
        battery.showBattery();
    }
}
