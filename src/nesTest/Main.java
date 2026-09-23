package nesTest;

public class Main {

    public static void main(String[] args) {
        String id = "user123";
        String password = "password123";

        int idResult = UserValidator.validateId(id);
        int passwordResult = UserValidator.validatePassword(password);

        System.out.println("아이디 결과: " + idResult);
        System.out.println("비밀번호 결과: " + passwordResult);
    }
}
