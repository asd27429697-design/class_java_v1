package design.single;

// 싱글톤 패턴으로 클래스를 다시 한번 만들어 보자

public class UserService {

    private static UserService instance;

    private UserService() {

    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
}
