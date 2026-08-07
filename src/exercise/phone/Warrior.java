package exercise.phone;

public class Warrior extends Character{

    int rage;

    public Warrior(String name, int hp, int rage) {
        super(name, hp);
        this.rage = rage;
    }

    @Override
    public void attack() {
        System.out.println(name + "이 검으로 강력한 공격을 합니다");
        System.out.println("분노수치: " + rage);
    }
}
