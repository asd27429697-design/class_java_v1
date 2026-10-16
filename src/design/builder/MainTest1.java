package design.builder;

import com.oop14.B;

public class MainTest1 {

    public static void main(String[] args) {
        // 빌더 패턴으로 클래스 생성해보기

        Burger burger1 = new Burger.Builder()
                .bread("참깨방")
                .patty("소고기")
                .sauce("케찹")
                .builder();
        System.out.println(burger1);

        // 순서를 바꿔도 되고, 원하는 것만 넣어도 된다(넣지 않은 값만 null)
        Burger burger2 = new Burger.Builder()
                .patty("치킨")
                .bread("호밀빵")
                .builder();
        System.out.println(burger2);



        Person person1 = new Person.Builder()
                .name("홍길동")
                .age(20)
                .height(175)
                .builder();
        System.out.println(person1);

        Person person2 = new Person.Builder()
                .name("김희성")
                .builder();
        System.out.println(person2);
    }


}
