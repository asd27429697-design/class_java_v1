package design.adapter2;

public class DualSensePad implements NintendoSwitchController{

    @Override
    public void connect() {
        System.out.println("듀얼센스 연결");
    }
}
