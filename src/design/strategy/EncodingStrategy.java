package design.strategy; // 1

// 전략 인터페이스 : 모든 인코딩 전략 클래스가 지켜야 하는 규칙
public interface EncodingStrategy {
    String encode(String text);
}
