package design.adapter;

// 핵심 (어댑터 클래스)
// 110v 를 받아서 220v 나가도록 코드를 어떻게 설계 해야 할까?
public class ElectronicAdapter implements IElectronic220v{

    private IElectronic110v iElectronic110v;

    public ElectronicAdapter(IElectronic110v iElectronic110v) {
        this.iElectronic110v = iElectronic110v;
    }

    @Override
    public void connect() {
        // 내부적으로는 110v 의 제품 connect() 호출 함
        iElectronic110v.connect();
    }
}
