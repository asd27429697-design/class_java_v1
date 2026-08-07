package useful.ch06;

/**
 * 제네릭 프로그래밍
 * 문법: 클래스, 데이터타입, 메서드 등에서 <T> 대체 문자열을 선언 할 수 있다.
 */
public class GenericPrinter<T> {

    // 데이터 타입에 대체문자 선언 가능, 단 클래스가 제네릭 클래스라고 선언이 되어야 한다.
    // 자료형 매개 변수 (type Parameter)
    T material;

    public T getMaterial() {
        return material;
    }

    public void setMaterial(T material) {
        this.material = material;
    }


}
