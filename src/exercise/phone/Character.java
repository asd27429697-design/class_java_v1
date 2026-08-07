package exercise.phone;

public class Character {

    String name;
    int hp;

    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public void attack() {
        System.out.println(name + "이 기본 공격을 합니다");
    }
}
