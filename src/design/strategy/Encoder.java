package design.strategy;


// 전략을 가지고 있다가 실제로 사용하는 객체
// 어떠 방식으로 인코딩하는지는 모르고, 인코딩은 받은 전략에게 일을 맡기기만 한다.
// GoF 패턴에서 정한 역활 이름이며, 전략이 실행되는 환경을 제공한다는 의미 이다.
// 컨텍스트 (Context) - 앞뒤 전후 맥락을 알고 있는 녀석이다.
public class Encoder {

    private EncodingStrategy strategy;

    // 생성할 때 전략을 반드시 받도록 하여 null 상태를 막아 준다.
    public Encoder(EncodingStrategy strategy) {
        this.strategy = strategy;
    }

    // 실행 중에 전략을 교체할 수 있도록 메서드를 만들어 준다.
    public void setStrategy(EncodingStrategy strategy) {
        this.strategy = strategy;
    }

    // 핵심 행동
    // 인코딩 작업을 현재 전략에게 위임한다 (((if-else 없음 ))
    public String encode(String text) {
        return strategy.encode(text);
    }

}
