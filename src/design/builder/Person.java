package design.builder;

// 빌더 패턴으로 적용한 Person 클래스를 설계해 보자.
public class Person {

    private String name;
    private int age;
    private int height;

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.height = builder.height;
    }


    public static class Builder {
        private String name;
        private int age;
        private int height;


        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Person builder() {
            return new Person(this);
        }
    } // end of inner class

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
