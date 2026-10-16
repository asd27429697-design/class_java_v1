package design.adapter;

public class Cleaner implements IElectronic220v {

    @Override
    public void connect() {
        System.out.println("청소기 연결 됨 (220v)");
    }
}
