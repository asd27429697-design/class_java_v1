package design.adapter2;

public class ControllerAdapter implements NintendoProController{

    @Override
    public void connect() {
        System.out.println("스위치 연결");
    }
}
