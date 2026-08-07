package useful.ch04;

public class PasswordMain {

    public static void main(String[] args) {
        //String password = "123123";
        ClassPassword password = new ClassPassword();
        try {
            //password.setPassword(null);
            password.setPassword("123");
        } catch (PasswordException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("비 정상종료 안됨");
    } // end of main
} // end of class
