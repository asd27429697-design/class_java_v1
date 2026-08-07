package useful.ch07;

/**
 * <T extends 클래스> 를 사용하면 현재 코드에서 Material 을 상속 받은 자식 클래스만
 * 대체 문자열에 들어올 수 있도록 범위 제한시킨다
 *
 */
public class GenericPrinter<T extends Material> {

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
