package design.adapter;

public class MyHouse {

    // 220v 콘센트에 전자기기를 연결하는 메서드를 가지고 있다.
    public static void plugIn(IElectronic220v device) {
        device.connect();
    }

    //
    public static void main(String[] args) {
        Cleaner cleaner = new Cleaner();
        HairDryer hairDryer = new HairDryer();
        plugIn(cleaner);
        // plugIn(hairDryer); 규격이 안 맞아 사용 못 함 !! (어댑터가 필요 함)
        ElectronicAdapter electronicAdapter = new ElectronicAdapter(hairDryer);
        plugIn(electronicAdapter);
    }

}
