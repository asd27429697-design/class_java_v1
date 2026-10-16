package design.single;

public class MainTest2 {

    public static void main(String[] args) {

        UserService userService1 = UserService.getInstance();
        UserService userService2 = UserService.getInstance();
        UserService userService3 = UserService.getInstance();

        System.out.println(userService1);
        System.out.println(userService2);
        System.out.println(userService3);

        System.out.println(System.identityHashCode(userService1));
        System.out.println(System.identityHashCode(userService2));
        System.out.println(System.identityHashCode(userService3));
    }
}
