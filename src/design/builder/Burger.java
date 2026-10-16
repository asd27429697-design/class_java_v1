package design.builder;

// 햄버거 클래스 : 빌더 패턴을 적용한 클래스를 설계해 보자
public class Burger {

    private String bread; // 빵
    private String patty; // 패티
    private String sauce; // 소스

    // 1. private 생성자 : 외부에서 new Burger()로 직접 만들 수 없게 함
    // 2. 빌더의 build() 메서드를 통해서만 객체가 만들어 지게 한다.
    private Burger(Builder builder) {
        this.bread = builder.bread;
        this.patty = builder.patty;
        this.sauce = builder.sauce;
    }

    // 정적 내부 클래스 설계
    public static class Builder {

        private String bread; // 빵
        private String patty; // 패티
        private String sauce; // 소스

        public Builder bread(String bread) {
            this.bread = bread;
            return this;
        }

        public Builder patty(String patty) {
            this.patty = patty;
            return this;
        }

        public Builder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        // 핵심 메서드 (마지막에 호출) : 모든 값으로 Burger 를 만들어 돌려 준다.
        public Burger builder() {
            // 외부 클래스를 생성해야 한다
            return new Burger(this);
        }
    } // end of inner class

    @Override
    public String toString() {
        return "Burger{" +
                "bread='" + bread + '\'' +
                ", patty='" + patty + '\'' +
                ", sauce='" + sauce + '\'' +
                '}';
    }
}
