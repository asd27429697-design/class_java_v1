package useful.ch01;

public class EBookMainTest {

    public static void main(String[] args) {

        EBook eBook1 = new EBook(1, "홍길동전", "허균");
        EBook eBook2 = new EBook(1, "홍길동전", "허균");
        EBook eBook3 = new EBook(2, "춘향전", "작자미상");

        System.out.println("eBook1: " + eBook1);
        System.out.println("eBook2: " + eBook2);
        System.out.println("eBook3: " + eBook3);
        System.out.println("----------------------------------");
        System.out.println("ebook1 == ebook2: " + (eBook1 == eBook2)); // false (참조 비교)
        System.out.println("ebook1.equals(eBook2) : " + (eBook1.equals(eBook2))); // true (논리적 동등성 비교)
        System.out.println("ebook1.equals(eBook2) : " + (eBook1.equals(eBook3))); // false (논리적 동등성 비교)

        System.out.println("eBook1.hashcode(): " + eBook1.hashCode());
        System.out.println("eBook1.hashcode(): " + eBook2.hashCode()); // book1과 동일 (필드 값 같음)
        System.out.println("eBook1.hashcode(): " + eBook3.hashCode());
    } // end of main
} // end of class


