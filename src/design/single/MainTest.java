package design.single;

public class MainTest {

    public static void main(String[] args) {

        // A.java
        SingleTon singleTonA = SingleTon.getInstance();

        // B.java
        SingleTon singleTonB = SingleTon.getInstance();

        // C.java
        SingleTon singleTonC = SingleTon.getInstance();

        System.out.println(singleTonA);
        System.out.println(singleTonB);
        System.out.println(singleTonC);

        System.out.println(System.identityHashCode(singleTonA));
        System.out.println(System.identityHashCode(singleTonB));
        System.out.println(System.identityHashCode(singleTonC));
    }
}
