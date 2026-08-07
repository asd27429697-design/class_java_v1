package exercise.phone;

public class CharacterMain {
    public static void main(String[] args) {
        Character character = new Character("홍길동", 100);
        character.attack();
        Warrior warrior = new Warrior("김길동", 200, 50);
        warrior.attack();


    }


}
